package com.hansy.frame.i18n;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ResourceBundleMessageSource;

public class LanguageManager {
	private static LanguageManager mger = new LanguageManager();
	private static ResourceBundleMessageSource msgSource = null;
	private static final ReentrantLock lock = new ReentrantLock();
	private String strDefault = "";
	private Map mLanguages = null;
	private Map mLocale = null;
	private boolean languageSwitch = false;

	public boolean canSwitchLanguage() {
		return this.languageSwitch;
	}

	public Object[] getLanguageInfo(String strLanguage) {
		if (this.mLanguages == null) {
			return null;
		}
		if ((strLanguage != null) && (!strLanguage.trim().equals(""))) {
			String strLanguageName = (String) this.mLanguages.get(strLanguage);
			if ((strLanguageName != null)
					&& (!strLanguageName.trim().equals(""))) {
				Object[] result = { strLanguage, strLanguageName, Boolean.FALSE };
				return result;
			}
		}
		String strLanguageName = (String) this.mLanguages.get(this.strDefault);
		if ((strLanguageName == null) || (strLanguageName.trim().equals(""))) {
			return null;
		}
		Object[] result = { this.strDefault, strLanguageName, Boolean.TRUE };
		return result;
	}

	public Map getLanguages() {
		return this.mLanguages;
	}

	public String getDefault() {
		return this.strDefault;
	}

	public String[] getLocaleInfo(String strLanguage) {
		if (this.mLocale == null) {
			return null;
		}
		if ((strLanguage == null) || (strLanguage.trim().equals(""))) {
			strLanguage = this.strDefault;
		}
		String strLocale = (String) this.mLocale.get(strLanguage);
		int index = strLocale.indexOf("_");
		if (index <= 0) {
			return null;
		}
		String[] result = new String[2];
		result[0] = strLocale.substring(0, index);
		result[1] = strLocale.substring(1 + index);

		return result;
	}

	public static String getMessage(String msgId, Object[] params) {
		Locale oLocale_Info = null;
		if (oLocale_Info == null) {
			oLocale_Info = Locale.getDefault();
		}
		return getMessage(msgId, params, oLocale_Info);
	}

	public static String getMessage(String msgId, Object[] params,
			HttpServletRequest request) {
		Locale oLocale_Info = null;
		if (oLocale_Info == null) {
			oLocale_Info = request.getLocale();
		}
		if (oLocale_Info == null) {
			oLocale_Info = Locale.getDefault();
		}
		return getMessage(msgId, params, oLocale_Info);
	}

	public static String getMessage(String msgId, Object[] params,
			Locale oLocale_Info) {
		lock.lock();
		try {
			if (msgSource == null) {
				Properties properties = new Properties();
				String i18nProperties;
				do {
					try {
						properties
								.load(LanguageManager.class
										.getResourceAsStream("/config/env/language_list.properties"));
					} catch (IOException e) {
						e.printStackTrace();
						lock.unlock();

						lock.unlock();

						return null;
					}
					i18nProperties = properties.getProperty("i18nproperties");
				} while ((i18nProperties == null)
						|| (i18nProperties.trim().equals("")));

				String[] resources = i18nProperties.split(",");
				msgSource = new ResourceBundleMessageSource();
				msgSource.setBasenames(resources);
			}
		} finally {
			lock.unlock();
		}
		lock.unlock();

		if (msgSource == null)
			return msgId;
		try {
			return msgSource.getMessage(msgId, params, oLocale_Info);
		} catch (Exception localException) {
		}
		return msgId;
	}

	private LanguageManager() {
		Properties properties = new Properties();
		this.mLanguages = new HashMap();
		this.mLocale = new HashMap();
		try {
			properties
					.load(LanguageManager.class
							.getResourceAsStream("/config/env/language_list.properties"));
			Set keys = properties.keySet();
			Iterator iterator = keys.iterator();
			while (iterator.hasNext()) {
				String strKey = (String) iterator.next();
				if (strKey.equals("lan_default")) {
					this.strDefault = properties.getProperty(strKey);
				} else if (strKey.startsWith("lan_")) {
					String strLanguage = strKey.substring("lan_".length());
					String strLanguageShowName = decodeISO(properties
							.getProperty(strKey));
					this.mLanguages.put(strLanguage, strLanguageShowName);
				} else if (strKey.startsWith("localevalue_")) {
					String strLanguage = strKey.substring("localevalue_"
							.length());
					String strLanguageShowName = decodeISO(properties
							.getProperty(strKey));
					this.mLocale.put(strLanguage, strLanguageShowName);
				}
			}

			String strlanguageswitch = properties.getProperty("languageswitch");
			if ((strlanguageswitch != null)
					&& (strlanguageswitch.trim().equals("1"))) {
				this.languageSwitch = true;
			}
			String i18nProperties = properties.getProperty("i18nproperties");
			msgSource = new ResourceBundleMessageSource();
			msgSource.setBasename(i18nProperties);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String decodeISO(String strISOChString) {
		if (strISOChString == null) {
			return null;
		}
		StringBuffer buffer = new StringBuffer();
		String strPrefix = "&#";
		String strPostfix = ";";
		int index = -1;
		if ((index = strISOChString.indexOf(strPrefix)) >= 0) {
			do {
				String strHead = strISOChString.substring(0, index);
				strISOChString = strISOChString.substring(index
						+ strPrefix.length());
				index = strISOChString.indexOf(strPostfix);
				if (index < 0) {
					buffer.append(strHead + strPrefix + strISOChString);
					return buffer.toString();
				}
				String strBody = strISOChString.substring(0, index);
				strISOChString = strISOChString.substring(index
						+ strPostfix.length());
				char c = ' ';
				try {
					c = (char) Integer.parseInt(strBody);
					buffer.append(strHead + c);
				} catch (Exception e) {
					buffer.append(strHead + strPrefix + strBody + strPostfix);
				}
			} while ((index = strISOChString.indexOf(strPrefix)) >= 0);
			buffer.append(strISOChString);
			return buffer.toString();
		}
		return strISOChString;
	}

	public static LanguageManager getInstance() {
		return mger;
	}

	public static void main(String[] arg) {
		System.out.println(getMessage("E_APP_0010", null, Locale.US));
		System.out.println(getMessage("js.info.closewindow", null, Locale.US));
	}
}

/*
 * Location: C:\Users\Administrator\Desktop\新建文件夹\hansy-frame.jar Qualified
 * Name: com.hansy.frame.i18n.LanguageManager JD-Core Version: 0.6.0
 */