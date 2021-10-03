package com.iot.home.one.poc.dtos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



//@JsonIgnoreProperties({"id"}) // can be helpful only when converting object to json
@Entity
@Table(name ="deviceiot" )
public class DeviceIOT {
	
	

	@Size(min = 2)
	public String devicename;
	
	//@JsonIgnore // will only be helpful while converting object to json
	@Id
	@GeneratedValue
	public String id;
	
   	public String getDevicename() {
		return devicename;
	}
	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
