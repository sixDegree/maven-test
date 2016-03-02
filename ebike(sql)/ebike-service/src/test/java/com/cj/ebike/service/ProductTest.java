package com.cj.ebike.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.cj.ebike.entity.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
@TransactionConfiguration(transactionManager="txManager",defaultRollback=true)
@Transactional
public class ProductTest
{

	@Inject
	private ProductService productService;
	
	private List<Product> intial()
	{
		List<Product> result=new ArrayList<Product>();
		
		Product parent=new Product();
		parent.setProductNameEn("GTA");
		parent.setProductNameGm("GTA");
		parent.setParentId(0);
		parent.setIsShow(1);
		parent.setCreateDate(new Date());
		productService.insert(parent);
		result.add(parent);
		
		Product p=new Product();
		p.setProductNameEn("GTA Light 2012");
		p.setProductNameGm("GTA Light 2012");
		p.setParentId(parent.getId());
		p.setIsShow(1);
		p.setImageUrl("123.png");
		p.setDescEn("Hello");
		p.setDescGm("Hi");
		p.setCreateDate(new Date());
		productService.insert(p);
		result.add(p);
		
		p=new Product();
		p.setProductNameEn("GTA Light 2013");
		p.setProductNameGm("GTA Light 2013");
		p.setParentId(parent.getId());
		p.setIsShow(1);
		p.setImageUrl("234.png");
		p.setDescEn("World");
		p.setDescGm("Wa");
		p.setCreateDate(new Date());
		productService.insert(p);
		result.add(p);
		
		return result;
	}
	
	@Test
	public void testInsert()
	{
		List<Product> productsOld=productService.list();
		List<Product> products=intial();
		List<Product> productsNew=productService.list();

		for(Product p:products)
		{
			System.out.println(p.getId());
		}
		Assert.assertEquals(productsOld.size()+products.size(), productsNew.size());
	}
	
	@Test
	public void testLoad()
	{
		List<Product> products=intial();
		
		for(Product p:products)
		{
			Assert.assertTrue(p.getId()!=0);
			Assert.assertNotNull(productService.load(p.getId()));
		}
	}
	
	@Test
	public void testDetails()
	{
		List<Product> products=intial();
		
		Product product=null;
		for(Product p:products)
		{
			product=productService.details(p.getId());
			Assert.assertSame(p, product);
		}
	}
	
}
