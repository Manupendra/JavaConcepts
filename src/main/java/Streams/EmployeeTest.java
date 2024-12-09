package Streams;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeTest {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", "2024-11-12", List.of("Java", "Scala")));
        empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", "2024-10-01", List.of("Java", "Python")));
        empList.add(new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", "2023-05-06", List.of("Java", "React")));
        empList.add(new Employee(4, "def", 32, 125, "F", "HR", "Chennai", "2022-05-29", List.of("C++", "Python")));

        empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", "2024-07-22", List.of("NodeJS", "Python")));
        empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", "2024-05-16", List.of("React", ".Net")));
        empList.add(new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", "2014-05-16", List.of("", "Python")));
        empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandam", "2024-10-16", List.of("NodeJS", "Python")));
        empList.add(new Employee(9, "stv", 25, 160, "M", "IT", "Blore", "1999-05-25", List.of("Java", "TypeJS")));

        /**
         * Group the employees by city
         */

        Map<String, List<Employee>> empByCity;
        empByCity = empList.stream().collect(Collectors.groupingBy(Employee::getCity));
        System.out.println("Employees grouped by city:: \n" + empByCity);

        System.out.println("-------------------------------");
        /**
         * Group the Employee by Age
         */

        Map<Integer, List<Employee>> empByAge;
        empByAge = empList.stream().collect(Collectors.groupingBy(Employee::getAge));
        System.out.println("Employees grouped by Age :: \n" + empByAge);

        /**
         * Find the count of male and female employees present in the organization.
         */

        System.out.println("-------------------------------");
        Map<String, Long> noOfMalesAndFemales = empList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Count of Males and Females \n" + noOfMalesAndFemales);

        /**
         * Print the names of all departments in the organization.
         */

        empList.stream().map(Employee::getDeptName).distinct().forEach(System.out::println);

        System.out.println("-------------------------------");
        /**
         * employee details whose age is greater than 28
         */

        empList.stream().filter(emp -> emp.getAge() > 28).
                collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("-------------------------------");

        /**
         * Sort the employees salary in the organisation in ascending order
         */

        empList.stream()
                .sorted(Comparator.comparingLong(Employee::getSalary).reversed())
                .toList()
                .forEach(System.out::println);

        System.out.println("-------------------------------");

        /**
         * Find Highest salary in the organisation.
         */
        Optional<Employee> empHighest = empList.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("Highest Salary in org: " + empHighest.get().getSalary());
        System.out.println("-------------------------------");

        /**
         * Find highest paid salary in the organisation based on gender
         */
        Map<String, Optional<Employee>> highestPaidMF = empList.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.maxBy((t1, t2) -> (int) (t1.getSalary() - t2.getSalary()))));
        System.out.println("Highest paid by gender: " + highestPaidMF);
        System.out.println("-------------------------------");

        /**
         * Find the department name which has the highest number of employees.
         */

        Map.Entry<String, Long> maxNoOfEmpInDept = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();

        System.out.println("Max # of employees present in Dept :: " + maxNoOfEmpInDept);
        System.out.println("-------------------------------");

        /**
         * Find youngest Female Employee
         */

        Optional<Employee> youngestEmp = empList.stream()
                .filter(emp -> emp.getGender() == "F")
                .min(Comparator.comparingInt(Employee::getAge));

        System.out.println("Youngest Female employee:: \n" + youngestEmp.get());

        /**
         * Find the employees with skill Java and DOJ is less than 6 months
         */

        System.out.println("-------------------------------");

        // Define the cutoff date (6 months back from now)
        LocalDate cutoffDate = LocalDate.now().minus(6, ChronoUnit.MONTHS);

        // Define the date formatter (assuming DOJ is in yyyy-MM-dd format)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<Employee> filteredEmp = empList.stream()
                .filter(emp -> emp.getSkills().contains("Java"))
                .filter(emp -> {
                    LocalDate doj = LocalDate.parse(emp.getDateOfJoining(), formatter);
                    return doj.isAfter(cutoffDate);
                })
                .toList();
        filteredEmp.forEach(emp -> System.out.println(emp.getName()));

    }
}
