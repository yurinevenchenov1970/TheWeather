package com.github.yurinevenchenov1970.theweather.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import java.util.List;

/**
 * Second BaseResponse level resided at Forecast and contained text weather data
 *
 * @author Yuri Nevenchenov on 10/25/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TextForecast {

    @JsonProperty("forecastday")
    private List<TextForecastDay> mTextForecastDayList;

    public TextForecast() {
        // leave empty for Jackson
    }

    public List<TextForecastDay> getTextForecastDayList() {
        return mTextForecastDayList;
    }

    public void setTextForecastDayList(List<TextForecastDay> textForecastDayList) {
        mTextForecastDayList = textForecastDayList;
    }

    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextForecast that = (TextForecast) o;
        return Objects.equal(mTextForecastDayList, that.mTextForecastDayList);
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hashCode(mTextForecastDayList);
    }

    @JsonIgnore
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("mTextForecastDayList", mTextForecastDayList)
                .toString();
    }
}