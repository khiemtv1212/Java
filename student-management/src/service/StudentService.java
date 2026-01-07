package service;

import java.util.List;
import model.Student;
import repository.StudentRepository;

public class StudentService {

    private StudentRepository repo = new StudentRepository();

    public void addStudent(int id, String name, int age) {
        Student student = new Student(id, name, age);
        repo.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return repo.getAllStudents();
    }
}
