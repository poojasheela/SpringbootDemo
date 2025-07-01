package com.demo.springboot;

import jakarta.persistence.*;

    @Entity
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

        public Student() {
        }

        public Student(String name, String email, String password, String course) {
            this.name = name;
            this.email = email;
            this.password = password;
            this.course = course;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public String getCourse(){
            return course;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password=password;

        }

        public  void  setCourse(String course){
        this.course=course;
        }
    }