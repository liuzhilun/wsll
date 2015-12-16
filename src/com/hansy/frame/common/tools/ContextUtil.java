/*    */ package com.hansy.frame.common.tools;
/*    */ 
/*    */ import com.hansy.frame.common.tools.context.ContextHolder;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.factory.BeanFactoryUtils;
/*    */ import org.springframework.context.ApplicationContext;
/*    */ 
/*    */ public class ContextUtil
/*    */ {
/*    */   private static final String NULL_BEAN = "null";
/*    */   public static final String SCOPE_SESSION = "sessionContextHolder";
/*    */   public static final String SCOPE_REQUEST = "requestContextHolder";
/*    */   public static final String SCOPE_APPLICATION = "applicationContextHolder";
/*    */   public static final String CONTEXT_HTTP_REQUEST = "httpRequest";
/*    */   public static final String CONTEXT_HTTP_SESSION = "httpSession";
/* 33 */   private static Log log = LogFactory.getLog(ContextUtil.class);
/*    */   private static ApplicationContext applicationContext;
/*    */ 
/*    */   public static ApplicationContext getApplicationContext()
/*    */   {
/* 37 */     return applicationContext;
/*    */   }
/*    */ 
/*    */   public static void setApplicationContext(ApplicationContext applicationContext)
/*    */   {
/* 42 */     applicationContext = applicationContext;
/*    */   }
/*    */ 
/*    */   public static Object getBean(String beanId) {
/* 46 */     if (beanId == null)
/* 47 */       return null;
/* 48 */     if (beanId.equalsIgnoreCase("null"))
/* 49 */       return null;
/* 50 */     return getBeanByBeanIdOrClass(beanId, null);
/*    */   }
/*    */ 
/*    */   public static List getBeansByClass(Class targetClass) {
/* 54 */     List ret = new ArrayList();
/* 55 */     if ((applicationContext == null) || (targetClass == null)) {
/* 56 */       return ret;
/*    */     }
/* 58 */     Map beans = BeanFactoryUtils.beansOfTypeIncludingAncestors(
/* 59 */       applicationContext, targetClass, true, true);
/*    */ 
/* 61 */     if (beans.size() == 0) {
/* 62 */       log.info("No bean of type " + targetClass.toString() + " found.");
/*    */     }
/* 64 */     return new ArrayList(beans.values());
/*    */   }
/*    */ 
/*    */   public static Object getBeanByBeanIdOrClass(String beanId, Class clazz) {
/* 68 */     if (applicationContext == null) {
/* 69 */       return null;
/*    */     }
/* 71 */     if ("null".equalsIgnoreCase(beanId)) {
/* 72 */       return null;
/*    */     }
/* 74 */     if ((beanId != null) && (applicationContext.containsBean(beanId))) {
/* 75 */       return applicationContext.getBean(beanId);
/*    */     }
/* 77 */     List l = getBeansByClass(clazz);
/* 78 */     if (l.size() > 0)
/* 79 */       return l.get(0);
/* 80 */     return null;
/*    */   }
/*    */ 
/*    */   public static void put(String key, Object value, String scopeBeanId) {
/* 84 */     ContextHolder contextHolder = (ContextHolder)getBean(scopeBeanId);
/* 85 */     if (contextHolder != null)
/* 86 */       contextHolder.put(key, value);
/*    */   }
/*    */ 
/*    */   public static Object get(String key, String scopeBeanId) {
/* 90 */     ContextHolder contextHolder = (ContextHolder)getBean(scopeBeanId);
/* 91 */     if (contextHolder != null)
/* 92 */       return contextHolder.get(key);
/* 93 */     return null;
/*    */   }
/*    */ 
/*    */   public static void clear(String scopeBeanId) {
/* 97 */     ContextHolder contextHolder = (ContextHolder)getBean(scopeBeanId);
/* 98 */     if (contextHolder != null)
/* 99 */       contextHolder.clear();
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\hansy-frame.jar
 * Qualified Name:     com.hansy.frame.common.tools.ContextUtil
 * JD-Core Version:    0.6.0
 */