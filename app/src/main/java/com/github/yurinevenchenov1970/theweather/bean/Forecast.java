package com.github.yurinevenchenov1970.theweather.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Forecast is in root of BaseResponse and contains two formats: text and detailed, named "simple"
 *
 * @author Yuri Nevenchenov on 10/25/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {

    @JsonProperty("txt_forecast")
    private TextForecast mTextForecast;

    @JsonProperty("simpleforecast")
    private SimpleForecast mSimpleForecast;

    public Forecast() {
        // leave empty for Jackson
    }

    public TextForecast getTextForecast() {
        return mTextForecast;
    }

    public void setTextForecast(TextForecast textForecast) {
        mTextForecast = textForecast;
    }

    public SimpleForecast getSimpleForecast() {
        return mSimpleForecast;
    }

    public void setSimpleForecast(SimpleForecast simpleForecast) {
        mSimpleForecast = simpleForecast;
    }

    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forecast forecast = (Forecast) o;
        return Objects.equal(mTextForecast, forecast.mTextForecast) &&
                Objects.equal(mSimpleForecast, forecast.mSimpleForecast);
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hashCode(mTextForecast, mSimpleForecast);
    }

    @JsonIgnore
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mTextForecast", mTextForecast)
                .add("mSimpleForrecast", mSimpleForecast)
                .toString();
    }
}