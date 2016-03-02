package com.cj.vo;

public class SysUserVo
{
	//{id:1,account:'admin',password:'51ca5dff068c393899233251450d95e2',enable:true},
	private Integer id;
	private String account;
	private String password;
	private Boolean enable;
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getAccount()
	{
		return account;
	}
	public void setAccount(String account)
	{
		this.account = account;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public Boolean getEnable()
	{
		return enable;
	}
	public void setEnable(Boolean enable)
	{
		this.enable = enable;
	}
}
