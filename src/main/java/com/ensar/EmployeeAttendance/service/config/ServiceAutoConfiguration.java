package com.ensar.EmployeeAttendance.service.config;

import com.ensar.EmployeeAttendance.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceAutoConfiguration {
    @Bean
    public AdminService adminService(){
        return new DefaultAdminService();
    }

    @Bean
    public EmployeeService employeeService() { return new DefaultEmployeeService(); }

    @Bean
    public HoursService hoursService() { return new DefaultHoursService(); }

}
