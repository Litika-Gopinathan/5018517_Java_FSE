
public class Driver4 {
	public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        Employee emp1 = new Employee(1, "ABC", "Developer", 80000);
        Employee emp2 = new Employee(2, "DEF", "Manager", 90000);
        Employee emp3 = new Employee(3, "GHI", "HR", 70000);

        ems.addEmployee(emp1);
        ems.addEmployee(emp2);
        ems.addEmployee(emp3);

        System.out.println("All Employees:");
        ems.traverseEmployees();

        System.out.println("Searching for Employee with ID 3:");
        System.out.println(ems.searchEmployee(3));

        System.out.println("Deleting Employee with ID 1:");
        ems.deleteEmployee(1);

        System.out.println("All Employees after deletion:");
        ems.traverseEmployees();
    }
}
