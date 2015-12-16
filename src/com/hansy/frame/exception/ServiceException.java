/*    */ package com.hansy.frame.exception;
/*    */ 
/*    */ import com.hansy.frame.i18n.LanguageManager;
/*    */ 
/*    */ public class ServiceException extends Exception
/*    */ {
/*    */   private String message;
/* 23 */   private StringBuffer sb = new StringBuffer();
/*    */ 
/*    */   public ServiceException(String message) {
/* 26 */     setStack();
/* 27 */     this.message = message;
/*    */   }
/*    */ 
/*    */   public ServiceException(String message, String[] params)
/*    */   {
/* 40 */     int paramsLen = params.length;
/* 41 */     setStack();
/* 42 */     if (paramsLen == 0) {
/* 43 */       this.message = message;
/*    */     } else {
/* 45 */       for (int i = 0; i < paramsLen; i++) {
/* 46 */         message = message.replaceAll("\\{" + i + "\\}", params[i]);
/*    */       }
/* 48 */       this.message = message;
/*    */     }
/*    */   }
/*    */ 
/*    */   private void setStack() {
/* 53 */     StackTraceElement[] trace = getStackTrace();
/* 54 */     for (int i = 0; i < trace.length; i++)
/* 55 */       this.sb.append("\tat " + trace[i] + "<br/>");
/*    */   }
/*    */ 
/*    */   public String getMessage() {
/* 59 */     if (this.message == null) {
/* 60 */       return LanguageManager.getMessage("systemError", null);
/*    */     }
/* 62 */     return this.message;
/*    */   }
/*    */ 
/*    */   public void setMessage(String message) {
/* 66 */     this.message = message;
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\hansy-frame.jar
 * Qualified Name:     com.hansy.frame.exception.ServiceException
 * JD-Core Version:    0.6.0
 */