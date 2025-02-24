package main;

import models.*;
import services.UniversityService;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UniversityService universityService = new UniversityService();
        Scanner scanner = new Scanner(System.in);

        // Initialization
        Teacher FT1 = new FullTeacher("Diana", 2000, 7);
        Teacher FT2 = new FullTeacher("Anderson", 2100, 10);
        Teacher PT1 = new PartTeacher("Laura", 30, 15);
        Teacher PT2 = new PartTeacher("Alexander", 35, 26);

        universityService.addTeacher(FT1);
        universityService.addTeacher(FT2);
        universityService.addTeacher(PT1);
        universityService.addTeacher(PT2);


        universityService.addStudent(new Student(1, "Carlos", 20));
        universityService.addStudent(new Student(2, "Natalia", 22));
        universityService.addStudent(new Student(3, "David", 21));
        universityService.addStudent(new Student(4, "Javier", 26));
        universityService.addStudent(new Student(5, "Miguel", 18));
        universityService.addStudent(new Student(6, "Sofia", 24));



        Classroom java_basics = new Classroom("Java Basics", "101", FT2);
        Classroom tae = new Classroom("T.A.E", "102", PT2);
        Classroom manual_testing = new Classroom("Manual Testing", "103", PT1);
        Classroom accessibility = new Classroom("Accessibility", "104", FT1);

        universityService.addClass(java_basics);
        universityService.addClass(tae);
        universityService.addClass(manual_testing);
        universityService.addClass(accessibility);

        java_basics.addStudent(universityService.findStudentById(1).get());  // Carlos
        java_basics.addStudent(universityService.findStudentById(2).get());  // Natalia

        tae.addStudent(universityService.findStudentById(3).get()); // David
        tae.addStudent(universityService.findStudentById(4).get()); // Javier

        manual_testing.addStudent(universityService.findStudentById(5).get()); // Miguel
        manual_testing.addStudent(universityService.findStudentById(6).get()); // Sofia

        accessibility.addStudent(universityService.findStudentById(1).get()); // Carlos
        accessibility.addStudent(universityService.findStudentById(3).get()); // David

        while (true) {
            System.out.println("\n1. List of Teachers");
            System.out.println("2. List of Classes");
            System.out.println("3. Show Class Details");
            System.out.println("4. Add Student to a Class");
            System.out.println("5. Create a New Class");
            System.out.println("6. Find Student Classes");
            System.out.println("7. Create New Student");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    universityService.listTeachers();
                    break;
                case 2:
                    universityService.listClasses();
                    break;
                case 3:
                    System.out.print("Enter class name: ");
                    String className = scanner.nextLine();
                    Optional<Classroom> foundClass = universityService.findClassByName(className);
                    if (foundClass.isPresent()) {
                        System.out.println(foundClass.get());  // Show full class details
                    } else {
                        System.out.println("Class not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();

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
                    scanner.nextLine();
                    universityService.findClassesByStudentId(id).forEach(System.out::println);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                case 7:
                    System.out.print("Enter student ID: ");
                    int newStudentId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    System.out.print("Enter student name: ");
                    String newStudentName = scanner.nextLine();

                    System.out.print("Enter student age: ");
                    int newStudentAge = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    Student newStudent = new Student(newStudentId, newStudentName, newStudentAge);
                    universityService.addStudent(newStudent);
                    System.out.println("New student added successfully.");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}