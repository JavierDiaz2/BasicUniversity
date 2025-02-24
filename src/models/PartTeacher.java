package models;

public class PartTeacher extends Teacher {
    private int activeHoursPerWeek;

    public PartTeacher(String name, double baseSalary, int activeHoursPerWeek) {
        super(name, baseSalary);
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    @Override
    public double calculateSalary() {
        return baseSalary * activeHoursPerWeek;
    }
}
