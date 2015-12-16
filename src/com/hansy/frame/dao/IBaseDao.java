package com.hansy.frame.dao;

import com.hansy.frame.exception.ServiceException;
import java.util.Collection;
import java.util.List;
import org.hibernate.Session;

public abstract interface IBaseDao
{
  public abstract Object queryById(Class<?> paramClass, String paramString)
    throws ServiceException;

  public abstract List<?> queryByValue(Class paramClass, String paramString1, String paramString2)
    throws ServiceException;

  public abstract List<?> queryByHSql(String paramString)
    throws ServiceException;

  public abstract void save(Object paramObject)
    throws ServiceException;

  public abstract void save(String paramString, Object paramObject)
    throws ServiceException;

  public abstract void update(Object paramObject)
    throws ServiceException;

  public abstract void saveOrUpdateObj(Object paramObject)
    throws ServiceException;

  public abstract void saveOrUpdate(Collection<?> paramCollection)
    throws ServiceException;

  public abstract void remove(Object paramObject)
    throws ServiceException;

  public abstract void remove(String paramString, Object paramObject)
    throws ServiceException;

  public abstract int remove(String paramString1, String paramString2, Class paramClass)
    throws ServiceException;

  public abstract void remove(Collection<?> paramCollection)
    throws ServiceException;

  public abstract Object queryByIBatis(String paramString, Object paramObject)
    throws ServiceException;

  public abstract List<?> queryListByIBatis(String paramString, Object paramObject)
    throws ServiceException;

  public abstract List<?> queryListByIBatis(String paramString, Object paramObject, int paramInt1, int paramInt2)
    throws ServiceException;

  public abstract int queryIntByIBatis(String paramString, Object paramObject)
    throws ServiceException;

  public abstract Object queryListByIBatis(String paramString)
    throws ServiceException;

  public abstract void saveByIBatis(String paramString, Object paramObject)
    throws ServiceException;

  public abstract int updateByIBatis(String paramString, Object paramObject)
    throws ServiceException;

  public abstract int deleteByIBatis(String paramString, Object paramObject)
    throws ServiceException;

  public abstract Session getSessionTwo();
}
