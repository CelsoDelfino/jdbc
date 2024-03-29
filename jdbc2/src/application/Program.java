package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {

		Connection conn = null; // conecta o banco
		Statement st = null; // prepara uma consulta sql
		ResultSet rs = null; // guarda o resultado da resulta sql

		try {
			conn = DB.getConnection(); // conectando o banco de dados

			st = conn.createStatement();

			rs = st.executeQuery("SELECT * FROM DEPARTMENT");

			while (rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
