package com.esLiceu.Movie.services;

import com.esLiceu.Movie.models.entitys.ProductionCompany;
import com.esLiceu.Movie.repository.ProductionCompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
@Autowired
ProductionCompanyRepo productionCompanyRepo;

    public ProductionCompany findById(Integer id) {
        return productionCompanyRepo.findByCompanyId(id);
    }

    public void saveCompany(ProductionCompany company) {
        productionCompanyRepo.save(company);
    }


    public void deleteCompany(Integer companyId) {
        productionCompanyRepo.deleteById(companyId);
    }
}
