package LLD.facadeDesignPattern;

public class EmployeeClient {
    public static void main(String[] args) {
        EmployeeFacade employeeFacade = new EmployeeFacade();

        // Insert a new employee
        Employee newEmployee = new Employee(1, "Alice Smith", "HR");
        employeeFacade.insertEmployee(newEmployee);

        System.out.println("-----------------------------");

        // Get employee by ID
        Employee employee = employeeFacade.getEmployeeById(1);
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Employee Department: " + employee.getDepartment());
    }
}
