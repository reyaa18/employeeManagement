package daoImpl;

import java.util.List;

import DOA.EmployeeDAO;
import model.Employee;
import java.sql.Connection;
import util.DbConnection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
	public void CreateEmployee(Employee employee) {
		
		String sql="insert into employee(employee_name,email,salary,date_of_joining,bonus) values(?,?,?,?,?)";
		Connection con=DbConnection.connectWithDb();
		try {
		PreparedStatement ps1=con.prepareStatement(sql);
		ps1.setString(1,employee.getEmployee_name());
		ps1.setString(2,employee.getEmail());
		ps1.setDouble(3,employee.getSalary());
		ps1.setString(4,employee.getDate_of_joining());
		ps1.setInt(5,employee.getBonus());
		
		int ans=ps1.executeUpdate();
		
		if(ans==1) 
			System.out.println("created");
		else 
			System.out.println("not created");
		
		}
		catch(SQLException e) {
			System.out.println(e);	
		}
	}
	
	
	public Employee getEmployeeById(int employeeId) {
		Employee employee = null;
		String sql="select * from employee where employee_id=?";
		Connection con=DbConnection.connectWithDb();
		try {
			PreparedStatement ps1=con.prepareStatement(sql);
			ps1.setInt(1,employeeId);
			ResultSet rs=ps1.executeQuery();
			
			while(rs.next()) {
				int empId = rs.getInt("employee_id");
				String Name = rs.getString("employee_name");
				String email = rs.getString("email");
				Double salary = rs.getDouble("salary");
				String date = rs.getString("date_of_joining");
				int bonus = rs.getInt("bonus");
				
				employee = new Employee();
				employee.setEmployee_name(Name);
				employee.setBonus(bonus);
				employee.setDate_of_joining(date);
				employee.setEmail(email);
				employee.setEmployee_Id(empId);
				employee.setSalary(salary);
			}
			 
			
		}catch(SQLException e) {
			System.out.println(e);	
		}
		
		return employee;
		
		
	}
	public void updateEmployeeEmailById(String newEmail,int employeeId) {
		String sql="UPDATE employee set email=? WHERE employee_id=?;";
		Connection con=DbConnection.connectWithDb();
		try
		{
		PreparedStatement ps1=con.prepareStatement(sql);
		ps1.setString(1,newEmail);
		ps1.setInt(2,employeeId);
		int ans=ps1.executeUpdate();
		if(ans==1) 
			System.out.println("updated..");
		else
			System.out.println("Not updated...");
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		

	}
	public void deleteEmployeeById(int employeeId) {
		String sql="delete from employee where employee_id=?";
		Connection con=DbConnection.connectWithDb();
		try
		{
		PreparedStatement ps1=con.prepareStatement(sql);
		ps1.setInt(1,employeeId);
		int ans=ps1.executeUpdate();
		if(ans==1) 
			System.out.println("Deleted");
		else
			System.out.println("Not Deleted...");
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}
	public List<Employee> getAllEmployeesInfo(){
		List<Employee> emplist=new ArrayList<>();
		String sql="select * from employee;";
		Connection con=DbConnection.connectWithDb();
		try {
			PreparedStatement ps1=con.prepareStatement(sql);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				int empid=rs.getInt("employee_id");
				String empname=rs.getString("employee_name");
				String empemail=rs.getString("email");
				Double empsalary=rs.getDouble("salary");
				String dateofjoining=rs.getString("date_of_joining");
				int empbonus=rs.getInt("bonus");
				
				Employee employee=new Employee();
				employee.setEmployee_Id(empid);
				employee.setEmployee_name(empname);
				employee.setEmail(empemail);
				employee.setSalary(empsalary);
				employee.setDate_of_joining(dateofjoining);
				employee.setBonus(empbonus);
				
				emplist.add(employee);
				
			}
		}
		catch(SQLException e) {
			System.out.println(e);
			
		}
		
		
		return emplist;
	}
	
}