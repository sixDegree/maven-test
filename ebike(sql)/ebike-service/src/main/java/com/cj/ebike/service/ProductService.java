package com.cj.ebike.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cj.ebike.dao.ProductDAO;
import com.cj.ebike.entity.Product;

@Service("productService")
public class ProductService
{
	private ProductDAO productDAO;

	public ProductDAO getProductDAO()
	{
		return productDAO;
	}

	@Inject
	public void setProductDAO(ProductDAO productDAO)
	{
		this.productDAO = productDAO;
	}
	
	public List<Product> list()
	{
		List<Product> products=null;
		products=productDAO.list();
		return products;
	}
	
	public Product load(int id)
	{
		return productDAO.load(id);
	}
	
	public Product details(int id)
	{
		return productDAO.details(id);
	}
	
	public int insert(Product p)
	{
		return productDAO.insert(p);
	}
}
