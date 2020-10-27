package Models;

import Utilities.DBUtility;

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

    /**
     * Method returns id of GDP
     *
     * @return
     */
    public int getGdpId() {
        return gdpId;
    }

    /**
     * Method sets the id of GDP must be greater than 0
     *
     * @param gdpId
     */
    public void setGdpId(int gdpId) {
        if (gdpId > 0)
            this.gdpId = gdpId;
        else
            throw new IllegalArgumentException("GDP ID must be Greater than 0");

    }

    /**
     * Method returns year
     *
     * @return
     */
    public int getYear() {
        return year;
    }

    /**
     * method sets year must be between 1961-current year
     *
     * @param year
     */
    public void setYear(int year) {
        if (year > 1960 && year <= Calendar.getInstance().get(Calendar.YEAR))
            this.year = year;
        else
            throw new IllegalArgumentException("Year must be between 1961 and the current year");
    }

    /**
     * Method gets the market value of gdp
     *
     * @return
     */
    public int getGdpMarketValue() {
        return gdpMarketValue;
    }

    /**
     * Method sets the gdp market value must be greater than 0
     *
     * @param gdpMarketValue
     */
    public void setGdpMarketValue(int gdpMarketValue) {
        if (gdpMarketValue >= 0)
            this.gdpMarketValue = gdpMarketValue;
        else
            throw new IllegalArgumentException("Gross Domestic Product Must be Greater Than 0");
    }

    /**
     * Method gets the domestic value of gdp
     *
     * @return
     */
    public int getGdpDomesticValue() {
        return gdpDomesticValue;
    }

    /**
     * Method sets the domestic gdp must be greater than 0
     *
     * @param gdpDomesticValue
     */
    public void setGdpDomesticValue(int gdpDomesticValue) {
        if (gdpMarketValue >= 0)
            this.gdpDomesticValue = gdpDomesticValue;
        else
            throw new IllegalArgumentException("Domestic Demand Must be Greater Than 0");
    }

    /**
     * Method returns the quarter
     *
     * @return
     */
    public String getQuarter() {
        return quarter;
    }

    /**
     * Method sets the quarter must be in Q[1-4] format
     *
     * @param quarter
     */
    public void setQuarter(String quarter) {
        if (quarter.matches("[Q][1-4]"))
            this.quarter = quarter;
        else
            throw new IllegalArgumentException("Quarter must be in Q[1-4] format");
    }

    /**
     * Method returns the gdp percent change
     *
     * @return
     */
    public double getGdpPercentChange() {
        return gdpPercentChange;
    }

    /**
     * Method sets gep percent change must be between -100 and 100
     *
     * @param gdpPercentChange
     */
    public void setGdpPercentChange(double gdpPercentChange) {
        if (gdpPercentChange >= -100 && gdpPercentChange <= 100)
            this.gdpPercentChange = gdpPercentChange;
        else
            throw new IllegalArgumentException("GDP Percent Change must be Between -100 and 100");
    }

    /**
     * Method formats information into a displayable string
     *
     * @return
     */
    public String toString() {
        return String.format("%d %s %d Domestic GDP: %d, Market GDP: %d, GDP Growth Rate:%.1f%%", gdpId, quarter, year, gdpDomesticValue, gdpMarketValue, gdpPercentChange);
    }
}
