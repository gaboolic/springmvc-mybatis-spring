package tk.gbl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import tk.gbl.bean.Project;
import tk.gbl.bean.Unit;
import tk.gbl.test.AbstractTest;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

public class ProjectServiceTest extends AbstractTest{

    @Autowired
    ProjectService service;

    @Test
    public void addProject() {
        Project project = new Project();
        project.setName("project");
        service.addProject(project);
    }
}
