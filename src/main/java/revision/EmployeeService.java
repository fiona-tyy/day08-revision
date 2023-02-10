package revision;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private List<Employee> employees;
    
    public List<Employee> generateEmployees(){
        employees = new ArrayList<>();
        
        Employee emp = new Employee("1234", "Daniel", "SS","lect", "daniel@gmail.com", 5000);
        employees.add(emp);
        emp = new Employee("1235", "Eileen", "SS","lect", "eileen@gmail.com", 7000);
        employees.add(emp);
        emp = new Employee("1236", "Steven", "SS","lect", "steven@gmail.com", 8000);
        employees.add(emp);

        return employees;
    }
}
