import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GdpGraphViewController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void viewTable(ActionEvent event) throws IOException {
        SceneChangerUtility.changeScene(event, "GdpTableView.fxml",
                "Canada GDP Table View");
    }
}
