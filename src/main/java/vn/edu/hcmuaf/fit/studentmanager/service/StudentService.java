package vn.edu.hcmuaf.fit.studentmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.hcmuaf.fit.studentmanager.model.Student;
import vn.edu.hcmuaf.fit.studentmanager.repository.StudentRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    // Thống sinh viên theo điểm
    public Map<String, Long> statsClassification() {
        List<Student> students = studentRepository.findAll();

        Map<String, Long> stats = new HashMap<>();
        stats.put("Xuất sắc", students.stream().filter(s -> s.getGpa() > 3.6).count());
        stats.put("Giỏi", students.stream().filter(s -> s.getGpa() > 3.2 && s.getGpa() <= 3.6).count());
        stats.put("Khá", students.stream().filter(s -> s.getGpa() > 2.5 && s.getGpa() <= 3.2).count());
        stats.put("Trung bình/Yếu", students.stream().filter(s -> s.getGpa() <= 2.5).count());

        return stats;
    }

    public List<Student> getTopStudentsByGPA() {
        List<Student> all = studentRepository.findAll();
        if (all.isEmpty()) return new ArrayList<>();

        // tìm GPA cao nhất
        double maxGPA = all.stream()
                .mapToDouble(Student::getGpa)
                .max()
                .orElse(0);

        // lọc ra các sinh viên có GPA = max
        return all.stream()
                .filter(s -> Double.compare(s.getGpa(), maxGPA) == 0)
                .collect(Collectors.toList());

    }


}
