package com.exa.vuespringboot.interceptor;

import com.exa.vuespringboot.entity.ResponseResult;
import com.exa.vuespringboot.utils.JWTUtil;
import com.exa.vuespringboot.utils.PowerCacheUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class UserAuthorityInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthorityInterceptor.class);

    @Resource
    private PowerCacheUtil powerCacheUtil;

    private static List<String> exceptionUrlList = null; //存放例外的url集合

    static {
        exceptionUrlList = new ArrayList<>();
        exceptionUrlList.add("login");
        exceptionUrlList.add("logout");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        String token = request.getHeader("token");
        if (isException(url) || isAuthority(url, token)) {
            logger.info("已通过(" + url + ")");
            return true;
        } else {
            logger.info("已拦截(" + url + ")");
            response.getWriter().print(ResponseResult.FAIL_CODE);
            return false;
        }
    }

    /**
     * 是否为例外url
     *
     * @param url
     * @return
     */
    private Boolean isException(String url) {
        for (String exception : exceptionUrlList) {
            if (url.indexOf(exception) > -1)
                return true;
        }
        return false;
    }

    /**
     * 是否有权限
     *
     * @param url
     * @return
     */
    private Boolean isAuthority(String url, String token) throws Exception {
        long userId = Long.parseLong(JWTUtil.parseJWT(token).get("userId")+"");
        List<String> urls = powerCacheUtil.getUserUrlAuthority(userId);
        for (String authority : urls) {
            if (authority.indexOf(url) > -1)
                return true;
        }
        return false;
    }

}
