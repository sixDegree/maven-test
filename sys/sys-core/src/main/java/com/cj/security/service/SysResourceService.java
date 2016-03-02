package com.cj.security.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.stereotype.Service;

import com.cj.security.dao.SysResourceDAO;
import com.cj.security.entity.SysResource;

@Service("sysResourceService")
public class SysResourceService
{
	private SysResourceDAO sysResourceDAO;

	public SysResourceDAO getSysResourceDAO()
	{
		return sysResourceDAO;
	}

	@Inject
	public void setSysResourceDAO(SysResourceDAO sysResourceDAO)
	{
		this.sysResourceDAO = sysResourceDAO;
	}
	
	public List<SysResource> list()
	{
		return sysResourceDAO.list();
	}
	
	public int add(SysResource u)
	{
		return sysResourceDAO.add(u);
	}
	
	public SysResource details(int id)
	{
		return sysResourceDAO.details(id);
	}

	public SysResource load(int id)
	{
		return sysResourceDAO.load(id);
	}
	
	public Map<String, Collection<ConfigAttribute>> loadAllResourceRoles()
	{
		return sysResourceDAO.loadAllResourceRoles();
	}
	
	public List<SysResource> listDetails()
	{
		return sysResourceDAO.listDetails();
	}
	
	public List<SysResource> search(SysResource resourceExample)
	{
		return sysResourceDAO.search(resourceExample);
	}
}

