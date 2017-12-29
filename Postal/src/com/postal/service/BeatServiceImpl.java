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
	public Beat loglast(Beat beat) {
		// TODO Auto-generated method stub
		return beatDao.loglast(beat);
	}


	@Override
	public Beat log(Beat beat) {
		// TODO Auto-generated method stub
		return beatDao.log(beat);
	}


	@Override
	public Beat finallog(Beat beat) {
		// TODO Auto-generated method stub
		return beatDao.finallog(beat);
	}


	@Override
	public Beat adrs(Beat beat) {
		// TODO Auto-generated method stub
		return beatDao.adrs(beat);
	}
	
	

}
