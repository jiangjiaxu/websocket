package com.jiang.websocket.entity.bo;

import lombok.Data;

/**
 * @author:jiangjiaxu
 * @date 2021/12/28  22:29
 * @version:V1.0
 * @description:登录返回信息
 */
@Data
public class Result<T> {
	private boolean flag;
	private String message;
	private String token;
	private String username;
}
