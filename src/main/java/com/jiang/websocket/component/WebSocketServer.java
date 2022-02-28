package com.jiang.websocket.component;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:jiangjiaxu
 * @date 2022/01/25  14:52
 * @version:V1.0
 * @description:webSocket服务
 */
@ServerEndpoint(value = "/imserver/{username}")
@Component
@Slf4j
public class WebSocketServer {

	/**
	 * 记录当前在线用户数
	 */
	private static final Map<String, Session> SESSION_MAP=new ConcurrentHashMap<>();

	/**
	 * 连接成功调用的方法
	 * @param session
	 * @param username
	 */
	@OnOpen
	public void onOpen(Session session, @PathParam("username") String username){
		SESSION_MAP.put(username,session);
		log.info("有新用户加入，username={}，当前在线人数:{}",username,SESSION_MAP.size());
		JSONObject result = new JSONObject();
		JSONArray array = new JSONArray();
		result.set("users",array);
		for(Object key : SESSION_MAP.keySet()){
			JSONObject jsonObject = new JSONObject();
			//把所有的用户名放入users这个数据json中
			//{"username":"a","username":"b"}
			jsonObject.set("username",key);
			array.add(jsonObject);
		}
		//最终结果,注意多了中间的{}，是一个个的对象了
		//{"users":[{"username":"a"},{"username":"b"}]}
		sendAllMessage(JSONUtil.toJsonStr(result));
	}

	/**
	 * 连接关闭调用的方法
	 * @param session
	 * @param username
	 */
	@OnClose
	public void onClose(Session session, @PathParam("username") String username){
		SESSION_MAP.remove(username);
		log.info("有一连接关闭，移除username={}，当前在线人数：{}",username,SESSION_MAP.size());
	}  

	/**
	 * 收到客户端消息调用的方法
	 * 后台收到消息
	 * @param message
	 * @param session
	 * @param username
	 */
	@OnMessage
	public void onMessage(String message,Session session, @PathParam("username") String username){
		log.info("服务端收到用户username={}的消息{}",username,message);
		JSONObject obj = JSONUtil.parseObj(message);
		//{"to":"a","text":"聊天文本"}
		String toUsername= obj.getStr("to");
		String text=obj.getStr("text");
		Session toSession=SESSION_MAP.get(toUsername);
		if(toSession!=null){
			JSONObject jsonObject = new JSONObject();
			jsonObject.set("from",username);
			jsonObject.set("text",text);
			this.sendAllMessage(jsonObject.toString(),toSession);
			log.info("发送给用户username={}，消息:{}",toUsername,jsonObject.toString());
		}else {
			log.info("发送失败，未找到用户{}的session",toUsername);
		}
	}

	@OnError
	public void onError(Session session,Throwable error){
		log.error("发送失败");
		error.printStackTrace();
	}

	/**
	 * 服务端发送给客户端
	 * @param message
	 * @param toSession
	 */
	private void sendAllMessage(String message,Session toSession){
		try {
			log.info("服务端发送给用户{},消息为{}",toSession.getId(),message);
			//发送到session
			toSession.getBasicRemote().sendText(message);
		}catch (Exception e){
			log.error("服务端发送客户端失败",e);
		}
	}

	/**
	 * 服务端群发给客户端
	 * @param message
	 */
	private void sendAllMessage(String message){
		try {
			for(Session session:SESSION_MAP.values()){
				log.info("服务端发送给客户端[{}]，消息{}",session.getId(),message);
				session.getBasicRemote().sendText(message);
			}
		}catch (Exception e){
			log.error("服务端发送客户端失败",e);
		}
	}
}
