package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.entitys.ProductionCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionCompanyRepo extends JpaRepository<ProductionCompany,Integer> {

}
