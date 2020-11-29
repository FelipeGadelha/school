package br.com.portfolio.rasmoo.school.api.handler;

import java.time.LocalDateTime;

public class ExceptionDetails<T extends ExceptionDetails.Builder<T>>{
	
	protected String title;
	protected int status;
	protected String details;
	protected String developerMessage;
	protected LocalDateTime timestamp;
	
	protected ExceptionDetails(Builder<T> builder) {
		this.title = builder.title;
		this.status = builder.status;
		this.details = builder.details;
		this.developerMessage = builder.developerMessage;
		this.timestamp = builder.timestamp;
	}
	
	protected static class Builder<T extends ExceptionDetails.Builder<T>> {
		private String title;
		private int status;
		private String details;
		private String developerMessage;
		private LocalDateTime timestamp;
				
		public T title(String title) {
			this.title = title;
			return (T)this;
		}
		public T status(int status) {
			this.status = status;
			return (T)this;
		}
		public T details(String details) {
			this.details = details;
			return (T)this;
		}
		public T developerMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return (T)this;
		}
		public T timestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
			return (T)this;
		}
		
		public ExceptionDetails<T> build() {
			return new ExceptionDetails<>(this);
		}
		
	}
	
//	public static class ExceptionDetailsBuilder implements ExceptionBuilder<ExceptionDetailsBuilder>{
//		private String title;
//		private int status;
//		private String details;
//		private String developerMessage;
//		private LocalDateTime timestamp;
//
//		public ExceptionDetailsBuilder() {}
//		
//		public ExceptionDetailsBuilder title(String title) {
//			this.title = title;
//			return this;
//		}
//		public ExceptionDetailsBuilder status(int status) {
//			this.status = status;
//			return this;
//		}
//		public ExceptionDetailsBuilder details(String details) {
//			this.details = details;
//			return this;
//		}
//		public ExceptionDetailsBuilder developerMessage(String developerMessage) {
//			this.developerMessage = developerMessage;
//			return this;
//		}
//		public ExceptionDetailsBuilder timestamp(LocalDateTime timestamp) {
//			this.timestamp = timestamp;
//			return this;
//		}
//		
//		public ExceptionDetails build() {
//			return new ExceptionDetails(this);
//		}
//	}

	public String getTitle() {
		return title;
	}

	public int getStatus() {
		return status;
	}

	public String getDetails() {
		return details;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}
