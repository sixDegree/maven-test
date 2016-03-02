package cn.edu.zttc.hello;

import org.junit.*;
import static junit.framework.Assert.*;
import cn.edu.zttc.hello.*;

public class TestHello
{
	@Test
	public void testHello() {
		Hello h = new Hello();
		assertEquals(h.sayHello("zs"),"hello:zs");
	}
}