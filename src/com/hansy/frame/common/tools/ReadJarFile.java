/*    */ package com.hansy.frame.common.tools;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import java.text.MessageFormat;
/*    */ import java.util.Properties;
/*    */ 
/*    */ public class ReadJarFile
/*    */ {
/* 18 */   private static Properties prop = new Properties();
/*    */ 
/*    */   public static String getMessageByJar(String classpath, String filename, String localLang, String subfix, String key, Object[] arguments)
/*    */   {
/* 22 */     String value = getMessageByJar(classpath, filename + "_" + localLang, 
/* 23 */       subfix, key, arguments);
/* 24 */     if (value == null) {
/* 25 */       value = getMessageByJar(classpath, filename, subfix, key, arguments);
/*    */     }
/* 27 */     return value;
/*    */   }
/*    */ 
/*    */   public static String getMessageByJar(String classpath, String filename, String subfix, String key, Object[] arguments)
/*    */   {
/* 32 */     String value = null;
/* 33 */     if (!prop.containsKey(key)) {
/* 34 */       String qualifiedfileName = "/" + classpath.replaceAll("\\\\", "/") + 
/* 35 */         filename + subfix;
/* 36 */       InputStream inStream = ReadJarFile.class
/* 37 */         .getResourceAsStream(qualifiedfileName);
/* 38 */       if (inStream != null) {
/*    */         try {
/* 40 */           Properties temp = new Properties();
/* 41 */           temp.load(inStream);
/* 42 */           prop.putAll(temp);
/*    */         } catch (Exception e) {
/* 44 */           e.printStackTrace();
/*    */         }
/* 46 */         if (prop.containsKey(key)) {
/* 47 */           value = prop.getProperty(key.toUpperCase());
/* 48 */           if ((arguments != null) && (arguments.length > 0))
/* 49 */             value = MessageFormat.format(value, arguments);
/*    */         }
/*    */       }
/*    */     }
/*    */     else {
/* 54 */       value = prop.getProperty(key.toUpperCase());
/* 55 */       if ((arguments != null) && (arguments.length > 0)) {
/* 56 */         value = MessageFormat.format(value, arguments);
/*    */       }
/*    */     }
/* 59 */     return value;
/*    */   }
/*    */ 
/*    */   public static String getMessageByJar(String classpath, String filename, String localLang, String subfix, String key)
/*    */   {
/* 64 */     return getMessageByJar(classpath, filename, localLang, subfix, key, null);
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\hansy-frame.jar
 * Qualified Name:     com.hansy.frame.common.tools.ReadJarFile
 * JD-Core Version:    0.6.0
 */