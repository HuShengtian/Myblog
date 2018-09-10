package junit;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.Users;
import service.AdminService;

public class SpringTest {

	@Test
	public void testLogin() {
		 System.out.println(Math.ceil((double)13/5));
	}
	
	/**
	 * 测试spring和mybatis整合从数据库取出用户
	 */
	@Test
	public void test(){
		ApplicationContext contest = new ClassPathXmlApplicationContext("classpath:bean.xml");
		AdminService service=(AdminService)contest.getBean("userServiceImpl");
		Users user = new Users();
		user.setUserName("xiepeng");
		user.setUserPassword("123456");
		Users login = service.login(user);
		System.out.println(login);
	}
	@Test
	public void changeDate() throws ParseException{
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format2 = format.format(date);
		System.out.println(format2);
		Date parse = format.parse(format2);
		System.out.println(parse);
	}
	
}

