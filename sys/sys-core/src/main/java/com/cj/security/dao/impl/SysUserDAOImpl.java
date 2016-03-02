package com.cj.security.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.cj.security.dao.SysUserDAO;
import com.cj.security.entity.SysRole;
import com.cj.security.entity.SysUser;
import com.cj.security.entity.SysUserRole;

@Repository("SysUserDAO")
public class SysUserDAOImpl implements SysUserDAO
{
	private SessionFactory sessionFactory;
	private PasswordEncoder passwordEncoder;
	
	public PasswordEncoder getPasswordEncoder()
	{
		return passwordEncoder;
	}
	@Inject
	public void setPasswordEncoder(PasswordEncoder passwordEncoder)
	{
		this.passwordEncoder = passwordEncoder;
	}

	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	@Inject
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public List<SysUser> list()
	{
		Session session=sessionFactory.getCurrentSession();
		List<SysUser> users= (List<SysUser>)session.createQuery("from SysUser u").list();
		return users;
	}
	
	public SysUser load(int id)
	{
		Session session=sessionFactory.getCurrentSession();
		return (SysUser)session.get(SysUser.class, id);
	}
	
	public SysUser details(int id)
	{
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(SysUser.class)
				.add(Restrictions.eq("id", id))
				.setFetchMode("sysRoles", FetchMode.JOIN);
		return (SysUser)c.uniqueResult();
		
//		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class).add(Restrictions.eq("id", id)).setFetchMode("productDetailsByProperties", FetchMode.JOIN);
//		List list=hibernateTemplate.findByCriteria(criteria);
//		return (Product)list.get(0);
	}
	
	public int add(SysUser u)
	{
		u.setPassword(passwordEncoder.encodePassword(u.getPassword(), u.getAccount()));
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
	public boolean update(SysUser u)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SysUser findByAccount(String account)
	{
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(SysUser.class)
				.add(Restrictions.eq("account", account));
				//.setFetchMode("sysRole", FetchMode.JOIN);
		return (SysUser)c.uniqueResult();
	}

	@Override
	public List<SysRole> loadUserRolesByAccount(String account)
	{
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(SysUser.class)
				.add(Restrictions.eq("account", account))
				//.createCriteria("sysRoles");
				.setFetchMode("sysRoles", FetchMode.JOIN);
		SysUser u= (SysUser)c.uniqueResult();
		if(u!=null)
			return u.getSysRoles();
		else
			return null;
	}
	
}

