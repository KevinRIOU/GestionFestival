import javafx.application.Application;
import javafx.stage.Stage;


public class Principale extends Application{
	
	private static Quadrillage q = new Quadrillage(70,40);
	private static QuadrillageAff qua = new QuadrillageAff(70,40);//Enzo les données a rentré son iciiiiiiiiiii
	
	public void start(Stage primaryStage) throws Exception{
		qua.show();
	} 

	public static void main(String[] args){ 
		Application.launch(args); 
	}

	public static Quadrillage getQ() {
		return q;
	}

	public static QuadrillageAff getQua() {
		return qua;
	}
	
}
