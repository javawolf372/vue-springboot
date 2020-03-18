package com.exa.vuespringboot.entity;

import java.io.Serializable;

public class ResponseResult implements Serializable{
	
	private static final long serialVersionUID = -3124924934996326716L;
	
	public static final Integer SUCCESS_CODE = 200;//成功
	public static final Integer NO_AUTH_CODE = 413;//无权限
	public static final Integer FAIL_CODE = 500;//错误
	
	private Integer code;
	private String message;
	private Object data;

	public ResponseResult(Integer code) {
		this.code = code;
	}
	
	public ResponseResult(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public ResponseResult(Integer code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
