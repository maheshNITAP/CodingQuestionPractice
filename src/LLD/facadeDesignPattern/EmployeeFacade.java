package LLD.facadeDesignPattern;

public class EmployeeFacade {
    private EmployeeDao employeeDao;

    public EmployeeFacade() {
        this.employeeDao = new EmployeeDao();
    }

    public void insertEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }

    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }
}
