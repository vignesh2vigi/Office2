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
	

	@RequestMapping(value = "/loglast", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Beat> loglast(@RequestBody Beat beat) {
			System.out.println("beatlogin_query:sdfcvgbhnnm"+beat);
		    Beat idj = beatService.loglast(beat);
		    
			return new ResponseEntity<Beat>(idj, HttpStatus.OK);
		}
	@RequestMapping(value = "/log", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Beat> log (@RequestBody Beat beat) {
			System.out.println("beatlogin_query:sdfcvgbhnnm"+beat);
		    Beat idj = beatService.log(beat);
		    return new ResponseEntity<Beat>(idj, HttpStatus.OK);
		}
	@RequestMapping(value = "/finallog", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Beat> finallog (@RequestBody Beat beat) {
			System.out.println("beatlogin_query:sdfcvgbhnnm"+beat);
		    Beat idj = beatService.finallog(beat);
		    return new ResponseEntity<Beat>(idj, HttpStatus.OK);
		}
	/*@RequestMapping(value = "/adre", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Beat> adre (@RequestBody Beat beat) {
			System.out.println("beatlogin_query:sdfcvgbhnnm"+beat);
		    Beat idj = beatService.adrs(beat);
		    return new ResponseEntity<Beat>(idj, HttpStatus.OK);
		}*/
}
