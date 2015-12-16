/*     */ package com.hansy.frame.common.tools;
/*     */ 
/*     */ import java.sql.Timestamp;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class DateTimeUtil
/*     */ {
/*     */   public static Timestamp nowTimestamp()
/*     */   {
/*  24 */     return getTimestamp(System.currentTimeMillis());
/*     */   }
/*     */ 
/*     */   public static Timestamp getTimestamp(long time) {
/*  28 */     return new Timestamp(time);
/*     */   }
/*     */ 
/*     */   public static Date nowDate() {
/*  32 */     return new Date();
/*     */   }
/*     */ 
/*     */   public static int getYear(Date date) {
/*  36 */     Calendar cal = Calendar.getInstance();
/*  37 */     cal.setTime(date);
/*  38 */     return cal.get(1);
/*     */   }
/*     */ 
/*     */   public static String formatDate(Date date, String pattern) {
/*  42 */     if (date == null) {
/*  43 */       return "";
/*     */     }
/*  45 */     if (pattern == null) {
/*  46 */       pattern = "yyyy-MM-dd";
/*     */     }
/*  48 */     SimpleDateFormat sdf = new SimpleDateFormat(pattern);
/*  49 */     return sdf.format(date);
/*     */   }
/*     */ 
/*     */   public static String formatDateTime(Date date) {
/*  53 */     return formatDate(date, "yyyy-MM-dd HH:mm:ss");
/*     */   }
/*     */ 
/*     */   public static String formatDateTime() {
/*  57 */     return formatDate(now(), "yyyy-MM-dd HH:mm:ss");
/*     */   }
/*     */ 
/*     */   public static String formatDate(Date date) {
/*  61 */     return formatDate(date, "yyyy-MM-dd");
/*     */   }
/*     */ 
/*     */   public static String formatDate(Date date, boolean flag) {
/*  65 */     return formatDate(date, "yyyyMMdd");
/*     */   }
/*     */ 
/*     */   public static String formatDate() {
/*  69 */     return formatDate(now(), "yyyy-MM-dd");
/*     */   }
/*     */ 
/*     */   public static String formatTime(Date date) {
/*  73 */     return formatDate(date, "HH:mm:ss");
/*     */   }
/*     */ 
/*     */   public static String formatTime() {
/*  77 */     return formatDate(now(), "HH:mm:ss");
/*     */   }
/*     */ 
/*     */   public static String formatTime2() {
/*  81 */     return formatDate(now(), "HHmmss");
/*     */   }
/*     */ 
/*     */   public static Date now() {
/*  85 */     return new Date();
/*     */   }
/*     */ 
/*     */   public static Date parseDateTime(String datetime) {
/*  89 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  90 */     if ((datetime == null) || (datetime.equals("")))
/*  91 */       return null;
/*     */     try {
/*  93 */       return formatter.parse(datetime);
/*     */     } catch (ParseException localParseException) {
/*     */     }
/*  96 */     return parseDate(datetime);
/*     */   }
/*     */ 
/*     */   public static Date parseDate(String date) {
/* 100 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
/*     */ 
/* 102 */     if ((date == null) || (date.equals("")))
/* 103 */       return null;
/*     */     try {
/* 105 */       return formatter.parse(date);
/*     */     } catch (ParseException localParseException) {
/*     */     }
/* 108 */     return null;
/*     */   }
/*     */ 
/*     */   public static Date parseDate(Date datetime) {
/* 112 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
/*     */ 
/* 114 */     if (datetime == null)
/* 115 */       return null;
/*     */     try {
/* 117 */       return formatter.parse(formatter.format(datetime));
/*     */     } catch (ParseException localParseException) {
/*     */     }
/* 120 */     return null;
/*     */   }
/*     */ 
/*     */   public static Date parseDateYYMMDD(String date) {
/* 124 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
/*     */ 
/* 126 */     if ((date == null) || (date.equals("")))
/* 127 */       return null;
/*     */     try {
/* 129 */       return formatter.parse(date);
/*     */     } catch (ParseException localParseException) {
/*     */     }
/* 132 */     return null;
/*     */   }
/*     */ 
/*     */   public static String formatDate(Object o) {
/* 136 */     if (o == null) {
/* 137 */       return "";
/*     */     }
/* 139 */     if (o.getClass() == String.class)
/* 140 */       return formatDate((String)o);
/* 141 */     if (o.getClass() == Date.class)
/* 142 */       return formatDate((Date)o);
/* 143 */     if (o.getClass() == Timestamp.class) {
/* 144 */       return formatDate(new Date(((Timestamp)o).getTime()));
/*     */     }
/* 146 */     return o.toString();
/*     */   }
/*     */ 
/*     */   public static String formatDateTime(Object o) {
/* 150 */     if (o.getClass() == String.class)
/* 151 */       return formatDateTime((String)o);
/* 152 */     if (o.getClass() == Date.class)
/* 153 */       return formatDateTime((Date)o);
/* 154 */     if (o.getClass() == Timestamp.class) {
/* 155 */       return formatDateTime(new Date(((Timestamp)o).getTime()));
/*     */     }
/* 157 */     return o.toString();
/*     */   }
/*     */ 
/*     */   public static Date add(Date date, int field, int amount) {
/* 161 */     if (date == null) {
/* 162 */       date = new Date();
/*     */     }
/*     */ 
/* 165 */     Calendar cal = Calendar.getInstance();
/* 166 */     cal.setTime(date);
/* 167 */     cal.add(field, amount);
/*     */ 
/* 169 */     return cal.getTime();
/*     */   }
/*     */ 
/*     */   public static Date addMilliSecond(Date date, int amount) {
/* 173 */     return add(date, 14, amount);
/*     */   }
/*     */ 
/*     */   public static Date addSecond(Date date, int amount) {
/* 177 */     return add(date, 13, amount);
/*     */   }
/*     */ 
/*     */   public static Date addMiunte(Date date, int amount) {
/* 181 */     return add(date, 12, amount);
/*     */   }
/*     */ 
/*     */   public static Date addHour(Date date, int amount) {
/* 185 */     return add(date, 10, amount);
/*     */   }
/*     */ 
/*     */   public static Date addDay(Date date, int amount) {
/* 189 */     return add(date, 5, amount);
/*     */   }
/*     */ 
/*     */   public static Date addMonth(Date date, int amount) {
/* 193 */     return add(date, 2, amount);
/*     */   }
/*     */ 
/*     */   public static Date addYear(Date date, int amount) {
/* 197 */     return add(date, 1, amount);
/*     */   }
/*     */ 
/*     */   public static Date getDate() {
/* 201 */     return parseDate(formatDate());
/*     */   }
/*     */ 
/*     */   public static Date getDateTime() {
/* 205 */     return parseDateTime(formatDateTime());
/*     */   }
/*     */ 
/*     */   public static Date parseDate(String date, boolean flag) {
/* 209 */     if (flag) {
/* 210 */       SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
/*     */ 
/* 212 */       if ((date == null) || (date.equals("")))
/* 213 */         return null;
/*     */       try {
/* 215 */         Date a = formatter.parse(date);
/* 216 */         return a;
/*     */       } catch (ParseException e) {
/* 218 */         return null;
/*     */       }
/*     */     }
/*     */ 
/* 222 */     return parseDate(date);
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\hansy-frame.jar
 * Qualified Name:     com.hansy.frame.common.tools.DateTimeUtil
 * JD-Core Version:    0.6.0
 */