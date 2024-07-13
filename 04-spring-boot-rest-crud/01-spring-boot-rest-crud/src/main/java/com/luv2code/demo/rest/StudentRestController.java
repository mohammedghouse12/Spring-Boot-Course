package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> students = new ArrayList<Student>();

    @PostConstruct
    public void init() {
        students.add(new Student("Mohammed", "Ghouse"));
        students.add(new Student("Harsh", "Kumar"));
        students.add(new Student("Ayush", "Jef"));
        students.add(new Student("Kiran", "Kumar"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        if(studentId<0 || studentId>=students.size()){
            throw new StudentNotFoundException("No such student with id " + studentId);
        }
        return students.get(studentId);
    }
}
