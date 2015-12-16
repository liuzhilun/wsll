/*    */ package com.hansy.frame.common.tools.context;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class ContextHolder
/*    */ {
/*    */   private Map contexts;
/*    */ 
/*    */   public ContextHolder()
/*    */   {
/* 22 */     this.contexts = new HashMap();
/*    */   }
/*    */ 
/*    */   public Object get(String key) {
/* 26 */     return this.contexts.get(key);
/*    */   }
/*    */ 
/*    */   public void put(String key, Object value) {
/* 30 */     this.contexts.put(key, value);
/*    */   }
/*    */ 
/*    */   public void clear() {
/* 34 */     this.contexts.clear();
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\hansy-frame.jar
 * Qualified Name:     com.hansy.frame.common.tools.context.ContextHolder
 * JD-Core Version:    0.6.0
 */