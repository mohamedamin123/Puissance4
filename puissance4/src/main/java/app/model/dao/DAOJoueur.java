package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.model.Joueur;

public class DAOJoueur extends DAO<Joueur> {

	@Override
	public List<Joueur> findAll() {
		List<Joueur>  list=new ArrayList<>();
		Statement ps;
		ResultSet rs;
		try {
			String requete = "select * from joueur  ";
			ps = getConn().createStatement();
			rs = ps.executeQuery(requete);
			while (rs.next()) {
				Joueur j=new Joueur((int)rs.getLong("id"),rs.getString("Nom"), rs.getString("Prenom"),rs.getInt("score"));
				list.add(j);
			}
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
		} 
		return list;
	}

	@Override
	public Joueur find(int id) {
		Joueur joueur = null;
    	Statement ps;
		ResultSet rs;
		try {
			String requete = "select * from joueur where id = "+id;
			ps = getConn().createStatement();
			rs = ps.executeQuery(requete);
			
			while (rs.next()) {
				 joueur=new Joueur((int)rs.getLong("id"),rs.getString("Nom"), rs.getString("Prenom"),rs.getInt("score"));
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return joueur;
	}

	@Override
	public Joueur create(Joueur a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Joueur update(Joueur a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Joueur delete(Joueur a) {
		// TODO Auto-generated method stub
		return null;
	}

}
