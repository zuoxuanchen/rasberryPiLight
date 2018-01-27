package com.zxc.mapper;

import com.zxc.model.NickName;
import com.zxc.model.NickNameExample;
import java.util.List;

public interface NickNameMapper {
    int countByExample(NickNameExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NickName record);

    int insertSelective(NickName record);

    List<NickName> selectByExample(NickNameExample example);

    NickName selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NickName record);

    int updateByPrimaryKey(NickName record);
    
    /**
     * 随机选中一个昵称
     * @return
     */
    NickName selectRandomName();
}