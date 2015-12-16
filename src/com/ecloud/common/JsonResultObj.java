package com.ecloud.common;

import java.io.Serializable;

/** Rest接口返回数据的包装器，主要用于通知是否操作（调用）成功与否（包含错误信息或Code）
 * @author 
 */
public class JsonResultObj implements Serializable {

	/** 变量 serialVersionUID(long) */
	private static final long serialVersionUID = 1L;
	
	private int code;
	private String message;
	private Object data;
	
	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
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
	
	/**
	 * @param obj 无用的参数，防止在JSON序列化时调用此方法，调用时请置为NULL.
	 * @return
	 */
	public Object getData(Object obj) {
		return this.data;
	}
	public void setData(Object obj) {
		this.data = obj;
	}
	
	
	/**
	 *  自定义信息
	 */
	public static JsonResultObj MESSAGE(int code){
		JsonResultObj rp=new JsonResultObj();
		rp.code=code;
		return rp;
	}
	
	public static JsonResultObj MESSAGE(int code, String message){
		JsonResultObj rp=new JsonResultObj();
		rp.code=code;
		rp.message=message;
		return rp;
	}
	public static JsonResultObj MESSAGE(int code, Object data){
		JsonResultObj rp=new JsonResultObj();
		rp.code=code;
		rp.data = data;
		return rp;
	}
	
	public static JsonResultObj MESSAGE(int code, String message, Object data){
		JsonResultObj rp=new JsonResultObj();
		rp.code=code;
		rp.message=message;
		rp.data=data;
		return rp;
	}

}
