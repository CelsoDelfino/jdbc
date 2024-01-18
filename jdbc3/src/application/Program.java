package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"INSERT INTO SELLER "
					+"(Name, Email, BirthDate, BaseSalary, DepartmnetId) "
					+ "VALUES "
					+ "(?,?,?,?,?)");
			
			st.setString(1, "Carl Purple");
			st.setString(2, "carl@email.com");
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1986").getTime()));
			st.setDouble(4, 3000);
			st.setInt(5, 4);
			
			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Linhas afetada: " + rowsAffected);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		finally{
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
	}

}
