package com.ecloud.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecloud.common.BeanMapUtils;
import com.ecloud.common.DateUtils;
import com.ecloud.common.JsonResultCode;
import com.ecloud.common.JsonResultObj;
import com.ecloud.common.JsonUtils;
import com.ecloud.common.RequestUtil;
import com.ecloud.common.UUIDUtils;
import com.ecloud.model.LoanBase;
import com.ecloud.model.ProdInfoVO;
import com.ecloud.model.TChannelVO;
import com.ecloud.model.TTempChannelInfoVO;
import com.ecloud.model.TTempPeriodProdVO;
import com.ecloud.model.TTempProdNorInfoVO;
import com.hansy.frame.exception.ServiceException;
import com.hansy.frame.service.IBaseService;

@Controller
@RequestMapping("/loanApp")
public class LoanApply {
	@Autowired
	IBaseService baseService;
	public LoanApply(){
		
	}
	
	//根据企业编号查询产品信息 返回产品信息 主要是利用利率计算对于的还款期数对应的还款金额
	@RequestMapping(value = "/getProdInfo",method = RequestMethod.GET)
	@ResponseBody
	public String getChanNoAndProInfo(HttpServletResponse response,HttpServletRequest request,String chanNo){
		int returnMessageCode = JsonResultCode.SUCCESS;
		JsonResultObj resultObj = null;
//		chanNo = request.getParameter("chanNo");
		chanNo = (String) RequestUtil.getParamMap(request).get("chanNo");
		if(chanNo == null || chanNo.equals("")){
			returnMessageCode = JsonResultCode.FAIL;
			resultObj = JsonResultObj.MESSAGE(returnMessageCode,"参数为空");
			return JsonUtils.toJson(resultObj);
		}else{
			try {
				TTempChannelInfoVO chan = (TTempChannelInfoVO) baseService.queryById(TTempChannelInfoVO.class, chanNo);
				if(chan == null){
					returnMessageCode = JsonResultCode.FAIL;
					resultObj = JsonResultObj.MESSAGE(returnMessageCode,"未查询到企业信息");
					return JsonUtils.toJson(resultObj);
				}else{
					List<TTempProdNorInfoVO> prodLst = (List<TTempProdNorInfoVO>) baseService.queryByValue(TTempProdNorInfoVO.class, "chanNo", chan.getChanNo());
					if(prodLst == null || prodLst.size() < 1){
						returnMessageCode = JsonResultCode.FAIL;
						resultObj = JsonResultObj.MESSAGE(returnMessageCode,"未查询到企业对应的产品信息");
						return JsonUtils.toJson(resultObj);
					}else{
						TChannelVO chanvo = new TChannelVO();
						chanvo.setChanName(chan.getChanName());
						chanvo.setChanNo(chan.getChanNo());
						List<ProdInfoVO> proLst = new ArrayList<ProdInfoVO>();
						for (TTempProdNorInfoVO prod : prodLst) {
							ProdInfoVO pro = new ProdInfoVO();
							pro.setChanNo(prod.getChanNo());
							pro.setLoanMax(prod.getLoanMax());
							pro.setLoanMin(prod.getLoanMin());
							pro.setProdName(prod.getProdName());
							pro.setRateYear(prod.getRateYear());
							pro.setProdNo(prod.getProdNo());
							List<TTempPeriodProdVO> perLst = (List<TTempPeriodProdVO>) baseService.queryByValue(TTempPeriodProdVO.class, "prodNo", prod.getProdNo());
							pro.setPerProd(perLst);
							proLst.add(pro);
						}
						chanvo.setProdvo(proLst);
						resultObj = JsonResultObj.MESSAGE(returnMessageCode, chanvo);
						return JsonUtils.toJson(resultObj);
					}
				}
			} catch (ServiceException e) {
				resultObj = JsonResultObj.MESSAGE(returnMessageCode,"系统错误");
				return JsonUtils.toJson(resultObj);
			}
			
		}
	}
	
	//贷款申请成功返回APPNO 业务编号
	@RequestMapping(value = "/push",method = RequestMethod.GET)
	@ResponseBody
	public String loanAppSave(HttpServletResponse response,HttpServletRequest request){
		 String appNo = request.getParameter("appNo");//业务编号
		 String custName = request.getParameter("custName");//客户姓名
		 String certNo = request.getParameter("certNo");//身份证号码
		 String totalPrice = request.getParameter("totalPrice");//商品总价
		 String firDownPay = request.getParameter("firDownPay");//首付金额
		 String loanAmt = request.getParameter("loanAmt");//贷款金额
		 String firRepayDate = request.getParameter("firRepayDate");//首次还款日
		 String mthRepayDate = request.getParameter("mthRepayDate");//每月还款日
		 String mthRepayAmt = request.getParameter("mthRepayAmt");//月还款
		 String installNum = request.getParameter("installNum");//分期期数
		 String repayAccount = request.getParameter("repayAccount");//还款账户
		 String repayAccountName = request.getParameter("repayAccountName");//还款帐户名
		 String applyDate = request.getParameter("applyDate");//申请日期
		 String phoneNumber = request.getParameter("phoneNumber");//客户电话
		 String chanNo = request.getParameter("chanNo");//企业编号
		 String proNo = request.getParameter("proNo");//产品编号
		 String busCode = request.getParameter("busCode");//业务识别码
		 String remak = request.getParameter("remak");//备用字段
		 String remak1 = request.getParameter("remak1");//备用字段1
		 //marques,brand,good_type
		 
		 int status = JsonResultCode.SUCCESS;
		 String appNoReturn = null;
		 JsonResultObj resultObj = null;
		 //String callbackFunName =request.getParameter("callbackparam");//得到js函数名称  
		 try {
			 Map map = RequestUtil.getParamMap(request);
			 LoanBase loan = (LoanBase) BeanMapUtils.toBean(LoanBase.class, map);
			 appNoReturn = String.valueOf(UUIDUtils.getInstance().getID());
			 loan.setRemark1("000002");
			 loan.setAppNo(appNoReturn);
			 loan.setApplyDate(DateUtils.getInternateDate("4"));
			 //baseService.saveByIBatis("", BeanMapUtils.toMap(loan));
			 baseService.saveByIBatis("rest.insertLoanBase", loan);
			 resultObj = JsonResultObj.MESSAGE(status,appNoReturn);
			 //String jsoncallback = callbackFunName +"({'result':"+JsonUtils.toJson(resultObj) +"})"; 
	        return JsonUtils.toJson(resultObj);

		} catch (Exception e) {
			resultObj = JsonResultObj.MESSAGE(1,"系统错误");
			//String jsoncallback = callbackFunName +"({'result':"+JsonUtils.toJson(resultObj) +"})"; 
	        return JsonUtils.toJson(resultObj);
		} 
	}
	
}