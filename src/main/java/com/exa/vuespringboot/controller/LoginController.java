package com.exa.vuespringboot.controller;

import com.exa.vuespringboot.dao.IUserMapper;
import com.exa.vuespringboot.entity.*;
import com.exa.vuespringboot.service.IAuthorityService;
import com.exa.vuespringboot.utils.JWTUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping(value="common")
public class LoginController {

	@Resource
	private IUserMapper userMapper;

	@Resource
	private IAuthorityService authorityService;
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ResponseResult login(@RequestBody Map<String, String> param){
		String username = param.get("username");
		String password = param.get("password");
		Map<String, Object> loginMap = new HashMap<>();
		loginMap.put("loginName", username);
		loginMap.put("password", password);
		try {
			UserEntity userEntity = userMapper.getUserByLoginNameAndPassword(loginMap);
			if (userEntity!=null){
				Map<String, Object> data = new HashMap<>();
				data.put("token", JWTUtil.createJWT(UUID.randomUUID().toString()));
				data.put("menuData", listMenuByPidAndUserId(2l, userEntity.getId()));
				return new ResponseResult(ResponseResult.SUCCESS_CODE, "sucess", data);
			}else{
				return new ResponseResult(ResponseResult.FAIL_CODE, "用户名或者密码错误！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseResult(ResponseResult.FAIL_CODE, "系统内部错误，登录失败！");
		}
	}

	// 根据user和系统权限pid查询权限下的菜单
	private Map<String, Object> listMenuByPidAndUserId(Long pid, Integer userId) {
		List<MenuTreeEntity> value = new ArrayList();
		List<AuthorityEntity> listmenu = authorityService.getAuthorityDataById(userId, pid);
		if(listmenu!=null &&listmenu.size()>0){
			//排序
			Collections.sort(listmenu, new Comparator<AuthorityEntity>() {
				public int compare(AuthorityEntity arg0, AuthorityEntity arg1) {
					return arg0.getId().compareTo(arg1.getId());
				}
			});
			for (int i = 0; i < listmenu.size(); i++) {
				AuthorityEntity authorityEntity = listmenu.get(i);
				if (authorityEntity.getParentId() == pid) {
					MenuTreeEntity mt = new MenuTreeEntity();
					mt.setId(authorityEntity.getId());
					mt.setParentTitle(authorityEntity.getTitle());
					mt.setSortNum(authorityEntity.getSortNumber().intValue());
					mt.setIcon(authorityEntity.getIcon());
					List<LowerMenuEntiry> lms = new ArrayList<>();
					for (AuthorityEntity ae : listmenu) {
						if (ae.getParentId().equals(authorityEntity.getId())) {
							LowerMenuEntiry lm = new LowerMenuEntiry();
							lm.setId(ae.getId());
							lm.setUrl(ae.getUrl());
							lm.setTitle(ae.getTitle());
							lm.setJsMethod(ae.getJsMethod());
							lm.setSortNum(ae.getSortNumber().intValue());
							lms.add(lm);
						}
					}
					mt.setLowerMenu(lms);
					value.add(mt);
				}
			}
		}
		//排序
		Collections.sort(value, new Comparator<MenuTreeEntity>() {
			@Override
			public int compare(MenuTreeEntity o1, MenuTreeEntity o2) {
				return o1.getSortNum().compareTo(o2.getSortNum());
			}
		});
		AuthorityEntity authorityEntity = authorityService.queryAuthorityById(pid);
		Map<String, Object> result = new HashMap<>();
		result.put("authInfo", authorityEntity);
		result.put("childAuth", value);
		return result;
	}
	
	@RequestMapping(value="test")
	public ResponseResult test(){
		return new ResponseResult(ResponseResult.SUCCESS_CODE, "sucess"); 
	}
}
