package com.ecloud.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataDetection {

    /**
     * 验证邮箱
     * 
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证手机号码
     * 
     * @param mobiles
     * @return [0-9]{5,9}
     */
    public static boolean isMobileNO(String mobiles) {
        boolean flag = false;
        try {
            Pattern p = Pattern.compile("^1\\d{10}$");
            Matcher m = p.matcher(mobiles);
            flag = m.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
    
    public static void main(String[] args) {
        System.out.println(isNum("3"));
    }

    /**
     * 验证数字
     * 
     * @param number
     * @return
     */
    public static boolean isNum(String number) {
        boolean flag = false;
        try {
            Pattern p = Pattern.compile("^[1-9]+\\d*$");
            Matcher m = p.matcher(number);
            flag = m.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证中文
     * 
     * @param orderPeople
     * @return
     */
    public static boolean isChinese(String orderPeople) {
        boolean flag = false;
        try {
            Pattern p = Pattern.compile("^[\u4E00-\u9FA5]+$");
            Matcher m = p.matcher(orderPeople);
            flag = m.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
    
    /**
     * 验证中文
     * 
     * @param orderPeople
     * @return
     */
    public static boolean checkFptt(String fptt) {
        boolean flag = false;
        try {
            Pattern p = Pattern.compile("^[\u4E00-\u9FA5a-zA-Z]+$");
            Matcher m = p.matcher(fptt);
            flag = m.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
    
    /**
     * 验证中文
     * 
     * @param orderPeople
     * @return
     */
    public static boolean checkRoomNumber(String roomNumber) {
        boolean flag = false;
        try {
            Pattern p = Pattern.compile("^[0-9a-zA-Z-#]+$");
            Matcher m = p.matcher(roomNumber);
            flag = m.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
    
    /**
     * 验证用户名
     * 
     * @param orderPeople
     * @return
     */
    public static boolean checkUser(String user) {
        boolean flag = false;
        try {
            Pattern p = Pattern.compile("^[a-z][a-z0-9_]{3,11}$");
            Matcher m = p.matcher(user);
            flag = m.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
