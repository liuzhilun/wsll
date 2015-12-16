package com.ecloud.web;

import java.io.UnsupportedEncodingException;
import java.util.Date;
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
import com.ecloud.common.UUIDUtils;
import com.ecloud.model.TBusBlackListVO;
import com.ecloud.model.TBusSearchRecordVO;
import com.ecloud.model.TBusUserInfoVO;
import com.hansy.frame.exception.ServiceException;
import com.hansy.frame.service.IBaseService;
/**
 * 
 * @author liuzhilun
 * @20151020
 * 查询黑名单，并做记录 
 */
@Controller
public class BlackController {
	@Autowired
	IBaseService baseService;
	public BlackController(){
		
	}
	//查询黑名单
	@RequestMapping(value = "/queryBlack",method = RequestMethod.GET)
	public @ResponseBody
	Map<String, String> queryBlack(HttpServletResponse response,HttpServletRequest request){
		response.setCharacterEncoding("utf8");
	
		String custCertType = request.getParameter("custCertType");
		String custCertNo = request.getParameter("custCertNo");
		String custMobNum = request.getParameter("custMobNum");
		String bankAccount = request.getParameter("bankAccount");
		String status = request.getParameter("status");
		Map<String, String> paramsMap = new HashMap<String, String>();
		//获取未经过tomcat编码的传参
		paramsMap=RequestUtil.getParamMapNotEnCode(request);
		String custName = paramsMap.get("custName");
		String userLoginName = paramsMap.get("userLoginName");
			try {
				Map<String, String> map=new HashMap<String, String>();
				map.put("custName", custName);
				map.put("custCertType", custCertType);
				map.put("custCertNo", custCertNo);
				map.put("custMobNum", custMobNum);
				map.put("bankAccount", bankAccount);
				map.put("status", status);
				//查询黑名单
				List<TBusBlackListVO> voLst = (List<TBusBlackListVO>) baseService.queryListByIBatis("busBlack.queryBusBlack", map);
				if(voLst.isEmpty()){
					String insertCode=insertQueryBlackRecord(JsonResultCode.FAIL+"",userLoginName,map);
					Map<String, String> resultMap = new HashMap<String, String>();
					resultMap.put("result",JsonResultCode.FAIL+"");
					resultMap.put("insertCode",insertCode);
					return resultMap;
				}else{
					String insertCode=insertQueryBlackRecord(JsonResultCode.SUCCESS+"",userLoginName,map);
					Map<String, String> resultMap = new HashMap<String, String>();
					resultMap.put("result",JsonResultCode.SUCCESS+"" );
					resultMap.put("insertCode",insertCode);
					return resultMap;
				}
			} catch (ServiceException e) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("result","系统错误！" );
				return map;
			}
		}
	//插入查询资料
	public String insertQueryBlackRecord(String result,String userLoginName,Map<String, String> map){
		try {
				TBusSearchRecordVO srVO= new TBusSearchRecordVO();
				srVO.setSearchChannel("网页");
				srVO.setSearchUserLoginName(userLoginName);
				if(map.get("custName") !=null)
				srVO.setSearchCustName(map.get("custName"));
				if(map.get("custName") !=null)
				srVO.setSearchMobNum(map.get("custMobNum"));
				if(map.get("custName") !=null)
				srVO.setSearchCertNo(map.get("custCertNo"));
				if(map.get("custName") !=null)
				srVO.setSearchBankAcc(map.get("bankAccount"));
				srVO.setSearchResult(result);
				srVO.setSearchRecordTime(new Date());
				srVO.setTableKey(UUIDUtils.getUUID());
				//组装好VO并保存
				baseService.save(srVO);
				return "success";
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	//更改用户密码
		@RequestMapping(value = "/changeUserPwd",method = RequestMethod.GET)
		public @ResponseBody
		Map<String, String> changeUserPwd(HttpServletResponse response,HttpServletRequest request){
			response.setCharacterEncoding("utf8");
			String newPassword  = request.getParameter("newPassword");
			String oldPassword = request.getParameter("oldPassword");
			String userLoginName = request.getParameter("userLoginName");
			Map<String, String> map = new HashMap<String, String>();
			//code 0:用户不存在！ 1：密码错误！ 2：修改成功！3：系统错误！
				try {
					userLoginName = new String((userLoginName.getBytes("ISO-8859-1")),"UTF-8");
					List<TBusUserInfoVO> voLst = (List<TBusUserInfoVO>) baseService.queryByValue(TBusUserInfoVO.class, "userLoginName", userLoginName);
					if(voLst.isEmpty()){
						map.put("info","0");
						return map;
					}else{
						if(!oldPassword.equals(voLst.get(0).getUserLoginPwd())){
							map.put("info","1" );
							return map;
						}else{
							TBusUserInfoVO vo=voLst.get(0);
							vo.setUserLoginPwd(newPassword);
							baseService.update(vo);
							map.put("info","2" );
							return map;
						}
					}
				} catch (ServiceException e) {
					map.put("info","3" );
					return map;
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					map.put("info","3" );
					return map;
				}
			}
	}
	
