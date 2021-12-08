package org.zerock.mapper.p05mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.controller.p05controller.bean.Bean09;
import org.zerock.controller.p05controller.bean.Bean10;
import org.zerock.controller.p05controller.bean.Bean11;
import org.zerock.controller.p05controller.bean.Bean12;
import org.zerock.controller.p05controller.bean.Bean13;
import org.zerock.controller.p05controller.bean.Bean14;
import org.zerock.controller.p05controller.bean.Bean15;

public interface TimeMapper {
	
	@Select("SELECT NOW()")
	public String getTime();
	
	@Select("SELECT CustomerName FROM Customers WHERE CustomerID = 1")
	public String getCustomerName();
	
	@Select("SELECT LastName FROM Employees WHERE EmployeeID = 1")
	public String getLastName();
	
	@Select("SELECT CustomerName FROM Customers WHERE CustomerID = #{id}")
	public String getCustomerNameById(Integer id);
	
	@Select("SELECT LastName FROM Employees WHERE EmployeeID = #{id}")
	public String getLastNameById(Integer id );
	
	@Select("SELECT CustomerName FROM Customers")
	public List<String> getCustomerNames();
	
	// 직원 테이블의 LastName 들을 조회하는 쿼리를 실행하는 메소드(getLastNames) 작성
	@Select("SELECT LastName FROM Employees")
	public List<String> getLastNames();
	
	@Select("SELECT EmployeeID, LastName, FirstName FROM Employees WHERE EmployeeID = 1")
	public Bean09 getEmployeeName();
	
	@Select("SELECT CustomerName, ContactName FROM Customers WHERE CustomerID = 1")
	public Bean10 getName();
	
	@Select("SELECT CustomerID AS id, CustomerName FROM Customers WHERE CustomerID = 1")
	public Bean11 getCustomerInfo();
	
	@Select("SELECT EmployeeID id, LastName lname, FirstName fname FROM Employees WHERE EmployeeID = 1")
	public Bean12 getEmployeeInfo();
	
	@Select("SELECT EmployeeID, LastName, FirstName, BirthDate, Photo, Notes FROM Employees WHERE EmployeeID = #{id}")
	public Bean13 getEmployeeById(Integer id);
	
	@Select("SELECT CustomerID, CustomerName, ContactName, City, Address, Country, PostalCode From Customers WHERE CustomerID = #{id}")
	public Bean14 getCustomerById(Integer id);
	
	@Select("SELECT CustomerID, CustomerName, ContactName,"
			+ " City, Address, Country, PostalCode "
			+ "FROM Customers")
	public List<Bean14> getCustomers();
	
	@Select("SELECT EmployeeID, LastName, FirstName, BirthDate, Photo, Notes FROM Employees")
	public List<Bean13> getEmployees();
	
	@Select("SELECT p.ProductName, c.CategoryName, p.Unit, p.Price FROM Products p JOIN Categories c ON p.CategoryID = c.CategoryID")
	public List<Bean15> getProductInfo();
	
	public List<Bean15> getProductInfo2();
}
