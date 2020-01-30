package com.ensar.EmployeeAttendance.pojo;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;


@Embeddable
public class HoursId implements Serializable {
    private LocalDate recdate;
    private Integer employeeid;

    public HoursId(Integer employeeid) {
        this.recdate = LocalDate.now();
        this.employeeid = employeeid;
    }

    public HoursId() {}

    public LocalDate getRecdate() {
        return recdate;
    }

    public void setRecdate(LocalDate recdate) {
        this.recdate = recdate;;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

}