package com.example.Student_manager_backend.service;

import com.example.Student_manager_backend.model.Student;
import com.example.Student_manager_backend.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repo;

    // Constructor Injection
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    // Fetch all students
    public List<Student> findAll() {
        return repo.findAll();
    }

    // Fetch student by ID
    public Optional<Student> findById(Long id) {
        return repo.findById(id);
    }

    // Save or update a student
    public Student save(Student student) {
        return repo.save(student);
    }

    // Delete student by ID
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
