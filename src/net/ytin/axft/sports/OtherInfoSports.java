/*     */ package net.ytin.axft.sports;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import jxl.Workbook;
/*     */ import jxl.write.Label;
/*     */ import jxl.write.Number;
/*     */ import jxl.write.WritableSheet;
/*     */ import jxl.write.WritableWorkbook;
/*     */ import net.ytin.axft.Good;
/*     */ 
/*     */ 
/*     */ public class OtherInfoSports
/*     */ {
/*     */   public OtherInfoSports(String filename, List list, Properties otherInfo)
/*     */   {
/*     */     try
/*     */     {
/*  23 */       Workbook wb = Workbook.getWorkbook(new File(filename));
/*     */       
/*  25 */       WritableWorkbook book = Workbook.createWorkbook(new File(filename), 
/*  26 */         wb);
/*  27 */       WritableSheet sheet = book.getSheet(0);
/*  28 */       int row_number = Integer.parseInt((String)otherInfo.get("row_number"));
/*     */       
/*  30 */       Date today_date = new Date();
/*  31 */       Calendar canlendar = Calendar.getInstance();
/*  32 */       canlendar
/*  33 */         .set(canlendar.get(1) + 5, 
/*  34 */         canlendar.get(2), 
/*  35 */         canlendar.get(5));
/*  36 */       Date endDate_date = canlendar.getTime();
/*  37 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/*  38 */       String today = df.format(today_date);
/*  39 */       String endDate = df.format(endDate_date);
/*     */       
/*  41 */       for (int b = 0; b < list.size(); b++) {
/*  42 */         Good good = (Good)list.get(b);
/*  43 */         int index = b + 3;
/*     */         
/*  45 */         sheet.addCell(new Label(ColDefSports.COL_manufacturer, index, 
/*  46 */           (String)otherInfo.get("manufacturer")));
/*     */         
/*  48 */         sheet.addCell(new Label(ColDefSports.COL_feed_product_type, index, 
/*  49 */           (String)otherInfo.get("feed_product_type")));
/*     */         
/*  51 */         sheet.addCell(new Label(ColDefSports.COL_update_delete, index, 
/*  52 */           (String)otherInfo.get("update_delete")));
/*     */         
/*  54 */         sheet.addCell(new Label(
/*  55 */           ColDefSports.COL_country_of_origin, index, 
/*  56 */           (String)otherInfo.get("country_of_origin")));
/*     */         
/*  58 */         if (!good.isParentFlag())
/*     */         {
/*  60 */           sheet.addCell(new Number(
/*  61 */             ColDefSports.COL_standard_price, 
/*  62 */             index, 
/*  63 */             Double.valueOf((String)otherInfo.get("standard_price")).doubleValue()));
/*     */           
/*  65 */           sheet.addCell(new Label(
/*  66 */             ColDefSports.COL_currency, 
/*  67 */             index, 
/*  68 */             (String)otherInfo.get("currency")));
/*     */           
/*  70 */           sheet.addCell(new Number(ColDefSports.COL_quantity, index, 
/*  71 */             Double.valueOf((String)otherInfo.get("quantity")).doubleValue()));
/*     */           
/*  73 */           sheet.addCell(new Label(ColDefSports.COL_condition_type, index, 
/*  74 */             (String)otherInfo.get("condition_type")));
/*     */           
/*  76 */           sheet.addCell(new Number(ColDefSports.COL_sale_price, index, 
/*  77 */             Double.valueOf((String)otherInfo.get("sale_price")).doubleValue()));
/*     */           
/*  79 */           sheet.addCell(new Label(ColDefSports.COL_sale_from_date, index, 
/*  80 */             today));
/*     */           
/*  82 */           sheet.addCell(new Label(ColDefSports.COL_sale_end_date, index, 
/*  83 */             endDate));
/*     */           
/*  85 */           sheet.addCell(new Label(ColDefSports.COL_rebate_name1, index, 
/*  86 */             (String)otherInfo.get("rebate_name1")));
/*     */           
/*  88 */           sheet.addCell(new Label(ColDefSports.COL_rebate_description1, 
/*  89 */             index, (String)otherInfo.get("rebate_description1")));
/*     */           
/*  91 */           sheet.addCell(new Label(ColDefSports.COL_rebate_start_at1, 
/*  92 */             index, today));
/*     */           
/*  94 */           sheet.addCell(new Label(ColDefSports.COL_rebate_end_at1, index, 
/*  95 */             endDate));
/*     */           
/*  97 */           sheet.addCell(new Number(ColDefSports.COL_item_package_quantity, 
/*  98 */             index, Double.valueOf(
/*  99 */             (String)otherInfo.get("item_package_quantity")).doubleValue()));
/*     */           
/* 101 */           sheet.addCell(new Label(
/* 102 */             ColDefSports.COL_product_site_launch_date, index, today));
/*     */           
/* 104 */           sheet.addCell(new Label(ColDefSports.COL_merchant_release_date, 
/* 105 */             index, today));
/*     */           
/* 107 */           sheet.addCell(new Number(ColDefSports.COL_fulfillment_latency, 
/* 108 */             index, Double.valueOf(
/* 109 */             (String)otherInfo.get("fulfillment_latency")).doubleValue()));
/*     */           
/*     */ 
/* 112 */           sheet.addCell(new Number(ColDefSports.COL_website_shipping_weight, 
/* 113 */             index, Double.valueOf(
/* 114 */             (String)otherInfo.get("website_shipping_weight")).doubleValue()));
/*     */           
/* 116 */           sheet.addCell(new Label(
/* 117 */             ColDefSports.COL_website_shipping_weight_unit_of_measure, 
/* 118 */             index, 
/* 119 */             (String)otherInfo.get("website_shipping_weight_unit_of_measure")));
/*     */           
/*     */ 
/*     */ 
/* 123 */           sheet.addCell(new Number(ColDefSports.COL_item_weight, index, 
/* 124 */             Double.valueOf((String)otherInfo.get("item_weight")).doubleValue()));
/* 125 */           sheet.addCell(new Label(
/* 126 */             ColDefSports.COL_item_weight_unit_of_measure, index, 
/* 127 */             (String)otherInfo.get("item_weight_unit_of_measure")));
/*     */         }
/*     */       }
/*     */       
/* 131 */       book.write();
/* 132 */       book.close();
/*     */     } catch (Exception e) {
/* 134 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Volumes/SanDisk/workspace/AutoGen/AutoGen 坐垫/GenExcel.jar!/net/ytin/axft/sports/OtherInfoSports.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */