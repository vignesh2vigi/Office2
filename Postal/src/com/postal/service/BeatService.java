package com.postal.service;

import com.postal.model.Beat;

public interface BeatService {
	
	public Beat login(Beat beat);
	
	public Beat passcheck(Beat beat);
	
	public Beat loginverify(Beat beat);

}
