package com.common.utils;

import java.lang.reflect.Field;
import java.sql.Timestamp;
public class ReflectionUtils {
	
	public static String getInsertFields(Object object) {
		if (object==null) {
			return null;
		}
		Class classInf=object.getClass();
		//获取当前类
		Field[] declaredFields =classInf.getDeclaredFields();

		return getField(declaredFields);
	}
	
	
	public static String fatherAndSon(Object object) {
		if (object==null) {
			return null;
		}
		Class classInf=object.getClass();
		//获取当前类
		Field[] declaredFields =classInf.getDeclaredFields();
		String son=getField(declaredFields);
		//获取父属性
		Field[] fatherDeclaredFields =classInf.getSuperclass().getDeclaredFields();
		
		String father=getField(fatherDeclaredFields);
		if (!father.equals("")) {
			return son+","+father;
		}
		return son;
	}
	
	
	public static String getField(Field[] declaredFields) {
		
		StringBuilder sfBuilder = new StringBuilder();
		for (int i = 0; i < declaredFields.length; i++) {
			sfBuilder.append(declaredFields[i].getName());
			if (i<declaredFields.length-1) {
				sfBuilder.append(",");
			}
		}
		return sfBuilder.toString();
	}
	
	
	public static String getInsertFieldsValue(Object object) {
		if (object==null) {
			return null;
		}
		Class classInf=object.getClass();
		//获取当前类
		Field[] declaredFields =classInf.getDeclaredFields();

		return getFieldValue(object,declaredFields);
	}
	
	public static String fatherAndSonValue(Object object) {
		if (object==null) {
			return null;
		}
		Class classInf=object.getClass();
		//获取当前类
		Field[] declaredFields =classInf.getDeclaredFields();
		String son=getFieldValue(object,declaredFields);
		//获取父属性
		Field[] fatherDeclaredFields =classInf.getSuperclass().getDeclaredFields();
		
		String father=getFieldValue(object,fatherDeclaredFields);
		if (!father.equals("")) {
			return son+","+father;
		}
		return son;
	}
	
	
	public static String getFieldValue(Object object,Field[] declaredFields) {
		
		StringBuilder sfBuilder = new StringBuilder();
		
		for (int i = 0; i < declaredFields.length; i++) {
			try {
				declaredFields[i].setAccessible(true);
				
				if (declaredFields[i].get(object)!=null && declaredFields[i].get(object) instanceof String||declaredFields[i].get(object) instanceof Timestamp) {
					sfBuilder.append("'"+declaredFields[i].get(object)+"'");
				}else {
					sfBuilder.append(declaredFields[i].get(object));
				}
				
				if (i<declaredFields.length-1) {
					sfBuilder.append(",");
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return sfBuilder.toString();
	}
	
	

	

}
