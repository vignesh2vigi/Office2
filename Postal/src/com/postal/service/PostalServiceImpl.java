package com.postal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.postal.dao.PostalAddressDao;
import com.postal.model.PostalAddressModel;
import com.postal.model.PostalAddressOutputModel;
@Repository("postalAddressService")


public class PostalServiceImpl implements PostalAddressService {
	@Autowired
	PostalAddressDao postalAddressDao;
	
	@Override
	public String getlogin_id(String loginid) {
		// TODO Auto-generated method stub
		return postalAddressDao.getlogin_id(loginid);
	}

	
	
	@Override
	public PostalAddressOutputModel getPostalAddress(String loginid, String flag) {
		// TODO Auto-generated method stub
		return postalAddressDao.getPostalAddress(loginid, flag);
	}



	@Override
	public PostalAddressModel Addressverify(String clientid, String lead_id,
			String leadstatus, String remark) {
		// TODO Auto-generated method stub
		return postalAddressDao.Addressverify(clientid, lead_id, leadstatus, remark);
	}

	
}
