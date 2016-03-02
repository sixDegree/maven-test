package com.cj.security.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Repository;

import com.cj.security.dao.SysResourceDAO;
import com.cj.security.entity.SysResource;

@Repository("sysResourceDAO")
public class SysResourceDAOImpl implements SysResourceDAO
{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	@Inject
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public List<SysResource> list()
	{
		Session session=sessionFactory.getCurrentSession();
		List<SysResource> resources= (List<SysResource>)session.createQuery("from SysResource r").list();
		return resources;
	}

	@Override
	public SysResource load(int id)
	{
		Session session=sessionFactory.getCurrentSession();
		return (SysResource)session.get(SysResource.class, id);
	}

	@Override
	public SysResource details(int id)
	{
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(SysResource.class)
				.add(Restrictions.eq("id", id))
				.setFetchMode("sysRoles", FetchMode.JOIN);
		return (SysResource)c.uniqueResult();
	}

	@Override
	public int add(SysResource u)
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(u);
		return u.getId();
	}

	@Override
	public boolean deleteById(int id)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(SysResource r)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SysResource> listDetails()
	{
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(SysResource.class)
				.setFetchMode("sysRoles", FetchMode.JOIN);
		return (List<SysResource>)c.list();
	}
	
	@Override
	public Map<String, Collection<ConfigAttribute>> loadAllResourceRoles()
	{
		Map<String, Collection<ConfigAttribute>> resourceMap=new HashMap<String, Collection<ConfigAttribute>>();
		
		Session session=sessionFactory.getCurrentSession();

		Query q=session.createQuery("select res.target,r.name from SysResource res left join res.sysRoles r ");
		List<Object[]> list=q.list();
		
		for(Object[] obj : list)
		{
			if(resourceMap.containsKey(obj[0]))
			{
				resourceMap.get(obj[0]).add(new SecurityConfig(obj[1].toString()));
			}
			else
			{
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();  
				configAttributes.add(new SecurityConfig(obj[1].toString()));
				resourceMap.put(obj[0].toString(), configAttributes);
			}
		}
		
		/*Criteria c=session.createCriteria(SysResource.class)
				.setFetchMode("sysRoles", FetchMode.JOIN);
		List<SysResource> resources=(List<SysResource>)c.list();
		Collection<ConfigAttribute> configAttributes=null;
		for(SysResource res:resources)
		{
			configAttributes = new ArrayList<ConfigAttribute>();  
			for(SysRole role:res.getSysRoles())
			{
				configAttributes.add(new SecurityConfig(role.getName()));
			}
			resourceMap.put(res.getTarget(), configAttributes);	
		}*/
		
		return resourceMap;
	}

	public List<SysResource> search(Example example)
	{
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(SysResource.class)
			.add(example);
		return (List<SysResource>)c.list();
	}
	
	public List<SysResource> search(SysResource resourceExample)
	{
		Example exsample=Example.create(resourceExample)
							.ignoreCase().enableLike();
		return search(exsample);
	}
}
