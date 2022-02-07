import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage arg) throws Exception {
		// TODO Auto-generated method stub
		HangManGame root = new HangManGame();
		Scene s = new Scene(root, 400, 650);
		root.requestFocus();
		arg.setScene(s);
		arg.setTitle("helloworld");
		arg.show();
	}

}
