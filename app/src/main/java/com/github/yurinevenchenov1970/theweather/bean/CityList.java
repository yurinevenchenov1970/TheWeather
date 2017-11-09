package com.github.yurinevenchenov1970.theweather.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuri Nevenchenov on 10/31/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityList {

    @JsonProperty("RESULTS")
    private ArrayList<City> mCityList;

    public CityList() {
        // leave empty for Jackson
    }

    public ArrayList<City> getCityList() {
        return mCityList;
    }

    public void setCityList(ArrayList<City> cityList) {
        mCityList = cityList;
    }

    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityList cityList = (CityList) o;
        return Objects.equal(mCityList, cityList.mCityList);
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hashCode(mCityList);
    }

    @JsonIgnore
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("mCityList", mCityList)
                .toString();
    }
}