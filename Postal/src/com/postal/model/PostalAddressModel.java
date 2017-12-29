package com.postal.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@XmlRootElement
@JsonInclude(Include.NON_DEFAULT)
public class PostalAddressModel {
	
	private String clientid;

	private String first_name;
	
	private String gender;
	
	private String age;

	private String door_no;

	private String street_name;
	
	private String area_name;

	private String taluk;
	
	private String city;
	
	private String pincode;
	
	private String state;
	
	private Date date;

	private String lead_status;
	
	private String lead_id;
	
	private String lead_assigned_to;
	private String flag;
	
	

	

	@Override
	public String toString() {
		return "PostalAddressModel [clientid=" + clientid + ", first_name="
				+ first_name + ", gender=" + gender + ", age=" + age
				+ ", door_no=" + door_no + ", street_name=" + street_name
				+ ", area_name=" + area_name + ", taluk=" + taluk + ", city="
				+ city + ", pincode=" + pincode + ", state=" + state
				+ ", date=" + date + ", lead_status=" + lead_status
				+ ", lead_id=" + lead_id + ", lead_assigned_to="
				+ lead_assigned_to + ", flag=" + flag + ", remark=" + remark
				+ ", status=" + status + "]";
	}



	public String getFlag() {
		return flag;
	}



	public void setFlag(String flag) {
		this.flag = flag;
	}



	public String getLead_assigned_to() {
		return lead_assigned_to;
	}

	public void setLead_assigned_to(String lead_assigned_to) {
		this.lead_assigned_to = lead_assigned_to;
	}

	public String getLead_id() {
		return lead_id;
	}

	public void setLead_id(String lead_id) {
		this.lead_id = lead_id;
	}

	private String remark;
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDoor_no() {
		return door_no;
	}

	public void setDoor_no(String door_no) {
		this.door_no = door_no;
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLead_status() {
		return lead_status;
	}

	public void setLead_status(String lead_status) {
		this.lead_status = lead_status;
	}

	

	public void setRemark(String remark) {
		this.remark = remark;
	}

	

}
