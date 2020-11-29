package br.com.portfolio.rasmoo.school.api.handler;

public class BadRequestExceptionDetails<T extends BadRequestExceptionDetails.Builder<T>> extends ExceptionDetails<T>{
	
	protected BadRequestExceptionDetails(Builder<T> builder) {
		super(builder);
	}

	public static class Builder<T extends BadRequestExceptionDetails.Builder<T>> extends ExceptionDetails.Builder<T> {
		
		public BadRequestExceptionDetails<T> build() {
			return new BadRequestExceptionDetails<>(this);
		}
		
	}
	
}
