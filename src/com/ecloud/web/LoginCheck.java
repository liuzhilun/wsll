package com.ecloud.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecloud.common.JsonResultCode;
import com.ecloud.common.RequestUtil;
import com.ecloud.model.TBusUserInfoVO;
import com.google.gson.Gson;
import com.hansy.frame.exception.ServiceException;
import com.hansy.frame.service.IBaseService;
/**
 * 
 * @author liuzhilun
 * @20151020
 * 登陆验证 
 */
@Controller
public class LoginCheck {
	@Autowired
	IBaseService baseService;
	public LoginCheck(){
		
	}
	//查询黑名单信息
	@RequestMapping(value = "/loginCheck",method = RequestMethod.GET)
	public @ResponseBody
	Map<String, String> loginCheck(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf8");
		String password = request.getParameter("password");
		Map<String, String> paramsMap = new HashMap<String, String>();
		//获取未经过tomcat编码的传参
		paramsMap=RequestUtil.getParamMapNotEnCode(request);
		String userName = paramsMap.get("username");
			try {
				List<TBusUserInfoVO> voLst = (List<TBusUserInfoVO>) baseService.queryByValue(TBusUserInfoVO.class, "userLoginName", userName);
				if(voLst.isEmpty()){
					Map<String, String> map = new HashMap<String, String>();
					map.put("info","用户不存在！");
					return map;
				}else{
					Map<String, String> map = new HashMap<String, String>();
					if(!password.equals(voLst.get(0).getUserLoginPwd())){
						map.put("info","密码错误！" );
						return map;
					}
					HttpSession se=request.getSession();
					se.setAttribute("username", userName);
					Gson gson= new Gson();
					String data=gson.toJson(voLst);
					map.put("userInfo", data);
					map.put("info",JsonResultCode.SUCCESS+"" );
					return map;
				}
			} catch (ServiceException e) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("info","系统错误！" );
				return map;
			}
		}
	}
	
