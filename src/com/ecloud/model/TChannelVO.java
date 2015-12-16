package com.ecloud.model;

import java.util.List;



public class TChannelVO {
	
	private String chanNo;							//企业编号
	private String chanName;						//企业名称
	private List<ProdInfoVO> prodvo;
	public String getChanNo() {
		return chanNo;
	}
	public void setChanNo(String chanNo) {
		this.chanNo = chanNo;
	}
	public String getChanName() {
		return chanName;
	}
	public void setChanName(String chanName) {
		this.chanName = chanName;
	}
	public List<ProdInfoVO> getProdvo() {
		return prodvo;
	}
	public void setProdvo(List<ProdInfoVO> prodvo) {
		this.prodvo = prodvo;
	}
	
}
