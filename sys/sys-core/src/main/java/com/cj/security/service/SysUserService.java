package com.cj.security.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.cj.security.dao.SysUserDAO;
import com.cj.security.entity.SysRole;
import com.cj.security.entity.SysUser;

@Service("sysUserService")
public class SysUserService
{
	private SysUserDAO sysUserDAO;

	public SysUserDAO getSysUserDAO()
	{
		return sysUserDAO;
	}

	@Inject
	public void setSysUserDAO(SysUserDAO sysUserDAO)
	{
		this.sysUserDAO = sysUserDAO;
	}
	
	public List<SysUser> list()
	{
		return sysUserDAO.list();
	}
	
	public SysUser findByAccount(String account)
	{
		return sysUserDAO.findByAccount(account);
	}
	
	public int add(SysUser u)
	{
		return sysUserDAO.add(u);
	}
	
	public SysUser details(int id)
	{
		return sysUserDAO.details(id);
	}
	
	public List<GrantedAuthority> loadUserAuthoritiesByAccount(String account)
	{
		List<SysRole> sysRoles=sysUserDAO.loadUserRolesByAccount(account);
		if(sysRoles==null || sysRoles.size()==0)
			return null;
		
		List<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority s=null;
		for(SysRole r: sysRoles)
		{
			s=new SimpleGrantedAuthority(r.getName());
			grantedAuthorities.add(s);
		}
		return grantedAuthorities;
	}
}
