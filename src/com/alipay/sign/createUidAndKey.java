package com.alipay.sign;

import java.util.Date;

import com.hansy.web.common.tools.UUIDGenerator;

public class createUidAndKey {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
   System.out.println("唯一的UUID值："+UUIDGenerator.generate(new Date()));
	}

}
