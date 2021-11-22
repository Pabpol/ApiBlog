package com.polan.apiblog.service;

import java.util.List;

import com.polan.apiblog.model.AppUser;
import com.polan.apiblog.model.Role;


public interface AppUserService {

    public AppUser saveAppUser (AppUser appUser);
    public Role saveRole(Role role);
    void addRoleToUser(String userEmail, String roleName);
    public AppUser getUser(String userEmail);
    public List<AppUser> getAppUsers();
    
    
}
