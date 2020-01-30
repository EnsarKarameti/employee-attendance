package com.ensar.EmployeeAttendance.service;

import com.ensar.EmployeeAttendance.pojo.*;

import java.util.HashMap;
import java.util.List;

public interface AdminService {
    Admin login(Login login);
    Admin signUp(SignUp signUp);
    List<Hours> getAll(Login login);
    HashMap<String, List<Hours>> getAllEmployees(Login login);
}
