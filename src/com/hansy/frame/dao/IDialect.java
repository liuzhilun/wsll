package com.hansy.frame.dao;

public abstract interface IDialect
{
  public abstract boolean supportsPaged();

  public abstract String getPagedString(String paramString, boolean paramBoolean);

  public abstract String getPagedString(String paramString, int paramInt1, int paramInt2);
}

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\hansy-frame.jar
 * Qualified Name:     com.hansy.frame.dao.IDialect
 * JD-Core Version:    0.6.0
 */