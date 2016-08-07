package com.devil.exception;

public class HttpException extends Exception {
	private static final long serialVersionUID = -2722402769494529066L;
	public static int code = 101;
	public static String message = "Http请求异常:";

	public HttpException(String e) {
		super(e);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getMessage()+"|"+message;
	}

}