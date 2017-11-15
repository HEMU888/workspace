package com.hemu.crud;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ModelDriven;

public class EmployeeAction implements RequestAware, ModelDriven<Employee> {

	private Dao dao = new Dao();

	private Map<String, Object> request;

	private Employee employee;



	public String list(){
		request.put("emps", dao.getEmployees());
		return "list";
	}


	public String delete(){
		dao.delete(employee.getEmployeeId());
		return "success";
	}

	public String save(){

		dao.save(employee);

		return "success";
	}

	public String edit(){
		Employee emp = dao.get(employee.getEmployeeId());

		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		employee.setEmail(emp.getEmail());

		return "edit";
	}

	public String update(){
		dao.update(employee);
		return "success";
	}


	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO 自動生成されたメソッド・スタブ
		this.request = arg0;
	}

	@Override
	public Employee getModel() {
		employee = new Employee();
		return employee;
	}
}
