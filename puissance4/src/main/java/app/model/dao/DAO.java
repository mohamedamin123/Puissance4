package app.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import app.model.Coup;
import app.model.Joueur;
import app.model.Partie;

public abstract class DAO<T> {
	private Connection conn;

	public DAO() {
		String serveurBD="jdbc:mysql://localhost/puissance4";
		String login = "root";
		String motPasse = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(serveurBD, login, motPasse);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public abstract List<T> findAll();

	public abstract T find(int id);

	public abstract T create(T a);

	public abstract T update(T a);

	public abstract T delete(T a);

	public Connection getConn() {
		return conn;
	}



	
	


	
}
