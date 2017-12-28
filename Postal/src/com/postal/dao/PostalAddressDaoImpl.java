package com.postal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.postal.config.Db;
import com.postal.model.PostalAddressModel;
import com.postal.model.PostalAddressOutputModel;

@Repository("postalAddressDao")

public class PostalAddressDaoImpl implements PostalAddressDao {

	@Override
	public PostalAddressOutputModel getPostalAddress(String loginid, String flag) {
		// TODO Auto-generated method stub

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
						
						/*System.out.println("remark####:"+address_model.getRemark());*/
						
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

		return address_model1;

	}

	public String getlogin_id(String loginid) {
		// TODO Auto-generated method stub
		String sno =null;
		//String sql="select sno from postal_login_details  where loginid='"+postmasteid+"'";
		
		String sql="select sno from postal_login_details  where loginid='"+loginid+"'";
		
		Connection con=null;
		ResultSet rs =null;
		try{

			Db db = new Db();
			con = db.mysqlConnect();
			PreparedStatement pst = con.prepareStatement(sql);
			System.out.println(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				sno =rs.getString("sno");
			}
			
			
			
		}
		catch(Exception e){
		
			e.printStackTrace();
		}
		return sno;
	}

	@Override
	public PostalAddressModel Addressverify(String clientid, String lead_id,
			String leadstatus, String remark) {
		// TODO Auto-generated method stub
		String reason="";
		PostalAddressModel verifymodel =  new PostalAddressModel();
		if(leadstatus.equalsIgnoreCase("4"))
		{
			
			if(remark.equalsIgnoreCase("4"))
			{
				System.out.println("bbbb" );
				leadstatus ="1";
				System.out.println("leadstatus   "+leadstatus);
				
			}
			reason =", remarks ='"+remark+"'";
		}
		String sql="update lead_details set lead_status='"+leadstatus+"' "+reason+",login_flag='0',lead_verified_date=NOW() where clientid='"+clientid+"' and lead_assigned_to='"+lead_id+"'";
		Connection con=null;
		try{

		Db db = new Db();
		con = db.mysqlConnect();
		PreparedStatement pst = con.prepareStatement(sql);
		System.out.println(sql);
		int insertCnt=pst.executeUpdate();
		if(insertCnt > 0){
			  verifymodel.setStatus("SUCCESS");
			  }
			  else{
			  verifymodel.setStatus("FAILURE");
			  }
		}
		catch(Exception e){
		
			e.printStackTrace();
		}
		return verifymodel;
	}	

}
