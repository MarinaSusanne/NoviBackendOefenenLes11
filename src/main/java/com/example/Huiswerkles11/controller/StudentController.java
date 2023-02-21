package com.example.Huiswerkles11.controller;

import com.example.Huiswerkles11.model.Student;
import com.example.Huiswerkles11.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/students")
public class StudentController {

@Autowired
    StudentRepository repos;

@GetMapping
    public ResponseEntity<Iterable<Student>> getStudents(){
    return ResponseEntity.ok(repos.findAll());
}

@PostMapping
public ResponseEntity<Student> createStudent (@RequestBody Student s){
    repos.save(s);
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + s.getId()).toUriString());
    return ResponseEntity.created(uri).body(s);
}

    @GetMapping("/fullname")
    public ResponseEntity<Iterable<Student>> getStudentBySubString(@RequestParam String name) {
        Iterable<Student> students = repos.findByFullNameContaining(name);
        return ResponseEntity.ok(students);
    }


}


