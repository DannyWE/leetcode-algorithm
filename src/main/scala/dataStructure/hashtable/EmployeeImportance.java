package dataStructure.hashtable;

//https://leetcode.com/problems/employee-importance/description/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeImportance {

    int total = 0;
    public int getImportance(List<Employee> employees, int id) {
        Employee leader = employees.stream().filter(e -> e.id == id).collect(Collectors.toList()).get(0);
        total += leader.importance;
        leader.subordinates.stream().forEach(t -> getImportance(employees, t));
        return total;
    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list.add(new Employee(1, 5, list1));
        list.add(new Employee(2, 3, new ArrayList<>()));
        list.add(new Employee(3, 3, new ArrayList<>()));
        System.out.println(new EmployeeImportance().getImportance(list, 1));
    }
}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
};