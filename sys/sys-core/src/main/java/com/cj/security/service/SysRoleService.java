package com.cj.security.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cj.security.dao.SysRoleDAO;
import com.cj.security.entity.SysMenu;
import com.cj.security.entity.SysResource;
import com.cj.security.entity.SysRole;

@Service("sysRoleService")
public class SysRoleService
{
	private SysRoleDAO sysRoleDAO;

	public SysRoleDAO getSysRoleDAO()
	{
		return sysRoleDAO;
	}

	@Inject
	public void setSysRoleDAO(SysRoleDAO sysRoleDAO)
	{
		this.sysRoleDAO = sysRoleDAO;
	}
	
	public List<SysRole> list()
	{
		return sysRoleDAO.list();
	}
	
	public SysRole findByRoleName(String roleName)
	{
		return sysRoleDAO.findByRoleName(roleName);
	}
	
	public int add(SysRole r)
	{
		return sysRoleDAO.add(r);
	}
	
	public SysRole details(int id)
	{
		return sysRoleDAO.details(id);
	}
	
	public List<SysResource> loadRoleResourcesByRoleName(String roleName)
	{
		return sysRoleDAO.loadRoleResourcesByRoleName(roleName);
	}
	
	public List<SysMenu> loadRoleMenusByRoleName(String roleName)
	{
		return sysRoleDAO.loadRoleMenusByRoleName(roleName);
	}
}

