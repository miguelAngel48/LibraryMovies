package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.entitys.Department;
import com.esLiceu.Movie.models.entitys.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {
//Movie findMoviesByActor(String actor);
}
