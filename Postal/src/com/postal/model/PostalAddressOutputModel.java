package com.postal.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement
@JsonInclude(Include.NON_DEFAULT)
public class PostalAddressOutputModel {
private String status;
	
private String loginid;
private String flag;
	public String getLoginid() {
	return loginid;
}
public void setLoginid(String loginid) {
	this.loginid = loginid;
}
public String getFlag() {
	return flag;
}
public void setFlag(String flag) {
	this.flag = flag;
}
	private String totalcount;
	private List<PostalAddressModel> postalAddress = new ArrayList<>();
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(String totalcount) {
		this.totalcount = totalcount;
	}
	public List<PostalAddressModel> getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(List<PostalAddressModel> postalAddress) {
		this.postalAddress = postalAddress;
	}


}
