package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.entitys.ProductionCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface ProductionCompanyRepo extends JpaRepository<ProductionCompany, Integer> {

    List<ProductionCompany> findTop5ByCompanyNameContainingIgnoreCase(String query);

    ProductionCompany findByCompanyId(Integer id);
}
