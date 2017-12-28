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

import com.postal.model.Beat;
import com.postal.service.BeatService;

@Controller
public class BeatController {
	
	@Autowired
	private BeatService beatService;
	

	/*@RequestMapping(value = "/login", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Beat> login(@RequestBody Beat beat) {
	    Beat idj = beatService.login(beat);
		return new ResponseEntity<Beat>(idj, HttpStatus.OK);
	}*/
     
	@RequestMapping(value = "/password", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Beat> password(@RequestBody Beat beat) {
	    Beat idj = beatService.passcheck(beat);
		return new ResponseEntity<Beat>(idj, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/loginfinal", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Beat> loginfinal(@RequestBody Beat beat) {
	    Beat idj = beatService.loginverify(beat);
		return new ResponseEntity<Beat>(idj, HttpStatus.OK);
	}
	@RequestMapping(value = "/getbeat", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	
     public ResponseEntity<Beat> getbeat(@RequestParam String pin_code) {
		System.out.println("beatlogin_query:sdfcvgbhnnm"+pin_code);
	    Beat idj = beatService.getbeat(pin_code);
	    
		return new ResponseEntity<Beat>(idj, HttpStatus.OK);
	}
	@RequestMapping(value = "/sign", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Beat> sign(@RequestParam String loginid) {
			System.out.println("beatlogin_query:sdfcvgbhnnm"+loginid);
		    Beat idj = beatService.sign(loginid);
		    return new ResponseEntity<Beat>(idj, HttpStatus.OK);
		}
	@RequestMapping(value = "/signlast", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Beat> signlast(@RequestParam String loginid,String password,String flag) {
			
		    Beat idj = beatService.signlast(loginid, password, flag);
		    return new ResponseEntity<Beat>(idj, HttpStatus.OK);
		}
	
}
