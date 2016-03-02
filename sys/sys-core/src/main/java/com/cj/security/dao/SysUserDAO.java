package com.cj.security.dao;

import java.util.List;

import com.cj.security.entity.SysRole;
import com.cj.security.entity.SysUser;

public interface SysUserDAO
{
	public List<SysUser> list();
	public SysUser load(int id);
	public SysUser details(int id);
	public int add(SysUser u);
	
	public boolean deleteById(int id);
	public boolean update(SysUser u);
	
	public SysUser findByAccount(String account);
	public List<SysRole> loadUserRolesByAccount(String account);
	
	//public List<GrantedAuthority> loadUserAuthoritiesByAccount(String account);
}
