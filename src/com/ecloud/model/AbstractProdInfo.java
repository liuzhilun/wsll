/**
 * 
 */
package com.ecloud.model;

/**
 * <p>decribing : 产品父类</p>
 * <p>copyright : Copyright @ 2012 hansy</p>
 * <p>company   : hansy</p>
 * <p>time      : 2013-7-12</p>
 *
 * @author jfeng
 * @version v1.0
 */
public class AbstractProdInfo {
	private String prodNo;
	private String prodName;
	private String chanNo;
	
	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getChanNo() {
		return chanNo;
	}
	public void setChanNo(String chanNo) {
		this.chanNo = chanNo;
	}
}
