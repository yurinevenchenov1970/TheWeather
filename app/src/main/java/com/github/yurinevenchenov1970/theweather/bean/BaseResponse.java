package com.github.yurinevenchenov1970.theweather.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * Root of response
 *
 * @author Yuri Nevenchenov on 10/25/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse {

    @JsonProperty("forecast")
    private Forecast mForecast;

    public BaseResponse() {
        // leave empty for Jackson
    }

    public Forecast getForecast() {
        return mForecast;
    }

    public void setForecast(Forecast forecast) {
        mForecast = forecast;
    }

    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseResponse that = (BaseResponse) o;
        return Objects.equal(mForecast, that.mForecast);
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hashCode(mForecast);
    }

    @JsonIgnore
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("mForecast", mForecast)
                .toString();
    }
}