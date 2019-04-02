/*     */ package net.ytin.axft;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import jxl.Workbook;
/*     */ import jxl.write.Label;
/*     */ import jxl.write.WritableSheet;
/*     */ import jxl.write.WritableWorkbook;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KeyInfo
/*     */ {
/*     */   public KeyInfo(String filename, List list, String desc, List attList, Properties coldef, Properties goodColumns)
/*     */   {
/*     */     try
/*     */     {
/*  24 */       Workbook wb = Workbook.getWorkbook(new File(filename));
/*     */       
/*  26 */       WritableWorkbook book = Workbook.createWorkbook(new File(filename), 
/*  27 */         wb);
/*  28 */       WritableSheet sheet = book.getSheet(0);
/*  29 */       for (int b = 0; b < list.size(); b++) {
/*  30 */         Good good = (Good)list.get(b);
/*  31 */         int index = b + 3;
/*  32 */         sheet.addCell(new Label(getColNo("item_name", coldef), index, 
/*  33 */           good.getName()));
/*  34 */         sheet.addCell(new Label(getColNo("brand_name", coldef), index, 
/*  35 */           good.getBrand_CN()));
/*  36 */         sheet.addCell(new Label(
/*  37 */           getColNo("product_description", coldef), index, desc));
/*  38 */         for (int i = 0; i < attList.size(); i++) {
/*  39 */           String attr = (String)attList.get(i);
/*  40 */           sheet.addCell(new Label(getColNo("bullet_point1", coldef) + 
/*  41 */             i, index, attr));
/*     */         }
/*     */         
/*  44 */         sheet.addCell(new Label(getColNo("recommended_browse_nodes", 
/*  45 */           coldef), index, good.getNode()));
/*     */         
/*  47 */         sheet.addCell(new Label(getColNo("generic_keywords1", coldef), 
/*  48 */           index, good.getKeyword1()));
/*  49 */         sheet.addCell(new Label(getColNo("generic_keywords2", coldef), 
/*  50 */           index, good.getKeyword2()));
/*  51 */         sheet.addCell(new Label(getColNo("generic_keywords3", coldef), 
/*  52 */           index, good.getKeyword3()));
/*  53 */         sheet.addCell(new Label(getColNo("generic_keywords4", coldef), 
/*  54 */           index, good.getKeyword4()));
/*  55 */         sheet.addCell(new Label(getColNo("generic_keywords5", coldef), 
/*  56 */           index, good.getKeyword5()));
/*     */         
/*  58 */         sheet.addCell(new Label(getColNo(
/*  59 */           "compatible_with_vehicle_type1", coldef), index, good
/*  60 */           .getCompatible_with_vehicle_type1()));
/*  61 */         sheet.addCell(new Label(getColNo(
/*  62 */           "compatible_with_vehicle_type2", coldef), index, good
/*  63 */           .getCompatible_with_vehicle_type2()));
/*  64 */         sheet.addCell(new Label(getColNo(
/*  65 */           "compatible_with_vehicle_type3", coldef), index, good
/*  66 */           .getCompatible_with_vehicle_type3()));
/*  67 */         sheet.addCell(new Label(getColNo(
/*  68 */           "compatible_with_vehicle_type4", coldef), index, good
/*  69 */           .getCompatible_with_vehicle_type4()));
/*  70 */         sheet.addCell(new Label(getColNo(
/*  71 */           "compatible_with_vehicle_type5", coldef), index, good
/*  72 */           .getCompatible_with_vehicle_type5()));
/*  73 */         sheet.addCell(new Label(getColNo(
/*  74 */           "compatible_with_vehicle_type6", coldef), index, good
/*  75 */           .getCompatible_with_vehicle_type6()));
/*  76 */         sheet.addCell(new Label(getColNo(
/*  77 */           "compatible_with_vehicle_type7", coldef), index, good
/*  78 */           .getCompatible_with_vehicle_type7()));
/*  79 */         sheet.addCell(new Label(getColNo(
/*  80 */           "compatible_with_vehicle_type8", coldef), index, good
/*  81 */           .getCompatible_with_vehicle_type8()));
/*  82 */         sheet.addCell(new Label(getColNo(
/*  83 */           "compatible_with_vehicle_type9", coldef), index, good
/*  84 */           .getCompatible_with_vehicle_type9()));
/*     */       }
/*     */       
/*     */ 
/*  88 */       book.write();
/*  89 */       book.close();
/*     */     } catch (Exception e) {
/*  91 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void generateKeyInfoIntoExcelFile() {}
/*     */   
/*     */   private String getValue(String key, Properties coldef)
/*     */   {
/* 100 */     String value = (String)coldef.get(key);
/* 101 */     String[] val = value.split(";");
/* 102 */     return val[1];
/*     */   }
/*     */   
/*     */   private int getColNo(String key, Properties coldef) {
/* 106 */     String value = (String)coldef.get(key);
/* 107 */     String[] val = value.split(";");
/* 108 */     return Integer.parseInt(val[0]);
/*     */   }
/*     */ }


/* Location:              /Volumes/SanDisk/workspace/AutoGen/AutoGen 坐垫/GenExcel.jar!/net/ytin/axft/KeyInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */