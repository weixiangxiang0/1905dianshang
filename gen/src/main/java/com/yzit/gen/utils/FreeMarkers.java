package com.yzit.gen.utils;

/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * FreeMarkers工具类
 * @author ThinkGem
 * @version 2013-01-15
 */
public class FreeMarkers {
	/**
	 * 根据模板的内容，返回模板替换之后的文件
	 * @param templateString  模板的名称
	 * @param model	模板的参数
	 * @return
	 */
	public static String renderString(String templateString, Map<String, ?> parentMap) {
		try {
			StringWriter result = new StringWriter();
			Template t = new Template("name", new StringReader(templateString), new Configuration());
			t.process(parentMap, result);
			return result.toString();
		} catch (Exception e) {
			throw Exceptions.unchecked(e);
		}
	}
	public static String renderTemplate(Template template, Object model) {
		try {
			StringWriter result = new StringWriter();
			template.process(model, result);
			return result.toString();
		} catch (Exception e) {
			throw Exceptions.unchecked(e);
		}
	}

	public static Configuration buildConfiguration(String directory) throws IOException {
		Configuration cfg = new Configuration();
//		Resource path = new DefaultResourceLoader().getResource(directory);
//		cfg.setDirectoryForTemplateLoading(path.getFile());
		
		cfg.setClassForTemplateLoading(FreeMarkers.class, directory);
		cfg.setDefaultEncoding("utf-8");
		return cfg;
	}
	
	public static void main(String[] args) throws IOException {
//		// renderString
		Map<String, String> model = com.google.common.collect.Maps.newHashMap();
		model.put("userName", "康威");
		String result = FreeMarkers.renderString("hello ${userName}", model);
		System.out.println(result);
//		// renderTemplate
//		Configuration cfg = FreeMarkers.buildConfiguration("classpath:/");
//		Template template = cfg.getTemplate("testTemplate.ftl");
//		String result2 = FreeMarkers.renderTemplate(template, model);
//		System.out.println(result2);
		
//		Map<String, String> model = com.google.common.collect.Maps.newHashMap();
//		model.put("userName", "calvin");
//		String result = FreeMarkers.renderString("hello ${userName} ${r'${userName}'}", model);
//		System.out.println(result);
	}
	public static void getTemplate(String templateName) {
		// TODO Auto-generated method stub
		
	}
	
}