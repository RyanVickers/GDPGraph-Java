import java.sql.SQLException;
import java.util.Calendar;

public class GrossDomesticProduct {
    private int gdpId, year, gdpMarketValue, gdpDomesticValue;
    private String quarter;
    private double gdpPercentChange;

    public GrossDomesticProduct(int gdpId, int year, String quarter, int gdpMarketValue, int gdpDomesticValue, double gdpPercentChange) {
        setGdpId(gdpId);
        setYear(year);
        setGdpPercentChange(gdpPercentChange);
        setGdpMarketValue(gdpMarketValue);
        setGdpDomesticValue(gdpDomesticValue);
        setQuarter(quarter);
    }

    public GrossDomesticProduct(int year, String quarter, int gdpMarketValue, int gdpDomesticValue, double gdpPercentChange) {
        setYear(year);
        setGdpPercentChange(gdpPercentChange);
        setGdpMarketValue(gdpMarketValue);
        setGdpDomesticValue(gdpDomesticValue);
        setQuarter(quarter);

        try {
            gdpId = DBUtility.insertNewGdp(this);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getGdpId() {
        return gdpId;
    }

    public void setGdpId(int gdpId) {
        if (gdpId > 0)
            this.gdpId = gdpId;
        else
            throw new IllegalArgumentException("GDP ID must be Greater than 0");

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 1960 && year <= Calendar.getInstance().get(Calendar.YEAR))
            this.year = year;
        else
            throw new IllegalArgumentException("Year must be between 1961 and the current year");
    }

    public int getGdpMarketValue() {
        return gdpMarketValue;
    }

    public void setGdpMarketValue(int gdpMarketValue) {
        if (gdpMarketValue >= 0)
            this.gdpMarketValue = gdpMarketValue;
        else
            throw new IllegalArgumentException("Gross Domestic Product Must be Greater Than 0");
    }

    public int getGdpDomesticValue() {
        return gdpDomesticValue;
    }

    public void setGdpDomesticValue(int gdpDomesticValue) {
        if (gdpMarketValue >= 0)
            this.gdpDomesticValue = gdpDomesticValue;
        else
            throw new IllegalArgumentException("Domestic Demand Must be Greater Than 0");
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        if (quarter.matches("[Q][1-4]"))
            this.quarter = quarter;
        else
            throw new IllegalArgumentException("Quarter must be in Q[1-4] format");
    }

    public double getGdpPercentChange() {
        return gdpPercentChange;
    }

    public void setGdpPercentChange(double gdpPercentChange) {
        if (gdpPercentChange >= -100 && gdpPercentChange <= 100)
            this.gdpPercentChange = gdpPercentChange;
        else
            throw new IllegalArgumentException("GDP Percent Change must be Between -100 and 100");
    }

    public String toString() {
        return String.format("%d %s %d Domestic GDP: %d, Market GDP: %d, GDP Growth Rate:%.1f%%", gdpId, quarter, year, gdpDomesticValue, gdpMarketValue, gdpPercentChange);
    }
}

