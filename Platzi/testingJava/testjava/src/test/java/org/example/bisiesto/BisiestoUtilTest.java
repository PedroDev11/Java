package org.example.bisiesto;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class BisiestoUtilTest {

    /* COMO SE CALCULA SI UN AÑO ES BISIESTO O NO
    Todos los años divisibles por 400 son años bisiestos (1600, 2000, 2400)
    Todos los años divisibles por 100 pero no por 400 no son años bisiestos (1700, 1800, 1900)
    Todos los años divisibles por 4 pero no por 100 son años bisiestos (1996, 2004, 2008)
    Todos los años que no sean divisibles por 4 no son años bisiestos (2017, 2018, 2019)
    */

    @Test
    public void isLeapYearWhenDivisibleBy400() {
        // Comprobamos que deberia ser cierto
        assertThat(BisiestoUtil.isLeapYear(1600), is(true));
        assertThat(BisiestoUtil.isLeapYear(2000), is(true));
        assertThat(BisiestoUtil.isLeapYear(2400), is(true));
    }

    @Test
    public void isNotLeapYearWhenDivisibleBy100ButNotBy400() {
        // Comprobamos que deberia ser cierto
        assertThat(BisiestoUtil.isLeapYear(1700), is(false));
        assertThat(BisiestoUtil.isLeapYear(1800), is(false));
        assertThat(BisiestoUtil.isLeapYear(1900), is(false));
    }

    @Test
    public void isLeapYearWhenDivisibleBy4ButNotBy100() {
        // Comprobamos que deberia ser cierto
        assertThat(BisiestoUtil.isLeapYear(1996), is(true));
        assertThat(BisiestoUtil.isLeapYear(2004), is(true));
        assertThat(BisiestoUtil.isLeapYear(2008), is(true));
    }

    @Test
    public void isNotLeapYearWhenNotDivisibleBy4() {
        // Comprobamos que deberia ser cierto
        assertThat(BisiestoUtil.isLeapYear(2017), is(false));
        assertThat(BisiestoUtil.isLeapYear(2018), is(false));
        assertThat(BisiestoUtil.isLeapYear(2019), is(false));
    }
}