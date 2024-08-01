package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.regex.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    private String empName;

    private String empAddress;

    private double empSalary;

    @JsonFormat(pattern = "dd-MM-YYYY")
    private Date empDOB;

    @Column(unique = true)
    private long empContactNumber;

    @Column(unique = true)
    private String empEmailId;

    private String empPassword;

}
