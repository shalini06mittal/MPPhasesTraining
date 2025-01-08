package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Login;

public class LoginDatabase {

	public boolean validate(Login login)
	{
		Connection con = MyConnection.getConnection();
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select username,password from customer");
			while(rs.next())
			{
				if(rs.getString(1).equals(login.getUsername()))
				{
					if(rs.getString(2).equals(login.getPassword()))
					{
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
