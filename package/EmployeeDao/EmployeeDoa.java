package DOA;

import java.util.List;

import model.Employee;

public interface EmployeeDAO {
	 void CreateEmployee(Employee employee);
	Employee getEmployeeById(int employee);
	void updateEmployeeEmailById(String newEmail,int employeeId);
	void deleteEmployeeById(int employeeId);
	List<Employee> getAllEmployeesInfo();

}