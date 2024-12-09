package Streams;

import java.util.List;

public class Employee {
    private int id;
    private String name;
    private int age;
    private long salary;
    private String gender;
    private String deptName;
    private String city;
    private String dateOfJoining;
    List<String> skills;

    public Employee(int id, String name, int age, long salary, String gender, String deptName, String city, String dateOfJoining, List<String> skills) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.deptName = deptName;
        this.city = city;
        this.dateOfJoining = dateOfJoining;
        this.skills = skills;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public List<String> getSkills() {
        return skills;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", deptName='" + deptName + '\'' +
                ", city='" + city + '\'' +
                ", dateOfJoining='" + dateOfJoining + '\'' +
                ", skills=" + skills +
                '}';
    }
}
