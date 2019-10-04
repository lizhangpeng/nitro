package com.common.api;

import java.util.HashMap;
import java.util.Map;
import com.common.api.constants.BaseApiConstants;

public class BaseApiService implements BaseApiConstants {
	
	public static Map<String, Object> setResutError(){
		return setResutr(HTTP_500_CODE,HTTP_ERROR_MSG,null);
	}
	
    
    public static Map<String, Object> setResutSuccser(){
    	return setResutr(HTTP_200_CODE,HTTP_SUCCER_MSG,null);
	}
    
    public static Map<String, Object> setResutSuccser(String msg){
    	return setResutr(HTTP_200_CODE,msg,null);
	}
    
    
    
    public static Map<String, Object> setResutSuccserData(Object data){
    	return setResutr(HTTP_200_CODE,HTTP_SUCCER_MSG,data);
	}
    
    public static Map<String, Object> setResutr(Integer code,String msg,Object data){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(HTTP_CODE, code);
		result.put(HTTP_MSG, msg);
		if (data!=null) {
			result.put(HTTP_DATA, data);
		}
		return result;
	}


}
