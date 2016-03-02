package com.cj.user.log;

import java.util.Date;

public class UserLog
{
	public static void log(String str)
	{
		System.out.println(new Date()+"------"+str);
	}
}
