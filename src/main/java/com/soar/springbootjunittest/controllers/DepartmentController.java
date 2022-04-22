package com.soar.springbootjunittest.controllers;

import com.soar.springbootjunittest.entities.Department;
import com.soar.springbootjunittest.services.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments/add")
    public Department saveDepartment(@Valid @RequestBody Department department){
        return departmentService.saveDepartment(department);

    }

    @GetMapping("/departments/all")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @PutMapping("/departments/update/{id}")
    public Department updateDepartment(@RequestBody Department department,@PathVariable("id") Long departmentId ){
        logger.info("Update Department with ID: " + departmentId);
         return departmentService.updateDepartment(department, departmentId);
    }

    @DeleteMapping("/departments/delete/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId){
        logger.info("Delete Department.");
        departmentService.deleteDepartmentById(departmentId);
        return "Department with id= " + departmentId + "was deleted successfully.";
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }
}
