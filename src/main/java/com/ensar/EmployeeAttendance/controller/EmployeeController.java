package com.ensar.EmployeeAttendance.controller;


import com.ensar.EmployeeAttendance.pojo.*;
import com.ensar.EmployeeAttendance.service.EmployeeService;
import com.ensar.EmployeeAttendance.service.HoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private HoursService hoursService;

    @PostMapping("/employee/hours")
    public HashMap getAllHours(@RequestBody Login login) {
        return employeeService.getAllHours(login);
    }

    @PostMapping("/employee/hours/month")
    public HashMap getAllHoursPerMonth(@RequestBody Login login, @RequestParam(defaultValue="0") Integer month, @RequestParam(defaultValue="0") Integer year) {
        return employeeService.getHoursPerMonth(login, month, year);
    }

    @PostMapping("/employee/checkin")
    public Hours checkIn(@RequestBody Login login) {
        return hoursService.checkin(login);
    }

    @PostMapping("/employee/checkout")
    public Hours checkOut(@RequestBody Login login) {
        return hoursService.checkout(login);
    }

    @PostMapping("/employee/signup")
    public Employee signUp(@RequestBody SignUp signUp) {
        return employeeService.signUp(signUp);
    }



}
