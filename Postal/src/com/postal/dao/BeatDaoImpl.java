package com.postal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.postal.model.Beat;


@Repository("beatDao")
public class BeatDaoImpl implements BeatDao {
   @Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Beat login(Beat beat) {
		// TODO Auto-generated method stub
		Beat le = new Beat();
		List<Beat> vey = new ArrayList<Beat>();
		@SuppressWarnings("unused")
		int rowvalue=0;
		
		//String query = "SELECT loginid FROM postal_beat_master";
		String query = "SELECT GROUP_CONCAT(SUBSTRING_INDEX(SUBSTRING_INDEX(loginid, '_', -1),'-','1')) AS  loginid FROM postal_beat_master";
		String pin_code = beat.getPin_code();
		if (pin_code != null && !pin_code.isEmpty()) {
			query += " WHERE pin_code='" + pin_code + "'";
		}
		/*query += " limit " + pageid + "," + tPerage;*/
 
		System.out.println("QueryListfghjk :::::+++" + query);

		vey = this.getJdbcTemplate().query(query, new RowMapper() {

			@Override
			public Beat mapRow(ResultSet resultSet, int rownumber)
					throws SQLException {
				Beat bt = new Beat();
				System.out.println(resultSet.getRow());
				
				
                bt.setLoginid(resultSet.getString("loginid"));
               
                return bt;
			}
		});
		String sql = "select count(*) from postal_beat_master";
		rowvalue = getJdbcTemplate().queryForObject(sql, Integer.class);
		
		if (vey.size() > 0) {
			System.out.println("beatdfghjkklltfrgdcr" + vey);
			
			le.setStatus("SUCCESS");
			le.setVey(vey);
			
		} else {
			le.setStatus("FAILURE");
		}
		
		return le;

		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Beat passcheck(Beat beat) {
		// TODO Auto-generated method stub
		Beat le = new Beat();
		List<Beat> vey = new ArrayList<Beat>();
		@SuppressWarnings("unused")
		int rowvalue=0;
		
		String query = "SELECT password FROM postal_beat_master";
		String loginid = beat.getLoginid();
		String pin_code=beat.getPin_code();
		/*if (beatno != null && !beatno.isEmpty() && pincode != null && !pincode.isEmpty()) {
			query += " WHERE beatno=' AND pincode='" + pincode + "'" + beatno + "'";
		}*/
		if (loginid != null && !loginid.isEmpty()) {
			query += " WHERE loginid='" + loginid + "'";
		}
		if (pin_code != null && !pin_code.isEmpty()) {
			query += " AND pin_code='" + pin_code + "'";
		}
		/*query += " limit " + pageid + "," + tPerage;*/
 
		System.out.println("QueryListfghjk :::::+++" + query);

		vey = this.getJdbcTemplate().query(query, new RowMapper() {

			@Override
			public Beat mapRow(ResultSet resultSet, int rownumber)
					throws SQLException {
				Beat btd = new Beat();
				System.out.println(resultSet.getRow());
				
                btd.setPassword(resultSet.getString("password"));
               
                return btd;
			}
		});
		String sql = "select count(*) from postal_beat_master";
		rowvalue = getJdbcTemplate().queryForObject(sql, Integer.class);
		
		
		if (vey.size() > 0) {
			System.out.println("beatdfghjkklltfrgdcr" + vey);
			
			le.setStatus("success");
			le.setFlag(1);               //1 - password exist
			 
			
		} else {
			le.setStatus("failure");
			le.setFlag(2);  //2- password not exist
		}
		
		return le;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Beat loginverify(Beat beat) {
		// TODO Auto-generated method stub
	
		Beat le = new Beat();
		List<Beat> vey = new ArrayList<Beat>();
		@SuppressWarnings("unused")
		int rowvalue=0;
		
		String query = "SELECT password FROM postal_beat_master";
		String loginid = beat.getLoginid();
		String pin_code=beat.getPin_code();
		String password=beat.getPassword();
		/*if (beatno != null && !beatno.isEmpty() && pincode != null && !pincode.isEmpty()) {
			query += " WHERE beatno=' AND pincode='" + pincode + "'" + beatno + "'";
		}*/
		if (loginid != null && !loginid.isEmpty()) {
			query += " WHERE loginid='" + loginid + "'";
		}
		if (pin_code != null && !pin_code.isEmpty()) {
			query += " AND pin_code='" + pin_code + "'";
		}
		if ( password != null && !password.isEmpty()) {
			query += " AND password='" + password + "'";
		}
		/*query += " limit " + pageid + "," + tPerage;*/
 
		System.out.println("QueryListfghjk :::::+++" + query);

		vey = this.getJdbcTemplate().query(query, new RowMapper() {

			@Override
			public Beat mapRow(ResultSet resultSet, int rownumber)
					throws SQLException {
				Beat btd = new Beat();
				System.out.println(resultSet.getRow());
				
                btd.setPassword(resultSet.getString("password"));
               
                return btd;
			}
		});
		String sql = "select count(*) from postal_beat_master";
		rowvalue = getJdbcTemplate().queryForObject(sql, Integer.class);
		
		
		if (vey.size() > 0) {
			System.out.println("beatdfghjkklltfrgdcr" + vey);
			
			le.setStatus("success");
			
			
		} else {
			le.setStatus("failure");
		}
		
		return le;
	}
	

}
