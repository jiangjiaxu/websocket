package com.jiang.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.server.ServerEndpoint;

/**
 * @author:jiangjiaxu
 * @date 2022/01/25  14:49
 * @version:V1.0
 * @description:
 */
@Configuration
public class WebSocketConfig{

	/**
	 * 注入一个ServerEndpointExporter,该Bean会自动注册使用
	 * @ServerEndpoint注解声明的websocket endpoint
	 * @return
	 */
	@Bean
	public ServerEndpointExporter serverEndpointExporter(){
		return new ServerEndpointExporter();
	}
}
