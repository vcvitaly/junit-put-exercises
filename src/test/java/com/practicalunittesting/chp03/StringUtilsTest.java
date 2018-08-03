package com.practicalunittesting.chp03;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class StringUtilsTest {

    private Object[] getStrings() {
        return $(
                $("apple", "elppa"),
                $("mail", "liam")
        );
    }

    @Test
    public void shouldReturnNullIfSuppliedWithNull() {
        Assert.assertNull(StringUtils.reverse(null));
    }

    @Test
    @Parameters(method = "getStrings")
    public void shouldReturnReversedString(String s, String reversed) {
        Assert.assertEquals(reversed, StringUtils.reverse(s));
    }
}
