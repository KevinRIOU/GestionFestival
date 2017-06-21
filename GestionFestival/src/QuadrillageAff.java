
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
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

	private TabPane onglets					= new TabPane();
	private GridPane gridArtiste			= new GridPane();
	private GridPane gridTarifs				= new GridPane();
	private GridPane gridFestival			= new GridPane();
	private Label nom						= new Label("Nom");
	private Label taille					= new Label("Taille");
	private Label xx							= new Label("x");
	private Label location					= new Label("Location");
	private Label tarifs					= new Label("Tarifs");
	private Label artistes					= new Label("Artistes");
	private TextField tfNom					= new TextField();
	private TextField tfTaille1				= new TextField();
	private TextField tfTaille2				= new TextField();
	private TextField tfLocation			= new TextField();
	private Button valider					= new Button("Valider");
	private Button annuler					= new Button("Annuler");
	private TableView<Artiste> tabArtistes	= new TableView<Artiste>();
	private TableView<Entree> tabTarifs		= new TableView<Entree>();
	private Button addArtiste				= new Button("Ajouter");
	private Button addTarifs				= new Button("Ajouter");

	private static final ObservableList<Artiste> dataArtiste =
			FXCollections.observableArrayList(
					new Artiste("Jacob", "TRASH METAL", "2h"),
					new Artiste("Isabella", "Classique", "2h"),
					new Artiste("Ethan", "Pop", "1h"),
					new Artiste("Emma", "EDM", "0.4s"),
					new Artiste("Michael", "Trap", "12jours")
					);
	private final static ObservableList<Entree> dataTarifs =
			FXCollections.observableArrayList(/*
					new Entree("Jacob",2.00),
	                new Entree("Isabella",3.00),
	                new Entree("Ethan",4.00),
	                new Entree("Emma", 5.00),
	                new Entree("Michael",6.00)*/
					);

	final Tab 			ongElements			= new Tab("Elements");
	final Tab 			ongArtistes			= new Tab("Artistes");
	final Tab 			ongTarifs			= new Tab("Tarifs");
	final Tab 			ongFestival			= new Tab("Festival");

	final double 		TitleFontSize		= 30.0;
	final double 		TextFontSize		= 20.0;
	final double 		BnSize				= 80.0;


	public QuadrillageAff(int x,int y){
		this.setTitle("Festival");
		this.setResizable(false);
		this.sizeToScene();
		this.setScene(new Scene(creerContenu()));
		this.x = x;
		this.y = y;
	}

	public TableView<Artiste> getTabArtistes() {
		return tabArtistes;
	}

	public void setTabArtistes(TableView<Artiste> tabArtistes) {
		this.tabArtistes = tabArtistes;
	}

	public TableView<Entree> getTabTarifs() {
		return tabTarifs;
	}

	public void setTabTarifs(TableView<Entree> tabTarifs) {
		this.tabTarifs = tabTarifs;
	}

	public static ObservableList<Artiste> getDataArtiste() {
		return dataArtiste;
	}

	public static ObservableList<Entree> getDataTarifs() {
		return dataTarifs;
	}

	private Parent creerContenu() {

		//	TAILLES ELEMS
		addArtiste.setMinWidth(BnSize);
		addTarifs.setMinWidth(BnSize);
		valider.setMinWidth(BnSize);
		annuler.setMinWidth(BnSize);

		nom.setFont(new Font(TextFontSize));
		taille.setFont(new Font(TextFontSize));
		xx.setFont(new Font(TextFontSize));
		location.setFont(new Font(TextFontSize));
		tarifs.setFont(new Font(TextFontSize));
		artistes.setFont(new Font(TextFontSize));

		tfTaille1.setMaxWidth(50);
		tfTaille2.setMaxWidth(50);

		// TABLEVIEW
		TableColumn nomCol = new TableColumn("Nom");
		nomCol.setMinWidth(100);
		nomCol.setCellValueFactory(
				new PropertyValueFactory<Artiste, String>("nom"));
		TableColumn genreCol = new TableColumn("Genre");
		genreCol.setMinWidth(100);
		genreCol.setCellValueFactory(
				new PropertyValueFactory<Artiste, String>("genre"));
		TableColumn dureeCol = new TableColumn("Durée");
		dureeCol.setMinWidth(100);
		dureeCol.setCellValueFactory(
				new PropertyValueFactory<Artiste, String>("duree"));

		tabArtistes.setItems(dataArtiste);
		tabArtistes.getColumns().addAll(nomCol,genreCol,dureeCol);
		tabArtistes.setEditable(true);
		// ---
		TableColumn nomTarifsCol = new TableColumn("Nom");
		nomTarifsCol.setMinWidth(100);
		nomTarifsCol.setCellValueFactory(
				new PropertyValueFactory<Entree, String>("nom"));
		TableColumn prixCol = new TableColumn("Prix (€)");
		prixCol.setMinWidth(100);
		prixCol.setCellValueFactory(
				new PropertyValueFactory<Entree, String>("prix"));

		tabTarifs.setItems(dataTarifs);
		tabTarifs.getColumns().addAll(nomTarifsCol,prixCol);
		tabTarifs.setEditable(true);

		// ACTION
		addArtiste.setOnAction(e -> {gererClick(e);});
		addTarifs.setOnAction(e -> {gererClick(e);});

		valider.setOnAction(e -> {gererClick(e);});
		annuler.setOnAction(e -> {gererClick(e);});

		//	ONGLET
		//	artistes
		gridArtiste.add(artistes,		0,0);
		gridArtiste.add(addArtiste,		2,0);
		gridArtiste.add(tabArtistes,	0,1,	3,1);

		gridArtiste.setPadding(new Insets(20));
		gridArtiste.setHgap(10); 
		gridArtiste.setVgap(10);
		gridArtiste.setHalignment(addArtiste,	HPos.RIGHT);

		ongArtistes.setContent(gridArtiste);
		//	tarifs
		gridTarifs.add(tarifs,			0,0);
		gridTarifs.add(addTarifs,		2,0);
		gridTarifs.add(tabTarifs,		0,1,	3,1);

		gridTarifs.setPadding(new Insets(20));
		gridTarifs.setHgap(10); 
		gridTarifs.setVgap(10);
		gridTarifs.setHalignment(addTarifs,	HPos.RIGHT);

		ongTarifs.setContent(gridTarifs);
		// festival
		// nom
		gridFestival.add(nom,			0,0);
		gridFestival.add(tfNom,			1,0,	3,1);
		// location
		gridFestival.add(location,		0,1);
		gridFestival.add(tfLocation,	1,1,	3,1);
		// taille
		gridFestival.add(taille,		0,2);
		gridFestival.add(tfTaille1,		1,2);
		gridFestival.add(xx,			2,2);
		gridFestival.add(tfTaille2,		3,2);

		gridFestival.setPadding(new Insets(20));
		gridFestival.setHgap(10); 
		gridFestival.setVgap(10);


// 		FIN GESTION ONGLETS

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
		ongElements.setContent(droite);
		ongFestival.setContent(gridFestival);


		onglets.getTabs().setAll(
				ongElements,
				ongArtistes,
				ongTarifs,
				ongFestival);
				
		racine.getChildren().addAll(tab,onglets);
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

	private void gererClick(ActionEvent e) {
		if (e.getSource() == valider) {
			//
		} else if(e.getSource() == annuler) {
			this.close();
		} else if(e.getSource() == addArtiste) {
			MainFestival.ouvrirAjoutArtiste();
		} else if(e.getSource() == addTarifs) {
			MainFestival.ouvrirAjoutTarif();
		}
	}
}
