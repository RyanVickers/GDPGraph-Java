import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
        //GrossDomesticProduct G = new GrossDomesticProduct(2020, "Q1", 1, 5, 100);
       // System.out.println(G);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GdpGraphView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Canada GDP Graph");
        stage.show();
    }
}
