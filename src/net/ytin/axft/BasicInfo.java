/*    */ package net.ytin.axft;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.List;
/*    */ import java.util.Properties;
/*    */ import jxl.Workbook;
/*    */ import jxl.write.Label;
/*    */ import jxl.write.WritableSheet;
/*    */ import jxl.write.WritableWorkbook;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BasicInfo
/*    */ {
/*    */   public BasicInfo() {}
/*    */   
/*    */   public BasicInfo(String filename, List list, boolean IsOption, int OptionType, Properties coldef, Properties goodColumns)
/*    */   {
/* 28 */     generateBasicInfoIntoExcelFile(filename, list, IsOption, OptionType, 
/* 29 */       coldef, goodColumns);
/*    */   }
/*    */   
/*    */ 
/*    */   private void generateBasicInfoIntoExcelFile(String filename, List list, boolean IsOption, int OptionType, Properties coldef, Properties goodColumns)
/*    */   {
/*    */     try
/*    */     {
/* 37 */       Workbook wb = Workbook.getWorkbook(new File(filename));
/*    */       
/* 39 */       File file_b = new File(filename);
/*    */       
/* 41 */       WritableWorkbook book = Workbook.createWorkbook(file_b, wb);
/*    */       
/* 43 */       WritableSheet sheet = book.getSheet(0);
/*    */       
/* 45 */       for (int b = 0; b < list.size(); b++) {
/* 46 */         Good good = (Good)list.get(b);
/* 47 */         int index = b + 3;
/* 48 */         sheet.addCell(new Label(getColNo("item_sku", coldef), index, 
/* 49 */           good.getSKU()));
/* 50 */         if (IsOption) {
/* 51 */           int seq = getColNo("variation_theme", coldef);
/* 52 */           sheet.addCell(new Label(seq, index, good
/* 53 */             .getVariation_theme()));
/* 54 */           if (!good.isParentFlag())
/*    */           {
/* 56 */             sheet.addCell(new Label(
/* 57 */               getColNo("parent_child", coldef), index, "子商品"));
/*    */             
/* 59 */             sheet.addCell(new Label(getColNo("parent_sku", coldef), 
/* 60 */               index, good.getParentSKU()));
/* 61 */             sheet.addCell(new Label(getColNo("relationship_type", 
/* 62 */               coldef), index, "变体"));
/*    */             
/* 64 */             sheet.addCell(new Label(getColNo("color_name", coldef), 
/* 65 */               index, good.getColor_CN()));
/* 66 */             sheet.addCell(new Label(getColNo("color_map", coldef), 
/* 67 */               index, good.getColor_map()));
/*    */             
/* 69 */             sheet.addCell(new Label(getColNo("size_name", coldef), 
/* 70 */               index, good.getSize_name()));
/* 71 */             sheet.addCell(new Label(getColNo("size_map", coldef), 
/* 72 */               index, good.getSize_map()));
/*    */           } else {
/* 74 */             sheet.addCell(new Label(
/* 75 */               getColNo("parent_child", coldef), index, "父商品"));
/*    */           }
/*    */         }
/*    */       }
/*    */       
/* 80 */       book.write();
/* 81 */       book.close();
/*    */     } catch (Exception e) {
/* 83 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */   
/*    */   private String getValue(String key, Properties coldef) {
/* 88 */     String value = (String)coldef.get(key);
/* 89 */     String[] val = value.split(";");
/* 90 */     return val[1];
/*    */   }
/*    */   
/*    */   private int getColNo(String key, Properties coldef) {
/* 94 */     String value = (String)coldef.get(key);
/* 95 */     String[] val = value.split(";");
/* 96 */     return Integer.parseInt(val[0]);
/*    */   }
/*    */ }


/* Location:              /Volumes/SanDisk/workspace/AutoGen/AutoGen 坐垫/GenExcel.jar!/net/ytin/axft/BasicInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */