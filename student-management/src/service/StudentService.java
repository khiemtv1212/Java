package service;

import java.util.List;
import model.Student;
import repository.StudentRepository;

public class StudentService {

    private StudentRepository repo = new StudentRepository();
    private int autoId = 1;

    public void addStudent(String name, int age) {
        if (age <= 0) {
            System.out.println("❌ Tuổi không hợp lệ!");
            return;
        }
        Student student = new Student(autoId, name, age);
        repo.addStudent(student);
        autoId++;
        System.out.println("✅ Thêm sinh viên thành công!");
    }

    public List<Student> getAllStudents() {
        return repo.getAllStudents();
    }

    public Student findStudentById(int id) {
        return repo.findById(id);
    }

    public void deleteStudentById(int id) {
        if (repo.deleteById(id)) {
            System.out.println("✅ Xóa sinh viên thành công!");
        } else {
            System.err.println("❌ Không tìm thấy sinh viên!");
        }
    }
}
