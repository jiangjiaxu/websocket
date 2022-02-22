package com.jiang.websocket.entity.bo;

import lombok.Data;

/**
 * @author:jiangjiaxu
 * @date 2021/12/28  21:59
 * @version:V1.0
 * @description:浏览器发送给服务器的websocket数据
 */
@Data
public class Message {
	private String toName;
	private String message;
}
