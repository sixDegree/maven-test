package com.cj.security.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cj.security.dao.SysRoleDAO;
import com.cj.security.entity.SysMenu;
import com.cj.security.entity.SysResource;
import com.cj.security.entity.SysRole;

@Repository("SysRoleDAO")
public class SysRoleDAOImpl implements SysRoleDAO
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
	
	public List<SysRole> list()
	{
		Session session=sessionFactory.getCurrentSession();
		List<SysRole> users= (List<SysRole>)session.createQuery("from SysRole u").list();
		return users;
	}
	
	public SysRole load(int id)
	{
		Session session=sessionFactory.getCurrentSession();
		return (SysRole)session.get(SysRole.class, id);
	}
	
	public SysRole details(int id)
	{
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(SysRole.class)
				.add(Restrictions.eq("id", id))
				.setFetchMode("sysUsers", FetchMode.JOIN);
		return (SysRole)c.uniqueResult();
		
//		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class).add(Restrictions.eq("id", id)).setFetchMode("productDetailsByProperties", FetchMode.JOIN);
//		List list=hibernateTemplate.findByCriteria(criteria);
//		return (Product)list.get(0);
	}
	
	public int add(SysRole u)
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
	public boolean update(SysRole r)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SysRole findByRoleName(String roleName)
	{
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(SysRole.class)
				.add(Restrictions.eq("name", roleName));
				//.setFetchMode("sysRole", FetchMode.JOIN);
		return (SysRole)c.uniqueResult();
	}

	@Override
	public List<SysResource> loadRoleResourcesByRoleName(String roleName)
	{
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(SysRole.class)
				.add(Restrictions.eq("name", roleName))
				.setFetchMode("sysResources", FetchMode.JOIN);
		SysRole u= (SysRole)c.uniqueResult();
		if(u!=null)
			return u.getSysResources();
		else
			return null;
	}

	@Override
	public List<SysMenu> loadRoleMenusByRoleName(String roleName)
	{
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(SysRole.class)
				.add(Restrictions.eq("name", roleName))
				.setFetchMode("sysMenus", FetchMode.JOIN);
		SysRole u= (SysRole)c.uniqueResult();
		if(u!=null)
			return u.getSysMenus();
		else
			return null;
	}

}
