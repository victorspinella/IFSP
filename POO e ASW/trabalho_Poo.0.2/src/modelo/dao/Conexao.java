package modelo.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	Connection conn = null;
	
	
	public Conexao() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalhopoo", "root","iago");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public Connection getConn() {
		return conn;
	}
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}
}


