package app.vue;

import java.util.List;

import app.model.Joueur;
import app.model.Partie;
import app.model.Puissance;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

public class InterfaceParti {
	private TableView<Partie> tabView=new TableView();
	public Node dessiner(List<Partie> list) {
		TableColumn<Partie, Integer> joueur1 = new TableColumn<Partie, Integer>("Joueur1");
		TableColumn<Partie, Integer> joueur2 = new TableColumn<Partie, Integer>("Joueur2");

        TableColumn<Partie, Integer> IDJoueur1 = new TableColumn<Partie, Integer>("idj1");
		TableColumn<Partie, Integer> IDJoueur2 = new TableColumn<Partie, Integer>("idj2");
		TableColumn<Partie, Integer> Score1Joueur1 = new TableColumn<Partie, Integer>("sj1");
		TableColumn<Partie, Integer> Score2Joueur2 = new TableColumn<Partie, Integer>("sj2");	
		joueur1.getColumns().addAll(IDJoueur1,Score1Joueur1);
		joueur2.getColumns().addAll(IDJoueur2,Score2Joueur2);

		tabView.getColumns().addAll(joueur1, joueur2);
		////
		
		IDJoueur1.setCellValueFactory(param -> {
			Integer j = param.getValue().getJ1().getId();
			return (new SimpleIntegerProperty(j)).asObject();
		});
		IDJoueur2.setCellValueFactory(param -> {
			Integer j = param.getValue().getJ2().getId();
			return (new SimpleIntegerProperty(j)).asObject();
		});
		Score1Joueur1.setCellValueFactory(param -> {
			Integer j = param.getValue().getJ1().getScore();
			return (new SimpleIntegerProperty(j)).asObject();
		});
		Score2Joueur2.setCellValueFactory(param -> {
			Integer j = param.getValue().getJ2().getScore();
			return (new SimpleIntegerProperty(j)).asObject();
		});	

		///
		ObservableList<Partie> list1 = FXCollections.observableArrayList(list);	
		tabView.setItems(list1);		
		//
		return tabView;
	}
	public TableView getTabView()
	{
		return tabView;
	}

}