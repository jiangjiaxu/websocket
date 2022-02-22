package com.jiang.websocket.entity.bo;

import lombok.Data;

/**
 * @author:jiangjiaxu
 * @date 2021/12/28  22:28
 * @version:V1.0
 * @description:服务端给客户端发送消息
 */
@Data
public class ResultMessage {
	//如果为true，系统消息，false推送给某一个人
	private boolean isSystem;
	private String fromName;
	private Object message;
}
