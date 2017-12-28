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
	  /* String sql = "select count(*) from postal_beat_master";
		rowvalue = getJdbcTemplate().queryForObject(sql, Integer.class);*/
		
		if (vey.size() > 0) {
			System.out.println("beatdfghjkklltfrgdcr" + vey);
			
			le.setStatus("SUCCESS");
			
			
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
		/*String pin_code=beat.getPin_code();*/
		/*if (beatno != null && !beatno.isEmpty() && pincode != null && !pincode.isEmpty()) {
			query += " WHERE beatno=' AND pincode='" + pincode + "'" + beatno + "'";
		}*/
		if (loginid != null && !loginid.isEmpty()) {
			query += " WHERE loginid='" + loginid + "'";
		}
		/*if (pin_code != null && !pin_code.isEmpty()) {
			query += " AND pin_code='" + pin_code + "'";
		}*/
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
			le.setVey(vey);
			le.setStatus("success");
			le.setFlag("1");               //1 - password exist
			 
			
		} else {
			le.setStatus("succes");
			le.setFlag("2");
			  //2- password exist
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
			le.setStatus("password found");
			
		} else {
			le.setStatus("failure");
			le.setMessage("password not found");
		}
		
		return le;
	}
	
	
	@Override
	public Beat getbeat(String pin_code) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		Beat login_model = new Beat();
		
	
		try {

			Db db = new Db();

			con = db.mysqlConnect();

			stmt = con.createStatement();

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
	public Beat sign(String loginid) {
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
	public Beat signlast(String loginid, String password, String flag) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		Beat login_model = new Beat();
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		System.out.println("1beatlogin_query:sghfjgfhnfkkgnhknhgknkj"+password);
		int cnt =0;
		try {
			System.out.println("2beatlogin_query:sghfjgfhnfkkgnhknhgknkj"+password);
			Db db = new Db();

			con = db.mysqlConnect();

			stmt = con.createStatement();
			System.out.println("3beatlogin_query:sghfjgfhnfkkgnhknhgknkj"+flag);
			
			if(flag.equals("1")){

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
	
	
}
