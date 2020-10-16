import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "root";
    private static String password = "Computers#1";

    public static int insertNewGdp(GrossDomesticProduct newGdp) throws SQLException {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        int gdpId = -1;
        try{
            //connecting to the database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gdpData",
                    user, password);
            //Creating SQL String
            String sql = "INSERT INTO grossDomesticProduct (year,quarter,gdpMarketValue,gdpDomesticValue,gdpPercentChange) " +
                    "VALUES (?,?,?,?,?)";
            //preparing query with SQL
            preparedStatement = con.prepareStatement(sql, new String[] {"gdpId"});
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
            while (rs.next())
            {
                gdpId = rs.getInt(1);
            }
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (preparedStatement != null)
                preparedStatement.close();
            if (con != null)
                con.close();
            return gdpId;
        }
    }
    public static ArrayList<GrossDomesticProduct> getGdp() throws SQLException {
        ArrayList<GrossDomesticProduct> gdp = new ArrayList<>();
        Connection con = null;
        Statement sqlStatement = null;
        ResultSet resultSet = null;

        try{
            //Connecting to Database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gdpData",
                    user, password);
            //creating statement object
            sqlStatement = con.createStatement();
            //creating SQL query
            resultSet = sqlStatement.executeQuery("SELECT * FROM grossDomesticProduct");
            //creating gdp objects
            while (resultSet.next())
            {
                GrossDomesticProduct newGdp = new GrossDomesticProduct
                        (resultSet.getInt("gdpId"),
                        resultSet.getInt("year"),
                        resultSet.getString("quarter"),
                        resultSet.getInt("gdpMarketValue"),
                        resultSet.getInt("gdpDomesticValue"),
                        resultSet.getDouble("gdpPercentChange"));
                gdp.add(newGdp);
            }

        }catch ( Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (con !=null) con.close();
            if (resultSet != null) resultSet.close();
            if (sqlStatement != null) resultSet.close();
            return gdp;
        }
    }
}