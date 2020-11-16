package com.rating.ratingsystem.exception;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ErrorResponse implements Serializable {
	
	private static final long serialVersionUID = 1237456L;
	
	private long errorId;
	private boolean isErrorIdHidden;
	private Date timestamp;
    private String status;
    private String message;
    private List<String> details;

	public ErrorResponse(String status, String message, List<String> details, boolean isErrorIdHidden) {
		super();
		this.timestamp = new Date();
		this.errorId = System.currentTimeMillis();
		this.status = status;
		this.message = message;
		this.details = details;
		this.isErrorIdHidden = isErrorIdHidden;
	}
    
	public ErrorResponse(String status, String message, List<String> details) {
		super();
		this.timestamp = new Date();
		this.errorId = System.currentTimeMillis();
		this.status = status;
		this.message = message;
		this.details = details;
	}

}
