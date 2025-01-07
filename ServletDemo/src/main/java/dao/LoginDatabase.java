package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Customer;
import model.Login;

public class LoginDatabase {

	public boolean validate(Login login)
	{
		try {
			Connection con = MyConnection.getConnection();
			Statement statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery("select username,password from customer");
			while(rs.next())
			{
				System.out.println("rs validate");
				if(rs.getString(1).equals(login.getUsername()))
				{
					if(rs.getString(2).equals(login.getPassword()))
					{
						System.out.println("validated");
						return true;
					}
				}
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
}
