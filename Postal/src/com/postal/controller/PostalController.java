package com.postal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.postal.model.PostalAddressModel;
import com.postal.model.PostalAddressOutputModel;
import com.postal.service.PostalAddressService;

@Controller
public class PostalController {
	
	@Autowired
	private PostalAddressService postalAddressService;
	
	/*@RequestMapping(value = "/getaddress", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<PostalAddressOutputModel> getaddress(@RequestParam String loginid,String flag) {
			
		   PostalAddressOutputModel  idj = postalAddressService.getPostalAddress(loginid, flag);
		    return new ResponseEntity<PostalAddressOutputModel>(idj, HttpStatus.OK);
		}
	
     @RequestMapping(value = "/pending", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<PostalAddressModel> pending(@RequestParam String clientid,String lead_id,String leadstatus, String remark) {
		
	    PostalAddressModel idj = postalAddressService.Addressverify(clientid, lead_id, leadstatus, remark);
	    return new ResponseEntity<PostalAddressModel>(idj, HttpStatus.OK);
	}*/


     @RequestMapping(value = "/verify", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<PostalAddressModel> verify(@RequestBody PostalAddressModel address) {
    	 System.out.println("beatlogin_query:sdfcdfgdfdssdsdsvgbhnnm"+address);
	    PostalAddressModel idj = postalAddressService.verify(address);
	    return new ResponseEntity<PostalAddressModel>(idj, HttpStatus.OK);
	}
     
     @RequestMapping(value = "/address", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<PostalAddressOutputModel> address(@RequestBody PostalAddressOutputModel add) {
    	 System.out.println("beatlogin_query:sdfcdfgdfdssdsdsvgbhnnm"+add);
		   PostalAddressOutputModel  idj = postalAddressService.getAddress(add);
		    return new ResponseEntity<PostalAddressOutputModel>(idj, HttpStatus.OK);
		}
}
