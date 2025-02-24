package models;

public abstract class Teacher {
    protected String name;
    protected double baseSalary;

    public Teacher (String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Teacher: " + name + ", Salary: " + calculateSalary();
    }
}
