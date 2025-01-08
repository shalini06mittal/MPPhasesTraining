package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Invoice;

public class InvoiceDatabase {

	public ArrayList<Invoice> getInvoicesByCustomer(String username){
		Connection con = MyConnection.getConnection();
		ArrayList<Invoice> invoices = new ArrayList<>();
		try {
			String sql = "select * from invoice where customer=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();			
			while(rs.next())
			{
				Invoice invoice = new Invoice();
				invoice.setInvno(rs.getInt(1));
				
				invoice.setInvdate(Date.valueOf(rs.getDate(2).toString()).toLocalDate());
				invoice.setAddress(rs.getString(4));
				invoice.setAmount(rs.getDouble(5));
				invoice.setDeldate(Date.valueOf(rs.getDate(6).toString()).toLocalDate());
				System.out.println(invoice);
				invoices.add(invoice);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return invoices;
		}
		return invoices;
	}
	public ArrayList<Invoice> getInvoicesByDateForCustomer(String username, LocalDate invdate){
		Connection con = MyConnection.getConnection();
		ArrayList<Invoice> invoices = new ArrayList<>();
		try {
			String sql = "select * from invoice where customer=? and invdate=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, username);
			statement.setDate(2, Date.valueOf(invdate));
			ResultSet rs = statement.executeQuery();			
			while(rs.next())
			{
				Invoice invoice = new Invoice();
				invoice.setInvno(rs.getInt(1));
				invoice.setInvdate(Date.valueOf(rs.getDate(2).toString()).toLocalDate());
				invoice.setCustomer(rs.getString(3));
				invoice.setAddress(rs.getString(4));
				invoice.setAmount(rs.getDouble(5));
				invoice.setDeldate(Date.valueOf(rs.getDate(6).toString()).toLocalDate());
				invoices.add(invoice);
			}
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return invoices;
		}
		return invoices;
	}
}
