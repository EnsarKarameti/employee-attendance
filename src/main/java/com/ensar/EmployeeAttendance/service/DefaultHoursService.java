package com.ensar.EmployeeAttendance.service;

import com.ensar.EmployeeAttendance.pojo.Employee;
import com.ensar.EmployeeAttendance.pojo.Hours;
import com.ensar.EmployeeAttendance.pojo.HoursId;
import com.ensar.EmployeeAttendance.pojo.Login;
import com.ensar.EmployeeAttendance.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class DefaultHoursService implements HoursService {

    @Autowired
    private HoursRepository hoursRepository;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public Hours findOne(HoursId hoursId) {
        return hoursRepository.findOneByIdEmployeeidAndIdRecdate(hoursId.getEmployeeid(), hoursId.getRecdate());
    }

    @Override
    public Hours checkin(Login login) {
        Employee employee = employeeService.login(login);
        if(employee != null) {
            HoursId hoursId = new HoursId(employee.getId());
            Hours hours = this.findOne(hoursId);
            if (hours == null) {
                LocalDate yesterday = LocalDate.now().minusDays(1);
                hoursId.setRecdate(yesterday);
                hours = this.findOne(hoursId);
                if (hours != null && hours.getCheckOut() == null) {
                    return null;
                }
            }

            if (this.findOne(hoursId) != null)
                return null;

            hours = new Hours();
            hours.setId(new HoursId(employee.getId()));
            hours.setCheckIn(LocalDateTime.now());
            return hoursRepository.save(hours);
        }
        return null;
    }

    @Override
    public Hours checkout(Login login) {
        Employee employee = employeeService.login(login);
        if(employee != null) {
            HoursId hoursId = new HoursId(employee.getId());
            Hours hours = this.findOne(hoursId);
            if (hours == null) {
                LocalDate yesterday = LocalDate.now().minusDays(1);
                hoursId.setRecdate(yesterday);
                hours = this.findOne(hoursId);
                if (hours.getCheckOut() == null) {
                    hours.setCheckOut(LocalDateTime.now());
                    return hoursRepository.save(hours);
                }
                return null;
            }

            hours.setCheckOut(LocalDateTime.now());
            return hoursRepository.save(hours);
        }
        return null;
    }

}
