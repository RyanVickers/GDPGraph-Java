package Utilities;

import Models.GrossDomesticProduct;
import javafx.scene.chart.XYChart;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "Ryan1111810";
    private static String password = "c-pehdxJDa";

    /**
     * Method to Insert gdp into database
     *
     * @param newGdp
     * @return
     * @throws SQLException
     */
    public static int insertNewGdp(GrossDomesticProduct newGdp) throws SQLException {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        int gdpId = -1;
        try {
            //connecting to the database
            con = DriverManager.getConnection("jdbc:mysql://172.31.22.43/Ryan1111810?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    user, password);
            //Creating SQL String
            String sql = "INSERT INTO grossDomesticProduct (year,quarter,gdpMarketValue,gdpDomesticValue,gdpPercentChange) " +
                    "VALUES (?,?,?,?,?)";
            //preparing query with SQL
            preparedStatement = con.prepareStatement(sql, new String[]{"gdpId"});
            //binding the values to datatypes.
            preparedStatement.setInt(1, newGdp.getYear());
            preparedStatement.setString(2, newGdp.getQuarter());
            preparedStatement.setInt(3, newGdp.getGdpMarketValue());
            preparedStatement.setInt(4, newGdp.getGdpDomesticValue());
            preparedStatement.setDouble(5, newGdp.getGdpPercentChange());

            //execute the insert statement
            preparedStatement.executeUpdate();
            //getting the gdpId
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                gdpId = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null)
                preparedStatement.close();
            if (con != null)
                con.close();
            return gdpId;
        }
    }

    /**
     * Method to return array of gdp from database to display in tableview
     *
     * @return
     * @throws SQLException
     */
    public static ArrayList<GrossDomesticProduct> getGdp() throws SQLException {
        ArrayList<GrossDomesticProduct> gdp = new ArrayList<>();
        Connection con = null;
        Statement sqlStatement = null;
        ResultSet resultSet = null;

        try {
            //Connecting to Database
            con = DriverManager.getConnection("jdbc:mysql://172.31.22.43/Ryan1111810?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    user, password);
            //creating statement object
            sqlStatement = con.createStatement();
            //creating SQL query
            resultSet = sqlStatement.executeQuery("SELECT * FROM grossDomesticProduct");
            //creating gdp objects
            while (resultSet.next()) {
                GrossDomesticProduct newGdp = new GrossDomesticProduct
                        (resultSet.getInt("gdpId"),
                                resultSet.getInt("year"),
                                resultSet.getString("quarter"),
                                resultSet.getInt("gdpMarketValue"),
                                resultSet.getInt("gdpDomesticValue"),
                                resultSet.getDouble("gdpPercentChange"));
                gdp.add(newGdp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) con.close();
            if (resultSet != null) resultSet.close();
            if (sqlStatement != null) resultSet.close();
            return gdp;
        }
    }

    /**
     * Method to return data from database to display in barchart
     *
     * @return
     * @throws SQLException
     */
    public static XYChart.Series<String, Double> getGdpGraph() throws SQLException {
        XYChart.Series<String, Double> gdpSeries = new XYChart.Series<>();
        Connection con = null;
        Statement sqlStatement = null;
        ResultSet resultSet = null;

        try {
            //Connecting to Database
            //have to use unicode to get around time error.
            con = DriverManager.getConnection("jdbc:mysql://172.31.22.43/Ryan1111810?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    user, password);
            //creating statement object
            sqlStatement = con.createStatement();
            resultSet = sqlStatement.executeQuery("SELECT quarter,year,gdpPercentChange FROM grossDomesticProduct order by year,quarter");
            while (resultSet.next()) {
                gdpSeries.getData().add(new XYChart.Data<>(resultSet.getString(1) + " " + (resultSet.getString(2)), resultSet.getDouble(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) con.close();
            if (resultSet != null) resultSet.close();
            if (sqlStatement != null) resultSet.close();
            return gdpSeries;
        }
    }
}