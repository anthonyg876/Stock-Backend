package com.example.StockBackend.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "stocks")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @GetMapping(value="/{stockName}/{year}")
    public ResponseEntity<?> getStudents(@PathVariable String stockName, @PathVariable int year) {

        System.out.println(stockName + " " + year);
        
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudents());   
    }

}
