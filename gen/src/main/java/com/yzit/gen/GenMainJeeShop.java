package com.yzit.gen;

import java.sql.SQLException;

import com.yzit.gen.entity.CodeGenerateFactory;


public class GenMainJeeShop {
	  public static String KEY_TYPE_01 = "01";
	  public static String KEY_TYPE_02 = "02";
	public static void main(String[] args) {
		/** 此处修改成你的 表名 和 中文注释** */
		String tableName = ""; // 表名称
		String codeName = "";// 中文注释 当然你用英文也是可以的
		String className = "";// 类名称

		
		try {
			/***************【平台数据库】********************/
			 /***************【电商数据库】********************/
//			 codeGenerate(tableName,codeName,className);//代码生成
//			codeGenerate("tb_advert","广告","Advert");
			/*codeGenerate("tb_advert_type","广告","AdvertType");
			codeGenerate("tb_goods_type","商品分类","GoodsType");
			codeGenerate("tb_brand","品牌","tb_brand");
			codeGenerate("tb_goods","商品","Goods");
			codeGenerate("tb_area","地区","Area");
			codeGenerate("tb_address","地址","Address");*/
			
			codeGenerate("ma_capacity_replacement","产能置换","CapacityReplacement");
			codeGenerate("ma_capacity_application","产能置换应用","CapacityApplication");
			
			
			 /***************【双创数据库】********************/
			 
			
//			 
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
