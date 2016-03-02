package com.cj.security.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;

import com.cj.security.entity.SysResource;

public interface SysResourceDAO
{
	public List<SysResource> list();
	public SysResource load(int id);
	public SysResource details(int id);
	public int add(SysResource u);
	
	public boolean deleteById(int id);
	public boolean update(SysResource r);
	
	public List<SysResource> listDetails();
	public Map<String, Collection<ConfigAttribute>> loadAllResourceRoles();
	public List<SysResource> search(SysResource resourceExample);
}

