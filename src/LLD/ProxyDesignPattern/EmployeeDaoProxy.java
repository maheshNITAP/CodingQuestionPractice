package LLD.ProxyDesignPattern;

public class EmployeeDaoProxy implements EmployeeDao {
    private EmployeeDaoImpl employeeDaoImpl;
    private String clientRole;

    public EmployeeDaoProxy(String clientRole) {
        this.employeeDaoImpl = new EmployeeDaoImpl();
        this.clientRole = clientRole;

    }


    @Override
    public void getEmployeeInfo(int empId) {
        if(clientRole=="USER" || clientRole=="ADMIN")
            employeeDaoImpl.getEmployeeInfo(empId);
        else
            throw new RuntimeException("Unauthorized Access");
    }

    @Override
    public void createEmployee(Employee employee) {
        if(clientRole == "ADMIN")
            employeeDaoImpl.createEmployee(employee);
        else
            throw new RuntimeException("Unauthorized Access");

    }
}
