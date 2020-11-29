package br.com.portfolio.rasmoo.school.api.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.portfolio.rasmoo.school.api.exception.BadRequestException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre){
		
		BadRequestExceptionDetails details = BadRequestExceptionDetails.builder()
		.timestamp(LocalDateTime.now())
		.status(HttpStatus.BAD_REQUEST.value())
		.title("Bad Request Exception, Check the Documentation")
		.details(bre.getMessage())
		.developerMessage(bre.getClass().getName())
		.build();
		
		System.out.println(details);
		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
}
