package com.exa.vuespringboot.controller;

import com.exa.vuespringboot.entity.*;
import com.exa.vuespringboot.service.IDemoService;
import com.exa.vuespringboot.utils.JWTUtil;
import com.exa.vuespringboot.utils.PageParamUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping(value="demo")
public class DemoController {

	@Resource
	private IDemoService demoService;
	
	@RequestMapping(value="list", method=RequestMethod.POST)
	public ResponseResult login(@RequestBody Map<String, Object> param){
		Map<String, Object> resposeData = new HashMap<>();
		resposeData.put("list", demoService.list(PageParamUtil.formate(param)));
		resposeData.put("total", demoService.count(PageParamUtil.formate(param)));
		return new ResponseResult(ResponseResult.SUCCESS_CODE, "sucess", resposeData);
	}

	@RequestMapping(value="insert")
	public ResponseResult insert(@RequestBody DemoEntity demo){
		demoService.insert(demo);
		return new ResponseResult(ResponseResult.SUCCESS_CODE, "sucess");
	}

	@RequestMapping(value="update")
	public ResponseResult update(@RequestBody DemoEntity demo){
		demoService.update(demo);
		return new ResponseResult(ResponseResult.SUCCESS_CODE, "sucess");
	}

	@RequestMapping(value="delete")
	public ResponseResult delete(@RequestParam Integer id){
		demoService.delete(id);
		return new ResponseResult(ResponseResult.SUCCESS_CODE, "sucess");
	}
}
