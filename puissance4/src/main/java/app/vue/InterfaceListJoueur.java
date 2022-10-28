package app.vue;

import java.util.List;

import app.model.Joueur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class InterfaceListJoueur {
	private TableView tabView=new TableView();
	public Node dessiner(List<Joueur> list) {
		TableColumn<Joueur, Integer> idCol //
        = new TableColumn<Joueur, Integer>("id");
		TableColumn<Joueur, String> joueurNomCol //
        = new TableColumn<Joueur, String>("nom");
		TableColumn<Joueur, String> joueurPrenomCol //
        = new TableColumn<Joueur, String>("prenom");
		TableColumn<Joueur, Integer> joueurScoreCol //
        = new TableColumn<Joueur, Integer>("score");
		tabView.getColumns().addAll(idCol, joueurNomCol, joueurPrenomCol, joueurScoreCol);
		////
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		joueurNomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
		joueurPrenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		joueurScoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));		
		///
		ObservableList<Joueur> list1 = FXCollections.observableArrayList(list);	
		tabView.setItems(list1);		
		//
		return tabView;
	}
}
