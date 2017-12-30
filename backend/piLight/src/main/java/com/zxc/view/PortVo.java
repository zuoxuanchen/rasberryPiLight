package com.zxc.view;

public class PortVo {
	
	/**
	 * GPIO编号
	 */
	private String portNum;
	
	/**
	 * 端口状态
	 */
	private String portStatus;

	/**
	 * 状态持续时间
	 */
	private String second;
	
	/**
	 * 端口取反
	 */
	private String reverse;
	
	public String getPortNum() {
		return portNum;
	}

	public void setPortNum(String portNum) {
		this.portNum = portNum;
	}

	public String getPortStatus() {
		return portStatus;
	}

	public void setPortStatus(String portStatus) {
		this.portStatus = portStatus;
	}

	public String getReverse() {
		return reverse;
	}

	public void setReverse(String reverse) {
		this.reverse = reverse;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}
	
	
}
