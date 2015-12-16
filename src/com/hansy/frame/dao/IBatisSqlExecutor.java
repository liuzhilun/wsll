/*    */ package com.hansy.frame.dao;
/*    */ 
/*    */ import com.ibatis.sqlmap.engine.execution.SqlExecutor;
/*    */ import com.ibatis.sqlmap.engine.mapping.statement.RowHandlerCallback;
/*    */ import com.ibatis.sqlmap.engine.scope.RequestScope;
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class IBatisSqlExecutor extends SqlExecutor
/*    */ {
/* 13 */   private static final Log logger = LogFactory.getLog(IBatisSqlExecutor.class);
/*    */   private IDialect dialect;
/* 15 */   private boolean enableCustomizedPaged = true;
/*    */ 
/*    */   public IDialect getDialect() {
/* 18 */     return this.dialect;
/*    */   }
/*    */ 
/*    */   public void setDialect(IDialect dialect) {
/* 22 */     this.dialect = dialect;
/*    */   }
/*    */ 
/*    */   public boolean isEnableCustomizedPaged() {
/* 26 */     return this.enableCustomizedPaged;
/*    */   }
/*    */ 
/*    */   public void setEnableCustomizedPaged(boolean enableCustomizedPaged) {
/* 30 */     this.enableCustomizedPaged = enableCustomizedPaged;
/*    */   }
/*    */ 
/*    */   public void executeQuery(RequestScope request, Connection conn, String sql, Object[] parameters, int skipResults, int maxResults, RowHandlerCallback callback)
/*    */     throws SQLException
/*    */   {
/* 39 */     if (((skipResults != 0) || (maxResults != -999999)) && 
/* 40 */       (supportsPaged())) {
/* 41 */       sql = this.dialect.getPagedString(sql, skipResults, maxResults);
/* 42 */       if (logger.isDebugEnabled()) {
/* 43 */         logger.debug(sql);
/*    */       }
/* 45 */       skipResults = 0;
/* 46 */       maxResults = -999999;
/*    */     }
/* 48 */     super.executeQuery(request, conn, sql, parameters, skipResults, 
/* 49 */       maxResults, callback);
/*    */   }
/*    */ 
/*    */   public boolean supportsPaged()
/*    */   {
/* 57 */     if ((this.enableCustomizedPaged) && (this.dialect != null)) {
/* 58 */       return this.dialect.supportsPaged();
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */ }
