package com.example.spring_demo.controllers;

import com.example.spring_demo.entities.Student;
import com.example.spring_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student/add")
    public Student addStudent(@RequestBody Student student) {
        return this.studentService.addStudent(student);
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable long studentId) {
        return this.studentService.getStudentById(studentId);
    }

    @DeleteMapping("/student/{studentId}")
    public void deleteStudentById(@PathVariable long studentId) {
        this.studentService.deleteStudentById(studentId);
    }

    @PutMapping("/student/{studentId}")
    public Student updateStudentById(@PathVariable long studentId, @RequestBody Student student) {
        if(studentId != student.getId()) {

        }
        return this.studentService.updateStudentById(student);
    }
}
