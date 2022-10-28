package app.model.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import app.model.Partie;

public class FilePartie {
	
	public void EnregistrerListe(String nom,Partie a)
	{
		File f=new File(nom);
		if(f.exists()&&f.isFile())
		{
			try {
				Writer fichier=new FileWriter(nom);
				fichier.write("id joueur1 est \n "+a.getJ1().getId()+"\n id joueur2 est "+a.getJ2().getId()+"\n score joueur1 est "+a.getJ1().getScore()+"\n score joueur2 est "+a.getJ2().getScore()+"\n");
			    fichier.close();
			    System.out.println("succesful");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		else
		{
			try {
				if(f.createNewFile())
				{
					try {
						Writer fichier=new FileWriter(nom);
						fichier.write("id joueur1 est "+a.getJ1().getId()+"id joueur2 est "+a.getJ2().getId()+"score joueur1 est "+a.getJ1().getScore()+"score joueur2 est "+a.getJ2().getScore());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void AfficherListe(String nom)
	{
		File f=new File(nom);
		if(f.exists()&&f.isDirectory())
		{
			File [] parties=f.listFiles();
			for(int i=0;i<parties.length;i++)
			{
				if(f.isFile())
				System.out.println("Parties "+parties[i].getName());
				else		
					AfficherListe(parties[i].getName());
			}

		}
		
		
		
			
	}
	

}
