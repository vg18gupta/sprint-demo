package com.example.spring_demo.service;

import com.example.spring_demo.entities.Student;
import com.example.spring_demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        Student addStudent = this.studentRepository.save(student);
        return addStudent;
    }

    public Student getStudentById(long studentId) {
        Optional<Student> optionalValue = this.studentRepository.findById(studentId);
//        if(optionalValue.isEmpty()) {
//            return null;
//        }
//        return optionalValue.get();
        return optionalValue.orElse(null);
    }

    public void deleteStudentById(long studentId) {
        this.studentRepository.deleteById(studentId);
    }

    public Student  updateStudentById(Student student) {
        Student existingStudent = this.getStudentById(student.getId());
        if(existingStudent == null) {
            return null;
        }
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        return this.studentRepository.save(existingStudent);
    }
}
