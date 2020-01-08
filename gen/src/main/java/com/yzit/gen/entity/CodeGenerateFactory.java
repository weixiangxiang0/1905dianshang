package com.yzit.gen.entity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



import com.google.common.collect.Maps;
import com.yzit.gen.utils.FileUtils;
import com.yzit.gen.utils.FreeMarkers;
import com.yzit.gen.utils.StringUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class CodeGenerateFactory {
	private static final Log log = LogFactory.getLog(CodeGenerateFactory.class);

	private static String url = CodeResourceUtil.URL;

	private static String username = CodeResourceUtil.USERNAME;

	private static String passWord = CodeResourceUtil.PASSWORD;

	private static String buss_package = CodeResourceUtil.bussiPackage;

	private static String projectPath = CodeResourceUtil.projectPath;// getProjectPath();

	/**
	 * @param tableName：表名
	 * @param codeName：注释
	 * @param entityPackage：实体包 
	 * @param keyType：主键生成方式  01:UUID  02:自增
	 * @param isGenerateJsp:是否生产jsp页面和js文件
	 * @throws SQLException 
	 */
	public static void codeGenerate(String tableName, String moduleName,
			String className, String entityPackage, String keyType,
			boolean isGenerateJsp) throws Exception {
		CreateBean createBean = new CreateBean();
	    createBean.setMysqlInfo(url, username, passWord);
	    
	    
//	    String className = createBean.getTablesNameToClassName(tableName);
	    String lowerName = className.substring(0, 1).toLowerCase() + className.substring(1, className.length());

	    String srcPath = projectPath + CodeResourceUtil.source_root_package + "\\";

	    String pckPath = srcPath + CodeResourceUtil.bussiPackageUrl + "\\";
	    String webPath = projectPath + CodeResourceUtil.web_root_package + "\\view\\"  + "\\";
		Map<String, Object> paramMap = Maps.newHashMap();
		paramMap.put("className", className);
	    paramMap.put("lowerName", lowerName);
	    paramMap.put("moduleName", moduleName);
	    paramMap.put("tableName", tableName);
	    paramMap.put("bussPackage", buss_package);
	    paramMap.put("entityPackage", entityPackage);
	    paramMap.put("keyType", keyType);
	    paramMap.put("user", System.getProperty("user.name"));
	    paramMap.put("time", new Date());
	    paramMap.put("organization",CodeResourceUtil.getOrganization());
	    
	    //数据库表的所有的列对象
	    List<ColumnData> columnDataList = createBean.getColumnDatas(tableName);
	    
	    System.out.println("----------------------"+columnDataList.toString());
	    paramMap.put("columnDatas", columnDataList);
	   //所有的列名称字符串
	    String columns = createBean.getColumnSplit(columnDataList);
	    paramMap.put("columns", columns);
	    
	    ColumnData columnDataPk = createBean.getTablePK(tableName);
	    paramMap.put("columnDataPk", columnDataPk);
	  
	    //insert
	    String fileds =  StringUtils.replaceUnderlineAndfirstToUpper(columns,"_","");
	    System.out.println("**********columns**************************");
	    System.out.println(columns);
	    System.out.println(columns.replaceAll("\\|", ","));
	    System.out.println("**********fileds**************************");
	    System.out.println(fileds);
	    System.out.println(fileds.replaceAll(",", "\\},\\#\\{"));
	    
	    String insertSql = "insert into " + tableName + "(" + columns.replaceAll("\\|", ",") + ")\n values(#{" + fileds.replaceAll(",", "\\},\\#\\{") + "})";
	    paramMap.put("insertSql", insertSql);
	    
	    
	    
	    //update
	    String updateSql  = getUpdateSql(tableName,  columnDataList, columnDataPk);
	    
	    paramMap.put("updateSql", updateSql);
	    
	    String updateSelective = getUpdateSelectiveSql(tableName,  columnDataList, columnDataPk);
	    paramMap.put("updateSelective",updateSelective);
	    
	    
//	    String columnFields =  StringUtils.replaceUnderlineAndfirstToUpper(columns,"_","");
//	    paramMap.put("columnFields", columnFields);
	    
	    String beanPath = "entity\\" + className + ".java";
	    String mapperPath = "dao\\" + className + "Dao.java";
	    String servicePath = "service\\" + className + "Service.java";
	    String serviceImplPath = "service\\" + className + "ServiceImpl.java";
	    String controllerPath = "controller\\" + className + "Controller.java";
	    String sqlMapperPath = "mapper\\" + className + "Mapper.xml";
	    webPath = webPath + lowerName + "\\";

//	    String jspPath = lowerName + ".jsp";
	    String jspListPath = lowerName + "_list.jsp";
	    String jspFormPath = lowerName + "_form.jsp";
	    
	    
	    WriterPage("EntityTemplate.xml",paramMap, pckPath, beanPath);
//	    WriterPage("PageTemplate.xml", paramMap,pckPath, modelPath);
	    WriterPage("DaoTemplate.xml",paramMap, pckPath, mapperPath);
	    WriterPage("ServiceTemplate.xml",paramMap, pckPath, servicePath);
	    WriterPage("ServiceImplTemplate.xml",paramMap, pckPath, serviceImplPath);
//	    
	    WriterPage("MapperTemplate.xml", paramMap,pckPath, sqlMapperPath);
	    WriterPage("ControllerTemplate.xml",paramMap, pckPath, controllerPath);
	    if(isGenerateJsp){
//		    WriterPage("jspTemplate.xml", webPath, jspPath);
//		    WriterPage("jsTemplate.xml", webPath, jsPath);
		    //列表页面
		    WriterPage("jspListTemplate.xml",paramMap, webPath, jspListPath);
		    //内容页面
		    WriterPage("jspFormTemplate.xml",paramMap, webPath, jspFormPath);
	    }
	    
	}
	
	/**
	 * 
	 * @param templateName
	 * @param paramMap
	 * @param pckPath
	 * @param targetFile
	 * @throws IOException 
	 * @throws  
	 */
	public static void WriterPage(String templateName,Map<String, Object> paramMap   , String fileDirPath,String targetFile) throws Exception{
		 //根据模板名称获取文件内容
//	    String templatepath = CodeResourceUtil.TEMPLATEPATH;//模板路径
//	    String classPath  =System.getProperty("user.dir"); //当前项目路径:D:\Workspaces\demo_5\gen_test
//	    String templateFilePath = classPath+"\\src\\"+templatepath+"\\"+templateName;
		 File file = new File(fileDirPath + targetFile);
	      if (!file.exists()) {
	        new File(file.getParent()).mkdirs();
	      }
	      else if (true) {
	        log.info("替换文件:" + file.getAbsolutePath());
	      }
	    
//	  第一步：实例化Freemarker的配置类
        Configuration conf = new Configuration();
        conf.setClassForTemplateLoading(CodeGenerateFactory.class, "/"+CodeResourceUtil.TEMPLATEPATH);
        conf.setDefaultEncoding("utf-8");
        
        
//        File templateFile = new File(templateFilePath);
        String newFileName = fileDirPath + targetFile;
        
        
        //根据模板获取路径
        Template template = conf.getTemplate(templateName);
        
       // 创建文件并输出
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFileName),"utf-8"));

        template.process(paramMap,   out);
	    
