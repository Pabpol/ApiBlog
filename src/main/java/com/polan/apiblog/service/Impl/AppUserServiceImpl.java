package com.polan.apiblog.service.Impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.polan.apiblog.model.AppUser;
import com.polan.apiblog.model.Role;
import com.polan.apiblog.repository.AppUserRepository;
import com.polan.apiblog.repository.RoleRepository;
import com.polan.apiblog.service.AppUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService ,UserDetailsService {

    @Autowired
    private  AppUserRepository appUserRepository;
    @Autowired
    private  RoleRepository roleRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Override
    public AppUser saveAppUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }

    @Override
    public Role saveRole(Role role) {
        
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String userEmail, String roleName) {
        AppUser appUser = appUserRepository.findByEmail(userEmail);
        Role role = roleRepository.findByName(roleName);
        appUser.getRoles().add(role);
        
    }

    @Override
    public AppUser getUser(String userEmail) {
        return appUserRepository.findByEmail(userEmail);
    }

    @Override
    public List<AppUser> getAppUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByEmail(email);
        if (appUser == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
            
        } else {
            log.info("User found in the database: {}", email);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            appUser.getRoles().forEach(role ->{
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return new User(appUser.getEmail(),appUser.getPassword(),authorities);
        }
        
    }
    
}
