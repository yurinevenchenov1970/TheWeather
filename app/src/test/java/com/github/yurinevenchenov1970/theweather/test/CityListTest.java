package com.github.yurinevenchenov1970.theweather.test;

import com.github.yurinevenchenov1970.theweather.bean.BaseJsonParserTest;
import com.github.yurinevenchenov1970.theweather.bean.City;
import com.github.yurinevenchenov1970.theweather.bean.CityList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test for @link SimpleForecast
 *
 * @author Yuri Nevenchenov on 10/25/2017.
 */
public class CityListTest extends BaseJsonParserTest {

    public static final String TEST_FILE = "autocomplete_d.json";

    @Test
    public void testParseObject() {
        testParse(TEST_FILE, getCityList(), CityList.class);
    }

    private CityList getCityList() {
        CityList cl = new CityList();
        cl.setCityList(formCityList());
        return cl;
    }

    private ArrayList<City> formCityList() {
        ArrayList<City> cl = new ArrayList<>();
        cl.add(createCity("Dnipropetrovs'k, Ukraine"));
        cl.add(createCity("Dniprodzerzhyns'k, Ukraine"));
        cl.add(createCity("Dniprorudne, Ukraine"));
        cl.add(createCity("Dnestrovsc, Republic of Moldova"));
        cl.add(createCity("Dno, Russia"));
        cl.add(createCity("Dnipryany, Ukraine"));
        cl.add(createCity("Dniprovka, Ukraine"));
        cl.add(createCity("Dneprovskaya, Russia"));
        cl.add(createCity("DNA, Japan"));
        cl.add(createCity("DNAA, Papua New Guinea"));
        cl.add(createCity("Dnago, Nigeria"));
        cl.add(createCity("Dnaikwo, Nigeria"));
        cl.add(createCity("DNAK, Papua New Guinea"));
        cl.add(createCity("Dnakuakhana, India"));
        cl.add(createCity("Dnakwala, Nigeria"));
        cl.add(createCity("Dnakwo, Nigeria"));
        cl.add(createCity("Dnasa, Nigeria"));
        cl.add(createCity("Dnawi, Nigeria"));
        cl.add(createCity("DNBE, Papua New Guinea"));
        cl.add(createCity("DNBI, Papua New Guinea"));

        return cl;
    }

    private City createCity(String cityName) {
        City city = new City();
        city.setCityName(cityName);
        return city;
    }
}