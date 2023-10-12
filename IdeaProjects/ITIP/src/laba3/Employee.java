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

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void info() {
        System.out.println(getName() + " имеет должность " + getPosition() + " и зарабатывает " + getSalary());
    }

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

        Employee employee1 = new Employee(1, "John Doe", "Manager", 50000);
        Employee employee2 = new Employee(2, "Jane Smith", "Developer", 60000);
        database.addEmployee(employee1);
        database.addEmployee(employee2);
        employee2.info();

        Employee foundEmployee1 = database.findEmployee(1);
        if (foundEmployee1 != null) {
            System.out.println("Employee found: " + foundEmployee1.getName());
        } else {
            System.out.println("Employee not found.");
        }

        database.removeEmployee(1);
        Employee foundEmployee2 = database.findEmployee(1);
        if (foundEmployee2 != null) {
            System.out.println("Employee found: " + foundEmployee2.getName());
        } else {
            System.out.println("Employee not found.");
        }
    }
}