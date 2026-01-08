package main;

import java.util.List;
import java.util.Scanner;
import model.Student;
import service.StudentService;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Xem danh sách sinh viên");
            System.out.println("3. Tìm sinh viên theo ID");
            System.out.println("4. Xóa sinh viên theo ID");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // ăn dòng thừa

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();

                    System.out.print("Nhập tuổi: ");
                    int age = scanner.nextInt();

                    service.addStudent(name, age);
                    break;

                case 2:
                    List<Student> students = service.getAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("📭 Danh sách trống");
                    } else {
                        for (Student s : students) {
                            System.out.println(
                                    s.getId() + " - " + s.getName() + " - " + s.getAge()
                            );
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID cần tìm: ");
                    int findId = scanner.nextInt();

                    Student found = service.findStudentById(findId);
                    if (found != null) {
                        System.out.println(
                                found.getId() + " - " + found.getName() + " - " + found.getAge()
                        );
                    } else {
                        System.out.println("❌ Không tìm thấy sinh viên");
                    }
                    break;

                case 4:
                    System.out.print("Nhập ID cần xóa: ");
                    int deleteId = scanner.nextInt();
                    service.deleteStudentById(deleteId);
                    break;

                case 0:
                    System.out.println("👋 Tạm biệt!");
                    return;

                default:
                    System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        }
    }
}
