package com.postal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.postal.dao.LeadDao;
import com.postal.model.Lead;

@Repository("leadService")
public class LeadServiceImpl implements Leadservice{
	
	/*public List<Lead>list(){
	      LeadDao leadDao=new LeadDaoImpl();
	   
	      List<Lead> list=leadDao.list();
	      return list;
	    
	}*/
	@Autowired
	LeadDao leadDao;
	@Override
	public Lead getlead(Lead lead) {
		return leadDao.getlead(lead);
	}

}
