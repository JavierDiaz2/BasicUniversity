package models;

import java.util.List;
import java.util.ArrayList;

public class Classroom {
    private String name;
    private String classNumber;
    private Teacher teacher;
    private List<Student> students;

    public Classroom(String name, String classNumber, Teacher teacher) {
        this.name = name;
        this.classNumber = classNumber;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    public List<Student> getStudents() {
        return students;
    }
    public String getName() {
        return name;
    }
    public String getClassNumber() {
        return classNumber;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public String toString() {
        StringBuilder studentsList = new StringBuilder();
        for (Student student : students){
            studentsList.append("\n - ").append(student.getName()).append(" (ID: ").append(student.getId()).append(")");
        }

        return "Class: " + name + " (" + classNumber + ") - Teacher: " + teacher.getName() + "\nStudents: " + (students.isEmpty() ? "No students in this class" : studentsList.toString());
    }
}
