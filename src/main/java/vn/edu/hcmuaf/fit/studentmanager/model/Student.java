package vn.edu.hcmuaf.fit.studentmanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students") // tên bảng trong DB
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "class_name") // tên cột vẫn là class_name
    private String className;

    private String email;

    @Column(length = 10)
    private String phone;

    private Float gpa;

    private String avatar;

    // 👇 Thêm cột MSSV
    @Column(name = "mssv", length = 20) // đặt length tùy ý
    private String mssv;

    public Student() {}

    public Student(int id, String name, String className, String email, String phone,
                   Float gpa, String avatar, String mssv) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.email = email;
        this.phone = phone;
        this.gpa = gpa;
        this.avatar = avatar;
        this.mssv = mssv;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Float getGpa() { return gpa; }
    public void setGpa(Float gpa) { this.gpa = gpa; }

    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }

    public String getMssv() { return mssv; }
    public void setMssv(String mssv) { this.mssv = mssv; }
}