//	    //获取文件内容
//	    
//	    String tplContent = null;
//	    
//	    String newFileName = fileDirPath + targetFile;
//	    boolean isReplace = true;
//		try {
//			
//			 File file = new File(newFileName);
//		      if (!file.exists()) {
//		        new File(file.getParent()).mkdirs();
//		      }else if (isReplace) {
//		        log.info("替换文件:" + file.getAbsolutePath());
//		      }
//		      
//		      
//			tplContent = FileUtils.readFileToString(templateFile,"utf-8");
//			
//			
//			
//			generateToFile(newFileName, tplContent, paramMap, true);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}//(templateFilePath,"utf-8");
//	  
	    
	    
	}
	/**
	 * 生成文件
	 * @param tplContent 模板文件内容  
	 * @param model 模板数据
	 * @param isReplaceFile 是否替换内容
	 * @return
	 */
	public static void generateToFile(String newFileName   , String tplContent, Map<String, Object> paramMap, boolean isReplaceFile){
		//boolean isReplaceFile  = true;//是否替换内容
//		String fileName = "";
//		String tplContent  = "";//模板内容
//		Map<String,Object> paramMap = new HashMap<String,Object>();
		
//		获取生成文件内容
		String content = FreeMarkers.renderString(StringUtils.trimToEmpty(tplContent), paramMap);
//		 如果选择替换文件，则删除原文件
		if (isReplaceFile){
			FileUtils.deleteFile(newFileName);
		}
		// 创建并写入文件
		if (FileUtils.createFile(newFileName)){
			FileUtils.writeToFile(newFileName, content, true);
			System.out.println( "生成成功："+newFileName+"<br/>");
		}else{
//			logger.debug(" file extents === " + fileName);
			System.out.println( "文件已存在："+newFileName+"<br/>");
		}
	}
	
	/**
	 * 获取修改语句
	 * @param tableName
	 * @param columnsList
	 * @param columnDataPk
	 * @return
	 * @throws SQLException
	 */
	 public static String getUpdateSql(String tableName, List<ColumnData> columnsList,ColumnData columnDataPk)
	    throws SQLException
	  {
	    StringBuffer sb = new StringBuffer();
	    int i = 0 ;
	    for(ColumnData column : columnsList){
	    	if(column.getColumnName() .equals(columnDataPk.getColumnName()  )){
	    		continue;
	    	}
	    	String field =  StringUtils.replaceUnderlineAndfirstToUpper(column.getColumnName(),"_","");
	    	  sb.append(column.getColumnName() + "=#{" + field + "}");
	    	  if (i + 1 <( columnsList.size()-1)) {
	  	        sb.append(",");
	  	      }
	    	  i++;
	    }
	    String update = "update " + tableName + " set " + sb.toString() + " where " + columnDataPk.getColumnName() + "=#{" + columnDataPk.getFieldName() + "}";
	    return update;
	  }
	 
	 /**
	  * 根据条件进行修改
	  * @param tableName
	  * @param columnList
	  * @param columnDataPk
	  * @return
	  * @throws SQLException
	  */
	 public static String getUpdateSelectiveSql(String tableName, List<ColumnData> columnList,ColumnData columnDataPk) throws SQLException {
		    StringBuffer sb = new StringBuffer();
		    sb.append("\t<trim  suffixOverrides=\",\" >\n");
		    for (int i = 1; i < columnList.size(); i++) {
		      ColumnData data = (ColumnData)columnList.get(i);
		      String columnName = data.getColumnName();
		      String fieldName =  StringUtils.replaceUnderlineAndfirstToUpper(columnName,"_","");
		      
		      

		      if ("String" == data.getDataType()) {
		    	  sb.append("\t<if test=\"").append(fieldName).append(" != null ");
		    	  sb.append(" and ").append(fieldName).append(" != ''");
		    	  sb.append(" \">\n\t\t");
		      }else{
		    	  sb.append("\t<if test=\"").append(fieldName).append(" != null ");
		    	  sb.append(" \">\n\t\t");
		      }
		     
		      sb.append(columnName + "=#{" + fieldName + "},\n");
		      sb.append("\t</if>\n");
		    }
		    sb.append("\t</trim>");
		    String update = "update " + tableName + " set \n" + sb.toString() + " where " + columnDataPk.getColumnName() + "=#{" + columnDataPk.getFieldName() + "}";
		    return update;
		  }
}
