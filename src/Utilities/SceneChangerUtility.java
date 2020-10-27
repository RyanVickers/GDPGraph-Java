package Utilities;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChangerUtility {
    /**
     * Method to change scenes
     *
     * @param event
     * @param viewName
     * @param title
     * @throws IOException
     */
    public static void changeScene(ActionEvent event, String viewName, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new Object() {
        }.getClass().getResource(viewName));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/Style.css");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
}