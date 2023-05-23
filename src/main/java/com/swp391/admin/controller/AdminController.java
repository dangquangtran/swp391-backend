package com.swp391.admin.controller;

import com.swp391.admin.model.AdminService;
import com.swp391.admin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<User> getListUser(){
        return adminService.getListUser();
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        adminService.createUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam String lastname){
        adminService.deleteUser(lastname);
    }

    @PutMapping
    public void updateUser(@RequestParam int id,
                           @RequestParam String firstname,
                           @RequestParam String lastname){
        adminService.updateUser(id,firstname,lastname);
    }

    @GetMapping("/searchbyemail")
    public List<User> searchUserByEmail(@RequestParam String email){
        return adminService.searchUserByEmail(email);
    }

    @GetMapping("/searchbyname")
    public List<User> searchUserByLastName(@RequestParam String lastname){
        return adminService.searchUserByLastName(lastname);
    }
    @GetMapping("/searchbyrole")
    public List<User> searchUserByRole(@RequestParam String role){
        return adminService.searchUserByRole(role);
    }



}
