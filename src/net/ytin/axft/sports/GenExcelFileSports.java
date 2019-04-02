/*     */ package net.ytin.axft.sports;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import jxl.Workbook;
/*     */ import jxl.write.Label;
/*     */ import jxl.write.WritableSheet;
/*     */ import jxl.write.WritableWorkbook;
/*     */ import jxl.write.WriteException;
/*     */ import jxl.write.biff.RowsExceededException;
/*     */ 
/*     */ public class GenExcelFileSports
/*     */ {
/*  16 */   private String filename_excel = "";
/*  17 */   private String shortFileName = "";
/*     */   
/*     */   public String getFilename() {
/*  20 */     return this.filename_excel;
/*     */   }
/*     */   
/*     */   public String getShortFileName() {
/*  24 */     return this.shortFileName;
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/*  28 */     new GenExcelFileSports();
/*     */   }
/*     */   
/*     */   public GenExcelFileSports() {
/*  32 */     String basePath = ".\\";
/*     */     
/*  34 */     Date date = new Date(System.currentTimeMillis());
/*  35 */     SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
/*  36 */     this.shortFileName = ("Sports_" + df.format(date) + ".xls");
/*  37 */     this.filename_excel = (basePath + this.shortFileName);
/*     */     
/*  39 */     generateNewExcelFile();
/*     */   }
/*     */   
/*     */   private void copyFromExampleFile()
/*     */   {
/*     */     try
/*     */     {
/*  46 */       String exampleFileName = "Example.xls";
/*     */       
/*  48 */       Workbook wb = Workbook.getWorkbook(new File(exampleFileName));
/*     */       
/*  50 */       WritableWorkbook book = Workbook.createWorkbook(new File(
/*  51 */         this.filename_excel), wb);
/*     */       
/*  53 */       WritableSheet sheet = book.getSheet(0);
/*  54 */       book.write();
/*  55 */       book.close();
/*     */     } catch (Exception e) {
/*  57 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   private void generateNewExcelFile()
/*     */   {
/*     */     try
/*     */     {
/*  65 */       WritableWorkbook book = 
/*  66 */         Workbook.createWorkbook(new FileOutputStream(new File(
/*  67 */         this.filename_excel)));
/*     */       
/*  69 */       WritableSheet sheet = book.createSheet("自动生成", 0);
/*     */       
/*  71 */       sheet.addCell(new Label(0, 0, "以下内容为软件自动生成，请复制到Amazon模板文件中进行验证。"));
/*  72 */       addTitleRowChinese(sheet);
/*  73 */       addTitleRowEnglish(sheet);
/*     */       
/*     */ 
/*  76 */       book.write();
/*  77 */       book.close();
/*     */     }
/*     */     catch (Exception e) {
/*  80 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   private void addTitleRowChinese(WritableSheet sheet)
/*     */     throws RowsExceededException, WriteException
/*     */   {
/*  87 */     int row = 1;
/*  88 */     sheet.addCell(new Label(0, row, "SKU"));
/*  89 */     sheet.addCell(new Label(1, row, "商品编码"));
/*  90 */     sheet.addCell(new Label(2, row, "商品编码类型"));
/*  91 */     sheet.addCell(new Label(3, row, "商品名称"));
/*  92 */     sheet.addCell(new Label(4, row, "品牌"));
/*  93 */     sheet.addCell(new Label(5, row, "制造商"));
/*  94 */     sheet.addCell(new Label(6, row, "描述"));
/*  95 */     sheet.addCell(new Label(7, row, "商品类型"));
/*  96 */     sheet.addCell(new Label(8, row, "制造商零件编号"));
/*  97 */     sheet.addCell(new Label(9, row, "更新-删除"));
/*  98 */     sheet.addCell(new Label(10, row, "商品价格"));
/*  99 */     sheet.addCell(new Label(11, row, "货币"));
/* 100 */     sheet.addCell(new Label(12, row, "库存数量"));
/* 101 */     sheet.addCell(new Label(13, row, "新旧程度"));
/* 102 */     sheet.addCell(new Label(14, row, "新旧程度说明"));
/* 103 */     sheet.addCell(new Label(15, row, "单笔订单最大数量"));
/* 104 */     sheet.addCell(new Label(16, row, "其它付款方式"));
/* 105 */     sheet.addCell(new Label(17, row, "限时折扣价"));
/* 106 */     sheet.addCell(new Label(18, row, "限时折扣价开始日期"));
/* 107 */     sheet.addCell(new Label(19, row, "限时折扣价结束日期"));
/* 108 */     sheet.addCell(new Label(20, row, "折扣优惠名称1"));
/* 109 */     sheet.addCell(new Label(21, row, "折扣优惠名称2"));
/* 110 */     sheet.addCell(new Label(22, row, "折扣优惠信息1 - 折扣优惠信息21"));
/* 111 */     sheet.addCell(new Label(23, row, "折扣优惠信息1 - 折扣优惠信息22"));
/* 112 */     sheet.addCell(new Label(24, row, "折扣优惠开始日期1"));
/* 113 */     sheet.addCell(new Label(25, row, "折扣优惠开始日期2"));
/* 114 */     sheet.addCell(new Label(26, row, "折扣优惠截止日期1 - 折扣优惠截止日期21"));
/* 115 */     sheet.addCell(new Label(27, row, "折扣优惠截止日期1 - 折扣优惠截止日期22"));
/* 116 */     sheet.addCell(new Label(28, row, "产品包装数量"));
/* 117 */     sheet.addCell(new Label(29, row, "商品税费代码"));
/* 118 */     sheet.addCell(new Label(30, row, "发布日期"));
/* 119 */     sheet.addCell(new Label(31, row, "发售日期"));
/* 120 */     sheet.addCell(new Label(32, row, "配送准备时间"));
/* 121 */     sheet.addCell(new Label(33, row, "补货日期"));
/* 122 */     sheet.addCell(new Label(34, row, "合并发货最大数量"));
/* 123 */     sheet.addCell(new Label(35, row, "可否提供礼品信息"));
/* 124 */     sheet.addCell(new Label(36, row, "可否提供礼品包装"));
/* 125 */     sheet.addCell(new Label(37, row, "是否已停产"));
/* 126 */     sheet.addCell(new Label(38, row, "注册参数"));
/* 127 */     sheet.addCell(new Label(39, row, "配送模板"));
/* 128 */     sheet.addCell(new Label(40, row, "直径"));
/* 129 */     sheet.addCell(new Label(41, row, "直径度量单位"));
/* 130 */     sheet.addCell(new Label(42, row, "商品高度"));
/* 131 */     sheet.addCell(new Label(43, row, "高度度量单位"));
/* 132 */     sheet.addCell(new Label(44, row, "容量"));
/* 133 */     sheet.addCell(new Label(45, row, "商品宽度"));
/* 134 */     sheet.addCell(new Label(46, row, "宽度计量单位"));
/* 135 */     sheet.addCell(new Label(47, row, "发货重量"));
/* 136 */     sheet.addCell(new Label(48, row, "商品重量（带包装）计量单位"));
/* 137 */     sheet.addCell(new Label(49, row, "商品长度"));
/* 138 */     sheet.addCell(new Label(50, row, "商品宽度"));
/* 139 */     sheet.addCell(new Label(51, row, "商品高度"));
/* 140 */     sheet.addCell(new Label(52, row, "商品长度计量单位"));
/* 141 */     sheet.addCell(new Label(53, row, "商品重量"));
/* 142 */     sheet.addCell(new Label(54, row, "商品重量计量单位"));
/* 143 */     sheet.addCell(new Label(55, row, "净重"));
/* 144 */     sheet.addCell(new Label(56, row, "净重计量单位"));
/* 145 */     sheet.addCell(new Label(57, row, "容量"));
/* 146 */     sheet.addCell(new Label(58, row, "容量计量单位"));
/* 147 */     sheet.addCell(new Label(59, row, "长度"));
/* 148 */     sheet.addCell(new Label(60, row, "长度计量单位"));
/* 149 */     sheet.addCell(new Label(61, row, "适用人群1"));
/* 150 */     sheet.addCell(new Label(62, row, "适用人群2"));
/* 151 */     sheet.addCell(new Label(63, row, "适用人群3"));
/* 152 */     sheet.addCell(new Label(64, row, "商品特性1"));
/* 153 */     sheet.addCell(new Label(65, row, "商品特性2"));
/* 154 */     sheet.addCell(new Label(66, row, "商品特性3"));
/* 155 */     sheet.addCell(new Label(67, row, "商品特性4"));
/* 156 */     sheet.addCell(new Label(68, row, "商品特性5"));
/* 157 */     sheet.addCell(new Label(69, row, "推荐分类节点1"));
/* 158 */     sheet.addCell(new Label(70, row, "推荐分类节点2"));
/* 159 */     sheet.addCell(new Label(71, row, "搜索关键词1"));
/* 160 */     sheet.addCell(new Label(72, row, "搜索关键词2"));
/* 161 */     sheet.addCell(new Label(73, row, "搜索关键词3"));
/* 162 */     sheet.addCell(new Label(74, row, "搜索关键词4"));
/* 163 */     sheet.addCell(new Label(75, row, "搜索关键词5"));
/* 164 */     sheet.addCell(new Label(76, row, "白金关键字1"));
/* 165 */     sheet.addCell(new Label(77, row, "白金关键字2"));
/* 166 */     sheet.addCell(new Label(78, row, "白金关键字3"));
/* 167 */     sheet.addCell(new Label(79, row, "白金关键字4"));
/* 168 */     sheet.addCell(new Label(80, row, "白金关键字5"));
/* 169 */     sheet.addCell(new Label(81, row, "主图片 URL"));
/* 170 */     sheet.addCell(new Label(82, row, "其他图片 URL1"));
/* 171 */     sheet.addCell(new Label(83, row, "其他图片 URL2"));
/* 172 */     sheet.addCell(new Label(84, row, "其他图片 URL3"));
/* 173 */     sheet.addCell(new Label(85, row, "其他图片 URL4"));
/* 174 */     sheet.addCell(new Label(86, row, "其他图片 URL5"));
/* 175 */     sheet.addCell(new Label(87, row, "其他图片 URL6"));
/* 176 */     sheet.addCell(new Label(88, row, "其他图片 URL7"));
/* 177 */     sheet.addCell(new Label(89, row, "其他图片 URL8"));
/* 178 */     sheet.addCell(new Label(90, row, "样本图片 URL"));
/* 179 */     sheet.addCell(new Label(91, row, "运营中心编号"));
/* 180 */     sheet.addCell(new Label(92, row, "包裹高度"));
/* 181 */     sheet.addCell(new Label(93, row, "包裹宽度"));
/* 182 */     sheet.addCell(new Label(94, row, "包裹长度"));
/* 183 */     sheet.addCell(new Label(95, row, "包装长度计量单位"));
/* 184 */     sheet.addCell(new Label(96, row, "包裹重量"));
/* 185 */     sheet.addCell(new Label(97, row, "包装重量计量单位"));
/* 186 */     sheet.addCell(new Label(98, row, "父子关系"));
/* 187 */     sheet.addCell(new Label(99, row, "父 SKU"));
/* 188 */     sheet.addCell(new Label(100, row, "关系类型"));
/* 189 */     sheet.addCell(new Label(101, row, "商品变体主题"));
/* 190 */     sheet.addCell(new Label(102, row, "生产地区"));
/* 191 */     sheet.addCell(new Label(103, row, "原产国"));
/* 192 */     sheet.addCell(new Label(104, row, "法律声明"));
/* 193 */     sheet.addCell(new Label(105, row, "警告"));
/* 194 */     sheet.addCell(new Label(106, row, "液体含量"));
/* 195 */     sheet.addCell(new Label(107, row, "液体体积计量单位"));
/* 196 */     sheet.addCell(new Label(108, row, "适用性别"));
/* 197 */     sheet.addCell(new Label(109, row, "颜色"));
/* 198 */     sheet.addCell(new Label(110, row, "尺寸名称"));
/* 199 */     sheet.addCell(new Label(111, row, "年龄性别分类"));
/* 200 */     sheet.addCell(new Label(112, row, "电流强度"));
/* 201 */     sheet.addCell(new Label(113, row, "电流量计量单位"));
/* 202 */     sheet.addCell(new Label(114, row, "是否亲笔签名"));
/* 203 */     sheet.addCell(new Label(115, row, "自行车轮辋尺寸"));
/* 204 */     sheet.addCell(new Label(116, row, "轮辋尺寸计量单位"));
/* 205 */     sheet.addCell(new Label(117, row, "靴子尺寸"));
/* 206 */     sheet.addCell(new Label(118, row, "靴筒尺寸"));
/* 207 */     sheet.addCell(new Label(119, row, "口径"));
/* 208 */     sheet.addCell(new Label(120, row, "容量"));
/* 209 */     sheet.addCell(new Label(121, row, "容量计量单位"));
/* 210 */     sheet.addCell(new Label(122, row, "注意事项"));
/* 211 */     sheet.addCell(new Label(123, row, "弯曲度"));
/* 212 */     sheet.addCell(new Label(124, row, "图案"));
/* 213 */     sheet.addCell(new Label(125, row, "使用说明"));
/* 214 */     sheet.addCell(new Label(126, row, "潜水帽厚度"));
/* 215 */     sheet.addCell(new Label(127, row, "击剑剑柄类型"));
/* 216 */     sheet.addCell(new Label(128, row, "味道"));
/* 217 */     sheet.addCell(new Label(129, row, "高尔夫球杆弹性"));
/* 218 */     sheet.addCell(new Label(130, row, "高尔夫球杆杆面倾角"));
/* 219 */     sheet.addCell(new Label(131, row, "握把尺寸"));
/* 220 */     sheet.addCell(new Label(132, row, "握把类型"));
/* 221 */     sheet.addCell(new Label(133, row, "手握"));
/* 222 */     sheet.addCell(new Label(134, row, "拍面尺寸"));
/* 223 */     sheet.addCell(new Label(135, row, "商品厚度"));
/* 224 */     sheet.addCell(new Label(136, row, "商品厚度计量单位"));
/* 225 */     sheet.addCell(new Label(137, row, "镜片颜色"));
/* 226 */     sheet.addCell(new Label(138, row, "线重量"));
/* 227 */     sheet.addCell(new Label(139, row, "材质类型"));
/* 228 */     sheet.addCell(new Label(140, row, "纪念品"));
/* 229 */     sheet.addCell(new Label(141, row, "等级"));
/* 230 */     sheet.addCell(new Label(142, row, "圈数"));
/* 231 */     sheet.addCell(new Label(143, row, "钓竿长度"));
/* 232 */     sheet.addCell(new Label(144, row, "轴长度计量单位"));
/* 233 */     sheet.addCell(new Label(145, row, "杆身材料"));
/* 234 */     sheet.addCell(new Label(146, row, "握把类型"));
/* 235 */     sheet.addCell(new Label(147, row, "商品形状"));
/* 236 */     sheet.addCell(new Label(148, row, "尺寸"));
/* 237 */     sheet.addCell(new Label(149, row, "产品款式"));
/* 238 */     sheet.addCell(new Label(150, row, "工作温度"));
/* 239 */     sheet.addCell(new Label(151, row, "额定温度度数计量单位"));
/* 240 */     sheet.addCell(new Label(152, row, "张力值"));
/* 241 */     sheet.addCell(new Label(153, row, "商品瓦数"));
/* 242 */     sheet.addCell(new Label(154, row, "推荐支撑重量"));
/* 243 */     sheet.addCell(new Label(155, row, "推荐支撑重量单位"));
/* 244 */     sheet.addCell(new Label(156, row, "车轮尺寸"));
/* 245 */     sheet.addCell(new Label(157, row, "轮胎尺寸计量单位"));
/* 246 */     sheet.addCell(new Label(158, row, "电源类型"));
/* 247 */     sheet.addCell(new Label(159, row, "电池类型1"));
/* 248 */     sheet.addCell(new Label(160, row, "电池类型2"));
/* 249 */     sheet.addCell(new Label(161, row, "电池类型3"));
/* 250 */     sheet.addCell(new Label(162, row, "电池数量1"));
/* 251 */     sheet.addCell(new Label(163, row, "电池数量2"));
/* 252 */     sheet.addCell(new Label(164, row, "电池数量3"));
/* 253 */     sheet.addCell(new Label(165, row, "电池平均寿命"));
/* 254 */     sheet.addCell(new Label(166, row, "待机时间"));
/* 255 */     sheet.addCell(new Label(167, row, "充电时间"));
/* 256 */     sheet.addCell(new Label(168, row, "锂电池容量"));
/* 257 */     sheet.addCell(new Label(169, row, "电池包装类型"));
/* 258 */     sheet.addCell(new Label(170, row, "电压"));
/* 259 */     sheet.addCell(new Label(171, row, "锂的含量"));
/* 260 */     sheet.addCell(new Label(172, row, "是否附带电池"));
/* 261 */     sheet.addCell(new Label(173, row, "是否需要电池"));
/* 262 */     sheet.addCell(new Label(174, row, "锂离子电池单元数量"));
/* 263 */     sheet.addCell(new Label(175, row, "锂金属电池单元数量"));
/* 264 */     sheet.addCell(new Label(176, row, "产品保修类型"));
/* 265 */     sheet.addCell(new Label(177, row, "维修维护描述"));
/* 266 */     sheet.addCell(new Label(178, row, "零部件更换描述"));
/* 267 */     sheet.addCell(new Label(179, row, "卖家保修描述"));
/* 268 */     sheet.addCell(new Label(180, row, "色卡"));
/*     */   }
/*     */   
/*     */   private void addTitleRowEnglish(WritableSheet sheet)
/*     */     throws RowsExceededException, WriteException
/*     */   {
/* 274 */     int row = 2;
/* 275 */     sheet.addCell(new Label(0, row, "item_sku"));
/* 276 */     sheet.addCell(new Label(1, row, "external_product_id"));
/* 277 */     sheet.addCell(new Label(2, row, "external_product_id_type"));
/* 278 */     sheet.addCell(new Label(3, row, "item_name"));
/* 279 */     sheet.addCell(new Label(4, row, "brand_name"));
/* 280 */     sheet.addCell(new Label(5, row, "manufacturer"));
/* 281 */     sheet.addCell(new Label(6, row, "product_description"));
/* 282 */     sheet.addCell(new Label(7, row, "feed_product_type"));
/* 283 */     sheet.addCell(new Label(8, row, "part_number"));
/* 284 */     sheet.addCell(new Label(9, row, "update_delete"));
/* 285 */     sheet.addCell(new Label(10, row, "standard_price"));
/* 286 */     sheet.addCell(new Label(11, row, "currency"));
/* 287 */     sheet.addCell(new Label(12, row, "quantity"));
/* 288 */     sheet.addCell(new Label(13, row, "condition_type"));
/* 289 */     sheet.addCell(new Label(14, row, "condition_note"));
/* 290 */     sheet.addCell(new Label(15, row, "max_order_quantity"));
/* 291 */     sheet.addCell(new Label(16, row, "optional_payment_type_exclusion"));
/* 292 */     sheet.addCell(new Label(17, row, "sale_price"));
/* 293 */     sheet.addCell(new Label(18, row, "sale_from_date"));
/* 294 */     sheet.addCell(new Label(19, row, "sale_end_date"));
/* 295 */     sheet.addCell(new Label(20, row, "rebate_name1"));
/* 296 */     sheet.addCell(new Label(21, row, "rebate_name2"));
/* 297 */     sheet.addCell(new Label(22, row, "rebate_description1"));
/* 298 */     sheet.addCell(new Label(23, row, "rebate_description2"));
/* 299 */     sheet.addCell(new Label(24, row, "rebate_start_at1"));
/* 300 */     sheet.addCell(new Label(25, row, "rebate_start_at2"));
/* 301 */     sheet.addCell(new Label(26, row, "rebate_end_at1"));
/* 302 */     sheet.addCell(new Label(27, row, "rebate_end_at2"));
/* 303 */     sheet.addCell(new Label(28, row, "item_package_quantity"));
/* 304 */     sheet.addCell(new Label(29, row, "product_tax_code"));
/* 305 */     sheet.addCell(new Label(30, row, "product_site_launch_date"));
/* 306 */     sheet.addCell(new Label(31, row, "merchant_release_date"));
/* 307 */     sheet.addCell(new Label(32, row, "fulfillment_latency"));
/* 308 */     sheet.addCell(new Label(33, row, "restock_date"));
/* 309 */     sheet.addCell(new Label(34, row, "max_aggregate_ship_quantity"));
/* 310 */     sheet.addCell(new Label(35, row, "offering_can_be_gift_messaged"));
/* 311 */     sheet.addCell(new Label(36, row, "offering_can_be_giftwrapped"));
/* 312 */     sheet.addCell(new Label(37, row, "is_discontinued_by_manufacturer"));
/* 313 */     sheet.addCell(new Label(38, row, "missing_keyset_reason"));
/* 314 */     sheet.addCell(new Label(39, row, "merchant_shipping_group_name"));
/* 315 */     sheet.addCell(new Label(40, row, "item_display_diameter"));
/* 316 */     sheet.addCell(new Label(41, row, "item_display_diameter_unit_of_measure"));
/* 317 */     sheet.addCell(new Label(42, row, "item_display_height"));
/* 318 */     sheet.addCell(new Label(43, row, "item_display_height_unit_of_measure"));
/* 319 */     sheet.addCell(new Label(44, row, "volume_capacity_name"));
/* 320 */     sheet.addCell(new Label(45, row, "item_display_width"));
/* 321 */     sheet.addCell(new Label(46, row, "item_display_width_unit_of_measure"));
/* 322 */     sheet.addCell(new Label(47, row, "website_shipping_weight"));
/* 323 */     sheet.addCell(new Label(48, row, "website_shipping_weight_unit_of_measure"));
/* 324 */     sheet.addCell(new Label(49, row, "item_length"));
/* 325 */     sheet.addCell(new Label(50, row, "item_width"));
/* 326 */     sheet.addCell(new Label(51, row, "item_height"));
/* 327 */     sheet.addCell(new Label(52, row, "item_length_unit_of_measure"));
/* 328 */     sheet.addCell(new Label(53, row, "item_weight"));
/* 329 */     sheet.addCell(new Label(54, row, "item_weight_unit_of_measure"));
/* 330 */     sheet.addCell(new Label(55, row, "item_display_weight"));
/* 331 */     sheet.addCell(new Label(56, row, "item_display_weight_unit_of_measure"));
/* 332 */     sheet.addCell(new Label(57, row, "item_display_volume"));
/* 333 */     sheet.addCell(new Label(58, row, "item_display_volume_unit_of_measure"));
/* 334 */     sheet.addCell(new Label(59, row, "item_display_length"));
/* 335 */     sheet.addCell(new Label(60, row, "item_display_length_unit_of_measure"));
/* 336 */     sheet.addCell(new Label(61, row, "target_audience_keywords1"));
/* 337 */     sheet.addCell(new Label(62, row, "target_audience_keywords2"));
/* 338 */     sheet.addCell(new Label(63, row, "target_audience_keywords3"));
/* 339 */     sheet.addCell(new Label(64, row, "bullet_point1"));
/* 340 */     sheet.addCell(new Label(65, row, "bullet_point2"));
/* 341 */     sheet.addCell(new Label(66, row, "bullet_point3"));
/* 342 */     sheet.addCell(new Label(67, row, "bullet_point4"));
/* 343 */     sheet.addCell(new Label(68, row, "bullet_point5"));
/* 344 */     sheet.addCell(new Label(69, row, "recommended_browse_nodes1"));
/* 345 */     sheet.addCell(new Label(70, row, "recommended_browse_nodes2"));
/* 346 */     sheet.addCell(new Label(71, row, "generic_keywords1"));
/* 347 */     sheet.addCell(new Label(72, row, "generic_keywords2"));
/* 348 */     sheet.addCell(new Label(73, row, "generic_keywords3"));
/* 349 */     sheet.addCell(new Label(74, row, "generic_keywords4"));
/* 350 */     sheet.addCell(new Label(75, row, "generic_keywords5"));
/* 351 */     sheet.addCell(new Label(76, row, "platinum_keywords1"));
/* 352 */     sheet.addCell(new Label(77, row, "platinum_keywords2"));
/* 353 */     sheet.addCell(new Label(78, row, "platinum_keywords3"));
/* 354 */     sheet.addCell(new Label(79, row, "platinum_keywords4"));
/* 355 */     sheet.addCell(new Label(80, row, "platinum_keywords5"));
/* 356 */     sheet.addCell(new Label(81, row, "main_image_url"));
/* 357 */     sheet.addCell(new Label(82, row, "other_image_url1"));
/* 358 */     sheet.addCell(new Label(83, row, "other_image_url2"));
/* 359 */     sheet.addCell(new Label(84, row, "other_image_url3"));
/* 360 */     sheet.addCell(new Label(85, row, "other_image_url4"));
/* 361 */     sheet.addCell(new Label(86, row, "other_image_url5"));
/* 362 */     sheet.addCell(new Label(87, row, "other_image_url6"));
/* 363 */     sheet.addCell(new Label(88, row, "other_image_url7"));
/* 364 */     sheet.addCell(new Label(89, row, "other_image_url8"));
/* 365 */     sheet.addCell(new Label(90, row, "swatch_image_url"));
/* 366 */     sheet.addCell(new Label(91, row, "fulfillment_center_id"));
/* 367 */     sheet.addCell(new Label(92, row, "package_height"));
/* 368 */     sheet.addCell(new Label(93, row, "package_width"));
/* 369 */     sheet.addCell(new Label(94, row, "package_length"));
/* 370 */     sheet.addCell(new Label(95, row, "package_length_unit_of_measure"));
/* 371 */     sheet.addCell(new Label(96, row, "package_weight"));
/* 372 */     sheet.addCell(new Label(97, row, "package_weight_unit_of_measure"));
/* 373 */     sheet.addCell(new Label(98, row, "parent_child"));
/* 374 */     sheet.addCell(new Label(99, row, "parent_sku"));
/* 375 */     sheet.addCell(new Label(100, row, "relationship_type"));
/* 376 */     sheet.addCell(new Label(101, row, "variation_theme"));
/* 377 */     sheet.addCell(new Label(102, row, "region_of_origin"));
/* 378 */     sheet.addCell(new Label(103, row, "country_of_origin"));
/* 379 */     sheet.addCell(new Label(104, row, "legal_disclaimer_description"));
/* 380 */     sheet.addCell(new Label(105, row, "safety_warning"));
/* 381 */     sheet.addCell(new Label(106, row, "liquid_volume"));
/* 382 */     sheet.addCell(new Label(107, row, "liquid_volume_unit_of_measure"));
/* 383 */     sheet.addCell(new Label(108, row, "target_gender"));
/* 384 */     sheet.addCell(new Label(109, row, "color_name"));
/* 385 */     sheet.addCell(new Label(110, row, "size_map"));
/* 386 */     sheet.addCell(new Label(111, row, "age_gender_category"));
/* 387 */     sheet.addCell(new Label(112, row, "amperage"));
/* 388 */     sheet.addCell(new Label(113, row, "amperage_unit_of_measure"));
/* 389 */     sheet.addCell(new Label(114, row, "is_autographed"));
/* 390 */     sheet.addCell(new Label(115, row, "rim_size"));
/* 391 */     sheet.addCell(new Label(116, row, "rim_size_unit_of_measure"));
/* 392 */     sheet.addCell(new Label(117, row, "boot_size"));
/* 393 */     sheet.addCell(new Label(118, row, "calf_size"));
/* 394 */     sheet.addCell(new Label(119, row, "caliber"));
/* 395 */     sheet.addCell(new Label(120, row, "capacity"));
/* 396 */     sheet.addCell(new Label(121, row, "capacity_unit_of_measure"));
/* 397 */     sheet.addCell(new Label(122, row, "care_instructions"));
/* 398 */     sheet.addCell(new Label(123, row, "curvature"));
/* 399 */     sheet.addCell(new Label(124, row, "pattern_name"));
/* 400 */     sheet.addCell(new Label(125, row, "directions"));
/* 401 */     sheet.addCell(new Label(126, row, "diving_clothing_thickness"));
/* 402 */     sheet.addCell(new Label(127, row, "fencing_pommel_type"));
/* 403 */     sheet.addCell(new Label(128, row, "flavor_name"));
/* 404 */     sheet.addCell(new Label(129, row, "golf_club_flex"));
/* 405 */     sheet.addCell(new Label(130, row, "golf_club_loft"));
/* 406 */     sheet.addCell(new Label(131, row, "grip_size"));
/* 407 */     sheet.addCell(new Label(132, row, "grip_type"));
/* 408 */     sheet.addCell(new Label(133, row, "hand_orientation"));
/* 409 */     sheet.addCell(new Label(134, row, "head_size"));
/* 410 */     sheet.addCell(new Label(135, row, "item_thickness_derived"));
/* 411 */     sheet.addCell(new Label(136, row, "item_thickness_unit_of_measure"));
/* 412 */     sheet.addCell(new Label(137, row, "lens_color"));
/* 413 */     sheet.addCell(new Label(138, row, "line_weight"));
/* 414 */     sheet.addCell(new Label(139, row, "material_type"));
/* 415 */     sheet.addCell(new Label(140, row, "is_memorabilia"));
/* 416 */     sheet.addCell(new Label(141, row, "manufacturer_defined_quality_description"));
/* 417 */     sheet.addCell(new Label(142, row, "number_of_rounds"));
/* 418 */     sheet.addCell(new Label(143, row, "shaft_length"));
/* 419 */     sheet.addCell(new Label(144, row, "shaft_length_unit_of_measure"));
/* 420 */     sheet.addCell(new Label(145, row, "shaft_material"));
/* 421 */     sheet.addCell(new Label(146, row, "shaft_style_type"));
/* 422 */     sheet.addCell(new Label(147, row, "item_shape"));
/* 423 */     sheet.addCell(new Label(148, row, "size_name"));
/* 424 */     sheet.addCell(new Label(149, row, "style_name"));
/* 425 */     sheet.addCell(new Label(150, row, "temperature_rating_degrees"));
/* 426 */     sheet.addCell(new Label(151, row, "temperature_rating_degrees_unit_of_measure"));
/* 427 */     sheet.addCell(new Label(152, row, "tension_level"));
/* 428 */     sheet.addCell(new Label(153, row, "wattage"));
/* 429 */     sheet.addCell(new Label(154, row, "display_maximum_weight_recommendation"));
/* 430 */     sheet.addCell(new Label(155, row, "display_maximum_weight_recommendation_unit_of_measure"));
/* 431 */     sheet.addCell(new Label(156, row, "wheel_size"));
/* 432 */     sheet.addCell(new Label(157, row, "wheel_size_unit_of_measure"));
/* 433 */     sheet.addCell(new Label(158, row, "power_source_type"));
/* 434 */     sheet.addCell(new Label(159, row, "battery_type1"));
/* 435 */     sheet.addCell(new Label(160, row, "battery_type2"));
/* 436 */     sheet.addCell(new Label(161, row, "battery_type3"));
/* 437 */     sheet.addCell(new Label(162, row, "number_of_batteries1"));
/* 438 */     sheet.addCell(new Label(163, row, "number_of_batteries2"));
/* 439 */     sheet.addCell(new Label(164, row, "number_of_batteries3"));
/* 440 */     sheet.addCell(new Label(165, row, "battery_average_life"));
/* 441 */     sheet.addCell(new Label(166, row, "battery_average_life_standby"));
/* 442 */     sheet.addCell(new Label(167, row, "battery_charge_time"));
/* 443 */     sheet.addCell(new Label(168, row, "lithium_battery_energy_content"));
/* 444 */     sheet.addCell(new Label(169, row, "lithium_battery_packaging"));
/* 445 */     sheet.addCell(new Label(170, row, "lithium_battery_voltage"));
/* 446 */     sheet.addCell(new Label(171, row, "lithium_battery_weight"));
/* 447 */     sheet.addCell(new Label(172, row, "are_batteries_included"));
/* 448 */     sheet.addCell(new Label(173, row, "batteries_required"));
/* 449 */     sheet.addCell(new Label(174, row, "number_of_lithium_ion_cells"));
/* 450 */     sheet.addCell(new Label(175, row, "number_of_lithium_metal_cells"));
/* 451 */     sheet.addCell(new Label(176, row, "mfg_warranty_description_type"));
/* 452 */     sheet.addCell(new Label(177, row, "mfg_warranty_description_labor"));
/* 453 */     sheet.addCell(new Label(178, row, "mfg_warranty_description_parts"));
/* 454 */     sheet.addCell(new Label(179, row, "seller_warranty_description"));
/* 455 */     sheet.addCell(new Label(180, row, "color_map"));
/*     */   }
/*     */ }


/* Location:              /Volumes/SanDisk/workspace/AutoGen/AutoGen 坐垫/GenExcel.jar!/net/ytin/axft/sports/GenExcelFileSports.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */