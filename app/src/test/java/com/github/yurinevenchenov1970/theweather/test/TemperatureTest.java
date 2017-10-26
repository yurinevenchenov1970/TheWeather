package com.github.yurinevenchenov1970.theweather.test;

import com.github.yurinevenchenov1970.theweather.bean.BaseJsonParserTest;
import com.github.yurinevenchenov1970.theweather.bean.Temperature;

import org.junit.Test;

/**
 * Test for @link Temperature
 *
 * @author Yuri Nevenchenov on 10/25/2017.
 */
public class TemperatureTest extends BaseJsonParserTest {

    public static final String TEST_FILE = "temperature.json";

    @Test
    public void testParseObject() {
        testParse(TEST_FILE, getTemperature(11), Temperature.class);
    }

    private Temperature getTemperature(int temper) {
        Temperature t = new Temperature();
        t.setTemperature(temper);
        return t;
    }
}