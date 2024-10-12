package com.ust.Spring_sec_demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.ust.Spring_sec_demo.model.UserCred;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserCred, Integer> {

    UserCred findByUsername(String username);
}
