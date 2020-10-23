package Controllers;

import Utilities.DBUtility;
import Utilities.SceneChangerUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class GdpGraphViewController implements Initializable {
    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis quarterAxis;

    @FXML
    private NumberAxis percentAxis;

    private XYChart.Series<String, Integer> gdpSeries;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        barChart.setTitle("Canada's GDP per Quarter");
        quarterAxis.setLabel("Quarters");
        percentAxis.setLabel("GDP Growth Rate");
        try {
            barChart.getData().add(DBUtility.getGdpGraph());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void viewTable(ActionEvent event) throws IOException {
        SceneChangerUtility.changeScene(event, "/Views/GdpTableView.fxml",
                "Canada GDP Table View");
    }
}
