package com.ensar.EmployeeAttendance.controller;


import com.ensar.EmployeeAttendance.pojo.*;
import com.ensar.EmployeeAttendance.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/admin/allhours")
    public List<Hours> getAllHours(@RequestBody Login login) { return adminService.getAll(login); }

    @PostMapping("/admin/signup")
    public Admin signup(@RequestBody SignUp signUp) {
        return adminService.signUp(signUp);
    }

    @PostMapping("/admin/allemployees")
    public HashMap<String, List<Hours>> getEmployeeAndHours(@RequestBody Login login) {
        return adminService.getAllEmployees(login);
    }

}
