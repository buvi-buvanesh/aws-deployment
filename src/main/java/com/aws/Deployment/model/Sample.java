package com.aws.Deployment.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sample")
public class Sample {

    @Id
    private Long userId;
    private String userName;
    private String email;

}
