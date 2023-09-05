package com.joblink.joblinktest01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class jobseeker {
    @Id
    private int n_jobseekerid;
    private String c_name;   
    private String c_logname;
    private String c_password;
    private int n_age;
    private String c_telephone;

}
