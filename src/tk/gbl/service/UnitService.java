package tk.gbl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.gbl.bean.Unit;
import tk.gbl.mapper.AdminMapper;
import tk.gbl.mapper.TeacherMapper;
import tk.gbl.mapper.UnitMapper;

import java.util.List;

@Service("unitService")
public class UnitService {
    @Autowired
    AdminMapper adminMapper;
    
    @Autowired
    TeacherMapper teacherMapper;
    
    @Autowired
    UnitMapper unitMapper;
    
    public void addUnit(Unit unit) {
        unitMapper.save(unit);
    }
    
    public Unit getUnit(int id) {
        return unitMapper.get(id);
    }
    
    public void deleteUnit(Unit unit) {
        unitMapper.delete(unit.getUnit_id());
    }
    
    public void updateUnit(Unit unit) {
        unitMapper.update(unit);
    }
    
    public void deleteUnit(int id) {
        unitMapper.delete(id);
    }

    public List<Unit> getAllUnit() {
        return unitMapper.getAll();
    }
}
