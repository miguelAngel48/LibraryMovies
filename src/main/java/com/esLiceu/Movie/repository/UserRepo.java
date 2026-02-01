package com.esLiceu.Movie.repository;
import com.esLiceu.Movie.models.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
