package com.example.StockBackend.student;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

public class Student {
    @Getter @Setter  Long id;
    @Getter @Setter private String name;
    @Getter @Setter private String email;
    @Getter @Setter private LocalDate dob;
    @Getter @Setter private Integer age;


    public Student(Long id,
        String name,
        String email,
        LocalDate dob,
        Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public String toString() {
        return "Student{" + "\n" + 
                "id=" + id + "\n" + 
                ", name='" + name + "\n" + 
                ", email='" + email + "\n" + 
                ", dob=" + dob + "\n" + 
                ", age=" + age + '}'; 
    }

    
}
