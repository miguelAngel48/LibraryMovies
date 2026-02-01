package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.entitys.LanguageRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRoleRepo extends JpaRepository<LanguageRole,Integer> {
}
