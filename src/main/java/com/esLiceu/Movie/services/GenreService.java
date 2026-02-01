package com.esLiceu.Movie.services;

import com.esLiceu.Movie.models.entitys.Genre;
import com.esLiceu.Movie.repository.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {
    @Autowired
    GenreRepo genreRepo;;

    public void saveGenre(Genre genre) {
        genreRepo.save(genre);
    }

    public void deleteGenre(Integer genreId) {
        genreRepo.deleteById(genreId);
    }

    public Genre findById(Integer id) {
       return genreRepo.findByGenreId(id);
    }
}
