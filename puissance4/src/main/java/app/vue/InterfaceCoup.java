package app.vue;

import java.util.List;

import app.model.Coup;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class InterfaceCoup {
	private TableView tabView=new TableView();
	public Node dessiner(List<Coup> list) {
		TableColumn<Coup, Integer> posx = new TableColumn<Coup, Integer>("posx");
		TableColumn<Coup, Integer> posy = new TableColumn<Coup, Integer>("posy");

		tabView.getColumns().addAll(posx, posy);
		posx.setCellValueFactory(param -> {
			Integer j = param.getValue().getPos().getPosX();
			return (new SimpleIntegerProperty(j)).asObject();
		});
		posy.setCellValueFactory(param -> {
			Integer j = param.getValue().getPos().getPosY();
			return (new SimpleIntegerProperty(j)).asObject();
		});
		////
		
		
		///
		ObservableList<Coup> list1 = FXCollections.observableArrayList(list);	
		tabView.setItems(list1);		
		//
		return tabView;
	}


}
