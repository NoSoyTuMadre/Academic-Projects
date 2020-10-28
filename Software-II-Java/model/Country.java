/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C195 - Software II
 * Project: Scheduling Application
 */

package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.SelectDB;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Country extends City {

    //declare fields
    public int countryId;
    private String country;
    public LocalDateTime createDate;
    public String createdBy;
    public Timestamp lastUpdate;
    public String lastUpdateBy;

    //setters
    @Override
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    @Override
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    @Override
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    @Override
    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    //getters
    @Override
    public int getCountryId() {
        return countryId;
    }
    public String getCountry() {
        return country;
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

    //declare methods & constructors
    public Country() {}

    public Country(int countryId, String country, LocalDateTime createDate, String createdBy, Timestamp lastUpdate, String lastUpdateBy) {
        this.countryId = countryId;
        this.country = country;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }

    public Country(int cityId, String city, int countryId, LocalDateTime createDate, String createdBy, Timestamp lastUpdate, String lastUpdateBy, int countryId1, String country, LocalDateTime createDate1, String createdBy1, Timestamp lastUpdate1, String lastUpdateBy1) {
        super(cityId, city, countryId, createDate, createdBy, lastUpdate, lastUpdateBy);
        this.countryId = countryId1;
        this.country = country;
        this.createDate = createDate1;
        this.createdBy = createdBy1;
        this.lastUpdate = lastUpdate1;
        this.lastUpdateBy = lastUpdateBy1;
    }

    private static ObservableList<Country> allResultCountries = FXCollections.observableArrayList();
    private static ObservableList<Country> allCountries = FXCollections.observableArrayList();
    public static ObservableList<Country> getAllCountries() throws SQLException {
        return SelectDB.selectAllCountries();
    }
    public static ObservableList<Country> getAllResultCountries() {
        return allResultCountries;
    }

}
