package com.github.yurinevenchenov1970.theweather.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.ArrayList;

/**
 * @author Yuri Nevenchenov on 10/31/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CitiesList {

    @JsonProperty("RESULTS")
    private ArrayList<City> mCitiesList;

    public CitiesList() {
        // leave empty for Jackson
    }

    public ArrayList<City> getCitiesList() {
        return mCitiesList;
    }

    public void setCitiesList(ArrayList<City> cityList) {
        mCitiesList = cityList;
    }

    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CitiesList citiesList = (CitiesList) o;
        return Objects.equal(mCitiesList, citiesList.mCitiesList);
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hashCode(mCitiesList);
    }

    @JsonIgnore
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mCitiesList", mCitiesList)
                .toString();
    }
}