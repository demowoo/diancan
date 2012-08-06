package com.diancan.util.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.diancan.util.JsonUtil;
import com.google.gson.Gson;

@Component("jsonUtil")
public class JsonUtilImpl implements JsonUtil{
	
	final static Logger logger = LoggerFactory.getLogger(JsonUtilImpl.class);
	
	final static private Gson gson = new Gson();
//	private ObjectMapper mapper = new ObjectMapper();
//	
//	public String toJsonString(Object obj){
//		try {
//			return mapper.writeValueAsString(obj);
//		} catch (JsonGenerationException e) {
//			logger.error("对象转换成Json字符串出错", e);
//		} catch (JsonMappingException e) {
//			logger.error("对象转换成Json字符串出错", e);
//		} catch (IOException e) {
//			logger.error("对象转换成Json字符串出错", e);
//		}
//		return "";
//	}
	
	@Override
	public String toJsonString(Object obj){
		return gson.toJson(obj);
	}

}
