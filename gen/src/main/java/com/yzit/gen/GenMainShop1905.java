package com.yzit.gen;

import java.sql.SQLException;

import com.yzit.gen.entity.CodeGenerateFactory;


public class GenMainShop1905 {
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

			codeGenerate("tb_brand","品牌","Brand");
			codeGenerate("tb_canshu","参数","Canshu");
			codeGenerate("tb_category","分类","Category");
			codeGenerate("tb_attributes","属性","Attributes");
			codeGenerate("tb_specification","品牌","Specification");


			//代码生成
			/*
			codeGenerate("tb_type_template","分类模板","TypeTemplate");//代码生成
			codeGenerate("tb_specification","规格","Spec");//代码生成
			codeGenerate("tb_specification_option","规格选项","SpecOption");//代码生成
			codeGenerate("tb_goods_type","商品分类","GoodsType");//代码生成
			codeGenerate("tb_goods","商品","Goods");//代码生成
			codeGenerate("tb_goods_desc","商品描述","GoodsDesc");//代码生成
			codeGenerate("tb_goods_item","商品SKU","GoodsItems");//代码生成
			
			codeGenerate("tb_advert","广告","Advert");//代码生成
			codeGenerate("tb_advert_type","广告分类","GoodsItems");//代码生成
*/	
			
//			codeGenerate("tb_user","用户","User");//代码生成
//			 tableName = "tb_brand";codeName="品牌";className="Brand";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 tableName = "tb_specification";codeName="商品规格";className="Specification";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 tableName = "tb_specification_option";codeName="规格选项";className="SpecificationOption";
//			 codeGenerate(tableName,codeName,className);//代码生成
			 
//			 tableName = "tb_type_template";codeName="分类模板";className="TypeTemplate";
//			 codeGenerate(tableName,codeName,className);//代码生成
			 
			 
			
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
