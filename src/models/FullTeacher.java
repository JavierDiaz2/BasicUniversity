package models;

public class FullTeacher extends Teacher {
    private int experienceYears;

    public FullTeacher(String name, double baseSalary, int experienceYears) {
        super(name,baseSalary);
        this.experienceYears = experienceYears;
    }

    @Override
    public double calculateSalary() {
        return baseSalary * (1 + (0.1 * experienceYears));
    }
}
