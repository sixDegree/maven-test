package com.cj.test;


import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cj.security.service.SysRoleService;
import com.cj.security.service.SysUserService;
import com.cj.util.ListUtils;
import com.cj.vo.SysUserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
/*@TransactionConfiguration(transactionManager="txManager",defaultRollback=true)
@Transactional*/
public class SysUserTest
{

	@Inject
	private SysUserService sysUserService;
	
	@Inject SysRoleService sysRoleService;

	@Test
	public void testDTO()
	{
		//System.out.println(ListUtils.transform(sysUserService.list(), "id","account","password","enable"));
		
		System.out.println(ListUtils.transform(sysUserService.list(), SysUserVo.class));
	}
	
	@Test
	public void testDTO2()
	{
		System.out.println(ListUtils.transform(sysRoleService.list(),"id","enable","name"));
	}
	
}
