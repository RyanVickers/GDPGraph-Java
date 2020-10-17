import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GdpTableViewController implements Initializable {

    @FXML
    private TableView<GrossDomesticProduct> tableView;

    @FXML
    private TableColumn<GrossDomesticProduct, Integer> gdpIdColumn;

    @FXML
    private TableColumn<GrossDomesticProduct, String> quarterColumn;

    @FXML
    private TableColumn<GrossDomesticProduct, Integer> yearColumn;

    @FXML
    private TableColumn<GrossDomesticProduct, Integer> gdpMarketValueColumn;

    @FXML
    private TableColumn<GrossDomesticProduct, Integer> gdpDomesticValueColumn;

    @FXML
    private TableColumn<GrossDomesticProduct, Integer> gdpPercentChangeColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gdpIdColumn.setCellValueFactory(new PropertyValueFactory<GrossDomesticProduct,Integer>("gdpId"));
        quarterColumn.setCellValueFactory(new PropertyValueFactory<GrossDomesticProduct,String>("quarter"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<GrossDomesticProduct,Integer>("year"));
        gdpMarketValueColumn.setCellValueFactory(new PropertyValueFactory<GrossDomesticProduct,Integer>("gdpMarketValue"));
        gdpDomesticValueColumn.setCellValueFactory(new PropertyValueFactory<GrossDomesticProduct,Integer>("gdpDomesticValue"));
        gdpPercentChangeColumn.setCellValueFactory(new PropertyValueFactory<GrossDomesticProduct,Integer>("gdpPercentChange"));

        try {
            tableView.getItems().addAll(DBUtility.getGdp());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
