package app.control;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import app.model.Coup;
import app.model.Joueur;
import app.model.Partie;
import app.model.Position;
import app.model.Puissance;
import app.model.dao.DAOcoup;
import app.model.dao.DAOJoueur;
import app.model.dao.DAOpartie;
import app.model.files.FilePartie;
import app.vue.InterfaceCoup;
import app.vue.InterfaceJeuPuissance;
import app.vue.InterfaceListJoueur;
import app.vue.InterfaceParti;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class Control {
	int compteur;
	Joueur jouer1, jouer2;
	Partie partieJeu;
	BorderPane fenetre = new BorderPane();
	InterfaceCoup InterfaceCoup;
	InterfaceParti InterfaceParti;
	Puissance puissance;
	Button[][] tabButton;
	InterfaceJeuPuissance interfaceJeuPuissance;
	InterfaceListJoueur joueur;
	int score1,score2;
    int e=0;
    DAOJoueur joueurs =new DAOJoueur();
    FilePartie FileParti;
	public void puissanceControl() {
		int nbLigne = 6, nbColonne = 7;
		jouer1 = joueurs.findAll().get(0);
		jouer2 = joueurs.findAll().get(1);
		partieJeu = new Partie(jouer1, jouer2);
		
		puissance = new Puissance(1, 3);
		
		// partie vue
		interfaceJeuPuissance = new InterfaceJeuPuissance(nbLigne, nbColonne);
		interfaceJeuPuissance.dessiner();
		
		
		// gestion d'actions
		tabButton = interfaceJeuPuissance.getTabButton();
		for (int i = 0; i < nbLigne; i++)
		{
			
			for (int j = 0; j < nbColonne; j++) {
				final int ii = i;
				final int jj = j;
				
				interfaceJeuPuissance.setCouleurButon(ii, jj, "#FFFF00");
				tabButton[i][j].setOnAction(event -> {
					e++;
					gestionAction(jj);
				});
			}}
		Button b1=interfaceJeuPuissance.Enregistrer();
		b1.setOnAction(event -> {
			
			EnregisterListe();
			save();
		});
		
		
		fenetre.setTop(this.getMenu());
		fenetre.setCenter(interfaceJeuPuissance.getRoot());
		fenetre.setRight(interfaceJeuPuissance.getJoueur(partieJeu.getJ1()));
		fenetre.setLeft(interfaceJeuPuissance.getJoueur(partieJeu.getJ2()));
		fenetre.setBottom(interfaceJeuPuissance.Enregistrer());
		
		
	}

	public void puissanceControl2() {
		int nbLigne = 6, nbColonne = 7;
		jouer1 = joueurs.findAll().get(0);
		jouer2 = joueurs.findAll().get(1);
		partieJeu = new Partie(jouer1, jouer2);
		
		puissance = new Puissance(1, 3);
		
		// partie vue
		interfaceJeuPuissance = new InterfaceJeuPuissance(nbLigne, nbColonne);
		interfaceJeuPuissance.dessiner();
		for (int i = 0; i < nbLigne; i++)
		{
			
			for (int j = 0; j < nbColonne; j++) {
				final int ii = i;
				final int jj = j;
				
				interfaceJeuPuissance.setCouleurButon(ii, jj, "#FFFF00");
			}}
		Button b1=new Button("Precdent");
		Button b2=new Button("Play");
		Button b3=new Button("stop");
		Button b4=new Button("suivant");
		HBox H= new HBox();
		H.getChildren().addAll(b1,b2,b3,b4);
		fenetre.setCenter(interfaceJeuPuissance.getRoot());
		fenetre.setRight(interfaceJeuPuissance.getJoueur(partieJeu.getJ1()));
		fenetre.setLeft(interfaceJeuPuissance.getJoueur(partieJeu.getJ2()));
		fenetre.setBottom(H);
		 b1.setOnAction(event -> {
	        	DAOcoup DAOcoup=new DAOcoup();
	        
	        	
	        		System.out.println(DAOcoup.findAll(jouer1, jouer2).get(compteur));
	        		compteur--;	
	        		

	        		System.out.println(compteur);
	        		precident(DAOcoup.findAll(jouer1, jouer2).get(compteur),compteur);
	        		
		});
		 b2.setOnAction(event -> {
	        		play();
		});
		 b3.setOnAction(event -> {
	        	stop();
		});
        b4.setOnAction(event -> {
        	DAOcoup DAOcoup=new DAOcoup();
        
        	
        		suivant(DAOcoup.findAll(jouer1, jouer2).get(compteur),compteur);
        		System.out.println(compteur);

        		compteur++;	
	});
        
	

		
	}

	private void play() 
	{
    	DAOcoup DAOcoup=new DAOcoup();
         int comp=DAOcoup.findAll(jouer1, jouer2).size();
         int  i=compteur;
         for (;i < comp;i++) {
                //Pause for 4 seconds
                try {
            		suivant(DAOcoup.findAll(jouer1, jouer2).get(i),i);
            		System.out.println(i);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                //Print a message
            }
         compteur=i-1;
         
	}

	private void stop()
	{
		compteur=compteur;
		
	}

	private void precident(Coup a, int i) {
		
			interfaceJeuPuissance.setCouleurButon(a.getPos().getPosX(), a.getPos().getPosY(), "#FFFF00");
			
	}

	private void suivant(Coup a,int i) {
		
		
		if(i%2==0)		
			interfaceJeuPuissance.setCouleurButon(a.getPos().getPosX(), a.getPos().getPosY(), "#FF0000");
		else
			interfaceJeuPuissance.setCouleurButon(a.getPos().getPosX(), a.getPos().getPosY(), "#008000");

			
			
	}



	private void EnregisterListe() {
		
		 FileParti=new FilePartie();
		 FileParti.EnregistrerListe("list.txt", partieJeu);
	}

	private void save() {
		DAOpartie DAOpartie=new DAOpartie();
		DAOpartie.create(partieJeu);
		
	}

	private void gestionAction(int jj) {

		Alert xBox, iBox, cBox;
		xBox = new Alert(AlertType.ERROR);
		iBox = new Alert(AlertType.INFORMATION);
		cBox = new Alert(AlertType.CONFIRMATION, "Delete " + " ?", ButtonType.YES, ButtonType.CANCEL);
		// modele
		int numLigne = this.puissance.getLigneVideByColonne(jj);
		if (numLigne == -1) {
			// view
			xBox.setHeaderText("La colonne " + jj + " est remplie");
			xBox.showAndWait();
		} else if(e%2==0) {
			// modele

			puissance.setCoup(new Position(numLigne, jj), puissance.getIdJ1());
			System.out.println(puissance.getValeurPosition(numLigne, jj));
             Coup coup=new Coup(new Position(numLigne, jj));
             saveCoup(coup,partieJeu.getJ1());
             System.out.println(coup.getPos());
             System.out.println(coup.getPos().getPosX());
             System.out.println(coup.getPos().getPosY());

             partieJeu.getLisCoupJ1().add(coup);
            // afficher(partieJeu.getLisCoupJ1());
			// view
			interfaceJeuPuissance.setCouleurButon(numLigne, jj, "#FF0000");
		}
		else
		{
	        // modele
		
			puissance.setCoup(new Position(numLigne, jj), puissance.getIdJ2());
            Coup coup=new Coup(new Position(numLigne, jj));
            partieJeu.getLisCoupJ2().add(coup);
            saveCoup(coup,partieJeu.getJ2());
            System.out.println(coup.getPos());
            System.out.println(coup.getPos().getPosX());
            System.out.println(coup.getPos().getPosY());
            partieJeu.getLisCoupJ2().add(coup);
           // afficher(partieJeu.getLisCoupJ2());
            // view
			interfaceJeuPuissance.setCouleurButon(numLigne, jj, "#008000");		

		}
		
		
		if (puissance.estGagnant(new Position(numLigne, jj), puissance.getIdJ1())) {
			// view
			iBox.setHeaderText("PARTIE FINIE");
			iBox.setContentText("Le joueur J1 est le gagant ");
			iBox.showAndWait();			
			puissance.initialiseGrille();
			puissanceControl();
			score1++;
			interfaceJeuPuissance.setText4("Score: "+score2);
			interfaceJeuPuissance.setText5("Score: "+score1);
		}
		else if(puissance.estGagnant(new Position(numLigne, jj), puissance.getIdJ2()))
		{
			// view
		     
			iBox.setHeaderText("PARTIE FINIE");
			iBox.setContentText("Le joueur J2 est le gagant ");
			iBox.showAndWait();			
			puissance.initialiseGrille();
			puissanceControl();
			score2++;
			interfaceJeuPuissance.setText4("Score: "+score2);
			interfaceJeuPuissance.setText5("Score: "+score1);
			
		}
		
		
		
		if (puissance.estRemplie()) {
			// view
			
			cBox.setHeaderText("PARTIE NULL");
			cBox.setContentText("La grille est remplie \n Voulez-vous rejouer?");
			cBox.showAndWait();
			if (cBox.getResult() == ButtonType.YES) {
				puissance.initialiseGrille();
				puissanceControl();
			}
		}
	}
	public BorderPane getFenetre() {
		return this.fenetre;
	}
	public MenuBar getMenu()
	{
		MenuBar bar=new MenuBar();
		Menu b1=new Menu("Gestion jeu");
		Menu b2=new Menu("Gestion Partie");
		Menu b3=new Menu("Stastique");
		Menu b4=new Menu("Gestion Profil");
		Menu b5=new Menu("Help");


		bar.getMenus().add(b1);
		bar.getMenus().add(b2);
		bar.getMenus().add(b3);
		bar.getMenus().add(b4);
		bar.getMenus().add(b5);
		
		
		MenuItem b11=new MenuItem("Lancer Jeu");
		MenuItem b12=new MenuItem("Lancer Jeu contre ordinateur");
		MenuItem b13=new MenuItem("quiter");
		

		MenuItem b21=new MenuItem("La liste des parties");
		MenuItem b22=new MenuItem("Simulation d'une partie");
		MenuItem b23=new MenuItem("Importer une Partie");

		MenuItem b31=new MenuItem("La liste des joueurs");
		MenuItem b32=new MenuItem("La liste des joueurs selon score");
		
		
		b1.getItems().addAll(b11,b12,b13);
		b2.getItems().addAll(b21,b22,b23);
		b3.getItems().addAll(b31,b32);

		
		b13.setOnAction(event -> {
			Platform.exit();
			});
		 
		b31.setOnAction(event -> {
			
			listeJoueur();
			fenetre.setRight(null);
			fenetre.setLeft(null);
			fenetre.setBottom(null);


			});
		 
		b22.setOnAction(event -> {
			
			puissanceControl2();
			


			});
		b21.setOnAction(event -> {
			
			listePartie();
			fenetre.setRight(null);
			fenetre.setLeft(null);
			fenetre.setBottom(null);
			

			});
      b11.setOnAction(event -> {
			
	fenetre.setCenter(interfaceJeuPuissance.getRoot());
	fenetre.setRight(interfaceJeuPuissance.getJoueur(partieJeu.getJ1()));
	fenetre.setLeft(interfaceJeuPuissance.getJoueur(partieJeu.getJ2()));
			

			});
		
		
		
		return bar;
		
	}
	

	private void listeCoup( Joueur j1,Joueur j2) {
		DAOcoup DAOcoup=new DAOcoup();
		List<Coup> list=DAOcoup.findAll(j1,j2);
		System.out.println("nb element joueur "+list.size());
		//view
		 InterfaceCoup=new InterfaceCoup();
    		
		this.fenetre.setCenter(InterfaceCoup.dessiner(list));	

	}



	private void listeJoueur() {
		///modele
		DAOJoueur daoJoueur=new DAOJoueur();
		List<Joueur> list=daoJoueur.findAll();
		System.out.println("nb element joueur "+list.size());
		//view
		InterfaceListJoueur interfaceListJoueur=new InterfaceListJoueur();
		this.fenetre.setCenter(interfaceListJoueur.dessiner(list));	
	}
	private void listePartie() {
		///modele
		DAOpartie DAOpartie=new DAOpartie();
		List<Partie> list=DAOpartie.findAll();
		System.out.println("nb element Parti "+list.size());
		//view
		 InterfaceParti=new InterfaceParti();
		this.fenetre.setCenter(InterfaceParti.dessiner(list));
		getDataColumn(InterfaceParti.getTabView());
	}
	

	private void getDataColumn(TableView TableView)
	{
		TableView.setRowFactory( tv -> {
		    TableRow<Partie> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
		        	listeCoup(partieJeu.getJ1(),partieJeu.getJ2());
					fenetre.setRight(null);
					fenetre.setLeft(null);
					fenetre.setBottom(null);
		        }
		    });
		    return row ;
		});
	}

	private void saveCoup(Coup a,Joueur j) {
		DAOcoup DAOcoup=new DAOcoup();
		DAOcoup.create(a,j);
		
	}
	
		
}

