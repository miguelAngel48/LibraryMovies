package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.DTO.SearchSuggestionDTO;
import com.esLiceu.Movie.models.entitys.Keyword;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface KeywordRepo extends JpaRepository <Keyword, Integer> {

   Keyword findByKeywordId(Integer id);

   List<Keyword> findTop5ByKeywordNameContainingIgnoreCase(String query);
}
