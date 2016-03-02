package com.cj.vo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class UsersTest
{
private static SessionFactory sf=null;
	
	@BeforeClass
	public static void beforeClass()
	{
		try
		{
			//Configuration cfg=new AnnotationConfiguration().configure();
			Configuration cfg = new Configuration().configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(cfg.getProperties()).buildServiceRegistry();
			sf = cfg.buildSessionFactory(serviceRegistry);
		} 
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void afterClass()
	{
		if(sf!=null)
			sf.close();
	}
	

	@Test
	public void test()
	{
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		Users users=(Users)session.get(Users.class, 1);
		System.out.println(users.getUsername());
		session.getTransaction().commit();
		
	}

}
