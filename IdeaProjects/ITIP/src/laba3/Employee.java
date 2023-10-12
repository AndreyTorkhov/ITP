package laba3;

import java.util.HashMap;
public class Employee {
    private int id;
    private String name;
    private String position;
    private double salary;

    public Employee(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    // Геттеры и сеттеры для полей
}


class EmployeeDatabase {
    private HashMap<Integer, Employee> employees;

    public EmployeeDatabase() {
        employees = new HashMap<>();
    }

    public void addEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    public Employee findEmployee(int id) {
        return employees.get(id);
    }

    public void removeEmployee(int id) {
        employees.remove(id);
    }
}

class MainEmployee {
    public static void main(String[] args) {
        EmployeeDatabase database = new EmployeeDatabase();

        // Добавление сотрудников
        Employee employee1 = new Employee(1, "John Doe", "Manager", 50000);
        Employee employee2 = new Employee(2, "Jane Smith", "Developer", 60000);
        database.addEmployee(employee1);
        database.addEmployee(employee2);

        // Поиск сотрудника по ID
        Employee foundEmployee = database.findEmployee(1);
        if (foundEmployee != null) {
            System.out.println("Employee found: " + foundEmployee.getName());
        } else {
            System.out.println("Employee not found.");
        }

        // Удаление сотрудника
        database.removeEmployee(1);
    }
}