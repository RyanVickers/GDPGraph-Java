import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
        //GrossDomesticProduct G = new GrossDomesticProduct(1, 2012, "Q1", 1, 5, 100);
        //System.out.println(G.toString());

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GdpTableView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("GDP Table");
        stage.show();
    }
}
