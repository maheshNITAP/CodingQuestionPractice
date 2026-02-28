package LLD.ProxyDesignPattern;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void getEmployeeInfo(int empId) {
        // Simulate fetching employee info from a database
        System.out.println("Fetching employee info for empId: " + empId);
    }

    @Override
    public void createEmployee(Employee employee) {
        // Simulate creating a new employee record in a database
        System.out.println("Creating employee: " + employee.getName() + " in department: " + employee.getDepartment());
    }
}
