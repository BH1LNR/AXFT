/*     */ package net.ytin.axft;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.Random;
/*     */ import java.util.Scanner;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class InitFromConfigFiles
/*     */ {
/*  21 */   private List list = null;
/*  22 */   private String desc = null;
/*  23 */   private List attList = null;
/*  24 */   private String GOODTYPE = "GFA";
/*  25 */   private Properties otherInfo = null;
/*  26 */   private Properties coldef = null;
/*  27 */   private Properties goodColumns = null;
/*     */   
/*     */   public String getDesc() {
/*  30 */     return this.desc;
/*     */   }
/*     */   
/*     */   public void setDesc(String desc) {
/*  34 */     this.desc = desc;
/*     */   }
/*     */   
/*     */   public List getAttList() {
/*  38 */     return this.attList;
/*     */   }
/*     */   
/*     */   public void setAttList(List attList) {
/*  42 */     this.attList = attList;
/*     */   }
/*     */   
/*     */   public Properties getOtherInfo() {
/*  46 */     return this.otherInfo;
/*     */   }
/*     */   
/*     */   public void setOtherInfo(Properties otherInfo) {
/*  50 */     this.otherInfo = otherInfo;
/*     */   }
/*     */   
/*     */   public InitFromConfigFiles(boolean IsOption, int ProductType, int OptionType) {
/*     */     try {
/*  55 */       Date date = new Date(System.currentTimeMillis());
/*  56 */       SimpleDateFormat df = new SimpleDateFormat("MMdd");
/*  57 */       this.GOODTYPE += df.format(date);
/*  58 */       String AutoAccessory_Config_Path = "/input_auto/";
/*  59 */       String Sports_Config_Path = "/input_sports/";
/*  60 */       String basePath = System.getProperty("user.dir") + "/config";
/*     */       
/*     */ 
/*  63 */       String configFile = basePath + "/config.inf";
/*     */       
/*  65 */       Properties config = new Properties();
/*  66 */       config.load(new FileInputStream(new File(configFile)));
/*     */       
/*     */ 
/*  69 */       String brandPath = config.getProperty("brand.file");
/*  70 */       String colorPath = config.getProperty("color.file");
/*  71 */       String carTypePath = config.getProperty("car.type.file");
/*  72 */       String descPath = config.getProperty("desc.file");
/*  73 */       String attributePath = config.getProperty("attribute.file");
/*  74 */       String keywordsPath = config.getProperty("keywords.file");
/*  75 */       String nodePath = config.getProperty("node.file");
/*  76 */       String namekeyPath = config.getProperty("namekeys.file");
/*  77 */       String sizePath = config.getProperty("size.file");
/*  78 */       if (ProductType == 0) {
/*  79 */         basePath = basePath + AutoAccessory_Config_Path;
/*  80 */       } else if (ProductType == 1) {
/*  81 */         basePath = basePath + Sports_Config_Path;
/*     */       } else {
/*  83 */         System.err.println();
/*  84 */         System.err.println("本软件目前只支持生成汽车用品或者户外用品数据文件，本次无法满足您的要求，请您重试。");
/*  85 */         System.err.println("感谢您使用AXFT。");
/*  86 */         Scanner reader = new Scanner(System.in);
/*  87 */         if (reader.hasNext()) {
/*  88 */           System.exit(0);
/*     */         }
/*     */       }
/*  91 */       String otherInfoPath = basePath + "Other.properties";
/*  92 */       String coldefPath = basePath + "ZeroColDef.properties";
/*  93 */       String goodColumnsPath = basePath + "ZeroGood.properties";
/*     */       
/*  95 */       List brandList = FileUtil.readLine2List(basePath + brandPath);
/*  96 */       List carTypeList = FileUtil.readLine2List(basePath + carTypePath);
/*     */       
/*  98 */       List descList = FileUtil.readLine2List(basePath + descPath);
/*  99 */       List colorListTemp = FileUtil.readLine2List(basePath + colorPath);
/* 100 */       this.attList = FileUtil.readLine2List(basePath + attributePath);
/* 101 */       List keywordListTemp = FileUtil.readLine2List(basePath + 
/* 102 */         keywordsPath);
/* 103 */       List nodeList = FileUtil.readLine2List(basePath + nodePath);
/* 104 */       List keywordsListForName = FileUtil.readLine2List(basePath + 
/* 105 */         namekeyPath);
/* 106 */       List sizeList = FileUtil.readLine2List(basePath + sizePath);
/* 107 */       this.otherInfo = new Properties();
/* 108 */       this.coldef = new Properties();
/* 109 */       this.goodColumns = new Properties();
/* 110 */       this.otherInfo.load(new InputStreamReader(new FileInputStream(
/* 111 */         otherInfoPath), "UTF-8"));
/* 112 */       this.coldef.load(new InputStreamReader(new FileInputStream(coldefPath), 
/* 113 */         "UTF-8"));
/* 114 */       this.goodColumns.load(new InputStreamReader(new FileInputStream(
/* 115 */         goodColumnsPath), "UTF-8"));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 120 */       String[] brand = ((String)brandList.get(0)).split(" ");
/* 121 */       String brand_CN = "";
/* 122 */       String brand_EN = "";
/* 123 */       if (brand.length == 3) {
/* 124 */         brand_CN = brand[0];
/* 125 */         brand_EN = brand[1];
/* 126 */         this.GOODTYPE = brand[2];
/*     */       }
/*     */       else {
/*     */         for (;;) {
/* 130 */           System.err.println("商品品牌配置文件错误，正确格式为【中文名称+空格+英文名称+空格+商品类型】");
/* 131 */           System.err.println("请修改配置文件后，重新运行本程序。谢谢。");
/* 132 */           Scanner reader = new Scanner(System.in);
/* 133 */           if (reader.hasNext()) {
/* 134 */             System.exit(-1);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 140 */       Map colorURLMap = initColorURLMap(colorListTemp);
/* 141 */       List color_name_list = (List)colorURLMap.get("color_name_list");
/* 142 */       this.list = new ArrayList();
/* 143 */       String variation_theme = null;
/* 144 */       if (OptionType == 1) {
/* 145 */         variation_theme = "颜色";
/* 146 */       } else if (OptionType == 2) {
/* 147 */         variation_theme = "尺寸名称";
/* 148 */       } else if (OptionType == 3) {
/* 149 */         variation_theme = "尺寸和颜色";
/*     */       }
/* 151 */       for (int x = 0; x < carTypeList.size(); x++) {
/* 152 */         Good goodParent = new Good();
/* 153 */         goodParent.setBrand_CN(brand_CN);
/* 154 */         goodParent.setBrand_EN(brand_EN);
/* 155 */         String carType = (String)carTypeList.get(x);
/* 156 */         String[] compatible_with_vehicle_types = null;
/* 157 */         if (carType != null) {
/* 158 */           compatible_with_vehicle_types = carType.split(" ");
/*     */         }
/* 160 */         String parentName = getGoodName(goodParent.getBrand_CN(), 
/* 161 */           carType, keywordsListForName);
/*     */         
/* 163 */         goodParent.setName(parentName);
/* 164 */         goodParent.setVariation_theme(variation_theme);
/* 165 */         int v1 = x % color_name_list.size();
/* 166 */         goodParent.setColor_url(
/* 167 */           (ColorURL)colorURLMap.get((String)color_name_list.get(v1) + "_url"));
/*     */         
/* 169 */         String parentSKU = goodParent.getBrand_EN() + "_" + this.GOODTYPE + 
/* 170 */           "_N" + (x + 1);
/* 171 */         goodParent.setSKU(parentSKU);
/* 172 */         if (IsOption) {
/* 173 */           goodParent.setParentFlag(true);
/*     */         } else {
/* 175 */           goodParent.setParentFlag(false);
/*     */         }
/*     */         
/* 178 */         this.desc = ((String)descList.get(0));
/* 179 */         String node = getNode(nodeList);
/* 180 */         goodParent.setNode(node);
/*     */         
/* 182 */         goodParent
/* 183 */           .setKeyword1(getKeyword(carTypeList, keywordListTemp));
/* 184 */         goodParent
/* 185 */           .setKeyword2(getKeyword(carTypeList, keywordListTemp));
/* 186 */         goodParent
/* 187 */           .setKeyword3(getKeyword(carTypeList, keywordListTemp));
/* 188 */         goodParent
/* 189 */           .setKeyword4(getKeyword(carTypeList, keywordListTemp));
/* 190 */         goodParent
/* 191 */           .setKeyword5(getKeyword(carTypeList, keywordListTemp));
/*     */         
/* 193 */         goodParent.setKeyCompatible_with_vehicle_types(compatible_with_vehicle_types);
/*     */         
/* 195 */         this.list.add(goodParent);
/* 196 */         if (IsOption) {
/* 197 */           int colorNumber = 1;
/* 198 */           int sizeNumber = 1;
/*     */           
/* 200 */           if (OptionType == 1)
/*     */           {
/* 202 */             colorNumber = color_name_list.size();
/* 203 */           } else if (OptionType == 2)
/*     */           {
/* 205 */             sizeNumber = sizeList.size();
/* 206 */           } else if (OptionType == 3)
/*     */           {
/* 208 */             colorNumber = color_name_list.size();
/* 209 */             sizeNumber = sizeList.size();
/*     */           }
/*     */           
/* 212 */           for (int p = 0; p < colorNumber; p++) {
/* 213 */             String color = (String)color_name_list.get(p);
/* 214 */             for (int u = 0; u < sizeNumber; u++) {
/* 215 */               String[] sizeStringArray = 
/* 216 */                 ((String)sizeList.get(u)).split(";");
/* 217 */               String sizeDef = sizeStringArray[0];
/* 218 */               String sizeName = sizeStringArray[1];
/* 219 */               String sizeFlag = sizeStringArray[2];
/* 220 */               Good good = new Good();
/* 221 */               good.setBrand_CN(brand_CN);
/* 222 */               good.setBrand_EN(brand_EN);
/* 223 */               good.setColor_EN(color);
/* 224 */               good.setColor_url((ColorURL)colorURLMap.get(color + 
/* 225 */                 "_url"));
/* 226 */               Color colorObj = (Color)colorURLMap.get(color + 
/* 227 */                 "_color");
/*     */               
/* 229 */               String SKU = generateSKUByOptionType(
/* 230 */                 good.getBrand_EN(), this.GOODTYPE, 
/* 231 */                 good.getColor_EN(), Integer.toString( x + 1), 
/* 232 */                 OptionType, sizeFlag);
/* 233 */               good.setSKU(SKU);
/* 234 */               good.setParentFlag(false);
/* 235 */               good.setParentSKU(parentSKU);
/*     */               
/* 237 */               String name = genGoodNameByOptionType(OptionType, 
/* 238 */                 colorObj.getColor_CN(), sizeName, 
/* 239 */                 parentName);
/* 240 */               good.setName(name);
/*     */               
/* 242 */               node = getNode(nodeList);
/* 243 */               good.setNode(node);
/* 244 */               if (OptionType != 1) {
/* 245 */                 good.setSize_name(sizeDef);
/* 246 */                 good.setSize_map(sizeName);
/*     */               }
/* 248 */               if (OptionType != 2) {
/* 249 */                 good.setColor_CN(colorObj.getColor_CN());
/* 250 */                 good.setColor_map(colorObj.getColor_map());
/*     */               }
/* 252 */               good.setVariation_theme(variation_theme);
/* 253 */               good.setKeyword1(getKeyword(carTypeList, 
/* 254 */                 keywordListTemp));
/* 255 */               good.setKeyword2(getKeyword(carTypeList, 
/* 256 */                 keywordListTemp));
/* 257 */               good.setKeyword3(getKeyword(carTypeList, 
/* 258 */                 keywordListTemp));
/* 259 */               good.setKeyword4(getKeyword(carTypeList, 
/* 260 */                 keywordListTemp));
/* 261 */               good.setKeyword5(getKeyword(carTypeList, 
/* 262 */                 keywordListTemp));
/*     */               
/* 264 */               good.setKeyCompatible_with_vehicle_types(compatible_with_vehicle_types);
/* 265 */               this.list.add(good);
/*     */             }
/*     */             
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 275 */       e.printStackTrace();
/* 276 */       System.err.println(e.getLocalizedMessage());
/*     */     }
/*     */     catch (FileException e) {
/* 279 */       e.printStackTrace();
/* 280 */       System.err.println(e.getLocalizedMessage());
/*     */     }
/*     */   }
/*     */   
/*     */   public List getList()
/*     */   {
/* 286 */     return this.list;
/*     */   }
/*     */   
/*     */   public void setList(List list) {
/* 290 */     this.list = list;
/*     */   }
/*     */   
/*     */   private String generateSKUByOptionType(String brand_EN, String goodType, String color, String index, int OptionType, String sizeFlag)
/*     */   {
/* 295 */     String SKU = null;
/* 296 */     if (OptionType == 1)
/*     */     {
/* 298 */       SKU = brand_EN + "_" + goodType + "_N" + index + "_" + color;
/* 299 */     } else if (OptionType == 2)
/*     */     {
/* 301 */       SKU = brand_EN + "_" + goodType + "_N" + index + "_" + sizeFlag;
/* 302 */     } else if (OptionType == 3)
/*     */     {
/* 304 */       SKU = 
/* 305 */         brand_EN + "_" + goodType + "_N" + index + "_" + color + "_" + sizeFlag;
/*     */     }
/* 307 */     return SKU;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private String generateSKUByOptionType(String brand_EN, String goodType, String index)
/*     */   {
/* 314 */     return brand_EN + "_" + goodType + "_N" + index;
/*     */   }
/*     */   
/*     */   private Map initColorURLMap(List colorListTemp)
/*     */   {
/* 319 */     List other_url_list = new ArrayList();
/* 320 */     List color_name_list = new ArrayList();
/* 321 */     Map colorUrlMap = new HashMap();
/* 322 */     Map colorMap = new HashMap();
/* 323 */     Map URLMap = new HashMap();
/* 324 */     ColorURL url = new ColorURL();
/* 325 */     List color_img_list = new ArrayList();
/* 326 */     String color_flag = "";
/* 327 */     for (int d = 0; d < colorListTemp.size(); d++) {
/* 328 */       String tempLine = (String)colorListTemp.get(d);
/*     */       
/* 330 */       if (tempLine.contains("^^")) {
/* 331 */         String[] line = tempLine.substring(tempLine.indexOf("^^") + 2)
/* 332 */           .split(" ");
/* 333 */         Color color = new Color();
/* 334 */         color.setColor_CN(line[0]);
/* 335 */         color.setColor_EN(line[1]);
/* 336 */         color.setColor_map(line[2]);
/* 337 */         color_img_list = new ArrayList();
/* 338 */         color_flag = line[1];
/* 339 */         colorUrlMap.put(color_flag + "_color", color);
/* 340 */         color_name_list.add(line[1]);
/* 341 */         url = new ColorURL();
/*     */       }
/*     */       else {
/* 344 */         if (tempLine.contains("@other@")) {
/* 345 */           other_url_list.add(tempLine.substring(tempLine
/* 346 */             .indexOf("@other@") + 7));
/* 347 */         } else if (tempLine.contains("@main@")) {
/* 348 */           String img = tempLine
/* 349 */             .substring(tempLine.indexOf("@main@") + 6);
/* 350 */           url.setMain_image_url(img);
/* 351 */           url.setSwatch_image_url(img);
/* 352 */         } else if (tempLine.contains("@color@")) {
/* 353 */           color_img_list.add(tempLine.substring(tempLine
/* 354 */             .indexOf("@color@") + 7));
/*     */         }
/* 356 */         url.setOther_image_url(other_url_list);
/* 357 */         url.setColor_image_url(color_img_list);
/* 358 */         colorUrlMap.put(color_flag + "_url", url);
/*     */       }
/*     */     }
/*     */     
/* 362 */     colorUrlMap.put("color_name_list", color_name_list);
/* 363 */     return colorUrlMap;
/*     */   }
/*     */   
/*     */   private String getNode(List nodeList) {
/* 367 */     return (String)nodeList.get(new Random().nextInt(nodeList.size()));
/*     */   }
/*     */   
/*     */   private String getKeyword(List carList, List keyList) {
/* 371 */     return 
/* 372 */       getWordsWithlength(carList, 29) + " " + getWordsWithlength(keyList, 69);
/*     */   }
/*     */   
/*     */   private String getName(String brand, String cartype, List keyList) {
/* 376 */     String namePre = brand + " " + cartype + " ";
/* 377 */     return namePre + getWordsWithlength(keyList, 100 - namePre.length());
/*     */   }
/*     */   
/*     */   private String getGoodName(String brand, String cartype, List keyList) {
/* 381 */     String namePre = brand + " " + cartype + " ";
/* 382 */     return namePre + 
/* 383 */       getKeywordsForGoodName(keyList, 100 - namePre.length());
/*     */   }
/*     */   
/*     */   private String getKeywordsForGoodName(List list, int len)
/*     */   {
/* 388 */     return (String)list.get(new Random().nextInt(list.size()));
/*     */   }
/*     */   
/*     */   private String getWordsWithlength(List list, int len)
/*     */   {
/* 393 */     String name = "";
/* 394 */     int no = 0;
/* 395 */     while (no < list.size()) {
/* 396 */       no++;
/*     */       
/* 398 */       String nameTemp = (String)list.get(new Random().nextInt(list
/* 399 */         .size()));
/* 400 */       String stemp = name + " " + nameTemp;
/*     */       
/* 402 */       if ((stemp.length() > len) && (name.length() <= len)) {
/*     */         break;
/*     */       }
/* 405 */       if (name.length() > 0) {
/* 406 */         name = stemp;
/*     */       } else {
/* 408 */         name = nameTemp;
/*     */       }
/*     */     }
/*     */     
/* 412 */     return name;
/*     */   }
/*     */   
/*     */   private Map castColdefFile2Map(Properties coldef) {
/* 416 */     Map map = new HashMap();
/*     */     
/* 418 */     int length = coldef.keySet().size();
/* 419 */     String[] coldef4Chinese = new String[length];
/* 420 */     String[] coldef4English = new String[length];
/* 421 */     Set keys = coldef.keySet();
/* 422 */     for (Object key : keys) {
/* 423 */       String keyOfEnglish = (String)key;
/* 424 */       String[] value = coldef.getProperty(keyOfEnglish).split(";");
/* 425 */       int index = Integer.parseInt(value[0]);
/* 426 */       String valueOfChinese = value[1];
/* 427 */       coldef4Chinese[index] = valueOfChinese;
/* 428 */       coldef4English[index] = keyOfEnglish;
/*     */     }
/*     */     
/* 431 */     map.put("chinese", coldef4Chinese);
/* 432 */     map.put("english", coldef4English);
/* 433 */     return map;
/*     */   }
/*     */   
/*     */   public Map getColDefMap()
/*     */   {
/* 438 */     return castColdefFile2Map(this.coldef);
/*     */   }
/*     */   
/*     */   public Properties getGoodColumns() {
/* 442 */     return this.goodColumns;
/*     */   }
/*     */   
/*     */   public Properties getColdef() {
/* 446 */     return this.coldef;
/*     */   }
/*     */   
/*     */   private String genGoodNameByOptionType(int OptionType, String color_CN, String sizeName, String parentName)
/*     */   {
/* 451 */     String name = null;
/* 452 */     if (OptionType == 1)
/*     */     {
/* 454 */       name = parentName + "(" + color_CN + ")";
/* 455 */     } else if (OptionType == 2)
/*     */     {
/* 457 */       name = parentName + "(" + sizeName + ")";
/* 458 */     } else if (OptionType == 3)
/*     */     {
/* 460 */       name = parentName + "(" + color_CN + "，" + sizeName + ")";
/*     */     }
/* 462 */     return name;
/*     */   }
/*     */ }


/* Location:              /Volumes/SanDisk/workspace/AutoGen/AutoGen 坐垫/GenExcel.jar!/net/ytin/axft/InitFromConfigFiles.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */