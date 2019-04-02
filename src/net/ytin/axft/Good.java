/*     */ package net.ytin.axft;
/*     */ 
/*     */ public class Good {
/*     */   private String SKU;
/*     */   private String Name;
/*     */   private String parentSKU;
/*     */   private String brand_CN;
/*     */   private String brand_EN;
/*     */   private String color_EN;
/*     */   private ColorURL color_url;
/*     */   
/*     */   public String getColor_CN() {
/*  13 */     return this.color_CN;
/*     */   }
/*     */   
/*     */   public void setColor_CN(String color_CN) {
/*  17 */     this.color_CN = color_CN;
/*     */   }
/*     */   
/*     */   public String getColor_map() {
/*  21 */     return this.color_map;
/*     */   }
/*     */   
/*     */   public void setColor_map(String color_map) {
/*  25 */     this.color_map = color_map;
/*     */   }
/*     */   
/*     */ 
/*     */   private String color_CN;
/*     */   private String color_map;
/*     */   private boolean parentFlag;
/*     */   private String node;
/*     */   private String size_name;
/*     */   private String size_map;
/*     */   private String variation_theme;
/*     */   private String keyword;



/*     */ 
/*     */ 
/*     */   public String getSKU()
/*     */   {
/*  93 */     return this.SKU;
/*     */   }
/*     */   
/*     */   public void setSKU(String sKU) {
/*  97 */     this.SKU = sKU;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 101 */     return this.Name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 105 */     this.Name = name;
/*     */   }
/*     */   
/*     */   public String getParentSKU() {
/* 109 */     return this.parentSKU;
/*     */   }
/*     */   
/*     */   public void setParentSKU(String parentSKU) {
/* 113 */     this.parentSKU = parentSKU;
/*     */   }
/*     */   
/*     */   public String getBrand_CN() {
/* 117 */     return this.brand_CN;
/*     */   }
/*     */   
/*     */   public void setBrand_CN(String brand_CN) {
/* 121 */     this.brand_CN = brand_CN;
/*     */   }
/*     */   
/*     */   public String getBrand_EN() {
/* 125 */     return this.brand_EN;
/*     */   }
/*     */   
/*     */   public void setBrand_EN(String brand_EN) {
/* 129 */     this.brand_EN = brand_EN;
/*     */   }
/*     */   
/*     */   public String getNode() {
/* 133 */     return this.node;
/*     */   }
/*     */   
/*     */   public void setNode(String node1) {
/* 137 */     this.node = this.node;
/*     */   }
/*     */   
/*     */   public String getColor_EN() {
/* 141 */     return this.color_EN;
/*     */   }
/*     */   
/*     */   public void setColor_EN(String color_EN) {
/* 145 */     this.color_EN = color_EN;
/*     */   }
/*     */   
/*     */   public ColorURL getColor_url() {
/* 149 */     return this.color_url;
/*     */   }
/*     */   
/*     */   public void setColor_url(ColorURL color_url) {
/* 153 */     this.color_url = color_url;
/*     */   }
/*     */   
/*     */   public boolean isParentFlag()
/*     */   {
/* 158 */     return this.parentFlag;
/*     */   }
/*     */   
/*     */   public void setParentFlag(boolean parentFlag) {
/* 162 */     this.parentFlag = parentFlag;
/*     */   }
/*     */   
/*     */   public String getKeyword() {
/* 166 */     return this.keyword;
/*     */   }
/*     */   
/*     */   public void setKeyword(String keyword) {
/* 170 */     this.keyword = keyword;
/*     */   }
/*     */   

/*     */ 

/*     */   public String getSize_name() {
/* 239 */     return this.size_name;
/*     */   }
/*     */   
/*     */   public void setSize_name(String size_name) {
/* 243 */     this.size_name = size_name;
/*     */   }
/*     */   
/*     */   public String getSize_map() {
/* 247 */     return this.size_map;
/*     */   }
/*     */   
/*     */   public void setSize_map(String size_map) {
/* 251 */     this.size_map = size_map;
/*     */   }
/*     */   
/*     */   public String getVariation_theme() {
/* 255 */     return this.variation_theme;
/*     */   }
/*     */   
/*     */   public void setVariation_theme(String variation_theme) {
/* 259 */     this.variation_theme = variation_theme;
/*     */   }
/*     */ }


/* Location:              /Volumes/SanDisk/workspace/AutoGen/AutoGen 坐垫/GenExcel.jar!/net/ytin/axft/Good.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */