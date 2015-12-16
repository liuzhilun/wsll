package com.ecloud.model;
/**
 * 
 * <p>decribing : 企业信息</p>
 * <p>copyright : Copyright @ 2012 hansy</p>
 * <p>company   : hansy</p>
 * <p>time      : 2013-7-9</p>
 *
 * @author Yogi
 * @version v1.0
 */
public class TTempChannelInfoVO {
	
	private String chanNo;							//企业编号
	private String chanName;						//企业名称
	private String chinapayMerid;					//商户ID
	private String chinapayMerkey;					//银联密钥
	private String chinapayUsername;				//银联用户名
	private String chinapayPassword;				//银联密码
	private String comOrg;							//公司
	private String comAcc;							//帐号
	private String openOrg;							//开户行
	private String repayType;						//还款方式|等额本金，等额本息
	private String settleOrder;						//结算顺序
	private String appFlow;							//审批流
	private String managerUser;						//企业管理员
	
	
	
	public String getManagerUser() {
		return managerUser;
	}
	public void setManagerUser(String managerUser) {
		this.managerUser = managerUser;
	}
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
	public String getChinapayMerid() {
		return chinapayMerid;
	}
	public void setChinapayMerid(String chinapayMerid) {
		this.chinapayMerid = chinapayMerid;
	}
	public String getChinapayMerkey() {
		return chinapayMerkey;
	}
	public void setChinapayMerkey(String chinapayMerkey) {
		this.chinapayMerkey = chinapayMerkey;
	}
	public String getChinapayUsername() {
		return chinapayUsername;
	}
	public void setChinapayUsername(String chinapayUsername) {
		this.chinapayUsername = chinapayUsername;
	}
	public String getChinapayPassword() {
		return chinapayPassword;
	}
	public void setChinapayPassword(String chinapayPassword) {
		this.chinapayPassword = chinapayPassword;
	}
	public String getComOrg() {
		return comOrg;
	}
	public void setComOrg(String comOrg) {
		this.comOrg = comOrg;
	}
	public String getComAcc() {
		return comAcc;
	}
	public void setComAcc(String comAcc) {
		this.comAcc = comAcc;
	}
	public String getOpenOrg() {
		return openOrg;
	}
	public void setOpenOrg(String openOrg) {
		this.openOrg = openOrg;
	}
	public String getRepayType() {
		return repayType;
	}
	public void setRepayType(String repayType) {
		this.repayType = repayType;
	}
	public String getSettleOrder() {
		return settleOrder;
	}
	public void setSettleOrder(String settleOrder) {
		this.settleOrder = settleOrder;
	}
	public String getAppFlow() {
		return appFlow;
	}
	public void setAppFlow(String appFlow) {
		this.appFlow = appFlow;
	}
	
}
