package com.postal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@XmlRootElement
@JsonInclude(Include.NON_DEFAULT)
public class Beat {



	@Override
	public String toString() {
		return "Beat [sno=" + sno + ", loginid=" + loginid + ", password="
				+ password + ", pin_code=" + pin_code + ", mobileno="
				+ mobileno + ", created_date=" + created_date
				+ ", last_login_date=" + last_login_date + ", ip_address="
				+ ip_address + ", status=" + status + ", message=" + message
				+ ", vey=" + vey + "]";
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPin_code() {
		return pin_code;
	}
	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getLast_login_date() {
		return last_login_date;
	}
	public void setLast_login_date(Date last_login_date) {
		this.last_login_date = last_login_date;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Beat> getVey() {
		return vey;
	}
	public void setVey(List<Beat> vey) {
		this.vey = vey;
	}
	private String sno;
	private String loginid;
	private String password;
	private String pin_code;
	private String mobileno; 
	private Date created_date;
	private Date last_login_date;
	private String ip_address;
	
	
	private String flag;

	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	private String status;
	
	private String message;
	private List<Beat> vey = new ArrayList<Beat>();

	

	
}
