package vn.edu.hcmuaf.fit.studentmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.hcmuaf.fit.studentmanager.model.Student;
import vn.edu.hcmuaf.fit.studentmanager.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

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

    public Student updateStudent(int id, Student studentDetails) {
        // Tìm sinh viên trong CSDL
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sinh viên với id: " + id));

        // Cập nhật thông tin
        student.setMssv(studentDetails.getMssv());
        student.setName(studentDetails.getName());
        student.setClassName(studentDetails.getClassName());
        student.setEmail(studentDetails.getEmail());
        student.setPhone(studentDetails.getPhone());
        student.setGpa(studentDetails.getGpa());
        student.setAvatar(studentDetails.getAvatar());

        // Lưu lại vào CSDL
        return studentRepository.save(student);
    }

    public Optional<Student> getStudentByMssv(String mssv) {
        return Optional.ofNullable(studentRepository.findByMssv(mssv));
    }

    public List<Student> searchByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }
}
