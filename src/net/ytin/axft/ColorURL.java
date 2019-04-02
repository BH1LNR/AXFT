/*    */ package net.ytin.axft;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ColorURL
/*    */ {
/*    */   private String main_image_url;
/*    */   private List color_image_url;
/*    */   private String swatch_image_url;
/*    */   private List other_image_url;
/*    */   
/*    */   public String getMain_image_url()
/*    */   {
/* 18 */     return this.main_image_url;
/*    */   }
/*    */   
/*    */   public void setMain_image_url(String main_image_url) {
/* 22 */     this.main_image_url = main_image_url;
/*    */   }
/*    */   
/*    */   public List getColor_image_url() {
/* 26 */     return this.color_image_url;
/*    */   }
/*    */   
/*    */   public void setColor_image_url(List color_image_url) {
/* 30 */     this.color_image_url = color_image_url;
/*    */   }
/*    */   
/*    */   public String getSwatch_image_url() {
/* 34 */     return this.swatch_image_url;
/*    */   }
/*    */   
/*    */   public void setSwatch_image_url(String swatch_image_url) {
/* 38 */     this.swatch_image_url = swatch_image_url;
/*    */   }
/*    */   
/*    */   public List getOther_image_url() {
/* 42 */     return this.other_image_url;
/*    */   }
/*    */   
/*    */   public void setOther_image_url(List other_image_url) {
/* 46 */     this.other_image_url = other_image_url;
/*    */   }
/*    */   
/*    */   public String toString1() {
/* 50 */     return 
/*    */     
/*    */ 
/* 53 */       "ColorURL [main_image_url=" + this.main_image_url + ", color_image_url=" + this.color_image_url + ", swatch_image_url=" + this.swatch_image_url + ", other_image_url=" + this.other_image_url + "]";
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     return "ColorURL [main_image_url=" + this.main_image_url;
/*    */   }
/*    */ }


/* Location:              /Volumes/SanDisk/workspace/AutoGen/AutoGen 坐垫/GenExcel.jar!/net/ytin/axft/ColorURL.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */