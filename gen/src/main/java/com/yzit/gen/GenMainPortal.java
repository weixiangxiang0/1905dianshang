package com.yzit.gen;

import java.sql.SQLException;

import com.yzit.gen.entity.CodeGenerateFactory;


public class GenMainPortal {
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
			
			
//			 tableName = "t_cms_admin";codeName="管理員";className="CmsAdmin";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 tableName = "t_cms_advert";codeName="广告";className="Advert";
//			 codeGenerate(tableName,codeName,className);//代码生成		 
//////	//
//			 tableName = "t_cms_advert_slot";codeName="广告位";className="AdvertSlot";
//			 codeGenerate(tableName,codeName,className);//代码生成		 
//////			 
//			 tableName = "t_cms_channel";codeName="文章栏目";className="Channel";
//			 codeGenerate(tableName,codeName,className);//代码生成
////			 
//			 tableName = "t_cms_article";codeName="文章";className="Article";
//			 codeGenerate(tableName,codeName,className);//代码生成
//
//			 
//			 
//			 tableName = "t_cms_category";codeName="栏目类别";className="CmsCategory";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 tableName = "t_cms_article_picture";codeName="文章图片";className="ArticlePic";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 
//			 tableName = "t_cms_article_type";codeName="文章类型";className="ArticleType";
//			 codeGenerate(tableName,codeName,className);//代码生成
//////			 
//			 tableName = "t_cms_comment";codeName="文章评论";className="CmsComment";
//			 codeGenerate(tableName,codeName,className);//代码生成
//////			 t_cms_links_type
//			 
//			 tableName = "t_cms_links_type";codeName="友情链接分类";className="LinksType";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 tableName = "t_cms_links";codeName="友情链接";className="Links";
//			 codeGenerate(tableName,codeName,className);//代码生成
//////////			 
//			 
//			 tableName = "t_cms_database_config";codeName="数据库配置";className="DatabaseConfig";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 tableName = "t_cms_group";codeName="用户组";className="CmsGroup";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 
//			 tableName = "t_cms_member";codeName="会员";className="CmsMember";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 
//			 tableName = "t_cms_model";codeName="模型";className="DocModel";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 tableName = "t_cms_model_field";codeName="模型属性";className="DocModelField";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 
//			 
//			 tableName = "t_cms_role";codeName="角色";className="Role";
//			 codeGenerate(tableName,codeName,className);//代码生成
//	
//			 tableName = "t_cms_log";codeName="操作日志";className="Logs";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 tableName = "t_cms_area";codeName="地区";className="Area";
//			 codeGenerate(tableName,codeName,className);//代码生成
//
////			 tableName = "t_cms_dict";codeName="字典";className="Dict";
////			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 tableName = "t_cms_resourse";codeName="系统菜单";className="Resource";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 tableName = "t_cms_organ";codeName="组织结构";className="Dept";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 tableName = "t_cms_user";codeName="登录用户";className="User";
//			 codeGenerate(tableName,codeName,className);//代码生成
			 
			 /***************【门户数据库】********************/
			
//			 tableName = "t_cms_site";codeName="站点";className="Site";
//			 codeGenerate(tableName,codeName,className);//代 码生成
			 
			 
//			 tableName = "t_cms_site_config";codeName="站点配置";className="SiteConfig";
//			 codeGenerate(tableName,codeName,className);//代码生成
			
//			 
//			 tableName = "t_cms_site_flow_log";codeName="站点流量通国际";className="SiteFlowLog";
//			 codeGenerate(tableName,codeName,className);//代码生成
			
			tableName = "t_cms_channel_data";codeName="栏目数据";className="ChanneData";
			 codeGenerate(tableName,codeName,className);//代码生成
			 
			tableName = "t_cms_chnl_tpl_selection";codeName="栏目模板";className="ChannelTpl";
			 codeGenerate(tableName,codeName,className);//代码生成
			
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
