package com.example.taller_app_monolitica.service;

import com.example.taller_app_monolitica.model.User;
import com.example.taller_app_monolitica.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUser {
    @Autowired
    private RepositoryUser repositoryUser;

    public List<User> findAll() {
        return repositoryUser.findAll();
    }

    public User saveUser(User user) {
        return repositoryUser.save(user);
    }

    public void deleteUser(Long id) {
        repositoryUser.deleteById(id);
    }



    public User loginUsername(String username, String password) {
        User user = repositoryUser.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public User loginEmail(String email, String password) {
        User user = repositoryUser.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }


}
