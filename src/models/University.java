package models;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Classroom> classes;

    public University () {
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.classes = new ArrayList<>();
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }
    public List<Student> getStudents() {
        return students;
    }
    public List<Classroom> getClasses() {
        return classes;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void addClass(Classroom classroom) {
        classes.add(classroom);
    }
}
