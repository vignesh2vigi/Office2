package com.postal.dao;

import com.postal.model.Beat;

public interface BeatDao{

	
	public Beat loglast(Beat beat);
	
	public Beat log(Beat beat);
	
	public Beat finallog(Beat beat);
	
	public Beat adrs(Beat beat);
	}
