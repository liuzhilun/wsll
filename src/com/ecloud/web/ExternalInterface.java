package com.ecloud.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.sign.HttpUtil;
import com.ecloud.common.JsonResultCode;
import com.ecloud.common.UUIDUtils;
import com.ecloud.model.TBusBlackListVO;
import com.ecloud.model.TBusSearchRecordVO;
import com.ecloud.model.TBusUserInfoVO;
import com.ecloud.model.TInterfaceUsersVO;
import com.hansy.frame.exception.ServiceException;
import com.hansy.frame.service.IBaseService;

/**
 * 
 * @author liuzhilun
 * @20151021 查询黑名单，并做记录 专门用作跨域查询，提供给其他系统
 */
@Controller
public class ExternalInterface {
	@Autowired
	IBaseService baseService;

	public ExternalInterface() {

	}

	// 接口方式查询黑名单信息
	@RequestMapping(value = "/queryBusBlack", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> queryBusBlack(HttpServletResponse response,
			HttpServletRequest request) {
		    response.setCharacterEncoding("utf8");
		    List<TBusUserInfoVO> voLst;
		    Map<String, String> paramsMap = new HashMap<String, String>();
		    Map<String, String> map = new HashMap<String, String>();
		    String key="";
		    ServletInputStream inputStream  ;
			try {
				inputStream=request.getInputStream();
				 String uid=request.getParameter("uid");
				List<TInterfaceUsersVO> userVOLst= (List<TInterfaceUsersVO>)baseService.queryByHSql("from TInterfaceUsersVO where userId='"+uid+"'");
				if(userVOLst.isEmpty()){
					map.put("userInfo", "用户不存在！");
				}else{
					key=userVOLst.get(0).getKey();
				}
				paramsMap=HttpUtil.getRequestParamArray(inputStream,key);
				map.put("userInfo", "密钥验证成功！");
				map = queryBlack(response, request, map,paramsMap);
				// 验证完登陆信息后，查询黑名单内容
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				map.put("userInfo", "密钥验证失败！");
				return map;
			}
			return map;
	}

	// 查询黑名单
	public Map<String, String> queryBlack(HttpServletResponse response,
			HttpServletRequest request, Map<String, String> map , Map<String, String> paramsMap) {
		String custCertNo = paramsMap.get("custCertNo");
		String custMobNum = paramsMap.get("custMobNum");
		String bankAccount = paramsMap.get("bankAccount");
		String custName =  paramsMap.get("custName");
		String username =  paramsMap.get("username");
		
		if (custName == null || custCertNo == null || custMobNum == null) {
			map.put("userInfo", "客户姓名、证件号、手机号必传！");
		}
		try {
			Map<String, String> queryMap = new HashMap<String, String>();
			queryMap.put("custName", custName);
			queryMap.put("custCertNo", custCertNo);
			queryMap.put("custMobNum", custMobNum);
			queryMap.put("bankAccount", bankAccount);
			// 查询黑名单
			List<TBusBlackListVO> voLst = (List<TBusBlackListVO>) baseService
					.queryListByIBatis("busBlack.queryBusBlack", queryMap);
			if (voLst.isEmpty()) {
				String insertCode = insertQueryBlackRecord(JsonResultCode.FAIL
						+ "", username, queryMap);
				map.put("result", JsonResultCode.FAIL + "");
				return map;
			} else {
				String insertCode = insertQueryBlackRecord(
						JsonResultCode.SUCCESS + "", username, queryMap);
				map.put("result", JsonResultCode.SUCCESS + "");
				return map;
			}
		} catch (ServiceException e) {
			map.put("result", "系统错误！");
			return map;
		}
	}

	// 插入查询资料
	public String insertQueryBlackRecord(String result, String userLoginName,
			Map<String, String> map) {
		try {
			TBusSearchRecordVO srVO = new TBusSearchRecordVO();
			srVO.setSearchChannel("网页");
			srVO.setSearchUserLoginName("");
			if (map.get("custName") != null)
				srVO.setSearchCustName(map.get("custName"));
			if (map.get("custName") != null)
				srVO.setSearchMobNum(map.get("custMobNum"));
			if (map.get("custName") != null)
				srVO.setSearchCertNo(map.get("custCertNo"));
			if (map.get("custName") != null)
				srVO.setSearchBankAcc(map.get("bankAccount"));
			srVO.setSearchResult(result);
			srVO.setSearchRecordTime(new Date());
			srVO.setTableKey(UUIDUtils.getUUID());
			// 组装好VO并保存
			baseService.save(srVO);
			return "success";
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
