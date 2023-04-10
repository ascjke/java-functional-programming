package ru.borisov.streams.transformingelements;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

public class EmployeesCounter {

    public static void main(String[] args) {

        List<Department> departments = List.of(
                new Department("dep-1", "111-1", List.of(
                        new Employee("William", 15000L),
                        new Employee("Sophia", 22000L),
                        new Employee("John", 20000L)
                )),
                new Department("dep-2", "222-1", List.of(
                        new Employee("Victor", 25000L)
                ))
        );
        System.out.println("Number calculated:" + EmployeesCounter.calcNumberOfEmployees(departments, 17000L));
    }

    /**
     * Calculates the number of employees with salary >= threshold (only for 111- departments)
     *
     * @param departments are list of departments
     * @param threshold   is lower edge of salary
     * @return the number of employees
     */
    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        return departments.stream()
                .filter(department -> department.getCode().startsWith("111-"))
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getSalary() >= threshold)
                .count();
    }
}

@RequiredArgsConstructor
@Getter
@ToString
class Employee {
    private final String name;
    private final Long salary;
}

@RequiredArgsConstructor
@Getter
@ToString
class Department {
    private final String name;
    private final String code;
    private final List<Employee> employees;
}
