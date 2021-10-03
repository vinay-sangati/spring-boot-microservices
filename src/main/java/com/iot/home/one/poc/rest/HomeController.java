package com.iot.home.one.poc.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iot.home.one.poc.dtos.DeviceIOT;
import com.iot.home.one.poc.exceptions.DeviceNotFoundException;
import com.iot.home.one.poc.service.DeviceService;


// @Controller
//@ResponseBody

@RestController
public class HomeController {

	
	List<String> conc = new ArrayList<String>();
	
	@Autowired
	DeviceService deviceService;
	
	@RequestMapping(path = "/addnewDevice",method = RequestMethod.POST)
	//@ResponseStatus(code=HttpStatus.CREATED)
	public ResponseEntity<String> addDevice(@Valid @RequestBody DeviceIOT device) {
		
		deviceService.addDeice(device);
		
	URI location =	ServletUriComponentsBuilder.
		fromCurrentRequest().path("/{id}").
		buildAndExpand(device.getId()).
		toUri();
		
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/allDevices")
	public ResponseEntity<List<DeviceIOT>> getAllDevices(){
		
		ResponseEntity<List<DeviceIOT>> responseEntity  = new ResponseEntity<List<DeviceIOT>>(deviceService.getAllDevices(),new HttpHeaders(),HttpStatus.OK);
 		
		return responseEntity;
	}
	
	
	@RequestMapping(value="/addval/{iotId}") // is also correct // value is alias for path attribute
	public String getDevice(@PathVariable String iotId) {
		conc.add(iotId);
		return "added";
	}
	@GetMapping(value="/allGet")
	public List<String> getAllDevices(@RequestParam String requestparam) {
		return conc;
	}
	
	@GetMapping("/exceptionCheck")
	public ResponseEntity<Object> exceptioncheck(){
		
		throw new DeviceNotFoundException("custom Exception");
		
		//return null;
	}

	
}
