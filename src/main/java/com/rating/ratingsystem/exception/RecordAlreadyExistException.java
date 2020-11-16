package com.rating.ratingsystem.exception;

public class RecordAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1237456L;

	public RecordAlreadyExistException(String exception) {
		super(exception);
	}
	
	public RecordAlreadyExistException(String exception, boolean isErrorIdHidden) {
		super(exception);
	}
}
