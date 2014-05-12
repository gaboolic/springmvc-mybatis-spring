package tk.gbl.service;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import tk.gbl.bean.Admin;
import tk.gbl.bean.Teacher;

@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest extends AbstractTestNGSpringContextTests {
    
    @Autowired
    UserService service;
    
    /*admin test start*/
    @Test
    public void add_get_delete_Admin() {
        Admin admin = new Admin();
        admin.setUsername("uuu");
        service.addAdmin(admin);
        Admin getAdmin = service.getAdmin("uuu");
        System.out.println(getAdmin.getAdmin_id()+" "+getAdmin.getUsername());
    
        service.deleteAdmin(getAdmin.getAdmin_id());
        getAdmin = service.getAdmin("uuu");
        assertNull(getAdmin);
    }
    @Test
    public void updateAdmin(){
        Admin admin = service.getAdmin("update");

        assertEquals(admin.getPassword(),"password");
        admin.setPassword("password2");
        service.updateAdmin(admin);
        
        admin = service.getAdmin("update");
        assertEquals(admin.getPassword(),"password2");
        
        admin.setPassword("password");
        service.updateAdmin(admin);
        admin = service.getAdmin("update");
        assertEquals(admin.getPassword(),"password");
    }
    @Test
    public void getAllAdmin(){
        List<Admin> admins = service.getAllAdmin();
        assertEquals(admins.get(0).getAdmin_id(),1);
        assertEquals(admins.get(1).getPassword(),"password");
    }
    /*admin test end*/
    
    
    @Test
    public void get_add_deleteTeacher(){
        Teacher teacher = new Teacher();
        teacher.setUsername("teachername");
        teacher.setPassword("pass");
        service.addTeacher(teacher);
        
        Teacher getTeacher = service.getTeacher("teachername");
        assertEquals(getTeacher.getPassword(),"pass");
        
        service.deleteTeacher(getTeacher.getTeacher_id());
        getTeacher = service.getTeacher("teacername");
        assertNull(getTeacher);
    }
    @Test
    public void updateTeacher(){
        Teacher teacher = service.getTeacher("teacher");
        teacher.setPassword("password");
        service.updateTeacher(teacher);
        
        teacher = service.getTeacher("teacher");
        assertEquals(teacher.getPassword(),"password");
        
        teacher.setPassword("123");
        service.updateTeacher(teacher);
        
        teacher = service.getTeacher("teacher");
        assertEquals(teacher.getPassword(),"123");
    }
    @Test
    public void isExist(){
        assertEquals(service.isExistTeacher("teacher"),true);
        assertEquals(service.isExistTeacher("teacher2222"),false);
        
        assertEquals(service.isExistAdmin("admin"),true);
        assertEquals(service.isExistAdmin("teacher2222"),false);
    }
    @Test
    public void isConfirm(){
        assertEquals(service.isConformAdmin("admin", "admin"),true);
        assertEquals(service.isConformAdmin("admin", "aaaa"),false);
        
        assertEquals(service.isConformTeacher("teacher", "123"),true);
        assertEquals(service.isConformTeacher("teacher", "2222"),false);
    }
}
