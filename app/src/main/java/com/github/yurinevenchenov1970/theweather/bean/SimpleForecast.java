package com.github.yurinevenchenov1970.theweather.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import java.util.List;

/**
 * Second BaseResponse level resided at Forecast and contained detailed weather data named "simple"
 *
 * @author Yuri Nevenchenov on 10/25/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpleForecast {

    @JsonProperty("forecastday")
    private List<SimpleForecastDay> mSimpleForecastDayList;

    public SimpleForecast() {
        // leave empty for Jackson
    }

    public List<SimpleForecastDay> getSimpleForecastDayList() {
        return mSimpleForecastDayList;
    }

    public void setSimpleForecastDayList(List<SimpleForecastDay> simpleForecastDayList) {
        mSimpleForecastDayList = simpleForecastDayList;
    }

    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleForecast that = (SimpleForecast) o;
        return Objects.equal(mSimpleForecastDayList, that.mSimpleForecastDayList);
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hashCode(mSimpleForecastDayList);
    }

    @JsonIgnore
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("mSimpleForecastDayList", mSimpleForecastDayList)
                .toString();
    }
}