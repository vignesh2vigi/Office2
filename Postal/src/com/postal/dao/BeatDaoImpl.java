package com.postal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.postal.config.Db;
import com.postal.model.Beat;
import com.postal.model.Lead;
import com.postal.model.PostalAddressModel;
import com.postal.model.PostalAddressOutputModel;


@Repository("beatDao")
public class BeatDaoImpl implements BeatDao {
   @Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
		
	
	@Autowired
	private JdbcTemplate jdbcTemplate1;

	public JdbcTemplate getJdbcTemplate1() {
		return jdbcTemplate;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Beat loglast(Beat beat) {
		// TODO Auto-generated method stub
		

		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		Beat login_model = new Beat();
		
	
		try {

			Db db = new Db();

			con = db.mysqlConnect();

			stmt = con.createStatement();
			
			String pin_code= beat.getPin_code();

			String login_query = "SELECT GROUP_CONCAT(SUBSTRING_INDEX(SUBSTRING_INDEX(loginid, '_', -1),'-','1')) AS  loginid FROM postal_beat_master WHERE pin_code='"+ pin_code+ "'";
			
			System.out.println("beatlogin_query:"+login_query);

			rs = stmt.executeQuery(login_query);

			System.out.println("beatlogin_query:dfscdghjs");

			int row = rs.getRow();

			rs.beforeFirst();

			/*if (row == 0) {
				login_model.setStatus("SUCCESS");
				System.out.println("beatlogin_query:dfscdghjs");
			
				} else {*/

				while (rs.next()) {
					
					String loginid= rs.getString("loginid");
					
					if(loginid!=null && loginid.length()> 0){
						
						login_model.setStatus("SUCCESS");
						
						login_model.setLoginid(rs.getString("loginid"));
					  
						 
					}
					else{
						login_model.setStatus("Failure");
						
						
					}
				}
			/*}*/

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rs != null) {

					rs.close();
				} else if (stmt != null) {

					stmt.close();

				} else if (con != null) {

					con.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return login_model;
	}
	@Override
	public Beat log(Beat beat) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		Beat login_model = new Beat();
		
		boolean flg= false;
		try {

			Db db = new Db();

			con = db.mysqlConnect();

			stmt = con.createStatement();

			String loginid=beat.getLoginid();
					
			String login_query = "SELECT loginid,password,pin_code,created_date FROM postal_beat_master WHERE loginid='"+ loginid + "'";
			
		System.out.println("beatlogin_query:"+login_query);

			rs = stmt.executeQuery(login_query);

			boolean last = rs.last();

			int row = rs.getRow();

			rs.beforeFirst();

			if (row == 0) {
				login_model.setStatus("SUCCESS");
				login_model.setMessage("No user Found");
			
				} else {

				while (rs.next()) {
					
					String password= rs.getString("password");
					
					if(password!=null && password.length()> 0){
						
						login_model.setStatus("SUCCESS");
						/*login_model.setMessage("user Found");*/
						/*login_model.setPassword("Not Null");*/
						login_model.setPassword("0");
					}
					else{
						login_model.setStatus("SUCCESS");
						/*login_model.setMessage("First time login");*/
						login_model.setPassword("1");
					}
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rs != null) {

					rs.close();
				} else if (stmt != null) {

					stmt.close();

				} else if (con != null) {

					con.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return login_model;
	}
	@Override
	public Beat finallog(Beat beat) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String loginid=beat.getLoginid();
		String password=beat.getPassword();
		int flag=beat.getFlag();
		Beat login_model = new Beat();
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		System.out.println("1beatlogin_query:sghfjgfhnfkkgnhknhgknkj"+password);
		int cnt =0;
		try {
			System.out.println("2beatlogin_query:sghfjgfhnfkkgnhknhgknkj"+password);
			Db db = new Db();

			con = db.mysqlConnect();

			stmt = con.createStatement();
			
			
			if(flag==1){

			String login_query = "update postal_beat_master set password='"+password+"'  where loginid='"+loginid+"'";
		
			System.out.println("4beatlogin_query:sghfjgfhnfkkgnhknhgknkj"+login_query);

			
			 cnt = stmt.executeUpdate(login_query);
			}
			else{
				cnt =1;
			}
			if(cnt > 0){
				String sql = "SELECT loginid,password,pin_code,created_date FROM postal_beat_master WHERE loginid='"+ loginid + "' and password ='"+password+"' ";
				rs =stmt.executeQuery(sql);
				boolean last = rs.last();
				int row = rs.getRow();
				System.out.println("5beatlogin_query:sghfjgfhnfkkgnhknhgknkj"+password);
				rs.beforeFirst();

				if (row == 0) {
					login_model.setStatus("Failure");
					login_model.setMessage("Invalid Credential");
				} else {

					while (rs.next()) {
						

						login_model.setStatus("LOGIN SUCCESS");

						login_model.setLoginid(rs.getString("loginid"));

						login_model.setPassword(rs.getString("password"));
						
						
						DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						
						Date d=new Date();
						
						String dateOf=dateFormat.format(d);
						
						Calendar cal = Calendar.getInstance();
						//System.out.println(dateFormat.format(cal.getTime()));
						System.out.println("6beatlogin_query:sghfjgfhnfkkgnhknhgknkj"+password);
								String login_summary_insert_query="insert into postal_login_summary(loginid,browser_type,os_type,login_time,logout_time,ip_address) values(?,?,?,?,?,?)"; 
								 
								PreparedStatement preparedStatement = con.prepareStatement(login_summary_insert_query);
									
								System.out.println("7beatlogin_query:sghfjgfhnfkkgnhknhgknkj"+password);
								
									preparedStatement.setString(1, rs.getString("loginid"));

									preparedStatement.setString(6, "Unknown");
									

									preparedStatement.setTimestamp(4, ts);

									preparedStatement.setTimestamp(5,null);

									preparedStatement.setString(2, "");

									preparedStatement.setString(3, "Android");

									int no=preparedStatement.executeUpdate();

									//session.setAttribute("logintime", ts);
									  
									//out.print("Correct");
						
								 //System.out.println("username########:"+username);
									
								 //System.out.println("else#### : "); 
								 
								// out.print("Incorrect");
					}
				}
			
			}else{
				System.out.println("8beatlogin_query:sghfjgfhnfkkgnhknhgknkj"+password);
				login_model.setStatus("Failure");
				login_model.setMessage("Password Not Updated");
			}

			

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rs != null) {

					rs.close();
				} else if (stmt != null) {

					stmt.close();

				} else if (con != null) {

					con.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		System.out.println("9beatlogin_query:sghfjgfhnfkkgnhknhgknkj"+loginid);
		return login_model;
	}
	@Override
	public Beat adrs(Beat beat) {
		// TODO Auto-generated method stub
		String loginid=beat.getLoginid();
		String flag=beat.getFlg();
		List<PostalAddressOutputModel> list = null;
		List<PostalAddressModel> addressList = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		
		Statement stmt_city=null;
		
		Statement stmt_state=null;
		
		ResultSet rs = null;
		
		ResultSet rs_city=null;
		
		ResultSet rs_state=null;
		
		
		

		PostalAddressOutputModel address_model1 = new PostalAddressOutputModel();

		try {

			Db db = new Db();

			con = db.mysqlConnect();

			stmt = con.createStatement();
			
			stmt_city=con.createStatement();
			
			stmt_state=con.createStatement();
			
			
			
			PostalAddressDaoImpl postal_addressverify = new PostalAddressDaoImpl();
			   
			   String sno = postal_addressverify.getlogin_id(loginid);
			   
			   String flag_status=""; 
			   
			   if(flag.equalsIgnoreCase("2")){
				   
				   flag_status=" AND lead_status='2'";
			   }else if(flag.equalsIgnoreCase("3")){
				   
				   flag_status=" AND lead_status='3'";
				   
			   }else if(flag.equalsIgnoreCase("4")){
				   
				   flag_status=" AND lead_status='4'";
				   
				   
			   }else {
				   
				   flag_status=" AND lead_status IN(2,3,4)";
			   }
			   
			  
			   
			   
			  String postal_area_address_query="SELECT SQL_CALC_FOUND_ROWS * FROM lead_details WHERE pincode IN (SELECT pin_code FROM postal_beat_master WHERE loginid='"+loginid+"' AND status='1') AND lead_assigned_to='"+loginid+"' "+flag_status+"";
			
			 System.out.println("postal_address:" + postal_area_address_query);

			 rs = stmt.executeQuery(postal_area_address_query);

			 boolean last = rs.last();

			 int row = rs.getRow();
			
			 rs.beforeFirst();

			if (row == 0) {
				
				list = new ArrayList<>();
				address_model1.setStatus("NO RECORDSFOUND");
				list.add(address_model1);

			} else {

				address_model1.setStatus("SUCCESS");

				while (rs.next()) {

					PostalAddressModel address_model = new PostalAddressModel();
					
					address_model.setClientid(rs.getString("clientid"));
					address_model.setFirst_name(rs.getString("first_name"));
					address_model.setGender(rs.getString("gender"));
					address_model.setAge(rs.getString("age"));
					address_model.setDoor_no(rs.getString("door_no"));
					address_model.setStreet_name(rs.getString("street_name"));
					address_model.setArea_name(rs.getString("area_name"));
					address_model.setTaluk(rs.getString("taluk"));
					address_model.setCity(rs.getString("city"));
					address_model.setPincode(rs.getString("pincode"));
					address_model.setState(rs.getString("state"));
					address_model.setDate(rs.getDate("lead_created_date"));
					address_model.setLead_status(rs.getString("lead_status"));
					String lead_status = address_model.getLead_status();
					
					String gender = address_model.getGender();
					
					
					if(gender.equalsIgnoreCase("0")){
						
						gender="Male";
						
						address_model.setGender(gender);
					
					}else if(gender.equalsIgnoreCase("1")){
						
					gender="Female";	
					address_model.setGender(gender);
					}else if(gender.equals("2")){
						
						gender="Other";
						address_model.setGender(gender);
						
					}
					
					
					String city = address_model.getCity();
					
					
					String city_query_display="select * from master_cities where city_id ='"+city+"'";
					
					System.out.println("city_query_display:"+city_query_display);
					
					if(String.valueOf(city) !=null){
						
						rs_city = stmt_city.executeQuery(city_query_display);
						
						if(rs_city.next()){
							
							address_model.setCity(rs_city.getString("city_name"));
							
							
						}
						
					}
					
					
					
					String state = address_model.getState();
					
					
					String state_query_display="select * from master_states where state_id ='"+state+"' ";
					
					
					if(String.valueOf(state)!=null){
						
						rs_state = stmt_state.executeQuery(state_query_display);
						
						if(rs_state.next()){
							
							address_model.setState(rs_state.getString("state_name"));
						}
				
						
					}
					
					
					if(lead_status.equalsIgnoreCase("1")){
						
						lead_status="Open";
						
						address_model.setLead_status(lead_status);
						
					}else if(lead_status.equalsIgnoreCase("2")){
						
						lead_status="Allocated";
						address_model.setLead_status(lead_status);
					}else if(lead_status.equalsIgnoreCase("3")){
						
						lead_status="Varified";
						address_model.setLead_status(lead_status);
						
					}else if(lead_status.equalsIgnoreCase("4")){
						
						lead_status="Not varified";
						
					//	address_model.setRemark(rs.getString("remarks"));
						
						address_model.setLead_status(lead_status);
						
						
						
						String remark = rs.getString("remarks");
						
						if(remark.equalsIgnoreCase("1")){
							
							remark="Customer Not Available, Address Correct";
							
							address_model.setRemark(remark);
							
						}else if(remark.equalsIgnoreCase("2")){
							
							remark="Customer Not Available, Address Incorrect";
							
							address_model.setRemark(remark);
							
						}else if(remark.equalsIgnoreCase("3")){
							
							remark="Customer Available, Address Incorrect";
							
							address_model.setRemark(remark);
							
						}else if(remark.equalsIgnoreCase("4")){
							
							remark="Request to reassign";
							
							address_model.setRemark(remark);
						}
						
						System.out.println("remark####:"+address_model.getRemark());
						
					}
					
					addressList.add(address_model);

				}
				address_model1.setTotalcount(String.valueOf(row));
				address_model1.setPostalAddress(addressList);

			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				
				if(rs_state!=null){
					
					
					rs_state.close();
					
				}else if(rs_city!=null){
					
					rs_city.close();
					
				}

				else if (rs != null) {

					rs.close();
				} else if (stmt != null) {

					stmt.close();

				} else if (con != null) {

					con.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

		// TODO Auto-generated method stub

		return beat;
	}
	
	
	
}
