package com.ramirez.eventos.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.ramirez.eventos.exception.GeneralException;
import com.ramirez.eventos.exception.NoDataFoundException;
import com.ramirez.eventos.exception.ValidateException;
import com.ramirez.eventos.util.WrapperResponse;

@ControllerAdvice
public class ErrorHandlerConfig {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> all(Exception e, WebRequest request){
		WrapperResponse<?> response = new WrapperResponse<>(false, "Internal server error", null);
		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(ValidateException.class)
	public ResponseEntity<?> validation(Exception e, WebRequest request){
		WrapperResponse<?> response = new WrapperResponse<>(false, e.getMessage(), null);
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<?> NoData(Exception e, WebRequest request){
		WrapperResponse<?> response = new WrapperResponse<>(false, e.getMessage(), null);
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(GeneralException.class)
	public ResponseEntity<?> general(Exception e, WebRequest request){
		WrapperResponse<?> response = new WrapperResponse<>(false, "Internal server error", null);
		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
