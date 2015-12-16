package com.ecloud.model;

import java.util.List;


public class ProdInfoVO extends AbstractProdInfo {
	
	private String prodNo;
	private String prodName;
	private String chanNo;
	private String rateYear;
	private String loanMin;
	private String loanMax;
	private List<TTempPeriodProdVO> perProd;

	public List<TTempPeriodProdVO> getPerProd() {
		return perProd;
	}

	public void setPerProd(List<TTempPeriodProdVO> perProd) {
		this.perProd = perProd;
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
}
