package com.mongodb.controller;

import com.mongodb.Repository.StudentRepository;
import com.mongodb.entity.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentRepository studentRepo;


    @PostMapping("/")
    public ResponseEntity<student> addStudent(@RequestBody student student) {
        student savedStudent = studentRepo.save(student);
        return ResponseEntity.ok(savedStudent);
    }

     @GetMapping("/")
     public ResponseEntity<?> getStudent() {

         return ResponseEntity.ok(this.studentRepo.findAll());
     }

    @PutMapping("/{studentId}")
    public ResponseEntity<student> updateStudent(@PathVariable Integer studentId, @RequestBody student updatedStudent) {
        // Check if the student with the given ID exists
        if (studentRepo.existsById(studentId)) {
            // Set the ID of the updated student to match the path variable
            updatedStudent.setId(studentId);
            // Save the updated student
            student updated = studentRepo.save(updatedStudent);
            return ResponseEntity.ok(updated);
        } else {
            // If the student with the given ID doesn't exist, return a 404 Not Found response
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer studentId) {
        // Check if the student with the given ID exists
        if (studentRepo.existsById(studentId)) {
            // Delete the student
            studentRepo.deleteById(studentId);
            // Return a 204 No Content response indicating successful deletion
            return ResponseEntity.noContent().build();
        } else {
            // If the student with the given ID doesn't exist, return a 404 Not Found response
            return ResponseEntity.notFound().build();
        }
    }





}
