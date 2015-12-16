/*    */ package com.hansy.frame.common.tools.context;
/*    */ 
/*    */ import com.hansy.frame.common.tools.ContextUtil;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.Filter;
/*    */ import javax.servlet.FilterChain;
/*    */ import javax.servlet.FilterConfig;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ 
/*    */ public class ContextRefreshFilter
/*    */   implements Filter
/*    */ {
/*    */   public void destroy()
/*    */   {
/*    */   }
/*    */ 
/*    */   public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
/*    */     throws IOException, ServletException
/*    */   {
/* 34 */     if ((arg0 instanceof HttpServletRequest)) {
/* 35 */       HttpServletRequest req = (HttpServletRequest)arg0;
/* 36 */       ContextUtil.put("httpRequest", req, "requestContextHolder");
/* 37 */       ContextUtil.put("httpSession", req.getSession(), "sessionContextHolder");
/*    */     }
/* 39 */     arg2.doFilter(arg0, arg1);
/*    */   }
/*    */ 
/*    */   public void init(FilterConfig arg0)
/*    */     throws ServletException
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\hansy-frame.jar
 * Qualified Name:     com.hansy.frame.common.tools.context.ContextRefreshFilter
 * JD-Core Version:    0.6.0
 */