package com.github.yurinevenchenov1970.theweather.test;

import com.github.yurinevenchenov1970.theweather.bean.BaseJsonParserTest;
import com.github.yurinevenchenov1970.theweather.bean.City;
import com.github.yurinevenchenov1970.theweather.bean.CityList;

import org.junit.Test;

/**
 * Test for @link SimpleForecast
 *
 * @author Yuri Nevenchenov on 10/25/2017.
 */
public class CityTest extends BaseJsonParserTest {

    public static final String TEST_FILE = "city.json";

    @Test
    public void testParseObject() {
        testParse(TEST_FILE, getCity(), City.class);
    }

    private City getCity() {
        City city = createCity("Dnipropetrovs'k, Ukraine");
        return city;
    }

    private City createCity(String cityName) {
        City city = new City();
        city.setCityName(cityName);
        return city;
    }
}