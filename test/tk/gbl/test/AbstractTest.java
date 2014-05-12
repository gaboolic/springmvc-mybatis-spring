package tk.gbl.test;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;



/**
 * 
 *
 * Date: 2014-2-24
 * Time: 下午12:57:53
 *
 * @author tian.dong@corp.elong.com
 */
@ContextConfiguration("classpath:applicationContext.xml")
public class AbstractTest  extends AbstractTestNGSpringContextTests{
    @Autowired
    protected SqlSessionFactory sqlSessionFactory;
}
