package com.ecloud.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Web工具类
 * 
 */
public final class WebUtils {

    /**
     * 普通文本
     */
    public static final String CONTENT_TEXT = "text/plain;charset=UTF-8";

    /**
     * HTML数据
     */
    public static final String CONTENT_HTML = "text/html;charset=UTF-8";

    /**
     * XML数据
     */
    public static final String CONTENT_XML = "text/xml;charset=UTF-8";

    /**
     * JSON格式数据
     */
    public static final String CONTENT_JSON = "application/json;charset=UTF-8";

    /**
     * javascript格式数据
     */
    public static final String CONTENT_JAVASCRIPT = "text/javascript;charset=UTF-8";

    /**
     * 文件下载时的缓存大小
     */
    protected static final int BUFFER_SIZE = 4096;

    private static Logger log = LoggerFactory.getLogger(WebUtils.class);

    private WebUtils() {
    }

    /**
     * 直接输出文本内容
     * 
     * @param response
     * @param text
     * @param contentType
     */
    public static void render(HttpServletResponse response, String text, String contentType) {
        response.setContentType(contentType);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.print(text);
        } catch (IOException e) {
            log.error("", e);
        } finally {
            if (writer != null) {
            	writer.flush();
                writer.close();
            }
        }
    }

    /**
     * 文件下载，弹出文件下载对话框供用户下载文件
     * 
     * @param response
     * @param file 要下载的文件
     */
    public static void renderDownload(HttpServletRequest request, HttpServletResponse response, final File file,
        final String fileName) throws IOException {
    	InputStream in = new FileInputStream(file);
		renderDownload(request, response, fileName, in );
    }

    /**
     * 文件下载，弹出文件下载对话框供用户下载文件
     * 
     * @param response
     * @param file 要下载的文件
     */
    public static void renderDownload(HttpServletRequest request, HttpServletResponse response, final String fileName,
        InputStream in) throws IOException {
        String mimetype = "application/octet-stream";
        String encodeName = fileName;
        String ua = request.getHeader("User-Agent");
        /**
        if (-1 != ua.toLowerCase().indexOf(" msie ")) {
            // 客户端为IE
            try {
               // encodeName = java.net.URLEncoder.encode(fileName, "UTF-8");
                encodeName = new String(encodeName.getBytes("GBK"),"ISO-8859-1");
            } catch (UnsupportedEncodingException e) {
                log.error("UnsupportedEncoding", e);
            }
            mimetype = " application/x-msdownload ";
        } else {
            // 非IE
            encodeName = MimeUtility.encodeText(fileName, "UTF8", "B");
            mimetype = " application/x-download ";
        }
        **/
        try {
             encodeName = new String(encodeName.getBytes("GBK"),"ISO-8859-1");
         } catch (UnsupportedEncodingException e) {
             log.error("UnsupportedEncoding", e);
         }
         mimetype = " application/octet-stream ";
         
        response.reset();
        response.setContentType(mimetype);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + encodeName + "\"");
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            byte[] buffer = new byte[BUFFER_SIZE];
            int i = -1;
            while ((i = in.read(buffer)) != -1) {
                out.write(buffer, 0, i);
            }
            response.flushBuffer();
        } finally {
            IOUtils.closeQuietly(out);
            IOUtils.closeQuietly(in);
        }
    }
}
