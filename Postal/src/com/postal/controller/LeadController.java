package com.postal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.postal.model.Lead;
import com.postal.service.Leadservice;

/*@Path("/lead")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})*/
@Controller
public class LeadController {
	
	/*@GET
	@Path(value="/getlead")
	public List<Lead>list(){
		LeadServiceImpl leadService= new LeadServiceImpl();
		List<Lead> list = leadService.list();
		return list;
		
	}*/
	@Autowired
	private Leadservice leadService;

	@RequestMapping(value = "/getlead", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Lead> getlead( @RequestBody Lead lead) {
		Lead id = leadService.getlead(lead);
		return new ResponseEntity<Lead>(id, HttpStatus.OK);
	}

	
	/*@RequestMapping(value = "/getlead", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Lead> getlead(@RequestBody Lead lead) {
		Lead id = leadService.list();
		return new ResponseEntity<Lead>(id, HttpStatus.OK);
	}*/

}
