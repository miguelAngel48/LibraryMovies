package com.esLiceu.Movie.services;

import com.esLiceu.Movie.models.entitys.Department;
import com.esLiceu.Movie.repository.DepartmentRepo;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepo departmentRepo;

    public Department findById(Integer id) {
        return departmentRepo.findByDepartmentId(id);
    }

    public void saveDepartment(Department department) {
        departmentRepo.save(department);
    }

    public void deleteDepartment(Integer departmentId) {
        departmentRepo.deleteById(departmentId);
    }

    public List<Department> findAll() {
        return departmentRepo.findAll();
    }
}
