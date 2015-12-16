package com.ecloud.model;

import java.util.Date;

/**
 * 
 * @author liuzhilun
 * @time 2015-10-20
 * 黑名单业务bean
 */

public class TBusBlackListVO {
	
	private String tableKey;//主键
	private String custName;//姓名
	private String custCertNo;//证件号
	private String custCertType;//证件类型
	private String custMobNum;//手机号码
	private String bankAccount;//银行卡号
	private String status;//状态
	private Date recordTime;//记录时间
	private String recordUser;//记录人
	private String applyUser;//审核人
	private Date applyTime;//审核时间
	private String remark;//备注
	public String getTableKey() {
		return tableKey;
	}
	public void setTableKey(String tableKey) {
		this.tableKey = tableKey;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustCertNo() {
		return custCertNo;
	}
	public void setCustCertNo(String custCertNo) {
		this.custCertNo = custCertNo;
	}
	public String getCustCertType() {
		return custCertType;
	}
	public void setCustCertType(String custCertType) {
		this.custCertType = custCertType;
	}
	public String getCustMobNum() {
		return custMobNum;
	}
	public void setCustMobNum(String custMobNum) {
		this.custMobNum = custMobNum;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	public String getRecordUser() {
		return recordUser;
	}
	public void setRecordUser(String recordUser) {
		this.recordUser = recordUser;
	}
	public String getApplyUser() {
		return applyUser;
	}
	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
