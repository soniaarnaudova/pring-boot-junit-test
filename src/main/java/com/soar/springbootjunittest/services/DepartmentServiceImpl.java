package com.soar.springbootjunittest.services;

import com.soar.springbootjunittest.entities.Department;
import com.soar.springbootjunittest.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("DepartmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public Department updateDepartment(Department department, Long departmentId) {
        Department depDB = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        Department departmengt = departmentRepository.findById(departmentId).get();
        departmentRepository.delete(departmengt);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
