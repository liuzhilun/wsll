package com.alipay.util;

import java.util.Map;

import com.alipay.config.AlipayConfig;

public class AlipayParam {

	public static void initParam(Map<String, String> sParaTemp){
		sParaTemp.put("service", "create_direct_pay_by_user");
		// 合作身份者ID
        sParaTemp.put("partner", AlipayConfig.partner);
        // 字符编码格式
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
        //支付类型//必填，不能修改
		sParaTemp.put("payment_type", "1");
		//卖家支付宝帐户
		sParaTemp.put("seller_email", "huanggc@ecloudpc.cn");
	}
	
}
