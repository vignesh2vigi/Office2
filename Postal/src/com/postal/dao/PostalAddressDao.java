package com.postal.dao;

import com.postal.model.PostalAddressModel;
import com.postal.model.PostalAddressOutputModel;

public interface PostalAddressDao {
	public PostalAddressOutputModel getPostalAddress(String loginid,String flag);

	public String getlogin_id(String loginid);
	
	public PostalAddressModel Addressverify(String clientid,String lead_id,
			String leadstatus, String remark);
}
