package com.github.yurinevenchenov1970.theweather.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Third BaseResponse level is one day resided at txt_forecast of forecast
 *
 * @author Yuri Nevenchenov on 10/25/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TextForecastDay {

    @JsonProperty("period")
    private int mPeriod;

    @JsonProperty("icon_url")
    private String mIconUrl;

    @JsonProperty("fcttext_metric")
    private String mForecastText;

    public TextForecastDay() {
        // leave empty for Jackson
    }

    public int getPeriod() {
        return mPeriod;
    }

    public void setPeriod(int period) {
        mPeriod = period;
    }

    public String getIconUrl() {
        return mIconUrl;
    }

    public void setIconUrl(String iconUrl) {
        mIconUrl = iconUrl;
    }

    public String getForecastText() {
        return mForecastText;
    }

    public void setForecastText(String forecastText) {
        mForecastText = forecastText;
    }

    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextForecastDay that = (TextForecastDay) o;
        return mPeriod == that.mPeriod &&
                Objects.equal(mIconUrl, that.mIconUrl) &&
                Objects.equal(mForecastText, that.mForecastText);
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hashCode(mPeriod, mIconUrl, mForecastText);
    }

    @JsonIgnore
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mPeriod", mPeriod)
                .add("mIconUrl", mIconUrl)
                .add("mForecastText", mForecastText)
                .toString();
    }
}