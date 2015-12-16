/**
 * 
 */
package com.ecloud.common;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * session监听器
 *@author zhuojian
 *	创建日期：2015-3-3
 */
public class BoxSessionListener implements HttpSessionListener {
    

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
     */
    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        HttpSession session= arg0.getSession();
        String apkType=(String)session.getAttribute("apkType");

    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    }

}
