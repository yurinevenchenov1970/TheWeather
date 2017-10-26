package com.github.yurinevenchenov1970.theweather.test;

import com.github.yurinevenchenov1970.theweather.bean.BaseJsonParserTest;
import com.github.yurinevenchenov1970.theweather.bean.Wind;

import org.junit.Test;

/**
 * Test for @link Wind
 *
 * @author Yuri Nevenchenov on 10/25/2017.
 */
public class WindTest extends BaseJsonParserTest {

    public static final String TEST_FILE = "wind.json";

    @Test
    public void testParseObject() {
        testParse(TEST_FILE, getWind(18,"West"), Wind.class);
    }


    private Wind getWind(int speed, String direction) {
        Wind wind = new Wind();
        wind.setWindSpeed(speed);
        wind.setWindDirection(direction);
        return wind;
    }
}