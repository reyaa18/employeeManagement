package model;



public class Employee {
 		private int emp_id;
		private String employee_name;
		private String email;
		private double salary;
		private String date_of_joining;
		private int bonus;
		
		

		public Employee(String employee_name, String email, double salary,  String Date_of_joining,	int bonus) {
			this.employee_name = employee_name;
			this.email = email;
			this.salary = salary;
			this.date_of_joining = Date_of_joining;
			this.bonus = bonus;
		}
		public Employee() {
			
		}

		
		public int getEmployee_Id(int emp_id) {
			return emp_id;
		}
		
		public void setEmployee_Id(int emp_id) {
			this.emp_id = emp_id;
		}
		
		public String getEmployee_name() {
			return employee_name;
		}
		
		public void setEmployee_name(String employee_name) {
			this.employee_name = employee_name;
		}
		
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public double getSalary() {
			return salary;
		}
		
		public void setSalary(double salary) {
			this.salary = salary;
		}
		
		public String getDate_of_joining() {
			return date_of_joining;
		}
		
		public void setDate_of_joining(String date_of_joining) {
			this.date_of_joining = date_of_joining;
		}
		
		public int getBonus() {
			return bonus;
		}
		
		public void setBonus(int bonus) {
			this.bonus = bonus;
		}

		@Override
		public String toString() {
			return "Employee [employee_id=" + emp_id +", employee_name=" + employee_name + ", email=" + email + ", salary="
					+ salary + ", date_of_joining=" + date_of_joining + ", bonus=" + bonus + "]";
		}

}