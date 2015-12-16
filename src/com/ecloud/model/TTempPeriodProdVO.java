package com.ecloud.model;
/**
 * <p>decribing : 产品期数关联</p>
 * <p>copyright : Copyright @ 2012 hansy</p>
 * <p>company   : hansy</p>
 * <p>time      : 2013-7-10</p>
 *
 * @author Yogi
 * @version v1.0
 */
public class TTempPeriodProdVO {
	
	private String ppNo;
	private String prodNo;
	private int ppValue;
	private Double ppRate;
	private Double amRate;//月账户管理费率
	private Double insFeeRate;//月保险手续费率
	private String difference;//贷款差额
	
	public String getPpNo() {
		return ppNo;
	}
	public void setPpNo(String ppNo) {
		this.ppNo = ppNo;
	}
	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	public Double getPpRate() {
		return ppRate;
	}
	public void setPpRate(Double ppRate) {
		this.ppRate = ppRate;
	}
	public int getPpValue() {
		return ppValue;
	}
	public void setPpValue(int ppValue) {
		this.ppValue = ppValue;
	}
	public Double getAmRate() {
		return amRate;
	}
	public void setAmRate(Double amRate) {
		this.amRate = amRate;
	}
	public Double getInsFeeRate() {
		return insFeeRate;
	}
	public void setInsFeeRate(Double insFeeRate) {
		this.insFeeRate = insFeeRate;
	}
	public String getDifference() {
		return difference;
	}
	public void setDifference(String difference) {
		this.difference = difference;
	}
	
}
