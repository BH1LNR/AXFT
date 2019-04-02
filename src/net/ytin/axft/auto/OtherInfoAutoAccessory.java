/*     */ package net.ytin.axft.auto;
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
/*     */ 
/*     */ public class OtherInfoAutoAccessory
/*     */ {
/*     */   public OtherInfoAutoAccessory(String filename, List list, Properties otherInfo, Properties coldef, Properties goodColumns)
/*     */   {
/*     */     try
/*     */     {
/*  24 */       Workbook wb = Workbook.getWorkbook(new File(filename));
/*     */       
/*  26 */       WritableWorkbook book = Workbook.createWorkbook(new File(filename), 
/*  27 */         wb);
/*  28 */       WritableSheet sheet = book.getSheet(0);
/*  29 */       int row_number = Integer.parseInt(otherInfo.get("row_number")+"");
/*     */       
/*  31 */       Date today_date = new Date();
/*  32 */       Calendar canlendar = Calendar.getInstance();
/*  33 */       canlendar
/*  34 */         .set(canlendar.get(1) + 5, 
/*  35 */         canlendar.get(2), 
/*  36 */         canlendar.get(5));
/*  37 */       Date endDate_date = canlendar.getTime();
/*  38 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/*  39 */       String today = df.format(today_date);
/*  40 */       String endDate = df.format(endDate_date);
/*     */       
/*  42 */       for (int b = 0; b < list.size(); b++) {
/*  43 */         Good good = (Good)list.get(b);
/*  44 */         int index = b + 3;
/*     */         
/*  46 */         sheet.addCell(new Label(getColNo("manufacturer", coldef), 
/*  47 */           index, (String)otherInfo.get("manufacturer")));
/*     */         
/*  49 */         sheet.addCell(new Label(getColNo("feed_product_type", coldef), 
/*  50 */           index, (String)otherInfo.get("feed_product_type")));
/*     */         
/*  52 */         sheet.addCell(new Label(getColNo("update_delete", coldef), 
/*  53 */           index, (String)otherInfo.get("update_delete")));
/*     */         
/*  55 */         sheet.addCell(new Label(getColNo("country_of_origin", coldef), 
/*  56 */           index, (String)otherInfo.get("country_of_origin")));
/*     */         
/*  58 */         if (!good.isParentFlag())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  67 */           sheet.addCell(new Number(
/*  68 */             getColNo("standard_price", coldef), index, 
/*  69 */             Double.valueOf(
/*  70 */             (String)otherInfo.get("standard_price")).doubleValue()));
/*     */           
/*  72 */           sheet.addCell(new Label(getColNo("currency", coldef), 
/*  73 */             index, (String)otherInfo.get("currency")));
/*     */           
/*  75 */           sheet.addCell(new Number(getColNo("quantity", coldef), 
/*  76 */             index, Double.valueOf(
/*  77 */             (String)otherInfo.get("quantity")).doubleValue()));
/*     */           
/*  79 */           sheet.addCell(new Label(getColNo("condition_type", coldef), 
/*  80 */             index, (String)otherInfo.get("condition_type")));
/*     */           
/*  82 */           sheet.addCell(new Number(getColNo("sale_price", coldef), 
/*  83 */             index, Double.valueOf(
/*  84 */             (String)otherInfo.get("sale_price")).doubleValue()));
/*     */           
/*  86 */           sheet.addCell(new Label(getColNo("sale_from_date", coldef), 
/*  87 */             index, today));
/*     */           
/*  89 */           sheet.addCell(new Label(getColNo("sale_end_date", coldef), 
/*  90 */             index, endDate));
/*     */           
/*  92 */           sheet.addCell(new Label(getColNo("rebate_name", coldef), 
/*  93 */             index, (String)otherInfo.get("rebate_name")));
/*     */           
/*  95 */           sheet.addCell(new Label(getColNo("rebate_description", 
/*  96 */             coldef), index, 
/*  97 */             (String)otherInfo.get("rebate_description")));
/*     */           
/*  99 */           sheet.addCell(new Label(
/* 100 */             getColNo("rebate_start_at", coldef), index, today));
/*     */           
/* 102 */           sheet.addCell(new Label(getColNo("rebate_end_at", coldef), 
/* 103 */             index, endDate));

/*  99 */           sheet.addCell(new Label(
/* 100 */             getColNo("offering_start_date", coldef), index, today));
/*     */           
/* 102 */           sheet.addCell(new Label(getColNo("offering_end_date", coldef), 
/* 103 */             index, endDate));
/*     */           
/* 105 */           sheet.addCell(new Number(
/* 106 */             getColNo("number_of_items", coldef), index, 
/* 107 */             Double.valueOf(
/* 108 */             (String)otherInfo.get("number_of_items")).doubleValue()));
/*     */           
/* 110 */           sheet.addCell(new Number(getColNo("item_package_quantity", 
/* 111 */             coldef), index, Double.valueOf(
/* 112 */             (String)otherInfo.get("item_package_quantity")).doubleValue()));
/*     */           
/* 114 */           sheet.addCell(new Label(getColNo(
/* 115 */             "product_site_launch_date", coldef), index, today));
/*     */           
/* 117 */           sheet.addCell(new Label(getColNo("merchant_release_date", 
/* 118 */             coldef), index, today));
/*     */           
/* 120 */           sheet.addCell(new Number(getColNo("fulfillment_latency", 
/* 121 */             coldef), index, Double.valueOf(
/* 122 */             (String)otherInfo.get("fulfillment_latency")).doubleValue()));
/*     */           

/*     */           
/* 136 */           sheet.addCell(new Number(getColNo("package_weight", coldef), 
/* 137 */             index, Double.valueOf(
/* 138 */             (String)otherInfo.get("package_weight")).doubleValue()));
/* 139 */           sheet.addCell(new Label(getColNo(
/* 140 */             "package_weight_unit_of_measure", coldef), index, 
/*     */             
/* 142 */             (String)otherInfo.get("package_weight_unit_of_measure")));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 148 */       book.write();
/* 149 */       book.close();
/*     */     } catch (Exception e) {
/* 151 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   private String getValue(String key, Properties coldef) {
/* 156 */     String value = (String)coldef.get(key);
/* 157 */     String[] val = value.split(";");
/* 158 */     return val[1];
/*     */   }
/*     */   
/*     */   private int getColNo(String key, Properties coldef) {
/* 162 */     String value = (String)coldef.get(key);
/* 163 */     String[] val = value.split(";");
/* 164 */     return Integer.parseInt(val[0]);
/*     */   }
/*     */ }


/* Location:              /Volumes/SanDisk/workspace/AutoGen/AutoGen 坐垫/GenExcel.jar!/net/ytin/axft/auto/OtherInfoAutoAccessory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */