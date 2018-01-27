package com.zxc.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import com.zxc.model.Hints;
import com.zxc.model.Weather;
import com.zxc.service.inf.AlarmClockService;
import com.zxc.service.inf.HintsService;
import com.zxc.service.inf.NewsService;
import com.zxc.service.inf.NickNameService;
import com.zxc.service.inf.WeatherService;
import com.zxc.service.inf.WorkDayService;

import javazoom.jl.player.Player;


@Service("alarmClockService")
public class AlarmClockServiceImpl implements AlarmClockService{

	public static final String APP_ID = "10750488";
    public static final String API_KEY = "pxp2chcjRxbX2YWrQuRffjw0";
    public static final String SECRET_KEY = "761b306676f5861a1aa4aa0eb0c6aed2";
    public static final String filePath = "D:\\tempSound\\";public static final String musicPath = "D:\\tempMusic\\";
    //public static final String filePath = "/home/pi/java/tempSound/";public static final String musicPath = "/home/pi/java/tempMusic/";
    
	@Autowired
	private WeatherService weatherService;
	
	@SuppressWarnings("unused")
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private HintsService hintsService;
	
	@Autowired
	private NickNameService nickNameService;
	
	@Autowired
	private WorkDayService workDayService;
	
	@Override
	public String findAllInfo() {
		Date date = new Date();
		StringBuilder result = new StringBuilder();
		result.append("嗨，亲爱的");
		result.append(nickNameService.getRandomNickName());
		result.append(","+new SimpleDateFormat("今天是yyyy年MM月dd日EEEE,现在时间HH点mm分,").format(date));
		if (workDayService.isWorkDay(date)) {
			result.append("今天您需要上班哦，");
		}
		else{
			result.append("今天您休假哦，");
		}
		weatherService.insertTodayWeather();
		Weather weather = weatherService.todayWeather();
		result.append("今天天气是"+weather.getWeather()+","+"室外气温"+weather.getTemp()+"摄氏度,雾霾指数"+weather.getPm()+","+weather.getComment());
		List<Hints> hints = hintsService.findAllHints("00000000");//传一个农历进去 方便查生日
		if (hints!=null && hints.size()>0) {
			result.append("您有"+hints.size()+"条待办事项，如下：");
			for (int i = 0; i < hints.size();i++) {
				Hints hint = hints.get(i);
				if (!StringUtils.isEmpty(hint.getBirthName())) {
					result.append((i+1)+",今天是"+hint.getBirthName()+"的生日，");
				}
				if (!StringUtils.isEmpty(hint.getHints())) {
					result.append((i+1)+",今天您要记得"+hint.getHints()+"哦，");
				}
			}
		}
		result.append("祝您今天心情愉快，再见！");
		System.out.println(result.toString());
		return result.toString();
	}

	@Override
	public void playSound(String text) {
		AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
		
		String filename = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".mp3";
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        
//        参数	类型	描述	是否必须
//        tex	String	合成的文本，使用UTF-8编码，请注意文本长度必须小于1024字节	是
//        lang	String	语言选择,填写zh	是
//        ctp	String	客户端类型选择，web端填写1	是
//        cuid	String	用户唯一标识，用来区分用户，填写机器 MAC 地址或 IMEI 码，长度为60以内	否
//        spd	String	语速，取值0-9，默认为5中语速	否
//        pit	String	音调，取值0-9，默认为5中语调	否
//        vol	String	音量，取值0-15，默认为5中音量	否
//        per	String	发音人选择, 0为女声，1为男声，3为情感合成-度逍遥，4为情感合成-度丫丫，默认为普通女	否
        
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("per", "4");
        options.put("spd", "3");
        options.put("vol", "10");
        // 调用接口
        TtsResponse res = client.synthesis(text, "zh", 1, options);
        
        byte[] data = res.getData();
        JSONObject res1 = res.getResult();
        if (data != null) {
            try {
                Util.writeBytesToFileSystem(data, filePath+filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (res1 != null) {
            System.out.println(res1.toString(2));
        }
        this.playRandomMusic();
        this.play(filePath+filename);

        			
	}

	/**
	 * 
	 */
	private void playRandomMusic() {
		File file = new File(musicPath);
		java.util.Random random=new java.util.Random();// 定义随机类
		int result=random.nextInt(1000);// 返回[0,1000)集合中的整数
		if (file.exists()) {
			File[] files = file.listFiles();
			result %= files.length;
			this.play(files[result].getAbsolutePath());
		}
	}

	/**
	 * 新线程异步播放文件
	 * @param string
	 */
	@Override
	public void play(String fileName) {
		new Thread(){
			public void run(){
				try {
					InputStream input = new FileInputStream(fileName);
					Player player = new Player(input);
					player.play();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();	
	}

	


}
