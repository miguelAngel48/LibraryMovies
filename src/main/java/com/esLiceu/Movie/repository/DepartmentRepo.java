package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.entitys.Department;
import com.esLiceu.Movie.models.entitys.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {
    List<Department> findTop5ByDepartmentNameContainingIgnoreCase(String query);

    Department findByDepartmentId(Integer id);
}
