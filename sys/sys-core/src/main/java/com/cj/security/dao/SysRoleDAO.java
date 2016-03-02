package com.cj.security.dao;

import java.util.List;

import com.cj.security.entity.SysMenu;
import com.cj.security.entity.SysResource;
import com.cj.security.entity.SysRole;

public interface SysRoleDAO
{
	public List<SysRole> list();
	public SysRole load(int id);
	public SysRole details(int id);
	public int add(SysRole r);
	
	public boolean deleteById(int id);
	public boolean update(SysRole r);
	
	public SysRole findByRoleName(String roleName);
	public List<SysResource> loadRoleResourcesByRoleName(String roleName);
	
	public List<SysMenu> loadRoleMenusByRoleName(String roleName);
	
}
