package com.practicalunittesting.chp03;

import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class HashMapTest {

    private HashMap hashMap;

    @Before
    public void setUp() {
        hashMap = new HashMap();
    }

    @Test
    public void shouldBeAbleToRetrieveAddedValueByCallingGet() {
        hashMap.put("key", "value");
        assertSame("value", hashMap.get("key"));
    }

    @Test
    public void shouldReplaceTheOldValueIfExistingKeyIsAdded() {
        hashMap.put("key", "value1");
        hashMap.put("key", "value2");
        assertSame("value2", hashMap.get("key"));
    }

    @Test
    public void shouldRemoveAllContents() {
        hashMap.clear();
        assertTrue(hashMap.size() == 0);
    }

    @Test
    public void shouldBeAbleToUseNullAsAKey () {
        hashMap.put(null, "value");
        assertSame("value", hashMap.get(null));
    }
}
