package yongs.temp.vo;

import java.io.Serializable;

public class AccountHistory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String no;
	private long tmoney;
	private String date;
	private String target;
	
	public AccountHistory(String no, long tmoney, String date, String target) {
		this.no = no;
		this.tmoney = tmoney;
		this.date = date;
		this.target = target;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public long getTmoney() {
		return tmoney;
	}

	public void setTmoney(long tmoney) {
		this.tmoney = tmoney;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}