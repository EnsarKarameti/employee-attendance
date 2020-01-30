package com.ensar.EmployeeAttendance.service;

import com.ensar.EmployeeAttendance.pojo.Hours;
import com.ensar.EmployeeAttendance.pojo.HoursId;
import com.ensar.EmployeeAttendance.pojo.Login;


public interface HoursService {
    Hours findOne(HoursId hoursId);
    Hours checkin(Login login);
    Hours checkout(Login login);
}
