package com.alipay.sign;

public interface CAConfig {

	//算法名称
	String KEY_ALGORITHM = "RSA";
	/**
	 * C
	 */
	String CA_C = "CN";
	/**
	 * ST
	 */
	String CA_ST = "BJ";
	/**
	 * L
	 */
	String CA_L = "BJ";
	/**
	 */                                                                                                                                                                                                                                  
	String CA_O = "SICCA";
	
	/**
	 * CA_ROOT_ISSUER
	 */
	String CA_ROOT_ISSUER="C=CN,ST=BJ,L=BJ,O=SICCA,OU=SC,CN=SICCA";
	/**
	 * CA_DEFAULT_SUBJECT
	 */
	String CA_DEFAULT_SUBJECT="C=CN,ST=BJ,L=BJ,O=SICCA,OU=SC,CN=";
	
	String CA_SHA="SHA256WithRSAEncryption";

}