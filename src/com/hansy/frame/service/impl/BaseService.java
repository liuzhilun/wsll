/*     */ package com.hansy.frame.service.impl;
/*     */ 
/*     */ import com.hansy.frame.dao.IBaseDao;
/*     */ import com.hansy.frame.exception.ServiceException;
/*     */ import com.hansy.frame.service.IBaseService;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ 
/*     */ public class BaseService
/*     */   implements IBaseService
/*     */ {
/*     */   IBaseDao baseDao;
/*     */ 
/*     */   public int deleteByIBatis(String paramString, Object paramObject)
/*     */     throws ServiceException
/*     */   {
/*  24 */     return this.baseDao.deleteByIBatis(paramString, paramObject);
/*     */   }
/*     */ 
/*     */   public List<?> queryByHSql(String paramString) throws ServiceException
/*     */   {
/*  29 */     return this.baseDao.queryByHSql(paramString);
/*     */   }
/*     */ 
/*     */   public Object queryByIBatis(String paramString, Object paramObject)
/*     */     throws ServiceException
/*     */   {
/*  35 */     return this.baseDao.queryByIBatis(paramString, paramObject);
/*     */   }
/*     */ 
/*     */   public Object queryById(Class<?> paramClass, String paramString) throws ServiceException
/*     */   {
/*  40 */     return this.baseDao.queryById(paramClass, paramString);
/*     */   }
/*     */ 
/*     */   public List<?> queryByValue(Class paramClass, String paramString1, String paramString2)
/*     */     throws ServiceException
/*     */   {
/*  46 */     return this.baseDao.queryByValue(paramClass, paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   public int queryIntByIBatis(String paramString, Object paramObject)
/*     */     throws ServiceException
/*     */   {
/*  52 */     return this.baseDao.queryIntByIBatis(paramString, paramObject);
/*     */   }
/*     */ 
/*     */   public List<?> queryListByIBatis(String paramString, Object paramObject)
/*     */     throws ServiceException
/*     */   {
/*  58 */     return this.baseDao.queryListByIBatis(paramString, paramObject);
/*     */   }
/*     */ 
/*     */   public List<?> queryListByIBatis(String paramString, Object paramObject, int paramInt1, int paramInt2)
/*     */     throws ServiceException
/*     */   {
/*  64 */     return this.baseDao.queryListByIBatis(paramString, paramObject, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   public Object queryListByIBatis(String paramString) throws ServiceException
/*     */   {
/*  69 */     return this.baseDao.queryListByIBatis(paramString);
/*     */   }
/*     */ 
/*     */   public void remove(Object paramObject) throws ServiceException
/*     */   {
/*  74 */     this.baseDao.remove(paramObject);
/*     */   }
/*     */ 
/*     */   public void remove(String paramString, Object paramObject) throws ServiceException
/*     */   {
/*  79 */     this.baseDao.remove(paramString, paramObject);
/*     */   }
/*     */ 
/*     */   public int remove(String paramString1, String paramString2, Class paramClass) throws ServiceException
/*     */   {
/*  84 */     return this.baseDao.remove(paramString1, paramString2, paramClass);
/*     */   }
/*     */ 
/*     */   public void remove(Collection<?> paramCollection) throws ServiceException
/*     */   {
/*  89 */     this.baseDao.remove(paramCollection);
/*     */   }
/*     */ 
/*     */   public void save(Object paramObject) throws ServiceException
/*     */   {
/*  94 */     this.baseDao.save(paramObject);
/*     */   }
/*     */ 
/*     */   public void save(String paramString, Object paramObject) throws ServiceException
/*     */   {
/*  99 */     this.baseDao.save(paramString, paramObject);
/*     */   }
/*     */ 
/*     */   public void saveByIBatis(String paramString, Object paramObject)
/*     */     throws ServiceException
/*     */   {
/* 105 */     this.baseDao.saveByIBatis(paramString, paramObject);
/*     */   }
/*     */ 
/*     */   public void saveOrUpdate(Collection<?> paramCollection) throws ServiceException
/*     */   {
/* 110 */     this.baseDao.saveOrUpdate(paramCollection);
/*     */   }
/*     */ 
/*     */   public void saveOrUpdateObj(Object paramObject) throws ServiceException
/*     */   {
/* 115 */     this.baseDao.saveOrUpdateObj(paramObject);
/*     */   }
/*     */ 
/*     */   public void update(Object paramObject) throws ServiceException
/*     */   {
/* 120 */     this.baseDao.update(paramObject);
/*     */   }
/*     */ 
/*     */   public int updateByIBatis(String paramString, Object paramObject)
/*     */     throws ServiceException
/*     */   {
/* 126 */     return this.baseDao.updateByIBatis(paramString, paramObject);
/*     */   }
/*     */   public void setBaseDao(IBaseDao baseDao) {
/* 129 */     this.baseDao = baseDao;
/*     */   }
/*     */ 
/*     */   public IBaseDao getBaseDao() {
/* 133 */     return this.baseDao;
/*     */   }
/*     */ }
