import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AjoutArtiste extends Stage{
	private Label titre			= new Label("Artiste");
	private BorderPane root		= new BorderPane();
	private GridPane grid		= new GridPane();
	private Label nom			= new Label("Nom");
	private Label genre			= new Label("Genre");
	private Label duree			= new Label("Duree");
	private TextField tfNom		= new TextField();
	private TextField tfGenre	= new TextField();
	private TextField tfDuree	= new TextField();
	private HBox zoneBot		= new HBox();
	private Button valider		= new Button("Valider");
	private Button annuler		= new Button("Annuler");
	
	final double TitleFontSize	= 20.0;
	final double BnSize			= 80.0;
	
	public AjoutArtiste(){
		this.setTitle("Ajouter artiste");
		this.setResizable(false);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.setMinWidth(200);
		this.setMinHeight(200);
		this.initModality(Modality.APPLICATION_MODAL); 
	}
	
	private Parent creerContenu(){
		valider.setMinWidth(BnSize);
		annuler.setMinWidth(BnSize);
		titre.setFont(new Font(TitleFontSize));
		
		valider.setOnAction(e -> {gererClick(e);});
		annuler.setOnAction(e -> {gererClick(e);});
		
		grid.add(nom,		0,0);
		grid.add(tfNom,		1,0);
		
		grid.add(genre,		0,1);
		grid.add(tfGenre,	1,1);
		
		grid.add(duree,		0,2);
		grid.add(tfDuree,	1,2);
		
		zoneBot.getChildren().addAll(
				valider,
				annuler
				);
		zoneBot.setAlignment(Pos.TOP_RIGHT);
		
		root.setTop(titre);
		root.setCenter(grid);
		root.setBottom(zoneBot);
		root.setPadding(new Insets(10));
		grid.setHgap(10); 
		grid.setVgap(10);
		grid.setPadding(new Insets(20));
		zoneBot.setSpacing(10);
		return root;
	}
	
	private void gererClick(ActionEvent e) {
		if (e.getSource() == valider) {
			Artiste a = new Artiste(
					tfNom.getText(),
					tfGenre.getText(),
					tfDuree.getText());
			System.out.print("Nom : "+a.getNom());
		} else if(e.getSource() == annuler) {
			this.close();
		}
	}
}

// ToDo
 //	Exception (Tarifs)
