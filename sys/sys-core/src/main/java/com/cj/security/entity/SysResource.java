package com.cj.security.entity;

// Generated 2012-12-17 15:20:22 by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * SysResource generated by hbm2java
 */
@Entity
@Table(name = "sys_resource", catalog = "mysecurity")
public class SysResource implements java.io.Serializable
{
	private static final long serialVersionUID = 3774417497857350889L;
	private Integer id;
	private String name;
	private String target;
	private String type;
	private String method;
	private Boolean userManaged;
	private String description;
	private Boolean enable;
	private List<SysRole> sysRoles = new ArrayList<SysRole>();

	public SysResource()
	{
	}

	public SysResource(String name, String target, String type, String method,
			Boolean userManaged, String description, Boolean enable,
			List<SysRole> sysRoles)
	{
		this.name = name;
		this.target = target;
		this.type = type;
		this.method = method;
		this.userManaged = userManaged;
		this.description = description;
		this.enable = enable;
		this.sysRoles = sysRoles;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@Column(name = "name", length = 100)
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "target")
	public String getTarget()
	{
		return this.target;
	}

	public void setTarget(String target)
	{
		this.target = target;
	}

	@Column(name = "type")
	public String getType()
	{
		return this.type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	@Column(name = "method", length = 50)
	public String getMethod()
	{
		return this.method;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	@Column(name = "userManaged")
	public Boolean getUserManaged()
	{
		return this.userManaged;
	}

	public void setUserManaged(Boolean userManaged)
	{
		this.userManaged = userManaged;
	}

	@Column(name = "description", length = 1000)
	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	@Column(name = "enable")
	public Boolean getEnable()
	{
		return this.enable;
	}

	public void setEnable(Boolean enable)
	{
		this.enable = enable;
	}

	@ManyToMany(mappedBy = "sysResources")
	public List<SysRole> getSysRoles()
	{
		return this.sysRoles;
	}

	public void setSysRoles(List<SysRole> sysRoles)
	{
		this.sysRoles = sysRoles;
	}

}
