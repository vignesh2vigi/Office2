package com.postal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement
@JsonInclude(Include.NON_DEFAULT)
public class Lead {
	
	

	
	private String lead_id;
	
	
	@Override
	public String toString() {
		return "Lead [lead_id=" + lead_id + ", client_id=" + client_id
				+ ", first_name=" + first_name + ", last_name=" + last_name
				+ ", gender=" + gender + ", age=" + age + ", door_no="
				+ door_no + ", street_name=" + street_name + ", area_name="
				+ area_name + ", taluk=" + taluk + ", city=" + city
				+ ", pincode=" + pincode + ", state=" + state
				+ ", lead_created_by=" + lead_created_by
				+ ", lead_created_date=" + lead_created_date
				+ ", lead_verified_date=" + lead_verified_date
				+ ", lead_approved_date=" + lead_approved_date
				+ ", lead_payable=" + lead_payable + ", ip_address="
				+ ip_address + ", remarks=" + remarks + ", lead_assigned_to="
				+ lead_assigned_to + ", image_doc=" + image_doc
				+ ", login_flag=" + login_flag + ", billing_price="
				+ billing_price + ", lead_status=" + lead_status
				+ ", approved_status=" + approved_status + ", status=" + status
				+ ", leadListArray=" + leadListArray + "]";
	}
	private String client_id;
	private String first_name;
	private String last_name;
	private String gender;
	private int age;
	private String door_no;
	private String street_name;
	private String area_name;
	private String taluk;
	private int city;
	private String pincode;
	private int state;
	private int lead_created_by;
	private Date lead_created_date;
	private Date lead_verified_date;
	private Date lead_approved_date;
	private String lead_payable;
	private String ip_address;
	private String remarks;
	private String lead_assigned_to;
	private String image_doc;
	private String login_flag;
	private String billing_price;
	private String lead_status;
	private String approved_status;
	private String status;
	
	private List<Lead> leadListArray = new ArrayList<Lead>();
	public List<Lead> getLeadListArray() {
		return leadListArray;
	}
	public void setLeadListArray(List<Lead> leadListArray) {
		this.leadListArray = leadListArray;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLead_id() {
		return lead_id;
	}
	public void setLead_id(String lead_id) {
		this.lead_id = lead_id;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
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
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getLead_created_by() {
		return lead_created_by;
	}
	public void setLead_created_by(int lead_created_by) {
		this.lead_created_by = lead_created_by;
	}
	public Date getLead_created_date() {
		return lead_created_date;
	}
	public void setLead_created_date(Date lead_created_date) {
		this.lead_created_date = lead_created_date;
	}
	public Date getLead_verified_date() {
		return lead_verified_date;
	}
	public void setLead_verified_date(Date lead_verified_date) {
		this.lead_verified_date = lead_verified_date;
	}
	public Date getLead_approved_date() {
		return lead_approved_date;
	}
	public void setLead_approved_date(Date lead_approved_date) {
		this.lead_approved_date = lead_approved_date;
	}
	public String getLead_payable() {
		return lead_payable;
	}
	public void setLead_payable(String lead_payable) {
		this.lead_payable = lead_payable;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	
	public String getLead_assigned_to() {
		return lead_assigned_to;
	}
	public void setLead_assigned_to(String lead_assigned_to) {
		this.lead_assigned_to = lead_assigned_to;
	}
	public String getImage_doc() {
		return image_doc;
	}
	public void setImage_doc(String image_doc) {
		this.image_doc = image_doc;
	}
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getLogin_flag() {
		return login_flag;
	}
	public void setLogin_flag(String login_flag) {
		this.login_flag = login_flag;
	}
	public String getBilling_price() {
		return billing_price;
	}
	public void setBilling_price(String billing_price) {
		this.billing_price = billing_price;
	}
	public String getLead_status() {
		return lead_status;
	}
	public void setLead_status(String lead_status) {
		this.lead_status = lead_status;
	}
	public String getApproved_status() {
		return approved_status;
	}
	public void setApproved_status(String approved_status) {
		this.approved_status = approved_status;
	}
	

}
