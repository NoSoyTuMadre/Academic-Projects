/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C195 - Software II
 * Project: Scheduling Application
 */

package model;

import javafx.collections.ObservableList;
import utils.SelectDB;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class City extends Address {
    public int cityId;
    private String city;
    public int countryId;
    private LocalDateTime createDate;
    private String createdBy;
    private Timestamp lastUpdate;
    private String lastUpdateBy;

    //setters
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    //getters
    public int getCityId() {
        return cityId;
    }

    public String getCity() {
        return city;
    }

    public int getCountryId() {
        return countryId;
    }

    @Override
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    //methods & constructors
    public City() {
    }

    public City(int cityId, String city, int countryId, LocalDateTime createDate, String createdBy, Timestamp lastUpdate, String lastUpdateBy) {
        this.cityId = cityId;
        this.city = city;
        this.countryId = countryId;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }

    public City(String customerName, boolean active, LocalDateTime createDate, String createdBy, String lastUpdateBy, int cityId, String city, int countryId, LocalDateTime createDate1, String createdBy1, Timestamp lastUpdate, String lastUpdateBy1) throws SQLException {
        super(customerName, active, createDate, createdBy, lastUpdateBy);
        this.cityId = cityId;
        this.city = city;
        this.countryId = countryId;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }

    public static ObservableList<City> getAllCities() throws SQLException {
        return SelectDB.selectAllCities();
    }

}