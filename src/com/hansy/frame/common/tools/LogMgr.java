/*    */ package com.hansy.frame.common.tools;
/*    */ 
/*    */ import java.net.URL;
/*    */ import org.apache.log4j.xml.DOMConfigurator;
/*    */ 
/*    */ public class LogMgr
/*    */ {
/* 18 */   private static boolean bInited = false;
/*    */ 
/*    */   public static synchronized void init(String logConfigFilePath) {
/* 21 */     if (bInited) {
/* 22 */       return;
/*    */     }
/*    */ 
/* 25 */     System.setProperty("org.apache.commons.logging.LogFactory", "org.apache.commons.logging.impl.LogFactoryImpl");
/* 26 */     System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Log4JLogger");
/* 27 */     URL path = LogMgr.class.getResource(logConfigFilePath);
/* 28 */     System.setProperty("log4j.configuration", path.getFile());
/* 29 */     DOMConfigurator.configure(path);
/* 30 */     bInited = true;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\hansy-frame.jar
 * Qualified Name:     com.hansy.frame.common.tools.LogMgr
 * JD-Core Version:    0.6.0
 */