package com.yzit.gen.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class CreateBean {

	private Connection connection = null;

	static String url;

	static String username;

	static String password;

	static String rt = "\r\t";

	String SQLTables = "show tables";

	private String method;

	private String argv;

	static String selectStr;

	static String from;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		selectStr = "select ";
		from = " from ";
	}

	public void setMysqlInfo(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Connection getConnection() throws SQLException {

		System.out.println(url + "==url");

		return DriverManager.getConnection(url, username, password);
	}
	//获取表的主键
	public ColumnData getTablePK(String tableName) throws Exception {  
	      Connection conn = getConnection(); 
	      ColumnData columnData = new ColumnData();
	      ResultSet rs = null;  
	      // 适用mysql  
	      rs = conn.getMetaData().getPrimaryKeys(conn.getCatalog().toUpperCase(),  
	              null, tableName.toUpperCase());  
	      // 适用oracle,mysql  
	      // rs =conn.getMetaData().getPrimaryKeys(conn.getCatalog().toUpperCase(),conn.getMetaData().getUserName().toUpperCase(),tableName.toUpperCase());  
	      int i = 0;  
	      while (rs.next()) {  
	          columnData.setColumnName(rs.getString("COLUMN_NAME"));
	          columnData.setColumnComment("主键");
	          columnData.setDataType("Integer");
	      }
	      rs.close();
	      conn.close();
	      return columnData;
	  } 
	//获取所有的键
	public List<ColumnData> getColumnDatas(String tableName)
			throws SQLException {
		String SQLColumns = "select column_name ,data_type,column_comment,0,0,character_maximum_length,is_nullable nullable from information_schema.columns where table_name =  '"
				+ tableName
				+ "' "
				+ "and table_schema =  '"
				+ CodeResourceUtil.DATABASE_NAME + "'";
		
		System.out.println("*******************");
		System.out.println(SQLColumns);
		System.out.println("*******************");
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(SQLColumns);
		List columnList = new ArrayList();
		ResultSet rs = ps.executeQuery();
		StringBuffer str = new StringBuffer();
		StringBuffer getset = new StringBuffer();
		while (rs.next()) {
			String name = rs.getString(1).toLowerCase();
			String type = rs.getString(2);
			String comment = rs.getString(3);
			String precision = rs.getString(4);
			String scale = rs.getString(5);
			String charmaxLength = rs.getString(6) == null ? "" : rs
					.getString(6);
			String nullable = getNullAble(rs.getString(7));
			type = getType(type, precision, scale);

			ColumnData cd = new ColumnData();
			cd.setColumnName(name);
			cd.setDataType(type);
			cd.setColumnType(rs.getString(2));
			cd.setColumnComment(comment);
			cd.setPrecision(precision);
			cd.setScale(scale);
			cd.setCharmaxLength(charmaxLength);
			cd.setNullable(nullable);
			formatFieldClassType(cd);
			columnList.add(cd);
		}
		this.argv = str.toString();
		this.method = getset.toString();
		rs.close();
		ps.close();
		con.close();
		return columnList;
	}
	
	 private void formatFieldClassType(ColumnData columnt)
	  {
	    String fieldType = columnt.getColumnType();
	    String scale = columnt.getScale();

	    if ("N".equals(columnt.getNullable())) {
	      columnt.setOptionType("required:true");
	    }
	    if (("datetime".equals(fieldType)) || ("time".equals(fieldType))) {
	      columnt.setClassType("easyui-datetimebox");
	    } else if ("date".equals(fieldType)) {
	      columnt.setClassType("easyui-datebox");
	    } else if ("int".equals(fieldType)) {
	      columnt.setClassType("easyui-numberbox");
	    } else if ("number".equals(fieldType)) {
	      if ((StringUtils.isNotBlank(scale)) && (Integer.parseInt(scale) > 0)) {
	        columnt.setClassType("easyui-numberbox");
	        if (StringUtils.isNotBlank(columnt.getOptionType()))
	          columnt.setOptionType(columnt.getOptionType() + "," + "precision:2,groupSeparator:','");
	        else
	          columnt.setOptionType("precision:2,groupSeparator:','");
	      }
	      else {
	        columnt.setClassType("easyui-numberbox");
	      }
	    } else if (("float".equals(fieldType)) || ("double".equals(fieldType)) || ("decimal".equals(fieldType))) {
	      columnt.setClassType("easyui-numberbox");
	      if (StringUtils.isNotBlank(columnt.getOptionType()))
	        columnt.setOptionType(columnt.getOptionType() + "," + "precision:2,groupSeparator:','");
	      else
	        columnt.setOptionType("precision:2,groupSeparator:','");
	    }
	    else {
	      columnt.setClassType("easyui-validatebox");
	    }
	  }

	  public String getType(String dataType, String precision, String scale)
	  {
	    dataType = dataType.toLowerCase();
	    if (dataType.contains("char"))
	      dataType = "String";
	    else if (dataType.contains("int"))
	      dataType = "Integer";
	    else if (dataType.contains("float"))
	      dataType = "Float";
	    else if (dataType.contains("double"))
	      dataType = "Double";
	    else if (dataType.contains("number")) {
	      if ((StringUtils.isNotBlank(scale)) && (Integer.parseInt(scale) > 0))
	        dataType = "java.math.BigDecimal";
	      else if ((StringUtils.isNotBlank(precision)) && (Integer.parseInt(precision) > 6))
	        dataType = "Long";
	      else
	        dataType = "Integer";
	    }
	    else if (dataType.contains("decimal"))
//	      dataType = "BigDecimal";
	    	dataType = "Integer";
	    else if (dataType.contains("date"))
	      dataType = "java.util.Date";
	    else if (dataType.contains("datetime"))
	        dataType = "java.util.Date";
	    else if (dataType.contains("time"))
	      dataType = "java.sql.Timestamp";
	    else if (dataType.contains("clob"))
	      dataType = "java.sql.Clob";
	    else {
	      dataType = "java.lang.Object";
	    }
	    return dataType;
	  }
	  
	  public static String getNullAble(String nullable)
	  {
	    if (("YES".equals(nullable)) || ("yes".equals(nullable)) || ("y".equals(nullable)) || ("Y".equals(nullable))) {
	      return "Y";
	    }
	    if (("NO".equals(nullable)) || ("N".equals(nullable)) || ("no".equals(nullable)) || ("n".equals(nullable))) {
	      return "N";
	    }
	    return null;
	  }

	  
	  /***
	   * 获取所有的列的字符串
	   * @param columnList
	   * @return
	   */
	public String getColumnSplit(List<ColumnData> columnList) {
		StringBuffer commonColumns = new StringBuffer();
	    for (ColumnData data : columnList) {
	      commonColumns.append(data.getColumnName() + ",");
	    }
	    
	    System.out.println("-------------commonColumns========"+commonColumns.length());
	   if(commonColumns.length() > 0 ) {
		   return commonColumns.delete(commonColumns.length() - 1, commonColumns.length()).toString();   
	   }
	   	return commonColumns.toString();
	}
}
