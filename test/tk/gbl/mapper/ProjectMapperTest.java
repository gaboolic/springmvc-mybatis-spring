package tk.gbl.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import tk.gbl.bean.Project;
import tk.gbl.bean.Teacher;
import tk.gbl.bean.Unit;
import tk.gbl.test.AbstractTest;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class ProjectMapperTest extends AbstractTest{

    @Autowired
    ProjectMapper mapper;

    @Test
    public void tttt(){
        Teacher teacher = new Teacher();
        teacher.setTeacher_id(1);
        Unit unit = new Unit();
        unit.setUnit_id(1);


        System.out.println("*****");
        List<Project> list =  mapper.getAllOfUnit(unit);
        System.out.println("*****"+list.size());

        assertEquals(list.size(),2);

        list =  mapper.getAllOfTeacher(teacher);
        System.out.println("*****"+list.size());

        assertEquals(list.size(),2);



        System.out.println("*****");
    }
}
