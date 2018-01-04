package com.github.yurinevenchenov1970.theweather.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * @author Yuri Nevenchenov on 10/31/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

    @JsonProperty("name")
    private String mCityName;

    public City() {
        // leave empty for Jackson
    }

    public String getCityName() {
        return mCityName;
    }

    public void setCityName(String cityName) {
        mCityName = cityName;
    }

    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City that = (City) o;
        return Objects.equal(mCityName, that.mCityName);
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hashCode(mCityName);
    }

    @JsonIgnore
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mCityName", mCityName)
                .toString();
    }
}