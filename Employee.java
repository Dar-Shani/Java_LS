package Lessons.LS4;

public class Employee {
    private String name;
    private int personnelNumber;
    private int phoneNumber;
    private float experience;

    Employee(String name, int personnelNumber, int phoneNumber, float experience) {
        this.name = name;
        this.personnelNumber = personnelNumber;
        this.phoneNumber = phoneNumber;
        this.experience = experience;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public float getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return name + ", табельный номер " + personnelNumber + ", тел " + getPhoneNumber() + ", Стаж "
                + getExperience();
    }
}
