package com.jiang.websocket.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiang.websocket.entity.bo.ResultMessage;

/**
 * @author:jiangjiaxu
 * @date 2021/12/28  22:30
 * @version:V1.0
 * @description:封装消息的工具类
 */
public class MessageUtils {
	public static String getMessage(boolean isSystemMessage, String fromName, Object message) {
		ResultMessage result=new ResultMessage();
		result.setSystem(isSystemMessage);
		result.setMessage(message);
		if(fromName!=null){
			result.setFromName(fromName);
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			//转成json
			return mapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
