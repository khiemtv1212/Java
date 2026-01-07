package main;

import java.util.List;
import model.Student;
import service.StudentService;

public class Main {

    public static void main(String[] args) {

        StudentService service = new StudentService();

        service.addStudent(1, "An", 20);
        service.addStudent(2, "Bình", 21);

        List<Student> students = service.getAllStudents();

        for (Student s : students) {
            System.out.println(
                    s.getId() + " - " + s.getName() + " - " + s.getAge()
            );
        }
    }
}
