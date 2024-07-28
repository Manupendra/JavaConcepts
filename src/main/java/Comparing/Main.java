package Comparing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        String[] fruits = {"banana", "apple", "pear", "mango", "BANANA"};
        Arrays.sort(fruits);
        System.out.println("-------------------------");
        System.out.println(Arrays.toString(fruits));

        Employee manu = new Employee("Manu");
        Employee[] employees = {new Employee("Manupendra"), new Employee("Raj"), new Employee("Ankush")};

        Arrays.sort(employees);
        System.out.println("-------------------------");
        System.out.println(Arrays.toString(employees));

        System.out.println("results = " + manu.compareTo(new Employee("manupendra")));

        Comparator<Employee> dependencySorter = new EmployeeDependencyComparator();
        Arrays.sort(employees, dependencySorter.reversed());
        System.out.println(Arrays.toString(employees));
    }
}

class EmployeeDependencyComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return (o1.dependency + o1.name).compareTo(o2.dependency + o2.name);
    }
}

class Employee implements Comparable<Employee> {
    private static int LAST_ID = 1000;
    private static Random random = new Random();
    String name;
    private int employeeID;
    protected double dependency;

    public Employee(String name) {
        this.name = name;
        employeeID = LAST_ID++;
        dependency = random.nextDouble(6.0, 10.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(employeeID, name, dependency);
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.valueOf(employeeID).compareTo(Integer.valueOf(o.employeeID));
    }


//    @Override
//    public int compareTo(Object o) {
//        Employee other = (Employee) o;
//        return name.compareTo(other.name);
//    }
}
