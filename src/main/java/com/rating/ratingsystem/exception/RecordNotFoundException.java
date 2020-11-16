package com.rating.ratingsystem.exception;

public class RecordNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1237456L;

	public RecordNotFoundException(String exception) {
		super(exception);
	}
	
	public RecordNotFoundException(String exception, boolean isErrorIdHidden) {
		super(exception);
	}
}
