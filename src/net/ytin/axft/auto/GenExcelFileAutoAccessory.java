/*     */ package net.ytin.axft.auto;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import jxl.Workbook;
/*     */ import jxl.write.Label;
/*     */ import jxl.write.WritableSheet;
/*     */ import jxl.write.WritableWorkbook;
/*     */ import jxl.write.WriteException;
/*     */ import jxl.write.biff.RowsExceededException;
/*     */ 
/*     */ public class GenExcelFileAutoAccessory
/*     */ {
/*  17 */   private String filename_excel = "";
/*  18 */   private String shortFileName = "";
/*     */   
/*     */   public String getFilename() {
/*  21 */     return this.filename_excel;
/*     */   }
/*     */   
/*     */   public String getShortFileName() {
/*  25 */     return this.shortFileName;
/*     */   }
/*     */   
/*     */   public GenExcelFileAutoAccessory(Map colDefMap) {
/*  29 */     String basePath = System.getProperty("user.dir") + "/output/";
/*     */     
/*  31 */     Date date = new Date(System.currentTimeMillis());
/*  32 */     SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
/*  33 */     this.shortFileName = ("AutoAccessory_" + df.format(date) + ".xls");
/*  34 */     this.filename_excel = (basePath + this.shortFileName);
/*     */     
/*  36 */     generateNewExcelFile(colDefMap);
/*     */   }
/*     */   
/*     */   private void copyFromExampleFile()
/*     */   {
/*     */     try
/*     */     {
/*  43 */       String exampleFileName = "Example.xls";
/*     */       
/*  45 */       Workbook wb = Workbook.getWorkbook(new File(exampleFileName));
/*     */       
/*  47 */       WritableWorkbook book = Workbook.createWorkbook(new File(
/*  48 */         this.filename_excel), wb);
/*     */       
/*  50 */       WritableSheet sheet = book.getSheet(0);
/*  51 */       book.write();
/*  52 */       book.close();
/*     */     } catch (Exception e) {
/*  54 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   private void generateNewExcelFile(Map colDefMap)
/*     */   {
/*     */     try
/*     */     {
/*  62 */       WritableWorkbook book = 
/*  63 */         Workbook.createWorkbook(new FileOutputStream(new File(
/*  64 */         this.filename_excel)));
/*     */       
/*  66 */       WritableSheet sheet = book.createSheet("自动生成", 0);
/*     */       
/*  68 */       sheet.addCell(new Label(0, 0, "以下内容为软件自动生成，请复制到Amazon模板文件中进行验证。"));
/*  69 */       String[] coldef4Chinese = (String[])colDefMap.get("chinese");
/*  70 */       String[] coldef4English = (String[])colDefMap.get("english");
/*  71 */       addTitleRowChinese(sheet, coldef4Chinese);
/*  72 */       addTitleRowEnglish(sheet, coldef4English);
/*     */       
/*     */ 
/*  75 */       book.write();
/*  76 */       book.close();
/*     */     }
/*     */     catch (Exception e) {
/*  79 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   private void addTitleRowChinese(WritableSheet sheet, String[] coldef4Chinese)
/*     */     throws RowsExceededException, WriteException
/*     */   {
/*  86 */     int row = 1;
/*  87 */     for (int i = 0; i < coldef4Chinese.length; i++) {
/*  88 */       sheet.addCell(new Label(i, row, coldef4Chinese[i]));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addTitleRowEnglish(WritableSheet sheet, String[] coldef4English)
/*     */     throws RowsExceededException, WriteException
/*     */   {
/* 465 */     int row = 2;
/* 466 */     for (int i = 0; i < coldef4English.length; i++) {
/* 467 */       sheet.addCell(new Label(i, row, coldef4English[i]));
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Volumes/SanDisk/workspace/AutoGen/AutoGen 坐垫/GenExcel.jar!/net/ytin/axft/auto/GenExcelFileAutoAccessory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */