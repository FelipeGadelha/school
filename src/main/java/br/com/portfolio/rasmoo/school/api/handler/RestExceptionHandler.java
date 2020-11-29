package br.com.portfolio.rasmoo.school.api.handler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.portfolio.rasmoo.school.api.exception.BadRequestException;

@ControllerAdvice
public class RestExceptionHandler { //extends ResponseEntityExceptionHandler{

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre){
		
		return new ResponseEntity<>(BadRequestExceptionDetails.builder()
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.BAD_REQUEST.value())
				.title("Bad Request Exception, Check the Documentation")
				.details(bre.getMessage())
				.developerMessage(bre.getClass().getName())
				.build(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationExceptionDetails> handlerMethodArgumentNotValidException(
			MethodArgumentNotValidException exception){
		
		List<FieldError> field = exception.getBindingResult().getFieldErrors();
		
		Map<String, Set<String>> map = field.stream().collect(
						Collectors.groupingBy(FieldError::getField, 
						Collectors.mapping(FieldError::getDefaultMessage, Collectors.toSet())));
		
		return new ResponseEntity<>(ValidationExceptionDetails.builder()
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.BAD_REQUEST.value())
				.title("Bad Request Exception")
				.details("Check the error field(s)")
				.developerMessage(exception.getClass().getName())
				.fieldError(map)
				.build(), HttpStatus.BAD_REQUEST);
	}
	
	
	
	
}
