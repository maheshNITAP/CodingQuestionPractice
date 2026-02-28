package LLD.ProxyDesignPattern;

public class EmpDemo {
    public static void main(String[] args) {
        EmployeeDao userProxyObj = new EmployeeDaoProxy("USER");
        userProxyObj.getEmployeeInfo(101);
        try {
            userProxyObj.createEmployee(new Employee(102, "John Doe", "Engineering"));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-----------------------------");

        EmployeeDao userProxy2 = new EmployeeDaoProxy("ADMIN");
        userProxy2.getEmployeeInfo(102);
        userProxy2.createEmployee(new Employee(103, "Jane Smith", "Marketing"));

    }
}
