package com.cj.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * 该过滤器的主要作用就是通过spring的IoC生成securityMetadataSource
 * securityMetadataSource：
 * 相当于本包中自定义的MyInvocationSecurityMetadataSourceService，
 * 用于从数据库提取权限和资源，装配到HashMap中，供Spring Security用于权限校验。
 */

public class MySecurityFilter extends AbstractSecurityInterceptor 
								implements Filter
{
	private FilterInvocationSecurityMetadataSource securityMetadataSource;
	
	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource()
	{
		return securityMetadataSource;
	}

	public void setSecurityMetadataSource(
			FilterInvocationSecurityMetadataSource securityMetadataSource)
	{
		this.securityMetadataSource = securityMetadataSource;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource()
	{
		return this.securityMetadataSource;
	}
	
	@Override
	public Class<?> getSecureObjectClass()
	{
		 //下面的MyAccessDecisionManager的supports方面必须放回true,
		//否则会提醒类型错误  
        return FilterInvocation.class;  
	}
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		System.out.println("MySecurityFilter-------");
	    FilterInvocation fi = new FilterInvocation(request, response, chain);  
	    invoke(fi);  

	}

	private void invoke(FilterInvocation fi) throws IOException, ServletException 
	{  
          
        //super.beforeInvocation(fi)：
        //1.根据SecurityMetadataSource获取配置的权限属性  (object为FilterInvocation对象)
        //Collection<ConfigAttribute> attributes = SecurityMetadataSource.getAttributes(object);  
		//2.判断是否需要对认证实体重新认证，默认为否  
	    //Authentication authenticated = authenticateIfRequired();  
		//3.决策管理器开始决定是否授权，如果授权失败，直接抛出AccessDeniedException    
        //this.accessDecisionManager.decide(authenticated, object, attributes);
		
/*		System.out.println("Filter:-----"+this.obtainSecurityMetadataSource().getClass());
		Collection<ConfigAttribute> attributes=this.obtainSecurityMetadataSource().getAttributes(fi);
		System.out.println(attributes);
		System.out.println("Filter:-----"+this.getAccessDecisionManager().getClass());*/
		
        InterceptorStatusToken token = super.beforeInvocation(fi);  
        try 
        {  
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());  
        } 
        finally
        {  
            super.afterInvocation(token, null);  
        }  
    }  
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub
		
	}


	

	

}
