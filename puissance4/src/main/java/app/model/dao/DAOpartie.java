package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import app.model.dao.DAOJoueur;

import app.model.Joueur;
import app.model.Partie;

public class DAOpartie extends DAO<Partie> {

	@Override
	public List<Partie> findAll() {
		List<Partie>  list=new ArrayList<>();
		Statement ps;
		ResultSet rs;
		 
		DAOJoueur DAOJoueur = new DAOJoueur();
		Partie partie;
		try {
			String requete = "select * from parties  ";
			ps = getConn().createStatement();
			rs = ps.executeQuery(requete);
			while (rs.next()) {
				Joueur joueur11= DAOJoueur.find(rs.getInt("idj1"));
				System.out.println(joueur11);

				Joueur joueur21= DAOJoueur.find(rs.getInt("idj2"));
				System.out.println(joueur21);

				 partie = new Partie(joueur11,joueur21);
                  partie.setJ1(joueur11);
                  partie.setJ2(joueur21);

				list.add(partie);

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
	public Partie find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Partie create(Partie a) {
		Statement ps;
		try {
			System.out.println(a.getJ1().getId());
			String requete = "insert into parties(idj1,idj2,sj1,sj2) values('"+a.getJ1().getId()+"','"+a.getJ2().getId()+"','"+a.getJ1().getScore()+"','"+a.getJ2().getScore()+"')";
			ps = getConn().createStatement();
			int rs = ps.executeUpdate(requete);
		
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption 1");
		} 
		return a;
	}

	@Override
	public Partie update(Partie a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Partie delete(Partie a) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
