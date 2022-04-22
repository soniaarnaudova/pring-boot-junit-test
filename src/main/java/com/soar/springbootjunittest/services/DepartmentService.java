package com.soar.springbootjunittest.services;

import com.soar.springbootjunittest.entities.Department;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long departmentId);

    Department updateDepartment(Department department, Long departmentId);

    void deleteDepartmentById(Long departmentId);

    Department getDepartmentByName(String departmentName);
}
