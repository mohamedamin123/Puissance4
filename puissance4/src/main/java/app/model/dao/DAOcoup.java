package app.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.model.Coup;
import app.model.Joueur;
import app.model.Position;

public class DAOcoup extends DAO<Coup> {


	public List<Coup> findAll(Joueur j1,Joueur j2) {
		List<Coup>  list=new ArrayList<>();
		Statement ps;
		ResultSet rs;
		try {
			String requete = "select posj1,posj2 from coups where idJoueur ='"+j1.getId()+"'or idJoueur ='"+j2.getId()+"'  ";
			ps = getConn().createStatement();
			rs = ps.executeQuery(requete);
			while (rs.next()) {
				Coup j=new Coup(new Position((int)rs.getLong("posj1"),(int)rs.getLong("posj2")));
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
	public Coup find(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public Coup create(Coup a,Joueur j) {
		Statement ps;
		try {
			String requete = "insert into coups(posj1,posj2,idJoueur) values('"+a.getPos().getPosX()+"','"+a.getPos().getPosY()+"','"+j.getId()+"')";
			ps = getConn().createStatement();
			int rs = ps.executeUpdate(requete);
		
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
		} 
		return a;
	}

	@Override
	public Coup update(Coup a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coup delete(Coup a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coup create(Coup a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coup> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
