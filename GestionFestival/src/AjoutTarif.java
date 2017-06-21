import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class AjoutTarif extends Stage{

	private Label titre			= new Label("Tarifs");
	private BorderPane root		= new BorderPane();
	private GridPane grid		= new GridPane();
	private Label nom			= new Label("Nom");
	private Label prix			= new Label("Prix (€)");
	private TextField tfNom		= new TextField();
	private TextField tfPrix	= new TextField();
	private HBox zoneBot		= new HBox();
	private Button valider		= new Button("Valider");
	private Button annuler		= new Button("Annuler");
	
	final double TitleFontSize	= 20.0;
	final double BnSize			= 80.0;
	
	public AjoutTarif(){
		this.setTitle("Ajouter tarif");
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
		
		grid.add(nom,		0,0);
		grid.add(tfNom,		1,0);
		
		grid.add(prix,		0,1);
		grid.add(tfPrix,	1,1);
		
		zoneBot.getChildren().addAll(
				valider,
				annuler
				);
		zoneBot.setAlignment(Pos.TOP_RIGHT);
		
		tfPrix.textProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	            if (!newValue.matches("\\d*")) {
	            	tfPrix.setText(newValue.replaceAll("[^\\d]", ""));
	            }
	        }
	    });
		
		annuler.setOnAction(e -> {gererClick(e);});
		valider.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		    	QuadrillageAff.getDataTarifs().add(new Entree(
		                tfNom.getText(),
		                Double.parseDouble(tfPrix.getText())));
		    	tfNom.clear();
		    	tfPrix.clear();
		    	gererClick(e);
		    	System.out.print(QuadrillageAff.getDataTarifs().get(0).getNom());
		    }
		});
		
		
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
			this.close();
		} else if(e.getSource() == annuler) {
			this.close();
		}
	}
}


// ToDo
 //	Exception (Tarifs)
