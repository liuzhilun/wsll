package com.alipay.sign;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import net.sf.json.JSONSerializer;
  
  
  
public class AEStest { 
	/**
	 * 工具类使用说明
	 * 一：向我们申请uid和私钥key
	 * 二：将参数包装进map，然后生成json格式字符串
	 * 三：利用 byte[] byteRe=enCrypt(str,key)进行加密 
	 * 四： //加密过的二进制数组转化成16进制的字符串    encrytStr = parseByte2HexStr(byteRe);   
	 * 五：利用httpUtil工具类发送Post的方法讲组装的参数发到服务器，返回json格式字符串 如：{"result":"0","userInfo":"密钥验证成功！"}
	 */
      
    public static void main(String[] args) throws Exception {  
        // TODO Auto-generated method stub  
    	Map<String,String> map=new HashMap(); 
    	map.put("custCertNo", "511023321");
    	map.put("custMobNum", "15928131114");
    	map.put("bankAccount", "444401323");
    	map.put("custName", "小青青");
    	JSONSerializer.toJSON(map);
    	// key 是私钥    uid是用户id  str是json格式的字符串，存放参数
        String key = "EADF4C5DFFA80179011A01DD23BDC75A"; 
        String uid="liuzhilun";
        String str=JSONSerializer.toJSON(map).toString();
        System.out.println("paramString"+str);
        String encrytStr;  
        byte[] encrytByte;  
        byte[] byteRe = enCrypt(str,key);  
        //加密过的二进制数组转化成16进制的字符串  
        encrytStr = parseByte2HexStr(byteRe);         
        //System.out.println("加密后："+encrytStr);  
        //加密过的16进制的字符串转化成二进制数组  
        encrytByte = parseHexStr2Byte(encrytStr);         
        //System.out.println("解密后："+deCrypt(encrytByte,key));  
        /**
         * 详解调用方法：
         * HttpUtil.sendPost("http://112.74.198.250:8080/wsll/queryBusBlack.do?uid="+uid, encrytStr));
         * http://112.74.198.250:8080/wsll/queryBusBlack.do?uid= 是服务器远程方法地址，uid是明文参数 
         * encrytStr 是加密参数的二进制数组转化成16进制的字符串  
         */
       System.out.println("服务器接口返回"+HttpUtil.sendPost("http://112.74.198.250:8080/wsll/queryBusBlack.do?uid="+uid, encrytStr));
       System.out.println("本地接口返回"+HttpUtil.sendPost("http://127.0.0.1:8080/wsll/queryBusBlack.do?uid="+uid, encrytStr));
    }  
      
    /** 
     * 加密函数 
     * @param content   加密的内容 
     * @param strKey    密钥 
     * @return          返回二进制字符数组 
     * @throws Exception 
     */  
    public static byte[] enCrypt(String content,String strKey) throws Exception{  
        KeyGenerator keygen;          
        SecretKey desKey;  
        Cipher c;         
        byte[] cByte;  
        String str = content;  
          
        keygen = KeyGenerator.getInstance("AES");  
        keygen.init(128, new SecureRandom(strKey.getBytes()));  
          
        desKey = keygen.generateKey();        
        c = Cipher.getInstance("AES");  
          
        c.init(Cipher.ENCRYPT_MODE, desKey);  
          
        cByte = c.doFinal(str.getBytes("UTF-8"));         
          
        return cByte;  
    }  
      
    /** 解密函数 
     * @param src   加密过的二进制字符数组 
     * @param strKey  密钥 
     * @return 
     * @throws Exception 
     */  
    public static String deCrypt (byte[] src,String strKey) throws Exception{  
        KeyGenerator keygen;          
        SecretKey desKey;  
        Cipher c;         
        byte[] cByte;     
      //防止linux下 随机生成key 
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );  
        secureRandom.setSeed(strKey.getBytes("UTF-8"));  
        keygen = KeyGenerator.getInstance("AES");  
        keygen.init(128, secureRandom);  
          
        desKey = keygen.generateKey();  
        c = Cipher.getInstance("AES");  
          
        c.init(Cipher.DECRYPT_MODE, desKey);  
          
          
        cByte = c.doFinal(src);   
          
        return new String(cByte,"UTF-8");  
    }  
      
      
    /**2进制转化成16进制 
     * @param buf 
     * @return 
     */  
    public static String parseByte2HexStr(byte buf[]) {  
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < buf.length; i++) {  
            String hex = Integer.toHexString(buf[i] & 0xFF);  
            if (hex.length() == 1) {  
                hex = '0' + hex;  
                }  
            sb.append(hex.toUpperCase());  
            }  
        return sb.toString();  
        }  
      
      
    /**将16进制转换为二进制 
     * @param hexStr 
     * @return 
     */       
    public static byte[] parseHexStr2Byte(String hexStr) {   
            if (hexStr.length() < 1)   
                    return null;   
            byte[] result = new byte[hexStr.length()/2];   
            for (int i = 0;i< hexStr.length()/2; i++) {   
                    int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);   
                    int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);   
                    result[i] = (byte) (high * 16 + low);   
            }   
            return result;   
    }   
  
  
  
}  