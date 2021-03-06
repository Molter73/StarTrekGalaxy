/**
 * 
 */
package starTrek.tests;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

import starTrek.weather.Weather;

/**
 * Tests for the Weather class
 * 
 * @author Molter
 *
 */
public class WeatherTest {

	/**
	 * Test method for {@link starTrek.weather.Weather#Weather(starTrek.weather.Weather)}.
	 * @throws SecurityException security exception on field creation
	 * @throws NoSuchFieldException exception on wrong field name
	 * @throws IllegalAccessException exception on access to prohibited field
	 * @throws IllegalArgumentException exception on illegal argument
	 */
	@Test
	public void testWeatherWeather() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException   {
		final Weather original = new Weather(1L, "test");
		final Weather weather = new Weather(original);
		final Field day = weather.getClass().getDeclaredField("day");
		final Field weatherCondition = weather.getClass().getDeclaredField("weatherCondition");
		
		day.setAccessible(true);
		weatherCondition.setAccessible(true);
		
		assertEquals(day.get(original), day.get(weather));
		assertEquals(weatherCondition.get(original), weatherCondition.get(weather));
	}
	
	/**
	 * Test method for {@link starTrek.weather.Weather#Weather(java.lang.Long, java.lang.String)}.
	 * @throws SecurityException security exception on field creation
	 * @throws NoSuchFieldException exception on wrong field name
	 * @throws IllegalAccessException exception on access to prohibited field
	 * @throws IllegalArgumentException exception on illegal argument
	 */
	@Test
	public void testWeatherLongString() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Weather weather = new Weather(1l, "test");
		final Field day = weather.getClass().getDeclaredField("day");
		final Field weatherCondition = weather.getClass().getDeclaredField("weatherCondition");
		
		day.setAccessible(true);
		weatherCondition.setAccessible(true);

		assertNotNull(weather);
		assertEquals(1l, day.get(weather));
		assertEquals("test", weatherCondition.get(weather));
	}

	/**
	 * Test method for {@link starTrek.weather.Weather#getDay()}.
	 */
	@Test
	public void testGetDay() {
		final Weather weather = new Weather(1l, "test");
		
		assertEquals((Long)1l, weather.getDay());
	}

	/**
	 * Test method for {@link starTrek.weather.Weather#getWeatherCondition()}.
	 */
	@Test
	public void testGetWeatherCondition() {
		final Weather weather = new Weather(1l, "test");
		
		assertEquals("test", weather.getWeatherCondition());
	}

	/**
	 * Test method for {@link starTrek.weather.Weather#toString()}.
	 */
	@Test
	public void testToString() {
		final Weather weather = new Weather(1l, "test");
		
		assertEquals("Weather [day=1, weatherCondition=test]", weather.toString());
	}

}
