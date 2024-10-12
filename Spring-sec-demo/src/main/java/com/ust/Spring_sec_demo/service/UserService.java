package com.ust.Spring_sec_demo.service;

import com.ust.Spring_sec_demo.model.UserCred;
import com.ust.Spring_sec_demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public UserCred saveUser(UserCred userCred) {
        userCred.setPassword(encoder.encode(userCred.getPassword()));
        System.out.println(userCred.getPassword());
        return repo.save(userCred) ;

    }
}
