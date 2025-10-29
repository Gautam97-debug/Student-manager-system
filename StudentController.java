package com.example.Student_manager_backend.controller;

import com.example.Student_manager_backend.model.Student;
import com.example.Student_manager_backend.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")  // allows frontend to access backend (for local dev)
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // ➕ CREATE a new student
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student saved = service.save(student);
        return ResponseEntity.created(URI.create("/api/students/" + saved.getId())).body(saved);
    }

    // 📋 READ all students
    @GetMapping
    public List<Student> getAllStudents() {
        return service.findAll();
    }

    // 📖 READ a specific student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✏️ UPDATE an existing student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        return service.findById(id)
                .map(existing -> {
                    existing.setName(updatedStudent.getName());
                    existing.setDepartment(updatedStudent.getDepartment());
                    existing.setEmail(updatedStudent.getEmail());
                    service.save(existing);
                    return ResponseEntity.ok(existing);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ❌ DELETE a student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
