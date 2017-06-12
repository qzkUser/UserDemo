package com.qzk.exception;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ServiceRuntimeException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ServiceRuntimeException(){};
	
	public ServiceRuntimeException(String msg){
		super(msg);
	}

	@Override
	public void printStackTrace() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		super.printStackTrace(new PrintStream(baos));
		String exception = baos.toString();
        System.out.println("exception:" + exception);
	}
	
}
