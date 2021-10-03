package com.iot.home.one.poc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.iot.home.one.poc.dtos.DeviceIOT;

@Component
public class DeviceService {

	
	List<DeviceIOT> devices = new ArrayList<DeviceIOT>();
	
	public String addDeice(DeviceIOT newDevice) {
		
		devices.add(newDevice);
		return "succcc";
		
	}
	
	public List<DeviceIOT> getAllDevices(){
		
		return devices;
		
	}
	
	
}
