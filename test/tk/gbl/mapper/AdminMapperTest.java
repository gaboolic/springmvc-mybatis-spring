package tk.gbl.mapper;

import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import tk.gbl.test.AbstractTest;

@ContextConfiguration("classpath:applicationContext.xml")
public class AdminMapperTest extends AbstractTest{

	@Test
	public void test(){
		System.out.println(sqlSessionFactory);
	}
}
