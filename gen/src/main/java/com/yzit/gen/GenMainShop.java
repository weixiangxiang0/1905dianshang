package com.yzit.gen;

import java.sql.SQLException;

import com.yzit.gen.entity.CodeGenerateFactory;


public class GenMainShop {
	  public static String KEY_TYPE_01 = "01";
	  public static String KEY_TYPE_02 = "02";
	public static void main(String[] args) {
		/** 此处修改成你的 表名 和 中文注释** */
		String tableName = ""; // 表名称
		String codeName = "";// 中文注释 当然你用英文也是可以的
		String className = "";// 类名称

		
		try {
			/***************【平台数据库】********************/
			 
			 /***************【平台数据库】********************/
			
			codeGenerate("xx_ad","广告","Ad");//代码生成
			codeGenerate("xx_ad_position ","广告位","");//代码生成
			codeGenerate("xx_admin","管理员","");//代码生成
			codeGenerate("xx_area","地区","");//代码生成
			codeGenerate("xx_article","文章","");//代码生成
			codeGenerate("xx_article_category","文章分类","");//代码生成
			codeGenerate("xx_attribute","属性","");//代码生成
			codeGenerate("xx_brand","品牌","");//代码生成
			codeGenerate("xx_card","购物车","");//代码生成
			codeGenerate("xx_card_item","购物车选项","");//代码生成
			codeGenerate("xx_consultation","咨询","");//代码生成
			codeGenerate("x_coupon","优惠券","");//代码生成
			codeGenerate("x_delivery_center","发货点","");//代码生成
			codeGenerate("x_delivery_corp","物流公司","");//代码生成
			codeGenerate("x_delivery_template","快递单模板","");//代码生成
			codeGenerate("x_friend_link","友情","");//代码生成
			codeGenerate("x_gift_item","赠品项","");//代码生成
			codeGenerate("x_log","日志","");//代码生成
			codeGenerate("x_member","会员","");//代码生成
			codeGenerate("x_member_attribute","会员扩展","");//代码生成
			codeGenerate("x_member_rank","会员等级","");//代码生成
			codeGenerate("x_message","消息","");//代码生成
			codeGenerate("x_navigation","导航","");//代码生成
			codeGenerate("x_order","订单","");//代码生成
			codeGenerate("x_order_item","订单详情","");//代码生成
			codeGenerate("x_order_log","订单日志","");//代码生成
			codeGenerate("x_product","商品","");//代码生成
			codeGenerate("x_product_category","商品分类","");//代码生成
			codeGenerate("x_promotion","促销","");//代码生成
			codeGenerate("x_receiver","收货地址","");//代码生成
			codeGenerate("x_returns","退货单","");//代码生成
			codeGenerate("x_refunds","退款单","");//代码生成
			codeGenerate("x_returns_item","退货详情","");//代码生成
			codeGenerate("x_review","评论","");//代码生成
			codeGenerate("x_role","角色","");//代码生成
			codeGenerate("x_seo","seo设置","");//代码生成
			codeGenerate("x_shipping","发货单","");//代码生成
			codeGenerate("x_shipping_item","发货详情","");//代码生成
			codeGenerate("x_shipping_method","","");//代码生成
			codeGenerate("x_shipping_method","配置方式","");//代码生成
			codeGenerate("x_specification","规格","");//代码生成
			codeGenerate("x_specification_value","规格值","");//代码生成
			codeGenerate("x_tag","标签","");//代码生成
			codeGenerate("","","");//代码生成
			codeGenerate("","","");//代码生成
			codeGenerate("","","");//代码生成
			codeGenerate("","","");//代码生成
			codeGenerate("","","");//代码生成
			codeGenerate("","","");//代码生成
			codeGenerate("","","");//代码生成
			codeGenerate("","","");//代码生成
			codeGenerate("","","");//代码生成
			codeGenerate("","","");//代码生成
			codeGenerate("","","");//代码生成
			codeGenerate("","","");//代码生成
			
//			 tableName = "tb_brand";codeName="品牌";className="Brand";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 tableName = "tb_specification";codeName="商品规格";className="Specification";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 tableName = "tb_specification_option";codeName="规格选项";className="SpecificationOption";
//			 codeGenerate(tableName,codeName,className);//代码生成
			 
			 tableName = "tb_type_template";codeName="分类模板";className="TypeTemplate";
			 codeGenerate(tableName,codeName,className);//代码生成
			 
			 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 代码生成
	}
	public static void codeGenerate(String tableName, String codeName,String className) throws Exception{
		 String entityPackage ="";//实体包
		 
		 String keyType = KEY_TYPE_02;//主键生成方式 01:UUID  02:自增
		 CodeGenerateFactory.codeGenerate(tableName, codeName,className,entityPackage,keyType,true);
	}
}
