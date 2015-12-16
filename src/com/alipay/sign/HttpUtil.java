package com.alipay.sign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

public class HttpUtil {
	public static String sendGet(String url, String param)
			throws SocketTimeoutException {
		return sendGet(url, param, 30000);
	}

	public static String sendGet(String url, String param, int timeout)
			throws SocketTimeoutException {
		trustEveryone();
		String result = "";
		BufferedReader in = null;
		boolean timeoutException = false;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setConnectTimeout(timeout);
			connection.setReadTimeout(timeout);
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
				System.out.println("result" + result);
			}
		} catch (SocketTimeoutException e) { // 调用接口发生异常
			timeoutException = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (timeoutException) {
			throw new SocketTimeoutException();
		}
		return result;
	}
//json格式的参数，由map转换成json，转成string
	public static String sendPost(String url, String param)
			throws SocketTimeoutException {
		return sendPost(url, param, 5000);
	}

	public static String sendPost(String url, String param, int timeout)
			throws SocketTimeoutException {
		trustEveryone();
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		boolean timeoutException = false;
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setConnectTimeout(timeout);
			conn.setReadTimeout(timeout);
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (SocketTimeoutException e) { // 调用接口发生异常
			timeoutException = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		if (timeoutException) {
			throw new SocketTimeoutException();
		}
		return result;
	}

	private static void trustEveryone() {
		try {
			HttpsURLConnection
					.setDefaultHostnameVerifier(new HostnameVerifier() {
						public boolean verify(String hostname,
								SSLSession session) {
							return true;
						}
					});

			SSLContext context = SSLContext.getInstance("TLS");
			context.init(null, new X509TrustManager[] { new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] chain,
						String authType) throws CertificateException {
				}

				public void checkServerTrusted(X509Certificate[] chain,
						String authType) throws CertificateException {
				}

				public X509Certificate[] getAcceptedIssuers() {
					return new X509Certificate[0];
				}
			} }, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(context
					.getSocketFactory());
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	/**
	 * 传过来的参数必须是json字符串格式
	 * 
	 * @param request
	 * @throws Exception 
	 */
	public static Map<String, String> getRequestParamArray(
			ServletInputStream inputStream,String praviteKey) throws Exception {
		String result = "";
		BufferedReader in;
		Map<String, String> paramsMap = new HashMap<String, String>();
		try {
			in = new BufferedReader(new InputStreamReader(
					inputStream, "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			System.out.println("request获取" + result.toString());
			JSONObject jsonObject = JSONObject.fromObject(AEStest.deCrypt(
					AEStest.parseHexStr2Byte(result), praviteKey));
			for (Iterator iter = jsonObject.keys(); iter.hasNext();) {
				String key = (String) iter.next();
				paramsMap.put(key, (String) jsonObject.get(key));
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return paramsMap;
	}
}
