package com.esLiceu.Movie.services;

import com.esLiceu.Movie.models.entitys.User;
import com.esLiceu.Movie.repository.UserRepo;
import com.esLiceu.Movie.security.EncrypterPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    @Autowired
    EncrypterPassword encrypterPassword;



    public boolean register(String email, String username, String password, String passwordCheck) {

        if (!password.equals(passwordCheck)) return false;
        if (password.length() < 5) return false;
        if (repo.findByUsername(username).isPresent()) return false;

        User u = new User();
        u.setEmail(email);
        u.setUsername(username);


        String hash = encrypterPassword.EncriptPassword(password);
        u.setPassword(hash);

        repo.save(u);

        return true;
    }



    public boolean login(String username, String password) {

        return repo.findByUsername(username)
                .map(u -> encrypterPassword.CheckEncriptPassword(password, u.getPassword()))
                .orElse(false);
    }


    public User getByUsername(String username) {
        return repo.findByUsername(username).orElse(null);
    }
}
