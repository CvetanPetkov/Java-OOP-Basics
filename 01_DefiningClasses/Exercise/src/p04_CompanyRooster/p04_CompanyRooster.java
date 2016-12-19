package p04_CompanyRooster;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Employee {
    String name;
    Double salary;
    String position;
    String department;
    String email;
    int age;

    Employee (String name, Double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }
}

public class p04_CompanyRooster {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ROOT);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, List<Double>> salaryByDepartments = new HashMap<String, List<Double>>();
        List<Employee> employees = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("[\\s+]");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            String email = "n/a";
            int age = -1;
            if (input.length > 4) {
                if (input[4].contains("@")) {
                    email = input[4];
                } else {
                    age = Integer.parseInt(input[4]);
                }
            } if (input.length > 5) {
                age = Integer.parseInt(input[5]);
            }

            Employee employee = new Employee(name, salary, position, department, email, age);

            if (!salaryByDepartments.containsKey(department)) {
                salaryByDepartments.put(department, new ArrayList<>());
                salaryByDepartments.get(department).add(salary);
                employees.add(employee);
            } else {
                salaryByDepartments.get(department).add(salary);
                employees.add(employee);
            }
        }

        HashMap<String, Double> averageSalaryes = new HashMap<>();
        salaryByDepartments.entrySet().stream()
                .forEach(entry -> {
                    double average = entry.getValue().stream().mapToDouble(i -> i)
                            .average().getAsDouble();
                    averageSalaryes.put(entry.getKey(), average);
                });

        String bestDepartment = Collections.max(averageSalaryes.entrySet(), (entry1, entry2) ->
        entry1.getValue() > entry2.getValue() ? 1:-1).getKey();

        System.out.println("Highest Average Salary: " + bestDepartment);
        employees.stream()
                .filter(employe -> employe.department.equals(bestDepartment))
                .sorted((employe1, employe2) -> employe2.salary.compareTo(employe1.salary))
                .forEach(employee -> {
                    System.out.printf("%s %.2f %s %d%n", employee.name, employee.salary
                    , employee.email, employee.age);
                });
    }
}
