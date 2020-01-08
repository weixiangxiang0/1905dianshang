package com.yzit.gen;

import java.sql.SQLException;

import com.yzit.gen.entity.CodeGenerateFactory;


public class GenMain {
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
			
			 codeGenerate("user","用户表","User");//代码生成
			 
//			 codeGenerate("sys_dict_type","字典类型表","SysDictType");//代码生成
//			 tableName = "t_sys_role";codeName="角色";className="Role";
//			 codeGenerate(tableName,codeName,className);//代码生成
////	
//			 tableName = "t_sys_log";codeName="操作日志";className="Logs";
//			 codeGenerate(tableName,codeName,className);//代码生成
////			 
////			 tableName = "t_sys_area";codeName="地区";className="Area";
////			 codeGenerate(tableName,codeName,className);//代码生成
////
//			 tableName = "t_sys_dict";codeName="字典";className="Dict";
//			 codeGenerate(tableName,codeName,className);//代码生成
////			 
//			 tableName = "t_sys_resourse";codeName="系统菜单";className="Ress";
//			 codeGenerate(tableName,codeName,className);//代码生成
////			 
//			 tableName = "t_sys_organ";codeName="组织结构";className="Organ";
//			 codeGenerate(tableName,codeName,className);//代码生成
////			 
//			 tableName = "t_sys_user";codeName="登录用户";className="User";
//			 codeGenerate(tableName,codeName,className);//代码生成
////			 
//			 tableName = "t_gen_scheme";codeName="数据库";className="GenScheme";
//			 codeGenerate(tableName,codeName,className);//代码生成
////			 
//			 tableName = "t_gen_table";codeName="数据库表";className="GenTable";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 tableName = "t_gen_table_column";codeName="数据表列字段";className="GenTableColumn";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 tableName = "t_gen_template";codeName="代码生成器模板";className="GenTemplate";
//			 codeGenerate(tableName,codeName,className);//代码生成
			 
			 
			 /***************【门户数据库】********************/
//			 tableName = "t_cms_advert";codeName="广告";className="Advert";
//			 codeGenerate(tableName,codeName,className);//代码生成		 
//////	//
//			 tableName = "t_cms_advert_slot";codeName="广告位";className="AdvertSlot";
//			 codeGenerate(tableName,codeName,className);//代码生成		 
//////			 
//////			 
//			 tableName = "t_cms_channel";codeName="文章栏目";className="Channel";
//			 codeGenerate(tableName,codeName,className);//代码生成
////	
////			 
//			 tableName = "t_cms_article";codeName="文章";className="Article";
//			 codeGenerate(tableName,codeName,className);//代码生成
//
//			 tableName = "t_cms_article_picture";codeName="文章图片";className="ArticlePic";
//			 codeGenerate(tableName,codeName,className);//代码生成
////			 
////			 tableName = "t_cms_company";codeName="企业信息";className="Company";
////			 codeGenerate(tableName,codeName,className);//代码生成
////			 
////			 tableName = "t_cms_Leave_messagee";codeName="留言";className="LeaveMessagee";
////			 codeGenerate(tableName,codeName,className);//代码生成
////			 
//			 tableName = "t_cms_article_type";codeName="文章类型";className="ArticleType";
//			 codeGenerate(tableName,codeName,className);//代码生成
//////			 
////	
//////			 
//			 tableName = "t_cms_comment";codeName="文章评论";className="Comment";
//			 codeGenerate(tableName,codeName,className);//代码生成
//////			 
//			 tableName = "t_cms_member";codeName="会员";className="Member";
//			 codeGenerate(tableName,codeName,className);//代码生成
////////			 
//			 tableName = "t_cms_member_group";codeName="用户组";className="MemberGroup";
//			 codeGenerate(tableName,codeName,className);//代码生成
////			 
//			 tableName = "t_cms_links";codeName="友情链接";className="Links";
//			 codeGenerate(tableName,codeName,className);//代码生成
//////////			 
//			 tableName = "t_cms_links_type";codeName="友情链接分类";className="LinkType";
//			 codeGenerate(tableName,codeName,className);//代码生成
////////			 
////////			 tableName = "t_cms_nav";codeName="导航";className="CmsNav";
////////			 codeGenerate(tableName,codeName,className);//代码生成
////			
//			 tableName = "t_cms_site";codeName="站点";className="Site";
//			 codeGenerate(tableName,codeName,className);//代 码生成
//////			 
//////			 
//			 tableName = "t_cms_site_config";codeName="站点配置";className="SiteConfig";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			
////			 
//			 tableName = "t_cms_site_flow_log";codeName="站点流量通国际";className="SiteFlowLog";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 
//			 tableName = "t_cms_article_subject";codeName="文章专题";className="ArticleSubject";
//			 codeGenerate(tableName,codeName,className);//代码生成
			 /***************【双创数据库】********************/
			 
//			 tableName = "t_model";codeName="模型";className="Models";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 tableName = "t_admin";codeName="登录";className="Admin";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 

//			 
//			 
//			 tableName = "t_article_sign";codeName="文章签收";className="articleSign";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 
//			 
//			 
//			 tableName = "t_keyword";codeName="关键字";className="Keywords";
//			 codeGenerate(tableName,codeName,className);//代码生成
//			 

////			 
//			 tableName = "t_cms_site_message";codeName="站点消息";className="SiteMessage";
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
