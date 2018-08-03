package com.practicalunittesting.chp03;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;

/**
 * Practical Unit Testing with JUnit and Mockito - source code for exercises.
 * Visit http://practicalunittesting.com for more information.
 *
 * @author Tomek Kaczanowski
 */
@RunWith(JUnitParamsRunner.class)
public class FahrenheitCelciusConverterTest {

	private Object[] getCelciusDegrees() {
		return $(
				$(32, 0),
				$(98, 37),
				$(212, 100)
		);
	}

	private Object[] getFahrenheitDegrees() {
		return $(
				$(0, 32),
				$(37, 100),
				$(100, 212)
		);
	}

	@Test
	@Parameters(method = "getCelciusDegrees")
	public void shouldConvertCelciusToFahrenheit(int fahrenheit, int celcius) {
		assertEquals(fahrenheit, FahrenheitCelciusConverter.toFahrenheit(celcius));
	}

	@Test
	@Parameters(method = "getFahrenheitDegrees")
	public void shouldConvertFahrenheitToCelcius(int celcius, int fahrenheit) {
		assertEquals(celcius, FahrenheitCelciusConverter.toCelcius(fahrenheit));
	}
}
