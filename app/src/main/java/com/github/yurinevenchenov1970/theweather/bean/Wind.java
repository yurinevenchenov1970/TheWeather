package com.github.yurinevenchenov1970.theweather.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * Fifth BaseResponse level resided at day of simpleforecast of forecast contained wind data
 *
 * @author Yuri Nevenchenov on 10/25/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {

    @JsonProperty("dir")
    private String mWindDirection;

    @JsonProperty("kph")
    private int mWindSpeed;

    public Wind() {
        // leave empty for Jackson
    }

    public String getWindDirection() {
        return mWindDirection;
    }

    public void setWindDirection(String windDirection) {
        mWindDirection = windDirection;
    }

    public int getWindSpeed() {
        return mWindSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        mWindSpeed = windSpeed;
    }

    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wind wind = (Wind) o;
        return mWindSpeed == wind.mWindSpeed &&
                Objects.equal(mWindDirection, wind.mWindDirection);
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hashCode(mWindDirection, mWindSpeed);
    }

    @JsonIgnore
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("mWindDirection", mWindDirection)
                .add("mWindSpeed", mWindSpeed)
                .toString();
    }
}