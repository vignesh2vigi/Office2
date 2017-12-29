package com.postal.service;

import com.postal.model.PostalAddressModel;
import com.postal.model.PostalAddressOutputModel;

public interface PostalAddressService {
	
	public PostalAddressOutputModel getPostalAddress(String loginid,String flag);

	public String getlogin_id(String loginid);
	
	public PostalAddressModel Addressverify(String clientid,String lead_id,
			String leadstatus, String remark);
	
	public PostalAddressModel verify(PostalAddressModel address);
	
	public PostalAddressOutputModel getAddress(PostalAddressOutputModel add);
}
