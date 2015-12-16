package com.ecloud.web;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecloud.common.RequestUtil;
import com.ecloud.common.UUIDUtils;
import com.ecloud.model.TBusUserInfoVO;
import com.hansy.frame.exception.ServiceException;
import com.hansy.frame.service.IBaseService;
/**
 * 
 * @author 张宇浩
 * @20151020
 * 用户注册
 */
@Controller
public class RegistAction {
	
	@Autowired
	private IBaseService baseService;
	
	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> saveRegistUser(HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf8");
		Map<String,String> result = new HashMap<String,String>();
		//获取未经过tomcat编码的传参
		TBusUserInfoVO user = null;
		if (request.getParameter("tableKey") == null || "".equals(request.getParameter("tableKey"))){
			user = new TBusUserInfoVO();
			user.setCreateTime(new Date());
			user.setTableKey(UUIDUtils.getUUID());
		}else{
			try {
				user = (TBusUserInfoVO) baseService.queryById(TBusUserInfoVO.class, request.getParameter("tableKey"));
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		user.setUserLoginName(request.getParameter("userLoginName"));
		user.setUserName(request.getParameter("userName"));
		user.setUserPhoneNum(request.getParameter("userPhoneNum"));
		user.setUserEmail(request.getParameter("userEmail"));
		user.setUserCertType(request.getParameter("userCertType"));
		user.setUserCertNo(request.getParameter("userCertNo"));
		user.setUserComName(request.getParameter("userComName"));
		user.setUserComAddr(request.getParameter("userComAddr"));
		user.setRemark(request.getParameter("remark"));
		user.setUserSex(request.getParameter("userSex"));
		user.setUserLoginPwd(request.getParameter("userLoginPwd"));
		if (request.getParameter("tableKey") == null || "".equals(request.getParameter("tableKey"))){
			try {
				baseService.save(user);
				result.put("info", "success");
				return result;
			} catch (ServiceException e) {
				e.printStackTrace();
				result.put("info", "failed");
				return result;
			}
		}else{
			try {
				baseService.update(user);
				result.put("info", "success");
				return result;
			} catch (ServiceException e) {
				e.printStackTrace();
				result.put("info", "failed");
				return result;
			}
		}
	}
	
	@RequestMapping(value="/getUserByLoginName", method=RequestMethod.GET)
	@ResponseBody
	public TBusUserInfoVO getUserById(HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException{
		Map<String, String> paramsMap = new HashMap<String, String>();
		//获取未经过tomcat编码的传参
		paramsMap=RequestUtil.getParamMapNotEnCode(request);
		String userLoginName = paramsMap.get("userLoginName");
		try {
			List<TBusUserInfoVO> lst = (List<TBusUserInfoVO>) baseService.queryByValue(TBusUserInfoVO.class, "userLoginName", userLoginName);
			return lst.get(0);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	@RequestMapping(value="/checkLoginName", method=RequestMethod.GET)
	@ResponseBody
	public boolean checkLoginName(HttpServletResponse response,HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf8");
		String userLoginName = request.getParameter("userLoginName");
		List<TBusUserInfoVO> lst = (List<TBusUserInfoVO>) baseService.queryByValue(TBusUserInfoVO.class, "userLoginName", userLoginName);
		return (lst.size() == 0) ? true : false;
		
	}
	
	@RequestMapping(value="/checkPhoneNo", method=RequestMethod.GET)
	@ResponseBody
	public boolean checkPhoneNo(HttpServletResponse response,HttpServletRequest request) throws Exception{
		String userPhoneNum = request.getParameter("userPhoneNum");
		List<TBusUserInfoVO> lst = (List<TBusUserInfoVO>) baseService.queryByValue(TBusUserInfoVO.class, "userPhoneNum", userPhoneNum);
		return (lst.size() == 0) ? true : false;
		
	}
	
	@RequestMapping(value="/checkUpdatePhoneNo", method=RequestMethod.GET)
	@ResponseBody
	public boolean checkUpdatePhoneNo(HttpServletResponse response,HttpServletRequest request) throws Exception{
		String userPhoneNum = request.getParameter("userPhoneNum");
		String tableKey = request.getParameter("tableKey");
		List<TBusUserInfoVO> lst = (List<TBusUserInfoVO>) baseService.queryByValue(TBusUserInfoVO.class, "userPhoneNum", userPhoneNum);
		if ((lst.size() > 0 && tableKey.equals(lst.get(0).getTableKey())) || lst.size() == 0){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping(value="/checkUpdateEmail", method=RequestMethod.GET)
	@ResponseBody
	public boolean checkUpdateEmail(HttpServletResponse response,HttpServletRequest request) throws Exception{
		String userEmail = request.getParameter("userEmail");
		String tableKey = request.getParameter("tableKey");
		List<TBusUserInfoVO> lst = (List<TBusUserInfoVO>) baseService.queryByValue(TBusUserInfoVO.class, "userEmail", userEmail);
		if ((lst.size() > 0 && tableKey.equals(lst.get(0).getTableKey())) || lst.size() == 0){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping(value="/checkEmail", method=RequestMethod.GET)
	@ResponseBody
	public boolean checkEmail(HttpServletResponse response,HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf8");
		String userEmail = request.getParameter("userEmail");
		List<TBusUserInfoVO> lst = (List<TBusUserInfoVO>) baseService.queryByValue(TBusUserInfoVO.class, "userEmail", userEmail);
		return (lst.size() == 0) ? true : false;
		
	}
}
