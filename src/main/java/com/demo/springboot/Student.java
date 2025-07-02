package com.demo.springboot;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "student", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
    public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;

        @Column(unique = true)
        private String email;

        private String password;

        private String course;


    }