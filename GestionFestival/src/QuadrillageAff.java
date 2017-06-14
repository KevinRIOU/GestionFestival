
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class QuadrillageAff extends Stage {
	private int x,y;
	
	private AnchorPane 		tab 		= 	new AnchorPane();
	private HBox 			racine 		= 	new HBox();
	
	private VBox 			droite		= 	new VBox();
	
	private TextField		tx			= 	new TextField(); 
	private TextField		ty			= 	new TextField(); 
	private TextField		txs			= 	new TextField(); 
	private TextField		tys			= 	new TextField(); 
	
	private RadioButton		rbscene		= 	new RadioButton("Scene");
	private RadioButton		rbstand		= 	new RadioButton("Stand");
	private RadioButton		rbeau		= 	new RadioButton("Eau");
	private RadioButton		rbobstacle	= 	new RadioButton("Obstacle");
	
	private ToggleGroup 	groupAdd	= 	new ToggleGroup();
	
	private Button 			badd		=	new Button("Ajouter");
	
	public QuadrillageAff(int x,int y){
		this.setTitle("Quadrilllage");
		this.setResizable(false);
		this.sizeToScene();
		this.setScene(new Scene(creerContenu()));
		this.x = x;
		this.y = y;
	}

	private Parent creerContenu() {
		
		droite.setPrefWidth(120);
		droite.setPadding(new Insets(10));
		droite.setSpacing(20);
		tx.setPrefWidth(100);
		ty.setPrefWidth(100);
		txs.setPrefWidth(100);
		tys.setPrefWidth(100);
		badd.setPrefWidth(100);
		
		rbscene.setSelected(true);
		rbscene.setToggleGroup(groupAdd);
		rbstand.setToggleGroup(groupAdd);
		rbeau.setToggleGroup(groupAdd);
		rbobstacle.setToggleGroup(groupAdd);
		
		
		
		for(int i = 0;i<70;i++){
			for(int j = 0;j<40;j++){
				Rectangle rect = new Rectangle();
				rect.setWidth(10);
				rect.setHeight(10);
				rect.setFill(Color.WHITE);
				AnchorPane.setLeftAnchor(rect, (double) (i*10+i));
				AnchorPane.setTopAnchor(rect, (double) (j*10+j));
				tab.getChildren().add(rect);
			}
		}

		
		appliqueStateScene(9,3,10,5);
		appliqueStateScene(22,3,10,5);
		appliqueStateStand(16,35,8,4);
		appliqueStateEau(30,35,2,2);
		appliqueStateObstacle(1,1,70,1);
		appliqueStateObstacle(20,2,1,6);
		
		Principale.getQ().affiche();
		
		badd.setOnAction( e -> {
			if(groupAdd.getSelectedToggle().equals(rbscene)){
				appliqueStateScene(Integer.parseInt(tx.getText()),Integer.parseInt(ty.getText()),Integer.parseInt(txs.getText()),Integer.parseInt(tys.getText()));
			}else if(groupAdd.getSelectedToggle().equals(rbstand)){
				appliqueStateStand(Integer.parseInt(tx.getText()),Integer.parseInt(ty.getText()),Integer.parseInt(txs.getText()),Integer.parseInt(tys.getText()));
			}else if(groupAdd.getSelectedToggle().equals(rbeau)){
				appliqueStateEau(Integer.parseInt(tx.getText()),Integer.parseInt(ty.getText()),Integer.parseInt(txs.getText()),Integer.parseInt(tys.getText()));
			}else if(groupAdd.getSelectedToggle().equals(rbobstacle)){
				appliqueStateObstacle(Integer.parseInt(tx.getText()),Integer.parseInt(ty.getText()),Integer.parseInt(txs.getText()),Integer.parseInt(tys.getText()));
			}else{
				System.out.println("# Erreur : Type de Création");
			}
			
			tx.setText("");
			ty.setText("");
			txs.setText("");
			tys.setText("");
		});
		
		droite.getChildren().addAll(tx,ty,txs,tys,rbscene,rbstand,rbeau,rbobstacle,badd);
		racine.getChildren().addAll(tab,droite);
		return racine;
	}

	public void appliqueStateObstacle(int x,int y,int sizex,int sizey){
		x-=1;
		y-=1;
		if(!Principale.getQ().zoneOccupe(x, y, sizex, sizey)){
			for(int i = x;i<x+sizex;i++){
				for(int j = y;j<y+sizey;j++){
					Rectangle rect = new Rectangle();
					rect.setWidth(10);
					rect.setHeight(10);
					rect.setFill(Color.LIGHTGREEN);
					AnchorPane.setLeftAnchor(rect, (double) (i*10+i));
					AnchorPane.setTopAnchor(rect, (double) (j*10+j));
					tab.getChildren().add(rect);
				}
			}
			Principale.getQ().zoneSetOccupe(x, y, sizex, sizey);
		}else{
			System.out.println("# Erreur : Placement ");
		}
		
	}
	
	public void appliqueStateEau(int x,int y,int sizex,int sizey){
		x-=1;
		y-=1;
		if(!Principale.getQ().zoneOccupe(x, y, sizex, sizey)){
			for(int i = x;i<x+sizex;i++){
				for(int j = y;j<y+sizey;j++){
					Rectangle rect = new Rectangle();
					rect.setWidth(10);
					rect.setHeight(10);
					rect.setFill(Color.LIGHTBLUE);
					AnchorPane.setLeftAnchor(rect, (double) (i*10+i));
					AnchorPane.setTopAnchor(rect, (double) (j*10+j));
					tab.getChildren().add(rect);
				}
			}
			Principale.getQ().zoneSetOccupe(x, y, sizex, sizey);
		}else{
			System.out.println("# Erreur : Placement ");
		}
		
	}
	
	public void appliqueStateStand(int x,int y,int sizex,int sizey){
		x-=1;
		y-=1;
		if(!Principale.getQ().zoneOccupe(x, y, sizex, sizey)){
			for(int i = x;i<x+sizex;i++){
				for(int j = y;j<y+sizey;j++){
					Rectangle rect = new Rectangle();
					rect.setWidth(10);
					rect.setHeight(10);
					rect.setFill(Color.LIGHTSALMON);
					AnchorPane.setLeftAnchor(rect, (double) (i*10+i));
					AnchorPane.setTopAnchor(rect, (double) (j*10+j));
					tab.getChildren().add(rect);
				}
			}
			Principale.getQ().zoneSetOccupe(x, y, sizex, sizey);
		}else{
			System.out.println("# Erreur : Placement ");
		}	
	}

	public void appliqueStateScene(int x,int y,int sizex,int sizey){
		x-=1;
		y-=1;
		if(!Principale.getQ().zoneOccupe(x, y, sizex, sizey)){
			for(int i = x;i<x+sizex;i++){
				for(int j = y;j<y+sizey;j++){	
					Rectangle rect = new Rectangle();
					rect.setWidth(10);
					rect.setHeight(10);
					rect.setFill(Color.GREY);
					AnchorPane.setLeftAnchor(rect, (double) (i*10+i));
					AnchorPane.setTopAnchor(rect, (double) (j*10+j));
					tab.getChildren().add(rect);				
				}
			}
			Principale.getQ().zoneSetOccupe(x, y, sizex, sizey);
		}else{
			System.out.println("# Erreur : Placement ");
		}	
	}
}
