package com.cj.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cj.security.service.SysUserService;
import com.cj.util.ListUtils;
import com.cj.vo.SysUserVo;

@Controller
@RequestMapping("/user")
public class UserController
{
	
	private SysUserService sysUserService;
	
	public SysUserService getSysUserService()
	{
		return sysUserService;
	}
	
	@Inject
	public void setSysUserService(SysUserService sysUserService)
	{
		this.sysUserService = sysUserService;
	}
	

	@RequestMapping(value={"test"})
	public String test(Model model)
	{
		System.out.println("Test---------");
		return "test";
	}
	
	@RequestMapping(value={"/","/list"},method=RequestMethod.GET)
	@ResponseBody
	public Object list(Model model)
	{
		System.out.println("User List-----------------");
		
		//return sysUserService.list();
		//return ResponseUtils.sendList(sysUserService.list());
		return ListUtils.transform(sysUserService.list(), "id","account","password","enable");
		//return ListUtils.transform(sysUserService.list(), SysUserVo.class);
	}
	
	

}
