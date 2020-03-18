package com.exa.vuespringboot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.exa.vuespringboot.entity.ResponseResult;
import com.exa.vuespringboot.utils.JWTUtil;

public class LoginInterceptor implements HandlerInterceptor{
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(request.getRequestURL().indexOf("login")<0){
			String token = request.getHeader("token");
			if(token==null || token.trim().equals("")){
				response.getWriter().print(ResponseResult.NO_AUTH_CODE);
				return false;
			}
			return JWTUtil.validateJWT(token);
		}
        return true;
    }

}
