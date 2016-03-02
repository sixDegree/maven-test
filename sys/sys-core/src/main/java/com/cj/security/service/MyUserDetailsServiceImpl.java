package com.cj.security.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cj.security.entity.SysUser;

public class MyUserDetailsServiceImpl implements UserDetailsService
{
	
	private SysUserService userService;
	
	public SysUserService getUserService()
	{
		return userService;
	}
	@Inject
	public void setUserService(SysUserService userService)
	{
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException
	{
		System.out.println("MyUserDetailsServiceImpl----------------loadUserByUsername");
		SysUser user=userService.findByAccount(username);
		if(user==null)
		{
			throw new UsernameNotFoundException(username  + "  不存在 ");
		}
		List<GrantedAuthority> glist=userService.loadUserAuthoritiesByAccount(username);
		
		User userDetails=new User(username,user.getPassword(),user.getEnable(),
				true,true,true,glist);
		
		return userDetails;
	}

}
