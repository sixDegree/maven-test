package com.cj.ebike.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggerHandler
{
	static Logger logger = Logger.getLogger(LoggerHandler.class);  
	public void afterReturning()
	{
		System.out.println("Use AspactJ -- After Returning");
	}
	
	public void beforeClass()
	{
		
		System.out.println("Use AspactJ---Begin Method");
	}
	
	public void afterClass()
	{
		System.out.println("Use AspactJ---End Method");
	}
	
	public void aroundClass(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("Use AspactJ -- Around begin");
		Object returnObj=pjp.proceed();
		System.out.println("Use AspactJ ("+returnObj+")-- Around end");
	}
	
	public void logArg(JoinPoint joinPoint )
	{
		Object[] args = joinPoint.getArgs();
		System.out.println("----------logArg()---------------");
		for (int i=0; i<args.length; i++) 
		{
			System.out.println(args[i]);
		}
		
		System.out.println(joinPoint.getSignature().getName());
		System.out.println("----------logArg()---------------");
	}
	
	public void logArgAndReturn(JoinPoint joinPoint,Object returnObj)
	{
		System.out.println("----------logArgAndReturn()---------------");
		Object[] args = joinPoint.getArgs();
		for (int i=0; i<args.length; i++) 
		{
			System.out.println(args[i]);
		}
		
		System.out.println(joinPoint.getSignature().getName());
		System.out.println(returnObj);
		System.out.println("----------logArgAndReturn()---------------");
	}
	
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable
	{
		StringBuffer sb=new StringBuffer();
		try
		{
			sb.append("Function:"+pjp.getTarget().getClass().getName()+"."+pjp.getSignature().getName()+"\n");
			sb.append("Args:");
			for(Object obj:pjp.getArgs())
			{
				sb.append(obj+"\t");
			}
			System.out.println(sb.toString());
			logger.info(sb.toString());   
			
			Object returnObj=pjp.proceed();		
			System.out.println("Return: "+returnObj);
			return returnObj;
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e.getMessage());
			return null;
		}
	}
}
