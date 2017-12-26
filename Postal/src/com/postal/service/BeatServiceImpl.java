package com.postal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.postal.dao.BeatDao;
import com.postal.model.Beat;
@Repository("beatService")
public class BeatServiceImpl implements BeatService {

	
	
	@Autowired
	BeatDao beatDao;
	@Override
	public Beat login(Beat beat) {
		return beatDao.login(beat);
	}
	
	@Override
	public Beat passcheck(Beat beat) {
		// TODO Auto-generated method stub
		return beatDao.passcheck(beat);
	}

	@Override
	public Beat loginverify(Beat beat) {
		// TODO Auto-generated method stub
		return beatDao.loginverify(beat);
	}
	
	

}