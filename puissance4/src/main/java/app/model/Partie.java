package app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Partie {
	private Joueur j1, j2;
	private ArrayList lisCoupJ1=new ArrayList();
	private ArrayList lisCoupJ2=new ArrayList();
	private int nbPionJ1=21;
	private int nbPionJ2=21;
	private int score;
	private int rolejoueur;
	private Puissance puissance;
	
	
	public ArrayList getLisCoupJ1() {
		return lisCoupJ1;
	}
	public void setLisCoupJ1(ArrayList lisCoupJ1) {
		this.lisCoupJ1 = lisCoupJ1;
	}
	public ArrayList getLisCoupJ2() {
		return lisCoupJ2;
	}
	public void setLisCoupJ2(ArrayList lisCoupJ2) {
		this.lisCoupJ2 = lisCoupJ2;
	}
	public void addLisCoupJ1(Coup a)
	{
		lisCoupJ1.add(a);
	}
	public Partie(){
		j1 = ListeJoueur.getJoueur(1);
		j2 = ListeJoueur.getJoueur(2);		
		this.rolejoueur=j1.getId();
		puissance = new Puissance(j1.getId(), j2.getId());
	}
	public Partie( Joueur j1,  Joueur j2) {
		this.j1=j1;
		this.j2=j2;
		puissance = new Puissance(j1.getId(), j2.getId());
	}
	@Override
	public String toString() {
		String ch="Partie entre Joueur: " + j1 + " et Joueur: " + j2 ;
		switch(score) {
		case 0 : ch=ch+"  est null";break;
		case 1 :ch=ch+"\n"+j1+" est gagnant";break;
		case -1 : ch=ch+"\n"+j2+" est gagnant";break;
		}
		return ch ;
	}

	public void modifieRole() {
		if(this.rolejoueur==this.j1.getId())
			this.rolejoueur=this.j2.getId();
		
		else
			this.rolejoueur=this.j1.getId();
	}
	public int getRolejoueur() {
		return rolejoueur;
	}
	public void insertCoup(Coup coup){
		if(this.rolejoueur==this.j1.getId()) {
			this.lisCoupJ1.add(coup);
			nbPionJ1--;
		}else {
			this.lisCoupJ2.add(coup);
			nbPionJ1--;
			}
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getNbPionJ1() {
		return nbPionJ1;
	}
	public void setNbPionJ1(int nbPionJ1) {
		this.nbPionJ1 = nbPionJ1;
	}
	public int getNbPionJ2() {
		return nbPionJ2;
	}
	public void setNbPionJ2(int nbPionJ2) {
		this.nbPionJ2 = nbPionJ2;
	}
	public Puissance getPuissance() {
		return puissance;
	}
	public void setPuissance(Puissance p) {
		this.puissance = p;
	}
	public Joueur getJ1() {
		return j1;
	}
	public void setJ1(Joueur j1) {
		this.j1 = j1;
	}
	public Joueur getJ2() {
		return j2;
	}
	public void setJ2(Joueur j2) {
		this.j2 = j2;
	}	
}
