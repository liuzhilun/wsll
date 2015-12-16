/*     */ package com.hansy.frame.common.tools;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.text.DecimalFormat;
/*     */ 
/*     */ public class ArithUtil
/*     */ {
/*     */   private static final int DEF_DIV_SCALE = 10;
/*     */ 
/*     */   public static boolean isDoubleNotGreater(double d1, double d2)
/*     */   {
/*  23 */     boolean bn = false;
/*  24 */     BigDecimal b1 = new BigDecimal(Double.toString(d1));
/*  25 */     BigDecimal b2 = new BigDecimal(Double.toString(d2));
/*     */ 
/*  27 */     if (b1.compareTo(b2) <= 0)
/*  28 */       bn = true;
/*     */     else {
/*  30 */       bn = false;
/*     */     }
/*     */ 
/*  33 */     return bn;
/*     */   }
/*     */ 
/*     */   public static boolean isDoubleNotLess(double d1, double d2) {
/*  37 */     boolean bn = false;
/*  38 */     BigDecimal b1 = new BigDecimal(Double.toString(d1));
/*  39 */     BigDecimal b2 = new BigDecimal(Double.toString(d2));
/*     */ 
/*  41 */     if (b1.compareTo(b2) >= 0)
/*  42 */       bn = true;
/*     */     else {
/*  44 */       bn = false;
/*     */     }
/*     */ 
/*  47 */     return bn;
/*     */   }
/*     */ 
/*     */   public static boolean isDoubleEqual(double d1, double d2) {
/*  51 */     boolean bn = false;
/*  52 */     BigDecimal b1 = new BigDecimal(Double.toString(d1));
/*  53 */     BigDecimal b2 = new BigDecimal(Double.toString(d2));
/*     */ 
/*  55 */     if (b1.compareTo(b2) == 0)
/*  56 */       bn = true;
/*     */     else {
/*  58 */       bn = false;
/*     */     }
/*     */ 
/*  61 */     return bn;
/*     */   }
/*     */ 
/*     */   public static double add(double d1, double d2) {
/*  65 */     BigDecimal b1 = new BigDecimal(Double.toString(d1));
/*  66 */     BigDecimal b2 = new BigDecimal(Double.toString(d2));
/*  67 */     return b1.add(b2).doubleValue();
/*     */   }
/*     */ 
/*     */   public static double sub(double d1, double d2) {
/*  71 */     BigDecimal b1 = new BigDecimal(Double.toString(d1));
/*  72 */     BigDecimal b2 = new BigDecimal(Double.toString(d2));
/*  73 */     return b1.subtract(b2).doubleValue();
/*     */   }
/*     */ 
/*     */   public static double mul(double d1, double d2) {
/*  77 */     BigDecimal b1 = new BigDecimal(Double.toString(d1));
/*  78 */     BigDecimal b2 = new BigDecimal(Double.toString(d2));
/*  79 */     return b1.multiply(b2).doubleValue();
/*     */   }
/*     */ 
/*     */   public static double div(double d1, double d2, int scale) {
/*  83 */     if (scale < 0) {
/*  84 */       throw new IllegalArgumentException(
/*  85 */         "The scale must be a positive integer or zero");
/*     */     }
/*  87 */     BigDecimal b1 = new BigDecimal(Double.toString(d1));
/*  88 */     BigDecimal b2 = new BigDecimal(Double.toString(d2));
/*  89 */     return b1.divide(b2, scale, 4).doubleValue();
/*     */   }
/*     */ 
/*     */   public static double div(double d1, double d2) {
/*  93 */     return div(d1, d2, 10);
/*     */   }
/*     */ 
/*     */   public static double round(double d, int scale) {
/*  97 */     if (scale < 0) {
/*  98 */       throw new IllegalArgumentException(
/*  99 */         "The scale must be a positive integer or zero");
/*     */     }
/* 101 */     BigDecimal b = new BigDecimal(Double.toString(d));
/* 102 */     BigDecimal one = new BigDecimal("1");
/* 103 */     return b.divide(one, scale, 4).doubleValue();
/*     */   }
/*     */ 
/*     */   public static String genPattern(String subStr, int n) {
/* 107 */     StringBuffer temp = new StringBuffer();
/* 108 */     while (n > 0) {
/* 109 */       if ((subStr.trim().equals("#")) && (n == 1))
/* 110 */         temp.append("0");
/*     */       else {
/* 112 */         temp.append(subStr);
/*     */       }
/* 114 */       n--;
/*     */     }
/* 116 */     return temp.toString();
/*     */   }
/*     */ 
/*     */   public static String formatDouble(double number, int intPart, int decPart) {
/* 120 */     return new DecimalFormat(genPattern("#", intPart) + "." + 
/* 121 */       genPattern("0", decPart)).format(number);
/*     */   }
/*     */ 
/*     */   public static String formatDecimal(BigDecimal number, int intPart, int decPart)
/*     */   {
/* 126 */     return new DecimalFormat(genPattern("#", intPart) + "." + 
/* 127 */       genPattern("0", decPart)).format(number);
/*     */   }
/*     */ 
/*     */   public static String formatDecimal(BigDecimal number) {
/* 131 */     String tmp = "";
/*     */ 
/* 133 */     tmp = new DecimalFormat(genPattern("#", 12) + "." + genPattern("0", 12))
/* 134 */       .format(number).trim();
/*     */ 
/* 136 */     int i = tmp.length() - 1;
/* 137 */     for (; i > 0; i--) {
/* 138 */       if (tmp.charAt(i) != '0')
/*     */         break;
/*     */     }
/* 141 */     return tmp.substring(0, i + 1);
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator\Desktop\新建文件夹\hansy-frame.jar
 * Qualified Name:     com.hansy.frame.common.tools.ArithUtil
 * JD-Core Version:    0.6.0
 */