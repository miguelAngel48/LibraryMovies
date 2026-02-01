package com.esLiceu.Movie.services;

import com.esLiceu.Movie.models.DTO.SearchSuggestionDTO;
import com.esLiceu.Movie.models.entitys.Movie;
import com.esLiceu.Movie.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MoviesStock {
    @Autowired
    MovieRepo movieRepo;
    @Autowired
    PersonRepo personRepo;
    @Autowired
    GenreRepo genreRepo;
    @Autowired
    MovieCastRepo movieCastRepo;
    @Autowired
    KeywordRepo keywordRepo;
    @Autowired
    CountryRepo countryRepo;
    @Autowired
    DepartmentRepo departmentRepo;
    @Autowired
    ProductionCompanyRepo productionCompanyRepo;
    @Autowired
    GenderRepo genderRepo;
    @Autowired
    LanguageRepo languageRepo;


    public enum SearchType {
        PERSON,
        MOVIE,
        DIRECTOR,
        CHARACTER,
        GENRE,
        KEYWORD,
        GENDER,
        LANGUAGE,
        LANGUAGEROL,
        PRODUCTIONCOMPANY,
        COUNTRY,
        DEPARTMENT

    }

    public List<Movie> findAllMovies() {
        return movieRepo.findAll();
    }

    public List<Movie> globalFinder(String query, Integer entityId, SearchType type) {
        List<Movie> returnsMovies = new ArrayList<>();
        switch (type) {
            case PERSON -> {

                return findByActor(entityId);
            }
            case MOVIE -> {
                returnsMovies.add(findMovieById(entityId));
                return returnsMovies;
            }
            case DIRECTOR -> {
                return findByDirectorMovies(query);
            }
            case CHARACTER -> {
                return findByCharacterMovie(query);
            }
            case GENRE -> {
                return findByGenre(query);
            }

        }

        return findAllMovies();
    }

    private List<Movie> findByDirectorMovies(String query) {
        return movieRepo.findDistinctByCrewPersonPersonNameContainingIgnoreCaseAndCrewJob(query, "Director");
    }

    private List<Movie> findByCharacterMovie(String query) {
        return movieRepo.findDistinctByCastCharacterName(query);
    }

    private List<Movie> findByGenre(String query) {
        return movieRepo.findDistinctByMovieGenresGenreGenreNameIgnoreCase(query);
    }

    public Movie findMovieById(Integer idMovie) {
        return movieRepo.findById(idMovie).orElse(null);
    }

    public List<Movie> findByActor(Integer actor) {
        List<Movie> filmsActor = movieRepo.findDistinctByCastPersonPersonId(actor);
        System.out.println(filmsActor);
        return filmsActor;
    }

    public List<SearchSuggestionDTO> findTop5Suggestions(
            String query,
            SearchType type
    ) {
        return switch (type) {

            case MOVIE -> findSugestionMovie(query);

            case PERSON -> findSugestionPerson(query);

            case DIRECTOR -> findSugestionDirector(query);

            case GENRE -> findSugestionGenre(query);
            case CHARACTER -> findSugestionCharacter(query);
            case KEYWORD -> findSugestionKeyword(query);
            case GENDER -> findSugestionGender(query);
            case LANGUAGE -> findSugestionLanguage(query);
            case LANGUAGEROL -> findSugestionLanguageRol(query);
            case PRODUCTIONCOMPANY -> findSugestionProductionCompany(query);
            case COUNTRY -> findSugestionCountry(query);
            case DEPARTMENT -> findSugestionDepartment(query);
        };
    }

    private List<SearchSuggestionDTO> findSugestionDepartment(String query) {
        return  departmentRepo
                .findTop5ByDepartmentNameContainingIgnoreCase(query)
                .stream()
                .map(d -> new SearchSuggestionDTO(d.getDepartmentId(), d.getDepartmentName(),null))
                .toList();
    }

    private List<SearchSuggestionDTO> findSugestionProductionCompany(String query) {
        return productionCompanyRepo
                .findTop5ByCompanyNameContainingIgnoreCase(query)
                .stream()
                .map(c -> new SearchSuggestionDTO(c.getCompanyId(), c.getCompanyName(),null))
                .toList();
    }

    private List<SearchSuggestionDTO> findSugestionLanguageRol(String query) {
        return null;
    }

    private List<SearchSuggestionDTO> findSugestionLanguage(String query) {
       return languageRepo.findTop5ByLanguageNameContainingIgnoreCase(query)
               .stream().map(l -> new SearchSuggestionDTO(l.getLanguageId(), l.getLanguageName(),l.getLanguageCode()))
               .toList();
    }

    private List<SearchSuggestionDTO> findSugestionGender(String query) {
       return  genderRepo
                .findTop5ByGenderContainingIgnoreCase(query)
                .stream()
                .map(c -> new SearchSuggestionDTO(c.getGenderId(), c.getGender(),null))
                .toList();
    }

    private List<SearchSuggestionDTO> findSugestionCountry(String query) {
        return countryRepo
                .findTop5ByCountryNameContainingIgnoreCase(query)
                .stream()
                .map(k -> new SearchSuggestionDTO(k.getCountryId(), k.getCountryName(),null))
                .toList();
    }

    private List<SearchSuggestionDTO> findSugestionKeyword(String query) {
        return keywordRepo
                .findTop5ByKeywordNameContainingIgnoreCase(query)
                .stream()
                .map(k -> new SearchSuggestionDTO(k.getKeywordId(), k.getKeywordName(),null))
                .toList();
    }

    private List<SearchSuggestionDTO> findSugestionCharacter(String query) {
        return movieCastRepo
                .findDistinctTop5ByCharacterNameContainingIgnoreCase(query)
                .stream()
                .map(cast -> new SearchSuggestionDTO(
                        cast.getId().getMovieId(),
                        cast.getCharacterName(),
                        null
                ))
                .toList();
    }

    private List<SearchSuggestionDTO> findSugestionGenre(String query) {
        return genreRepo
                .findTop5ByGenreNameContainingIgnoreCase(query)
                .stream()
                .map(genre -> new SearchSuggestionDTO(
                        genre.getGenreId(),
                        genre.getGenreName(),
                        null
                ))
                .toList();
    }

    private List<SearchSuggestionDTO> findSugestionDirector(String query) {
        return personRepo
                .findTop5DirectorsByPersonNameContainingIgnoreCase(query, "Director")
                .stream()
                .map(person -> new SearchSuggestionDTO(
                        person.getPersonId(),
                        person.getPersonName(),
                        null
                ))
                .toList();
    }


    private List<SearchSuggestionDTO> findSugestionPerson(String query) {
        return personRepo
                .findTop5ByPersonNameContainingIgnoreCase(query)
                .stream()
                .map(p -> new SearchSuggestionDTO(
                        p.getPersonId(),
                        p.getPersonName(),
                        null
                ))
                .toList();
    }

    private List<SearchSuggestionDTO> findSugestionMovie(String query) {
        return movieRepo
                .findTop5ByTitleContainingIgnoreCase(query)
                .stream()
                .map(movie -> new SearchSuggestionDTO(
                        movie.getMovieId(),
                        movie.getTitle(),
                        null

                ))
                .toList();
    }


}
