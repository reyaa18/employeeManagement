package Client;

import daoImpl.EmployeeDAOImpl;
import java.util.List;
import java.util.Scanner;
import model.Employee;
import DOA.EmployeeDAO;

class Organizes{
	Scanner in=new Scanner(System.in);
	
	void createUser() {
		EmployeeDAO employeeDAO=new EmployeeDAOImpl();
		System.out.println("Enter the Emp name");
		String name=in.nextLine();
		System.out.println("Enter the Emp email");
		String email=in.nextLine();
		System.out.println("Enter the Emp Salary");
		double salary=in.nextDouble();
		in.nextLine();
		System.out.println("Enter the Emp DOJ DD-MM-YYYY");
		String dateString=in.nextLine();
		System.out.println("Enter the Emp bonus");
		int bonus=in.nextInt();
		in.nextLine();
		Employee e3=new Employee(name, email,salary,dateString,bonus);
		System.out.println("Employee Data");
		employeeDAO.CreateEmployee(e3);
	}
	void getByEmpId(){
        Employee e1=new Employee();	
		EmployeeDAO employeeDAO=new EmployeeDAOImpl();
		System.out.println("Enter the Emp Id");
		int emp_id=in.nextInt();
		in.nextLine();
		e1=employeeDAO.getEmployeeById(emp_id);
		System.out.println(e1);
	}
	void deleteById() {
		System.out.println("Enter the Emp Id");
		int emp_id=in.nextInt();
		in.nextLine();
		EmployeeDAO employeeDAO=new EmployeeDAOImpl();
		employeeDAO.deleteEmployeeById(emp_id);
	}
	void updateEmail() {
		System.out.println("Enter the Emp ID");
		int emp_id=in.nextInt();
		in.nextLine();
		System.out.println("Enter the New Email");
		String emp_email=in.nextLine();
		EmployeeDAO employeeDAO=new EmployeeDAOImpl();
		employeeDAO.updateEmployeeEmailById(emp_email,emp_id);
	}
	void listAll() {
		EmployeeDAO employeeDAO=new EmployeeDAOImpl();
		List<Employee> empList = employeeDAO.getAllEmployeesInfo();
		System.out.println();
		for (Employee employee : empList)
			System.out.println(employee);
		System.out.println();
	}
	
}

public class ClientTest {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		Organizes org=new Organizes();
		boolean con=true;

		while(con) {
			System.out.println();
			System.out.println("Enter 1 to add new Employee");
			System.out.println("Enter 2 to get employee details by ID");
			System.out.println("Enter 3 to delete employee by ID");
			System.out.println("Enter 4 to update email by ID");
			System.out.println("Enter 5 to update list all employees");
			System.out.println("Enter 6 to Exit");
			System.out.println("---Enter an option---");
			
			int ch=in.nextInt();
			
			switch(ch) {
			case 1:
				org.createUser();
				break;
			case 2:
				org.getByEmpId();
				break;
			case 3:
				org.deleteById();
				break;
			case 4:
				org.updateEmail();
				break;
			case 5:
				org.listAll();
				break;
			case 6:
				con=false;
				System.out.println("End of Program");
				break;
			default:
				System.out.println("Enter a valid option");
				break;
			}
		}
	
		in.close();
	}
}