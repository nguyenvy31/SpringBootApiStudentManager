package vn.edu.hcmuaf.fit.studentmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.hcmuaf.fit.studentmanager.model.Student;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Integer là kiểu của ID trong Student

    // Tìm theo MSSV
    Student findByMssv(String mssv);

    // Tìm theo tên
    List<Student> findByNameContainingIgnoreCase(String name);

}