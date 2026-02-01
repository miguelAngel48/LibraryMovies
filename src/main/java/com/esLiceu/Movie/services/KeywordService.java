package com.esLiceu.Movie.services;

import com.esLiceu.Movie.models.entitys.Keyword;
import com.esLiceu.Movie.repository.KeywordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordService {
@Autowired
    KeywordRepo keywordRepo;
    public void saveKeyword(Keyword keyword) {
        keywordRepo.save(keyword);
    }

    public void deletekeyword(Integer keywordId) {
        keywordRepo.deleteById(keywordId);
    }


    public Keyword findById(Integer id) {
        Keyword keyword = keywordRepo.findByKeywordId(id);
        return keyword;
    }
}
