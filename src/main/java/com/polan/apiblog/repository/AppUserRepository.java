package com.polan.apiblog.repository;

import com.polan.apiblog.model.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
   
    AppUser findByEmail(String email);


}
