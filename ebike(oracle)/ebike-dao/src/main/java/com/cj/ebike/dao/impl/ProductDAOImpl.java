package com.cj.ebike.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cj.ebike.dao.ProductDAO;
import com.cj.ebike.entity.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO
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

	public List<Product> list()
	{
		Session session=sessionFactory.getCurrentSession();
		List<Product> products= (List<Product>)session.createQuery("from Product p").list();
		return products;
	}
	
	public Product load(int id)
	{
		Session session=sessionFactory.getCurrentSession();
		return (Product)session.get(Product.class, id);
	}
	
	public Product details(int id)
	{
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Product.class)
				.add(Restrictions.eq("id", id))
				//.createCriteria("productDetailsByProperties")
				.setFetchMode("productDetailsByProperties", FetchMode.JOIN);
		return (Product)c.uniqueResult();
		
//		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class).add(Restrictions.eq("id", id)).setFetchMode("productDetailsByProperties", FetchMode.JOIN);
//		List list=hibernateTemplate.findByCriteria(criteria);
//		return (Product)list.get(0);
	}
	
	public int insert(Product p)
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(p);
		return p.getId();
	}
}

