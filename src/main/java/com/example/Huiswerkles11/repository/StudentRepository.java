package com.example.Huiswerkles11.repository;

import com.example.Huiswerkles11.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository <Student, Long> {
    Iterable<Student> findByFullNameContaining(String name);
}
