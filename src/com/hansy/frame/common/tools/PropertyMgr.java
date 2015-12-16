/*    */ package com.hansy.frame.common.tools;
/*    */ 
/*    */ import java.util.Enumeration;
/*    */ import java.util.Properties;
/*    */ import java.util.ResourceBundle;
/*    */ 
/*    */ public class PropertyMgr
/*    */ {
/*    */   public static final String PROPERTY_LIST_SIZE_KEY = "size";
/*    */   public static final String PROPERTY_NAME_KEY = "name";
/*    */   public static final String PROPERTY_VALUE_KEY = "value";
/*    */ 
/*    */   public static synchronized Properties init(String sPropFile)
/*    */   {
/* 23 */     Properties props = new Properties();
/* 24 */     ResourceBundle bundle = ResourceBundle.getBundle(sPropFile);
/* 25 */     Enumeration enums = bundle.getKeys();
/* 26 */     Object key = null;
/* 27 */     Object value = null;
/* 28 */     while (enums.hasMoreElements()) {
/* 29 */       key = enums.nextElement();
/* 30 */       value = bundle.getString(key.toString());
/* 31 */       props.put(key, value);
/*    */     }
/* 33 */     bundle = null;
/* 34 */     return props;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\hansy-frame.jar
 * Qualified Name:     com.hansy.frame.common.tools.PropertyMgr
 * JD-Core Version:    0.6.0
 */