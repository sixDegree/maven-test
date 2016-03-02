package com.cj.ebike.entity;

// Generated 2012-12-4 14:02:03 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PropertyType generated by hbm2java
 */
@Entity
public class PropertyType implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private int id;
	private String propertyNameEn;
	private String propertyNameGm;
	private Date createDate;
	private Set<ProductDetailsByProperty> productDetailsByProperties = new HashSet<ProductDetailsByProperty>(
			0);

	public PropertyType()
	{
	}

	public PropertyType(int id)
	{
		this.id = id;
	}

	public PropertyType(int id, String propertyNameEn,
			String propertyNameGm, Date createDate,
			Set<ProductDetailsByProperty> productDetailsByProperties)
	{
		this.id = id;
		this.propertyNameEn = propertyNameEn;
		this.propertyNameGm = propertyNameGm;
		this.createDate = createDate;
		this.productDetailsByProperties = productDetailsByProperties;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	@Column(name = "propertyNameEn", length = 100)
	public String getPropertyNameEn()
	{
		return this.propertyNameEn;
	}

	public void setPropertyNameEn(String propertyNameEn)
	{
		this.propertyNameEn = propertyNameEn;
	}

	@Column(name = "propertyNameGm")
	public String getPropertyNameGm()
	{
		return this.propertyNameGm;
	}

	public void setPropertyNameGm(String propertyNameGm)
	{
		this.propertyNameGm = propertyNameGm;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate", length = 23)
	public Date getCreateDate()
	{
		return this.createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyType")
	public Set<ProductDetailsByProperty> getProductDetailsByProperties()
	{
		return this.productDetailsByProperties;
	}

	public void setProductDetailsByProperties(
			Set<ProductDetailsByProperty> productDetailsByProperties)
	{
		this.productDetailsByProperties = productDetailsByProperties;
	}

}