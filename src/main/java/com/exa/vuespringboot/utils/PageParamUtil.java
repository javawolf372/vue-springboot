package com.exa.vuespringboot.utils;

import java.util.HashMap;
import java.util.Map;

public class PageParamUtil {

    private static final String DEFAULT_CURR_PAGE_PARAM_NAME = "currPage";
    private static final String DEFAULT_PAGE_SIZE_PARAM_NAME = "size";

    //将查询分页的参数封装一下 当前页数和每页页数默认为currPage、size则调用此方法，反之调用下面重载方法
    public static Map<String, Object> formate(Map<String, Object> param){
        String currPageParamName = DEFAULT_CURR_PAGE_PARAM_NAME;
        String pageSizeParamName = DEFAULT_PAGE_SIZE_PARAM_NAME;
        return formate(param, currPageParamName, pageSizeParamName);
    }

    //非默认参数名
    public static Map<String, Object> formate(Map<String, Object> param, String currPageParamName, String pageSizeParamName){
        Map<String, Object> newMap = new HashMap<>();
        Integer currPage = null;
        Integer size = null;
        try {
            currPage = Integer.parseInt(param.get(currPageParamName)+"");
            size = Integer.parseInt(param.get(pageSizeParamName)+"");
            Integer limitStart = (currPage-1) * size;
            Integer limitEnd = currPage * size;
            newMap.put("limitStart", limitStart);
            newMap.put("limitEnd", limitEnd);
            for(String key : param.keySet()){
                if (!currPageParamName.equals(key) && !pageSizeParamName.equals(key)){
                    newMap.put(key, param.get(key));
                }
            }
        } catch (NumberFormatException e) {
            try {
                throw new Exception("在参数Map【"+param+"】中找不到对应的参数名：【"+currPageParamName+"】【"+pageSizeParamName+"】");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            newMap.put("limitStart", 0);
            newMap.put("limitEnd", 0);
        }
        return newMap;
    }
}
