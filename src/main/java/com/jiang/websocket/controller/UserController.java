package com.jiang.websocket.controller;


import com.jiang.websocket.entity.bo.Result;
import com.jiang.websocket.entity.bo.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


/**
 * @author:jiangjiaxu
 * @date 2021/12/28  22:44
 * @version:V1.0
 * @description:登录控制器
 */
@RestController

public class UserController {

	@PostMapping("/login")
	public Result login(@RequestBody User user, HttpSession session){
		Result result = new Result();
//		if(user !=null && "123".equals(user.getPassword())){
			result.setFlag(true);
			result.setUsername(user.getUsername());
			result.setToken("aaaaa");
//		}else{
//			 result.setFlag(false);
//			result.setMessage("登陆失败");
//		}
		return result;
	}

}
