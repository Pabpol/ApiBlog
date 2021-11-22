package com.polan.apiblog.controller;

import java.net.URI;
import java.util.List;

import com.polan.apiblog.model.AppUser;
import com.polan.apiblog.model.Role;
import com.polan.apiblog.service.AppUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
@RequestMapping("/api")
public class AppUserController {
    
    @Autowired
    private AppUserService appUserService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getAppUsers(){
        return ResponseEntity.ok().body(appUserService.getAppUsers());
    }


    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());

        return ResponseEntity.created(uri).body(appUserService.saveRole(role));
    }

    @PostMapping("/role/add_to_user")
    public ResponseEntity<Role> addRoltoUser(@RequestParam String userEmail, @RequestParam String roleName){
        appUserService.addRoleToUser(userEmail, roleName);;

        return ResponseEntity.ok().build();
    } 

    
}
