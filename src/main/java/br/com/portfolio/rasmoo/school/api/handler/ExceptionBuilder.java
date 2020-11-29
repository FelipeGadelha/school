package br.com.portfolio.rasmoo.school.api.handler;

import java.time.LocalDateTime;

public interface ExceptionBuilder<T> {

	public T title(String title);
	public T status(int status);
	public T details(String details);
	public T developerMessage(String developerMessage);
	public T timestamp(LocalDateTime timestamp);
	
	
	
}
