package com.practicalunittesting.chp04;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class RegexTest {

    private Regex regex = new Regex();

    private Object[] getParams() {
        return $(
                $("abc 12", new Integer[] {} ),
                $("cdefg 345 12bb23", new Integer[] {345} ),
                $("cdefg 345 12bbb33 678tt", new Integer[] {345, 678} )
        );
    }

    @Test
    @Parameters(method = "getParams")
    public void shouldReturnNumbers(String s, Integer[] numbers) {
        assertArrayEquals(regex.parseStringToNumbers(s), numbers);
    }

}