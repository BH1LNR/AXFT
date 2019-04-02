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
/*    */ public class URLInfo
/*    */ {
/*    */   public URLInfo(String filename, List list, Properties coldef, Properties goodColumns)
/*    */   {
/*    */     try
/*    */     {
/* 22 */       Workbook wb = Workbook.getWorkbook(new File(filename));
/*    */       
/* 24 */       WritableWorkbook book = Workbook.createWorkbook(new File(filename), 
/* 25 */         wb);
/* 26 */       WritableSheet sheet = book.getSheet(0);
/*    */       
/* 28 */       for (int b = 0; b < list.size(); b++) {
/* 29 */         Good good = (Good)list.get(b);
/* 30 */         int index = b + 3;
/* 31 */         ColorURL url = good.getColor_url();
/* 32 */         sheet.addCell(new Label(getColNo("main_image_url", coldef), 
/* 33 */           index, url.getMain_image_url()));
/* 34 */         sheet.addCell(new Label(getColNo("swatch_image_url", coldef), 
/* 35 */           index, url.getSwatch_image_url()));
/* 36 */         List color_url_list = url.getColor_image_url();
/* 37 */         List other_url_list = url.getOther_image_url();
/* 38 */         int color_size = color_url_list.size();
/* 39 */         if (color_size <= 8) {
/* 40 */           for (int p = 0; p < color_url_list.size(); p++)
/*    */           {
/* 42 */             sheet.addCell(new Label(getColNo("other_image_url1", 
/* 43 */               coldef) + p, index, 
/* 44 */               (String)color_url_list.get(p)));
/*    */           }
/*    */         }
/* 47 */         if (8 - color_size > 0) {
/* 48 */           for (int q = 0; q < 8 - color_size; q++) {
/* 49 */             if (q < other_url_list.size()) {
/* 50 */               sheet.addCell(new Label(getColNo(
/* 51 */                 "other_image_url1", coldef) + 
/*    */                 
/* 53 */                 color_size + q, index, 
/* 54 */                 (String)other_url_list.get(q)));
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/* 59 */       book.write();
/* 60 */       book.close();
/*    */     } catch (Exception e) {
/* 62 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */   
/*    */   private String getValue(String key, Properties coldef) {
/* 67 */     String value = (String)coldef.get(key);
/* 68 */     String[] val = value.split(";");
/* 69 */     return val[1];
/*    */   }
/*    */   
/*    */   private int getColNo(String key, Properties coldef) {
/* 73 */     String value = (String)coldef.get(key);
/* 74 */     String[] val = value.split(";");
/* 75 */     return Integer.parseInt(val[0]);
/*    */   }
/*    */ }


/* Location:              /Volumes/SanDisk/workspace/AutoGen/AutoGen 坐垫/GenExcel.jar!/net/ytin/axft/URLInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */