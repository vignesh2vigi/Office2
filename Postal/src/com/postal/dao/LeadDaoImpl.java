package com.postal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.postal.model.Lead;

@Repository("leadDao")
public class LeadDaoImpl implements LeadDao {

	/*@Override
	public List<Lead> list() {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		List<Lead> list = new ArrayList<Lead>();
		try {
			
			String sql = "SELECT first_name,last_name,gender,door_no,street_name,area_name,taluk,pincode,state,lead_status FROM lead_lead";
			connection = Db.mysqlConnect();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				Lead ld = new Lead();
				//outob.set
				User user = new User();
				user.setUsername(resultSet.getString("username"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setPhonenumber(resultSet.getString("phonenumber"));
				ld.setFirst_name(resultSet.getString("first_name"));
                ld.setLast_name(resultSet.getString("last_name"));
                ld.setGender(resultSet.getString("gender"));
                ld.setStreet_name(resultSet.getString("street_name"));
                ld.setDoor_no(resultSet.getString("door_no"));
                ld.setArea_name(resultSet.getString("area_name"));
                ld.setTaluk(resultSet.getString("taluk"));
                
			list.add(ld);
			}

			
			
			
		} catch (Exception e) {

			e.printStackTrace();
		    
		} 
		finally{
			try {
				preparedStatement.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;
	}*/
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Lead getlead(Lead lead) {

		Lead lead2 = new Lead();
		List<Lead> vearray = new ArrayList<Lead>();
		@SuppressWarnings("unused")
		int rowvalue=0;
		
		/*@SuppressWarnings("unused")
		int rowvalue=0;
		int tPerage = 0;
		int pageid = 0;
		
		System.out.println("pageid:"+lead.getPageID());
		if (lead.getPageID() == null || lead.getPageID().isEmpty() || lead.getPageID().equals("1")) {
			pageid = 0;
		}else
		{
			pageid = (Integer.parseInt(lead.getPageID())-1)*10;
		}
		if (lead.getTotalPerPage() == null || lead.getTotalPerPage().isEmpty()) {
			tPerage = 10;
		}else
		{
			tPerage = Integer.parseInt(lead.getTotalPerPage());
		}*/
		String query = "SELECT first_name,last_name,gender,door_no,street_name,area_name,taluk,pincode,state,lead_status,lead_assigned_to FROM lead_details";
		String lead_assigned_to = lead.getLead_assigned_to();
		if (lead_assigned_to != null && !lead_assigned_to.isEmpty()) {
			query += " where lead_assigned_to='" + lead_assigned_to + "'";
		}
		/*query += " limit " + pageid + "," + tPerage;*/

		System.out.println("QueryList :::::+++" + query);

		vearray = this.getJdbcTemplate().query(query, new RowMapper() {

			@Override
			public Lead mapRow(ResultSet resultSet, int rownumber)
					throws SQLException {
				Lead ld = new Lead();
				ld.setFirst_name(resultSet.getString("first_name"));
                ld.setLast_name(resultSet.getString("last_name"));
                ld.setGender(resultSet.getString("gender"));
                ld.setStreet_name(resultSet.getString("street_name"));
                ld.setDoor_no(resultSet.getString("door_no"));
                ld.setArea_name(resultSet.getString("area_name"));
                ld.setTaluk(resultSet.getString("taluk"));
                ld.setPincode(resultSet.getString("pincode"));
                ld.setLead_status(resultSet.getString("lead_status"));
                ld.setLead_assigned_to(resultSet.getString("lead_assigned_to"));
                return ld;
			}
		});
		String sql = "select count(*) from lead_details";
		rowvalue = getJdbcTemplate().queryForObject(sql, Integer.class);
		System.out.println("dfcgvebhnjfxlklkfvmgbmbmmmmmmmldfxl" + sql);
		
		

		if (vearray.size() > 0) {
			lead2.setStatus("SUCCESS");
			lead2.setLeadListArray(vearray);
		
		} else {
			lead2.setStatus("FAILURE");
		}
		return lead2;
	}
	
}
