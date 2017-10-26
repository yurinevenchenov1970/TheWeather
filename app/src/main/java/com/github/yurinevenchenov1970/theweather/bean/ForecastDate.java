package com.github.yurinevenchenov1970.theweather.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * Fifth BaseResponse level resided at day of simpleforecast of forecast contained date data
 *
 * @author Yuri Nevenchenov on 10/25/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDate {

    @JsonProperty("day")
    private int mDay;

    @JsonProperty("month")
    private int mMonth;

    @JsonProperty("year")
    private int mYear;

    public ForecastDate() {
        // leave empty for Jackson
    }

    public int getDay() {
        return mDay;
    }

    public void setDay(int day) {
        mDay = day;
    }

    public int getMonth() {
        return mMonth;
    }

    public void setMonth(int month) {
        mMonth = month;
    }

    public int getYear() {
        return mYear;
    }

    public void setYear(int year) {
        mYear = year;
    }

    public String getFullDate() {
        return mDay + "." + mMonth + "." + mYear;
    }

    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForecastDate that = (ForecastDate) o;
        return mDay == that.mDay &&
                mMonth == that.mMonth &&
                mYear == that.mYear;
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hashCode(mDay, mMonth, mYear);
    }

    @JsonIgnore
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("mDay", mDay)
                .add("mMonth", mMonth)
                .add("mYear", mYear)
                .toString();
    }
}