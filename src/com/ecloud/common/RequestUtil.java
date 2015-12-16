package com.ecloud.common;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RequestUtil {
	private static Logger logger = LoggerFactory.getLogger(RequestUtil.class);
	
	
	
	/**
	 * request中获取参数map
	 * @param request
	 * @return
	 */
	public static Map<String, Object> getParamMap(HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		Iterator entries = request.getParameterMap().entrySet().iterator();
		Map.Entry entry;
		String name = "";
		while (entries.hasNext()) {
			String value = "";
			entry = (Map.Entry) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value += values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();
			}
			try {
				params.put(name, new String((value.getBytes("ISO-8859-1")),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return params;
	}
	
	/**
	 * 获取参数值
	 * @param request
	 * @param key
	 * @return
	 */
	public static String getParamString(HttpServletRequest request, String key) {
		return request.getParameter(key);
	}

	/**
	 * request中获取参数map 获取未经过tomcat编码的传参
	 * @param request
	 * @return
	 */
	public static Map<String, String> getParamMapNotEnCode(HttpServletRequest request) {
		String paramsString=request.getQueryString();
		String encodedParams = null;
		try {
			encodedParams = URLDecoder.decode(paramsString,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String[] params=encodedParams.split("&");
		Map<String, String> paramMap=new HashMap<String, String>();	
		for(int i=0;i<params.length;i++){
			String key=params[i].split("=")[0];
			String value="";
			if(params[i].split("=").length == 2 ){
				value=params[i].split("=")[1];
			}
			paramMap.put(key,value);
		}
		return paramMap;
	}
	
	/**
	 * 获取IP地址
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * 对象转换为int
	 * @param valueObj
	 * @return
	 */
	private static int getIntegerValue(Object valueObj) {
		if(valueObj instanceof String[]){
			String[] values = (String[]) valueObj;
			return Integer.parseInt(values[0]);
		} else {
			return Integer.parseInt((String) valueObj);
		}
	}

}
