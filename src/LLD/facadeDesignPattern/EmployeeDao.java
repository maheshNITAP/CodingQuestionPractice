package LLD.facadeDesignPattern;

public class EmployeeDao {
    public Employee getEmployeeById(int id) {
        // Simulating database access
        return new Employee(id, "John Doe", "Engineering");
    }
    public void insertEmployee(Employee employee) {
        // Simulating database access
        System.out.println("Employee saved: " + employee.getName());
    }
    public void updateEmployee(Employee employee) {
        // Simulating database access
        System.out.println("Employee updated: " + employee.getName());
    }
    public void deleteEmployee(int id) {
        // Simulating database access
        System.out.println("Employee deleted with ID: " + id);
    }
}
