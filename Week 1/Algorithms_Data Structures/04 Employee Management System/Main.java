public class Main {
    public static void main(String[] args) {
        // Create an EmployeeManager with a capacity of 5 employees
        System.out.println();
        EmployeeManager manager = new EmployeeManager(5);

        // Create some employees
        Employee emp1 = new Employee(1, "Ansari", "Developer", 60000);
        Employee emp2 = new Employee(2, "Bala", "Manager", 80000);
        Employee emp3 = new Employee(3, "Caesar", "Designer", 50000);
        
        // Add employees to the manager
        manager.addEmployee(emp1);
        manager.addEmployee(emp2);
        manager.addEmployee(emp3);
        
        // Traverse and display employees
        System.out.println("Employees after adding:");
        manager.traverseEmployees();
        
        // Search for an employee
        Employee searchedEmployee = manager.searchEmployee(2);
        System.out.println("\nSearched Employee with ID 2: " + searchedEmployee);
        
        // Delete an employee
        boolean isDeleted = manager.deleteEmployee(1);
        System.out.println("\nEmployee with ID 1 deleted: " + isDeleted);
        
        // Display employees after deletion
        System.out.println("\nEmployees after deletion:");
        manager.traverseEmployees();
        
        // Attempt to add an employee after reaching capacity
        Employee emp4 = new Employee(4, "Nafila", "Analyst", 55000);
        manager.addEmployee(emp4);
        
        // Display employees after adding a new employee
        System.out.println("\nEmployees after adding a new employee:");
        manager.traverseEmployees();
    }
}
