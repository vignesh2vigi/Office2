package com.postal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.postal.model.Beat;
import com.postal.service.BeatService;

@Controller
public class BeatController {
	
	@Autowired
	private BeatService beatService;

	@RequestMapping(value = "/login", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Beat> login(@RequestBody Beat beat) {
	    Beat idj = beatService.login(beat);
		return new ResponseEntity<Beat>(idj, HttpStatus.OK);
	}
     
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
	
	
	
}
