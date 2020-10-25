import Models.GrossDomesticProduct;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        // Q1 = new GrossDomesticProduct(2019, "Q1", 1, 5, -20);
        //GrossDomesticProduct Q2 = new GrossDomesticProduct(2019, "Q2", 1, 5, -40);
        //GrossDomesticProduct Q3 = new GrossDomesticProduct(2019, "Q3", 1, 5, 2);
        //GrossDomesticProduct Q4 = new GrossDomesticProduct(2019, "Q4", 1, 5, -5);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Views/GdpGraphView.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/Style.css");
        stage.setScene(scene);
        stage.getIcons().add(new Image("/Icon.png"));
        stage.setTitle("Canada GDP Graph");
        stage.show();
    }
}
