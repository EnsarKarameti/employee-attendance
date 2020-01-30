package com.ensar.EmployeeAttendance.service;

import com.ensar.EmployeeAttendance.pojo.*;
import com.ensar.EmployeeAttendance.repository.EmployeeRepository;
import com.ensar.EmployeeAttendance.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;


public class DefaultEmployeeService implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private HoursRepository hoursRepository;


    @Override
    public Employee login(Login login) {
        Employee employee = employeeRepository.findOneByEmailAndPassword(login.getEmail(), login.getPassword());
        if (employee.getPassword().equals(login.getPassword()))
            return employee;
        return null;
    }

    @Override
    public Employee signUp(SignUp signUp) {
        Employee employee = employeeRepository.findOneByEmailAndPhone(signUp.getEmail(), signUp.getPhone());
        if (employee == null) {
            employee = new Employee(signUp.getName(), signUp.getSurname(), signUp.getEmail(), signUp.getPassword(), signUp.getPhone());
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public HashMap<String, Object> getAllHours(Login login) {
        Employee employee = this.login(login);
        if (employee != null) {
            List<Hours> hours = hoursRepository.findAllByIdEmployeeid(employee.getId());
            if (hours != null) {
                Double total = this.getTotalHoursWorked(hours);
                HashMap<String, Object> res = new HashMap<>();
                res.put("hours", hours);
                res.put("totalHoursWorked", total);
                return res;
            }
            return null;
        }
        return null;
    }


    @Override
    public HashMap<String, Object> getHoursPerMonth(Login login, Integer month, Integer year) {
        Employee employee = this.login(login);
        if (employee != null) {
            List<Hours> hours = hoursRepository.findAllByMonthAndYearAndIdEmployeeid(month, year, employee.getId());
            if (hours != null) {
                Double total = this.getTotalHoursWorked(hours);
                HashMap<String, Object> res = new HashMap<>();
                res.put("hours", hours);
                res.put("totalHoursWorked", total);
                return res;
            }
            return null;
        }
        return null;
    }

    private Double getTotalHoursWorked(List<Hours> hours) {
        Double total = 0.0;
        for (Hours hour:
                hours) {
            if(interval(hour) == null)
                continue;
            total += interval(hour);
        }
        return Math.round(total * 100) / 100d;
    }

    private static Double interval(Hours hours) {
        if(hours.getCheckOut() != null && hours.getCheckIn() != null)
            return ChronoUnit.SECONDS.between(hours.getCheckIn(), hours.getCheckOut()) / 3600d;
        return null;
    }

}
