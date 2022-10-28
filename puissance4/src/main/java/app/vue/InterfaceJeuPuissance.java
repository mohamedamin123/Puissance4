package app.vue;

import app.model.Joueur;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class InterfaceJeuPuissance {
	private GridPane root = new GridPane();
	private int nbLigne, nbColonne;
    private Button[][]tabButton;
	Button b1=new Button("Enregistrer");
	Button b2=new Button("coup precident");
	Button b3=new Button("coup suivant");
	Button []bb={b2,b3};

    Label Text1;
    Label Text2;
    Label Text3;
    Label Text4;
    Label Text5;
	public InterfaceJeuPuissance(int nbLigne, int nbColonne) {
		this.nbLigne = nbLigne;
		this.nbColonne = nbColonne;
		tabButton=new Button[nbLigne][nbColonne];
	}

	public void dessiner() {
		int it=nbLigne;
		int jt=nbColonne;
		int iii=-1;
		for (int i = 0; i < nbLigne; i++)
		{   iii++;
			it--;
			jt=0;
			for (int j = 0; j < nbColonne; j++) {
				tabButton[i][j] = new Button("" + iii + " " + jt);
				
				jt++;
				final int ii=it;
				final int jj=jt;
				root.add(tabButton[i][j] , jt, it);
				
			}}
	}
	    public Button[][] getTabButton(){
    	return this.tabButton;
    }
	public GridPane getRoot() {
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		return root;
	}

	public void setCouleurButon(int numLigne,int numColonne, String couleur) {
		tabButton[numLigne][numColonne].setStyle("-fx-background-radius: 150em; " +
                "-fx-min-width: 50px;" +
	                "-fx-min-height: 50px; " +
	                "-fx-max-width: 50px; " +
                "-fx-max-height: 50px;"+
             "-fx-background-color:"+couleur+";");
	}
	public void setText4(String a)
	{
		 Text4.setText(a);
	}
	public void setText5(String a)
	{
		 Text5.setText(a);
	}
	public Node getJoueur(Joueur j){
    	//VBox hbox= new 	VBox();
		GridPane root2 = new GridPane();
    	Label ljnom= new Label (j.getNom());
    	Label ljPrenom= new Label (j.getPrenom());
    	Label ljscore= new Label (""+j.getScore());
    	root2.add(ljnom, 0, 0);
    	root2.add(ljPrenom, 0, 10);
		root2.add(ljscore, 0, 20);
    	return root2;
    }
	
	public Button getB2() {
		return b2;
	}


	public Button Enregistrer()
	{
		return b1;
	}
	
	
}
