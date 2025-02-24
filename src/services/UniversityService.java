package services;

import models.Classroom;
import models.Student;
import models.Teacher;
import models.University;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UniversityService {
    private University university;
    public UniversityService() {
        this.university = new University();
    }
    public void addTeacher(Teacher teacher) {
        university.addTeacher(teacher);
    }
    public void addStudent(Student student) {
        university.addStudent(student);
    }
    public void addClass(Classroom classroom) {
        university.addClass(classroom);
    }
    public Optional<Student> findStudentById(int id) {
        return university.getStudents().stream().filter(s -> s.getId() == id).findFirst();
    }
    public List<Classroom> findClassesByStudentId(int id) {
        return university.getClasses().stream()
                .filter(c -> c.getStudents().stream().anyMatch(s -> s.getId() == id))
                .collect(Collectors.toList());
    }
    public Optional<Classroom> findClassByName(String name) {
        return university.getClasses().stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public Optional<Teacher> findTeacherByName(String name) {
        return university.getTeachers().stream()
                .filter(t -> t.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public void listTeachers() {
        university.getTeachers().forEach(System.out::println);
    }
    public void listClasses() {
        university.getClasses().forEach(System.out::println);
    }
}
