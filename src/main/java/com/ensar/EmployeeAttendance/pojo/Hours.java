package com.ensar.EmployeeAttendance.pojo;


import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "hours")
public class Hours {

    @EmbeddedId
    private HoursId id;

    @Column(name = "checkin")
    private LocalDateTime checkIn;

    @Column(name = "checkout")
    private LocalDateTime checkOut;

    @Column(name = "month")
    private Integer month;

    @Column(name = "year")
    private Integer year;

    public Hours() {
        this.month = LocalDateTime.now().getMonthValue();
        this.year = LocalDateTime.now().getYear();
    }

    public Hours(HoursId id, LocalDateTime checkIn, LocalDateTime checkOut) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.month = LocalDateTime.now().getMonthValue();
        this.year = LocalDateTime.now().getYear();
    }

    public HoursId getId() {
        return id;
    }

    public void setId(HoursId id) {
        this.id = id;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth() {
        this.month = LocalDateTime.now().getMonthValue();
    }

    public Integer getYear() {
        return year;
    }

    public void setYear() {
        this.year = LocalDateTime.now().getYear();
    }
}

