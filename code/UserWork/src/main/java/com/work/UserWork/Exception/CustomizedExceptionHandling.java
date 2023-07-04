package com.work.UserWork.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleExceptions( UserNotFoundException exception, WebRequest webRequest) 
	{
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage("User Not found.");
        response.setError(HttpStatus.NOT_FOUND);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        return entity;
    }
	
	@ExceptionHandler(FillDataException.class)
	 public ResponseEntity<Object> handleExceptions( FillDataException exception, WebRequest webRequest) 
		{
	        ExceptionResponse response = new ExceptionResponse();
	        response.setDateTime(LocalDateTime.now());
	        response.setMessage("Please provide correct data in Request Body.");
	        response.setError(HttpStatus.BAD_REQUEST);
	        response.setStatus(HttpStatus.BAD_REQUEST.value());
	        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	        return entity;
	    }

//	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//		public ResponseEntity<Object> handleExceptions(HttpRequestMethodNotSupportedException exception, WebRequest webRequest) 
//		{
//	        ExceptionResponse response = new ExceptionResponse();
//	        response.setDateTime(LocalDateTime.now());
//	        response.setMessage("Please change the http method type.");
//	        response.setError(HttpStatus.METHOD_NOT_ALLOWED);
//	        response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
//	        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.METHOD_NOT_ALLOWED);
//	        return entity;
//	    }
}
