package vn.edu.hcmuaf.fit.studentmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.hcmuaf.fit.studentmanager.model.Student;
import vn.edu.hcmuaf.fit.studentmanager.service.StudentService;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    // Thống kê sinh viên theo điểm
    @GetMapping("/stats/classification")
    public Map<String, Long> statsClassification() {
        return studentService.statsClassification();
    }

    //Lọc theo gpt cao nhất
    @GetMapping("/top-gpa")
    public List<Student> getTopStudents() {
        return studentService.getTopStudentsByGPA();
    }


}