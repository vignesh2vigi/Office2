package com.postal.model;

import java.util.ArrayList;
import java.util.List;

public class PostalAddressOutputModel {
private String status;
	
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
