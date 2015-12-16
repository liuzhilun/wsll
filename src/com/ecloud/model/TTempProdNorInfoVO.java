package com.ecloud.model;


/**
 * <p>decribing : 一般企业产品信息</p>
 * <p>copyright : Copyright @ 2012 hansy</p>
 * <p>company   : hansy</p>
 * <p>time      : 2013-7-10</p>
 *
 * @author Yogi
 * @version v1.0
 */
public class TTempProdNorInfoVO extends AbstractProdInfo {
	
	private String prodNo;
	private String prodName;
	private String chanNo;
	
	private String rateYear;
	private String loanMin;
	private String loanMax;
	
	//业务利率	add by hmzhou 2015-5-21 
	private String rateBus;
	
	public String getRateYear() {
		return rateYear;
	}
	public void setRateYear(String rateYear) {
		this.rateYear = rateYear;
	}
	public String getLoanMin() {
		return loanMin;
	}
	public void setLoanMin(String loanMin) {
		this.loanMin = loanMin;
	}
	public String getLoanMax() {
		return loanMax;
	}
	public void setLoanMax(String loanMax) {
		this.loanMax = loanMax;
	}
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
	public String getRateBus() {
		return rateBus;
	}
	public void setRateBus(String rateBus) {
		this.rateBus = rateBus;
	}
}
