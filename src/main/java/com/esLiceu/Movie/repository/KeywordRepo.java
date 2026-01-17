package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.entitys.Keyword;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordRepo extends JpaRepository <Keyword, Integer> {

}
