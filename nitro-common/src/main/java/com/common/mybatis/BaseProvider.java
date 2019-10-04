package com.common.mybatis;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.common.utils.ReflectionUtils;

public class BaseProvider {
	
	public String save(Map<String, String> map) {
		String table = map.get("table");

		Object object = map.get("oj");
		
		SQL sql = new SQL() {
			{
				INSERT_INTO(table);
				VALUES(ReflectionUtils.getInsertFields(object), ReflectionUtils.getInsertFieldsValue(object));
			}
		};
		System.out.println(sql.toString());
		return sql.toString();
	}

}
