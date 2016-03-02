package com.cj.ebike.dao;

import java.util.List;

import com.cj.ebike.entity.Product;

public interface ProductDAO
{
	public List<Product> list();
	public Product load(int id);
	public Product details(int id);
	
	public int insert(Product p);
}
