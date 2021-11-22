package com.polan.apiblog.repository;

import com.polan.apiblog.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    public Role findByName(String name);

}
