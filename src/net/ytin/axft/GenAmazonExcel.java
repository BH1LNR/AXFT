/*     */ package net.ytin.axft;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.Scanner;

/*     */ import net.ytin.axft.auto.GenExcelFileAutoAccessory;
/*     */ import net.ytin.axft.auto.OtherInfoAutoAccessory;
/*     */ import net.ytin.axft.sports.GenExcelFileSports;
/*     */ import net.ytin.axft.sports.OtherInfoSports;
/*     */ 
/*     */ public class GenAmazonExcel
/*     */ {
/*  15 */   private static boolean IsOption = false;
/*  16 */   private static int OptionType = 0;
/*  17 */   private static int ProductType = 0;
/*     */   public static final int ProductType_AutoAccessory = 0;
/*     */   public static final int ProductType_Sports = 1;
/*     */   
/*     */   private static void displayHelp()
/*     */   {
/*  23 */     System.err.println("***********************************************************");
/*  24 */     System.err
/*  25 */       .println("**                                                       **");
/*  26 */     System.err
/*  27 */       .println("**      Welcome to use AXFT (Amazon Excel File Tool)     **");
/*  28 */     System.err
/*  29 */       .println("**                                                       **");
/*  30 */     System.err.println("**      本软件可以帮助您生成符合亚马逊批量文件要求的数据内容      **");
/*  31 */     System.err
/*  32 */       .println("**                                                       **");
/*  33 */     System.err
/*  34 */       .println("** 1、商品基本信息                                          **");
/*  35 */     System.err.println("** 主要包括 商品SKU、父子关系、商品变体主题、颜色、尺寸等         **");
/*  36 */     System.err
/*  37 */       .println("**                                                       **");
/*  38 */     System.err
/*  39 */       .println("** 2、商品关键信息                                         **");
/*  40 */     System.err.println("** 主要包括 商品名称、描述、商品属性、分类节点、关键字等          **");
/*  41 */     System.err
/*  42 */       .println("**                                                       **");
/*  43 */     System.err.println("** 3、商品图片URL等其他信息                                 **");
/*  44 */     System.err.println("** 主要包括 主图URL、其他图片URL、样品图片URL等                **");
/*  45 */     System.err
/*  46 */       .println("**                                                       **");
/*  47 */     System.err
/*  48 */       .println("***********************************************************");
/*     */   }
/*     */   
/*     */   private static void chooseUseOptionOrNot() {
/*     */     int option;
/*     */     Scanner reader;
/*  54 */       do { System.err.println();
/*  55 */         System.err.println("请选择本次是否使用【变体】，1 使用;2 不使用。");
/*  56 */         System.err.println("注意：只能输入1或者2，其他输入都将无法识别。");
/*  57 */         System.err.print("请输入您的选项：");
/*  58 */         reader = new Scanner(System.in);
					option = reader.nextInt();
/*  62 */       if (option == 1) {
/*  63 */         IsOption = true;

/*  64 */         break;
/*  65 */       } 
/*     */       }
/*  60 */       while (true);
/*  61 */      
/*     */   }
/*     */   
/*     */   private static void chooseProductType()
/*     */   {
/*     */     int option;
/*     */     
/*     */         System.err.println();
/*  78 */         System.err.println("请选择本次处理商品类型，1 汽车用品;2 户外用品。");
/*  79 */         System.err.println("注意：只能输入1或者2，其他输入都将无法识别。");
/*  80 */         System.err.print("请输入您的选项：");
/*     */       Scanner reader;
				 
/*     */       do
/*     */       {
/*  77 */         
/*  81 */         reader = new Scanner(System.in);
				  option = reader.nextInt();
/*  84 */       if (option == 1) {
/*  85 */         ProductType = 0;
/*  86 */         break;
/*  87 */       }  if (option == 1) {
	/*  85 */         ProductType = 1;
	
	/*  86 */         break;
	/*  87 */       }else {
					ProductType = 2;
					
/*  86 */         break;
					}
/*  82 */       } while (true);
/*  83 */       
				
/*  88 */    
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void setOptionType()
/*     */   {
/*  98 */     OptionType = 1;
/*     */     int option;
				System.err.println();
				System.err.println("请选择本次【变体】类型，1 颜色;2 尺寸名称;3 颜色和尺寸 。");
/* 101 */       System.err.println("注意：只能输入1、2或者3，其他输入都将无法识别。");
/* 100 */     
	              Scanner reader; 
	              do { 
	            	  reader = new Scanner(System.in);
					  option = reader.nextInt();
					if (option == 1) {
/* 106 */         		OptionType = 1;

/* 107 */         		break; }else
/* 108 */       	if (option == 2) {
/* 109 */         		OptionType = 2;

/* 110 */         		break;
/* 111 */       	}else {
					OptionType = 3;
					
					break;
					}
/* 103 */       } while (true);
/* 104 */      
/* 105 */       
			
/* 112 */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 121 */     displayHelp();
/* 122 */     chooseProductType();
/* 123 */     chooseUseOptionOrNot();
/* 124 */     if (IsOption) {
/* 125 */       setOptionType();
/*     */     }
/*     */     
/* 128 */     System.err.println();
/* 129 */     System.err.println("系统正在处理，请您稍后。");
/*     */     
/* 131 */     String shortName = "";
/* 132 */     List list = null;
/* 133 */     String desc = null;
/* 134 */     List attList = null;
/* 135 */     Properties otherInfo = null;
/* 136 */     Properties coldef = null;
/* 137 */     Properties goodColumns = null;
/*     */     
/* 139 */     InitFromConfigFiles init = new InitFromConfigFiles(IsOption, 
/* 140 */       ProductType, OptionType);
/* 141 */     list = init.getList();
/* 142 */     desc = init.getDesc();
/* 143 */     attList = init.getAttList();
/* 144 */     otherInfo = init.getOtherInfo();
/* 145 */     otherInfo.put("row_number", Integer.valueOf(list.size()));
/* 146 */     coldef = init.getColdef();
/* 147 */     Map colDefMap = init.getColDefMap();
/* 148 */     goodColumns = init.getGoodColumns();
/*     */     
/* 150 */     String excelName = "";
/*     */     
/*     */ 
/* 153 */     if (ProductType == 0) {
/* 154 */       GenExcelFileAutoAccessory gen = new GenExcelFileAutoAccessory(
/* 155 */         colDefMap);
/* 156 */       excelName = gen.getFilename();
/* 157 */       shortName = gen.getShortFileName();
/* 158 */     } else if (ProductType == 1) {
/* 159 */       GenExcelFileSports gen = new GenExcelFileSports();
/* 160 */       excelName = gen.getFilename();
/* 161 */       shortName = gen.getShortFileName();
/*     */     } else {
/* 163 */       System.err.println();
/* 164 */       System.err.println("本软件目前只支持生成汽车用品或者户外用品数据文件，本次无法满足您的要求，请您重试。");
/* 165 */       System.err.println("感谢您使用AXFT。");
/* 166 */       Scanner reader = new Scanner(System.in);
/* 167 */       if (reader.hasNext()) {
/* 168 */         System.exit(0);
/*     */       }
/*     */     }
/*     */     
/* 172 */     new BasicInfo(excelName, list, IsOption, OptionType, coldef, 
/* 173 */       goodColumns);
/*     */     
/* 175 */     new KeyInfo(excelName, list, desc, attList, coldef, goodColumns);
/*     */     
/* 177 */     new URLInfo(excelName, list, coldef, goodColumns);
/*     */     
/* 179 */     if (ProductType == 0) {
/* 180 */       new OtherInfoAutoAccessory(excelName, list, otherInfo, coldef, 
/* 181 */         goodColumns);
/* 182 */     } else if (ProductType == 1) {
/* 183 */       new OtherInfoSports(excelName, list, otherInfo);
/*     */     } else {
/* 185 */       System.err.println();
/* 186 */       System.err.println("本软件目前只支持生成汽车用品或者户外用品数据文件，本次无法满足您的要求，请您重试。");
/* 187 */       System.err.println("感谢您使用AXFT。");
/* 188 */       Scanner reader = new Scanner(System.in);
/* 189 */       if (reader.hasNext()) {
/* 190 */         System.exit(0);
/*     */       }
/*     */     }
/*     */     
/* 194 */     for (int g = 0; g < 50; g++) {
/*     */       try {
/* 196 */         Thread.sleep(20L);
/*     */       }
/*     */       catch (InterruptedException e) {
/* 199 */         e.printStackTrace();
/*     */       }
/* 201 */       System.err.print("*");
/*     */     }
/* 203 */     System.err.println();
/*     */     
/* 205 */     System.err.println("恭喜您，商品批量信息文件【" + shortName + "】已经生成，请您到指定目录下查看。");
/* 206 */     System.err.println("感谢您使用AXFT。");
/* 207 */     Scanner reader = new Scanner(System.in);
/* 208 */     if (reader.hasNext()) {
/* 209 */       System.exit(0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Volumes/SanDisk/workspace/AutoGen/AutoGen 坐垫/GenExcel.jar!/net/ytin/axft/GenAmazonExcel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */