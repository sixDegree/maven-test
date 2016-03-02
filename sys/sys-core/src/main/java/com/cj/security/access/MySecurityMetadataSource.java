package com.cj.security.access;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;

import com.cj.security.entity.SysResource;
import com.cj.security.entity.SysRole;
import com.cj.security.service.SysResourceService;

/**
*  加载资源与权限的对应关系,即getAttributes方法返回的结果
* 此类在初始化时，应该取到所有资源及其对应角色的定义。
*/

public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource 
{
	private SysResourceService sysResourceService;
	private static Map<RequestMatcher, Collection<ConfigAttribute>> resourceMap = null;  
	 
	public MySecurityMetadataSource()
	{
		System.out.println("MySecurityMetadataSource construct--------------");
		loadResourceDefine();
	}
	
	public MySecurityMetadataSource(SysResourceService sysResourceService) 
	{  
		System.out.println("MySecurityMetadataSource construct--------------");
        this.sysResourceService = sysResourceService;  
        loadResourceDefine();  
    }  
	
	public SysResourceService getSysResourceService()
	{
		return sysResourceService;
	}

	@Inject
	public void setSysResourceService(SysResourceService sysResourceService)
	{
		this.sysResourceService = sysResourceService;
	}

	
	
	//加载所有资源与权限的关系  
    private void loadResourceDefine() 
    {  
    	System.out.println("loadResourceDefine--------------");
        if(resourceMap == null) 
        {  
        	//resourceMap=this.sysResourceService.loadAllResourceRoles();
        	
            resourceMap = new HashMap<RequestMatcher, Collection<ConfigAttribute>>();  
            List<SysResource> resources = this.sysResourceService.listDetails();  
    		Collection<ConfigAttribute> configAttributes=null;
    		for(SysResource res:resources)
    		{
    			configAttributes = new ArrayList<ConfigAttribute>();  
    			for(SysRole role:res.getSysRoles())
    			{
    				configAttributes.add(new SecurityConfig(role.getName()));
    			}
    			resourceMap.put(new AntPathRequestMatcher(res.getTarget()), configAttributes);	
    		}
        }  
          
        /*Set<Entry<String, Collection<ConfigAttribute>>> resourceSet = resourceMap.entrySet();  
        Iterator<Entry<String, Collection<ConfigAttribute>>> iterator = resourceSet.iterator();  
          */
    }  
    
    //返回所请求资源所需要的权限
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException
	{
		System.out.println("getAttributes-------");
		String requestUrl = ((FilterInvocation) object).getRequestUrl();  
        System.out.println("requestUrl is " + requestUrl);  
        if(resourceMap == null) 
        {  
            loadResourceDefine();  
        }  
     
       // return resourceMap.get(requestUrl);  
        
        // object 是一个URL，被用户请求的url。
		String url = ((FilterInvocation) object).getRequestUrl();

		int firstQuestionMarkIndex = url.indexOf("?");

		if (firstQuestionMarkIndex != -1)
		{
			url = url.substring(0, firstQuestionMarkIndex);
		}

		Iterator<RequestMatcher> ite = resourceMap.keySet().iterator();

		while (ite.hasNext())
		{
			RequestMatcher resURL = ite.next();

			if (resURL.matches(((FilterInvocation) object).getHttpRequest()))
			{
				return resourceMap.get(resURL);
			}
		}

		return null;
        
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes()
	{
		Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();

        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : resourceMap.entrySet()) 
        {
            allAttributes.addAll(entry.getValue());
        }

        return allAttributes;
	}

	@Override
	public boolean supports(Class<?> clazz)
	{
		// TODO Auto-generated method stub
		return true;
	}

}
