package ru.anikeeva.secondweek.dao;

import org.springframework.stereotype.Component;
import ru.anikeeva.secondweek.models.Employee;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAO {
    public static int EMPLOYEE_COUNT;
    private List<Employee> employees;

    {
        employees = new ArrayList<Employee>();

        employees.add(new Employee(++EMPLOYEE_COUNT, "Oleg", "Gorshkov", 39, 18, 1));
        employees.add(new Employee(++EMPLOYEE_COUNT, "Anna", "Broun", 28, 6, 1));
        employees.add(new Employee(++EMPLOYEE_COUNT, "Nikolay", "Gogolev", 45, 27, 3));
        employees.add(new Employee(++EMPLOYEE_COUNT, "Ivan", "Sumskiy", 30, 8, 2));
        employees.add(new Employee(++EMPLOYEE_COUNT, "Maria", "Blinova", 35, 9, 2));
        employees.add(new Employee(++EMPLOYEE_COUNT, "Julia", "Sergeeva", 29, 8, 1));
        employees.add(new Employee(++EMPLOYEE_COUNT, "Semen", "Slepakov", 43, 16, 3));
        employees.add(new Employee(++EMPLOYEE_COUNT, "Artur", "Sharifov", 31, 5, 2));
        employees.add(new Employee(++EMPLOYEE_COUNT, "Galina", "Bochkareva", 30, 5, 3));
    }

    public List<Employee> index(){
        return employees;
    }

    public Employee show(int id){
        return employees.stream().filter(e -> e.getId() == id).findAny().orElse(null);
    }

    public void save(Employee employee){
        employee.setId(++EMPLOYEE_COUNT);
        employees.add(employee);
    }

    public void update(int id, Employee updatedEmployee){
        Employee employeeToUpdated = show(id);
        employeeToUpdated.setName(updatedEmployee.getName());
        employeeToUpdated.setSurname(updatedEmployee.getSurname());
        employeeToUpdated.setAge(updatedEmployee.getAge());
        employeeToUpdated.setExperience(updatedEmployee.getExperience());
        employeeToUpdated.setManagerId(updatedEmployee.getManagerId());
    }

    public void delete(int id){
        employees.removeIf(e -> e.getId() == id);
    }

}
