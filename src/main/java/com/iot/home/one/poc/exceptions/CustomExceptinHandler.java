package com.iot.home.one.poc.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


// this is the handler // it handles different type of exceptions

@ControllerAdvice
@RestController
public class CustomExceptinHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException
	(Exception ex, WebRequest request) throws Exception {
		
		
			return new ResponseEntity<Object>(new ExceptionResponse(new Date(),ex.getMessage(),"foo"),HttpStatus.NOT_FOUND);
		}
	

	@ExceptionHandler(DeviceNotFoundException.class) // this line is important // have a look at it
	public final ResponseEntity<Object> handleDeviceException
	(Exception ex, WebRequest request) throws Exception {
		
		
			return new ResponseEntity<Object>(new ExceptionResponse(new Date(),"devicenot found","foo"),HttpStatus.NOT_FOUND);
		}
	
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		// we are not creating any Exceptin Response object while sending back, so a raw text will be sent
		return new ResponseEntity<Object>(ex.getBindingResult().toString(),HttpStatus.BAD_REQUEST);

	}
}
