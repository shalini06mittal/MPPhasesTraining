package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Customer;

public class CustomerDatabase {

	public boolean insert(Customer c)
	{
		System.out.println("insert "+c);
		Connection con = MyConnection.getConnection();
		String sql = "insert into customer(username, password, name, email, phone, city, gender) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, c.getUsername());
			preparedStatement.setString(2, c.getPassword());
			preparedStatement.setString(3, c.getName());
			preparedStatement.setString(4, c.getEmail());
			preparedStatement.setString(5, c.getPhone());
			preparedStatement.setString(6, c.getCity());
			preparedStatement.setString(7, c.getGender());
			preparedStatement.execute();
			
			System.out.println("executed");
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("exception");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public ArrayList<Customer> getCustomers()
	{
		Connection con = MyConnection.getConnection();
		ArrayList<Customer> customers = new ArrayList<>();
		try {
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from customer");			
			while(rs.next())
			{
				Customer customer = new Customer();
				customer.setName(rs.getString(1));
				customer.setPhone(rs.getString(2));
				customer.setEmail(rs.getString(3));
				customer.setCity(rs.getString(4));
				customer.setGender(rs.getString(5));	
				customer.setUsername(rs.getString(6));
				customer.setPassword(rs.getString(7));;				
				customers.add(customer);
			}
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return customers;
		}
		return customers;
	}
	public boolean delete(String username)
	{
		Connection con = MyConnection.getConnection();
		try {
			Statement statement = con.createStatement();
			statement.executeUpdate("delete from customer where username = '"+username+"'");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public Customer getCustomer(String username)
	{
		Customer customer = null;
		try {
			Connection con = MyConnection.getConnection();
			Statement statement = con.createStatement();
			String sql = "select * from customer where username='"+username+"'";
			System.out.println(sql);
			ResultSet rs = statement.executeQuery(sql);	

			while(rs.next())
			{
				customer = new Customer();
				customer.setName(rs.getString(1));
				customer.setPhone(rs.getString(2));
				customer.setEmail(rs.getString(3));
				customer.setCity(rs.getString(4));
				customer.setGender(rs.getString(5));	
				customer.setUsername(rs.getString(6));
				customer.setPassword(rs.getString(7));
							
			}
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return customer;
		}
		return customer;
	}
	public boolean updateCustomer(Customer customer)
	{
		Connection con = MyConnection.getConnection();

		System.out.println("update");
		System.out.println(customer);
		try {
			PreparedStatement statement = con.prepareStatement("update customer set name=?,email=?,phone=?,city=?,gender=?"
					+ "where username=?");
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getEmail());
			statement.setString(3, customer.getPhone());
			statement.setString(4, customer.getCity());
			statement.setString(5, customer.getGender());
			statement.setString(6, customer.getUsername());
			statement.execute();			
			
			statement.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}


