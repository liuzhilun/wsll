package com.ecloud.common;

import java.io.Serializable;

/** Rest接口返回数据的包装器，主要用于通知是否操作（调用）成功与否（包含错误信息或Code）
 * @author heshengchao@qq.com
 */
public class ReturnResult implements Serializable {

	/** 变量 serialVersionUID(long) */
	private static final long serialVersionUID = 1L;
	
	private int code;
	private String description;
	private Object data;
	
	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	public static ReturnResult SUCCESS(){
		return SUCCESS("成功");
	}
	public static ReturnResult SUCCESS(Object Data){
		return SUCCESS("成功",Data);
	}
	
	/**
	 * @param msg 成功信息
	 * @return
	 */
	public static ReturnResult SUCCESS(String description){
		ReturnResult rp=new ReturnResult();
		rp.code=MessageCode.STATUS_SUCESS;
		rp.description=description;
		return rp;
	}
	
	/**
	 * @param msg  成功信息
	 * @param data 返回数据
	 * @return
	 */
	public static ReturnResult SUCCESS(String description,Object data){
		ReturnResult rp=new ReturnResult();
		rp.code=MessageCode.STATUS_SUCESS;
		rp.description=description;
		rp.setData(data);
		return rp;
	}
	
	
	/** 
	 * @param msg 错误消息
	 * @return
	 */
	public static ReturnResult FAILUER(String description){
		ReturnResult rp=new ReturnResult();
		rp.code=MessageCode.STATUS_FAIL;
		rp.description=description;
		return rp;
	}
	
	/** 
	 * @param msg 错误消息
	 * @return
	 */
	public static ReturnResult FAILUER(String description,Object data){
		ReturnResult rp=new ReturnResult();
		rp.code=MessageCode.STATUS_FAIL;
		rp.description=description;
		rp.data=data;
		return rp;
	}
	
	/**
	 *  自定义信息
	 */
	public static ReturnResult MESSAGE(int code){
		ReturnResult rp=new ReturnResult();
		rp.code=code;
		return rp;
	}

	public static ReturnResult MESSAGE(String description){
		ReturnResult rp=new ReturnResult();
		rp.description=description;
		return rp;
	}
	
	public static ReturnResult MESSAGE(int code, String description){
		ReturnResult rp=new ReturnResult();
		rp.code=code;
		rp.description=description;
		return rp;
	}
	
	public static ReturnResult MESSAGE(int code, String description, Object data){
		ReturnResult rp=new ReturnResult();
		rp.code=code;
		rp.description=description;
		rp.data=data;
		return rp;
	}

}
