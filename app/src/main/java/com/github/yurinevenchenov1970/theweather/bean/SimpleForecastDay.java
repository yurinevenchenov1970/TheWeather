package com.github.yurinevenchenov1970.theweather.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * Third BaseResponse level is one day resided at simpleforecast of forecast
 *
 * @author Yuri Nevenchenov on 10/25/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimpleForecastDay {

    @JsonProperty("date")
    private ForecastDate mForecasrDate;

    @JsonProperty("period")
    private int mPeriod;

    @JsonProperty("high")
    private Temperature mHighTemperature;

    @JsonProperty("low")
    private Temperature mLowTemperature;

    @JsonProperty("icon_url")
    private String mIconUrl;

    @JsonProperty("maxwind")
    private Wind mMaxWind;

    @JsonProperty("avewind")
    private Wind mAveWind;

    public SimpleForecastDay() {
        // leave empty for Jackson
    }

    public ForecastDate getForecasrDate() {
        return mForecasrDate;
    }

    public void setForecasrDate(ForecastDate forecastDate) {
        mForecasrDate = forecastDate;
    }

    public int getPeriod() {
        return mPeriod;
    }

    public void setPeriod(int period) {
        mPeriod = period;
    }

    public Temperature getHighTemperature() {
        return mHighTemperature;
    }

    public void setHighTemperature(Temperature highTemperature) {
        mHighTemperature = highTemperature;
    }

    public Temperature getLowTemperature(

    ) {
        return mLowTemperature;
    }

    public void setLowTemperature(Temperature lowTemperature) {
        mLowTemperature = lowTemperature;
    }

    public String getIconUrl() {
        return mIconUrl;
    }

    public void setIconUrl(String iconUrl) {
        mIconUrl = iconUrl;
    }

    public Wind getMaxWind() {
        return mMaxWind;
    }

    public void setMaxWind(Wind maxWind) {
        mMaxWind = maxWind;
    }

    public Wind getAveWind() {
        return mAveWind;
    }

    public void setAveWind(Wind aveWind) {
        mAveWind = aveWind;
    }

    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleForecastDay that = (SimpleForecastDay) o;
        return mPeriod == that.mPeriod &&
                Objects.equal(mForecasrDate, that.mForecasrDate) &&
                Objects.equal(mHighTemperature, that.mHighTemperature) &&
                Objects.equal(mLowTemperature, that.mLowTemperature) &&
                Objects.equal(mIconUrl, that.mIconUrl) &&
                Objects.equal(mMaxWind, that.mMaxWind) &&
                Objects.equal(mAveWind, that.mAveWind);
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hashCode(mForecasrDate, mPeriod, mHighTemperature, mLowTemperature, mIconUrl, mMaxWind, mAveWind);
    }

    @JsonIgnore
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("mForecasrDate", mForecasrDate)
                .add("mPeriod", mPeriod)
                .add("mHighTemperature", mHighTemperature)
                .add("mLowTemperature", mLowTemperature)
                .add("mIconUrl", mIconUrl)
                .add("mMaxWind", mMaxWind)
                .add("mAveWind", mAveWind)
                .toString();
    }
}