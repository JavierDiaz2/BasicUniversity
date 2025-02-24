package main;

import models.*;
import services.UniversityService;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UniversityService universityService = new UniversityService();
        Scanner scanner = new Scanner(System.in);

        //Initialization will be here

        while (true) {
            System.out.println("\n1. List Teachers");
            System.out.println("2. List Class Names");
            System.out.println("3. Show Class Details");
            System.out.println("4. Add New Student to a Class");
            System.out.println("5. Create a New Class");
            System.out.println("6. Find Student Classes");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    universityService.listTeachers();
                    break;
                case 2:
                    universityService.listClasses(); // Changed to list only class names
                    break;
                case 3:
                    System.out.print("Enter class name: ");
                    String className = scanner.nextLine();
                    Optional<Classroom> foundClass = universityService.findClassByName(className);
                    if (foundClass.isPresent()) {
                        System.out.println(foundClass.get());
                    } else {
                        System.out.println("Class not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    Optional<Student> student = universityService.findStudentById(studentId);
                    if (!student.isPresent()) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.print("Enter class name: ");
                    String targetClassName = scanner.nextLine();
                    Optional<Classroom> targetClass = universityService.findClassByName(targetClassName);
                    if (targetClass.isPresent()) {
                        targetClass.get().addStudent(student.get());
                        System.out.println("Student added to class.");
                    } else {
                        System.out.println("Class not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter new class name: ");
                    String newClassName = scanner.nextLine();
                    System.out.print("Enter classroom number: ");
                    String newClassRoom = scanner.nextLine();

                    universityService.listTeachers();
                    System.out.print("Enter teacher's name: ");
                    String teacherName = scanner.nextLine();
                    Optional<Teacher> assignedTeacher = universityService.findTeacherByName(teacherName);

                    if (!assignedTeacher.isPresent()) {
                        System.out.println("Teacher not found.");
                        break;
                    }

                    Classroom newClass = new Classroom(newClassName, newClassRoom, assignedTeacher.get());
                    universityService.addClass(newClass);
                    System.out.println("New class created.");
                    break;
                case 6:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    universityService.findClassesByStudentId(id).forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}