package io.swagger.api;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-13T22:59:20.852Z")

public class ApiException extends Exception{
	private int code;
	
	public ApiException (int code, String msg) {
		super(msg);
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	
}
