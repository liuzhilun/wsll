package com.ecloud.model;

import java.util.Date;

/**
 * 
 * @author liuzhilun
 * @time 2015-10-20
 * 黑名单查询记录业务bean
 */


public class TBusSearchRecordVO {
	
	private String tableKey;//主键
	private String searchUserLoginName;//查询人登录ID
	private String searchChannel;//查询渠道|网页、接口
	private Date searchRecordTime;//查询时间
	private String searchMobNum;//提交查询手机号
	private String searchCertNo;//提交查询身份证号
	private String searchCustName;//提交查询客户姓名
	private String searchBankAcc;//提交查询银行账号
	private String searchResult;//查询结果
	private String remark;//备注
	private String searchType;//查询类型
	public String getTableKey() {
		return tableKey;
	}
	public void setTableKey(String tabkeKey) {
		this.tableKey = tabkeKey;
	}
	public String getSearchUserLoginName() {
		return searchUserLoginName;
	}
	public void setSearchUserLoginName(String searchUserLoginName) {
		this.searchUserLoginName = searchUserLoginName;
	}
	public String getSearchChannel() {
		return searchChannel;
	}
	public void setSearchChannel(String searchChannel) {
		this.searchChannel = searchChannel;
	}
	public Date getSearchRecordTime() {
		return searchRecordTime;
	}
	public void setSearchRecordTime(Date searchRecordTime) {
		this.searchRecordTime = searchRecordTime;
	}
	public String getSearchMobNum() {
		return searchMobNum;
	}
	public void setSearchMobNum(String searchMobNum) {
		this.searchMobNum = searchMobNum;
	}
	public String getSearchCertNo() {
		return searchCertNo;
	}
	public void setSearchCertNo(String searchCertNo) {
		this.searchCertNo = searchCertNo;
	}
	public String getSearchCustName() {
		return searchCustName;
	}
	public void setSearchCustName(String searchCustName) {
		this.searchCustName = searchCustName;
	}
	public String getSearchBankAcc() {
		return searchBankAcc;
	}
	public void setSearchBankAcc(String searchBankAcc) {
		this.searchBankAcc = searchBankAcc;
	}
	public String getSearchResult() {
		return searchResult;
	}
	public void setSearchResult(String searchResult) {
		this.searchResult = searchResult;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
}
