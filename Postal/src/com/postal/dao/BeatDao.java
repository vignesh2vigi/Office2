package com.postal.dao;

import com.postal.model.Beat;

public interface BeatDao{

	public Beat login(Beat beat);
	
	public Beat passcheck(Beat beat);
	
	public Beat loginverify(Beat beat);
	
	public Beat getbeat(String pin_code);
	
	public Beat sign(String loginid);
	
	public Beat signlast(String loginid,String password,String flag);
	
	}
