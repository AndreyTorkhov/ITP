package laba3_fixed;

import java.util.Hashtable;
import java.util.LinkedList;

public class HashTable<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    public HashTable() {
        table = new LinkedList[INITIAL_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> getTable = table[index];
        if (getTable != null) {
            for (Entry<K, V> entry : getTable) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> removeTable = table[index];
        if (removeTable != null) {
            for (Entry<K, V> entry : removeTable) {
                if (entry.getKey().equals(key)) {
                    removeTable.remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % table.length;
    }
    public static class Employee {
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

    public static class EmployeeDatabase {
        private Hashtable<Integer, Employee> employees;

        public EmployeeDatabase(int capacity) {
            employees = new Hashtable<>();
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

    public static void main(String[] args) {
        HashTable.EmployeeDatabase database = new HashTable.EmployeeDatabase(10);

        HashTable.Employee employee1 = new HashTable.Employee(1, "John Doe", "Manager", 50000);
        HashTable.Employee employee2 = new HashTable.Employee(2, "Jane Smith", "Developer", 60000);
        database.addEmployee(employee1);
        database.addEmployee(employee2);
        employee2.info();

        database.removeEmployee(1);
        System.out.println("Employee found: " + database.findEmployee(1));

    }
}
