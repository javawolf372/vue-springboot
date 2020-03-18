package com.exa.vuespringboot.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exa.vuespringboot.entity.ResponseResult;
import com.exa.vuespringboot.utils.JWTUtil;

@RestController
@RequestMapping(value="common")
public class LoginController {
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ResponseResult login(@RequestBody Map<String, String> param){
		String username = param.get("username");
		String password = param.get("password");
		if("admin".equals(username) && "123".equals(password)){
			Map<String, Object> data = new HashMap<>();
			data.put("token", JWTUtil.createJWT(UUID.randomUUID().toString()));
			return new ResponseResult(ResponseResult.SUCCESS_CODE, "sucess", data);
		}else{
			return new ResponseResult(ResponseResult.FAIL_CODE, "用户名或者密码错误！");
		}
	}
	
	@RequestMapping(value="test")
	public ResponseResult test(){
		return new ResponseResult(ResponseResult.SUCCESS_CODE, "sucess"); 
	}
}
