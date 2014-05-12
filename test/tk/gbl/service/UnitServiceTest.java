package tk.gbl.service;

import static org.testng.AssertJUnit.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import tk.gbl.bean.Unit;
import tk.gbl.test.AbstractTest;

public class UnitServiceTest extends AbstractTest {
    
    @Autowired
    UnitService service;
    
    @Test
    public void addUnit() {
        Unit unit = new Unit();
        unit.setName("addunitest");
        service.addUnit(unit);
    }
    @Test
    public void getUnit() {
        Unit unit = service.getUnit(1);
        assertEquals(unit.getName(),"计算机学院");
    }
    @Test
    public void updateUnit(){
        Unit unit = service.getUnit(2);
        unit.setName("updateunit2");
        service.updateUnit(unit);
        
        unit = service.getUnit(2);
        assertEquals(unit.getName(),"updateunit2");
        
        unit.setName("updateunit");
        service.updateUnit(unit);
        assertEquals(unit.getName(),"updateunit");
    }
    @Test
    public void deleteUnit(){
        service.deleteUnit(3);
    }
}
