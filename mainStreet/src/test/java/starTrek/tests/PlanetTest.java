/**
 * 
 */
package starTrek.tests;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

import starTrek.galaxy.Planet;

/**
 * Tests for the Planet class
 * @author Mauro Moltrasio
 *
 */
public class PlanetTest {

    /**
     * Test method for {@link starTrek.galaxy.Planet#Planet(String, Integer, Double)}.
     */
    @Test
    public void testPlanet() {
        Boolean speedException = false;
        Boolean distanceException = false;
        
        try {
            new Planet("", null, 1d);
        } catch (NullPointerException ex) {
            speedException = true;
        }
        
        try {
            new Planet("", 1, null);
        } catch (NullPointerException ex) {
            distanceException = true;
        }
        
        assertTrue(speedException);
        assertTrue(distanceException);
    }

    /**
     * Test method for {@link starTrek.galaxy.Planet#getxPos()}.
	 * @throws SecurityException security exception on field creation
	 * @throws NoSuchFieldException exception on wrong field name
	 * @throws IllegalAccessException exception on access to prohibited field
	 * @throws IllegalArgumentException exception on illegal argument
     */
    @Test
    public void testGetxPos() throws NoSuchFieldException, IllegalAccessException {
        final Planet testPlanet = new Planet("", 100, 100d);
        final Field field = testPlanet.getClass().getDeclaredField("xPos");
        field.setAccessible(true);
        field.set(testPlanet, 50d);
        
        final Double result = testPlanet.getxPos();

        assertEquals("Wrong xPos value", 50d, result, 0.001);
    }

    /**
     * Test method for {@link starTrek.galaxy.Planet#setxPos(java.lang.Double)}.
	 * @throws SecurityException security exception on field creation
	 * @throws NoSuchFieldException exception on wrong field name
	 * @throws IllegalAccessException exception on access to prohibited field
	 * @throws IllegalArgumentException exception on illegal argument
     */
    @Test
    public void testSetxPos() throws NoSuchFieldException, IllegalAccessException{
        final Planet testPlanet = new Planet("", 100, 100d);
        
        testPlanet.setxPos(50d);
        
        final Field field = testPlanet.getClass().getDeclaredField("xPos");
        field.setAccessible(true);
        
        assertEquals("Wrong xPos value", 50d, field.get(testPlanet));
    }

    /**
     * Test method for {@link starTrek.galaxy.Planet#getyPos()}.
	 * @throws SecurityException security exception on field creation
	 * @throws NoSuchFieldException exception on wrong field name
	 * @throws IllegalAccessException exception on access to prohibited field
	 * @throws IllegalArgumentException exception on illegal argument
     */
    @Test
    public void testGetyPos() throws NoSuchFieldException, IllegalAccessException{
        final Planet testPlanet = new Planet("", 100, 100d);
        final Field field = testPlanet.getClass().getDeclaredField("yPos");
        field.setAccessible(true);
        field.set(testPlanet, 50d);
        
        final Double result = testPlanet.getyPos();

        assertEquals("Wrong yPos value", 50d, result, 0.001);
    }

    /**
     * Test method for {@link starTrek.galaxy.Planet#setyPos(java.lang.Double)}.
	 * @throws SecurityException security exception on field creation
	 * @throws NoSuchFieldException exception on wrong field name
	 * @throws IllegalAccessException exception on access to prohibited field
	 * @throws IllegalArgumentException exception on illegal argument
     */
    @Test
    public void testSetyPos() throws NoSuchFieldException, IllegalAccessException{
        final Planet testPlanet = new Planet("", 100, 100d);
        
        testPlanet.setyPos(50d);
        
        final Field field = testPlanet.getClass().getDeclaredField("yPos");
        field.setAccessible(true);
        
        assertEquals("Wrong xPos value", 50d, field.get(testPlanet));
    }

    /**
     * Test method for {@link starTrek.galaxy.Planet#getSpeed()}.
	 * @throws SecurityException security exception on field creation
	 * @throws NoSuchFieldException exception on wrong field name
	 * @throws IllegalAccessException exception on access to prohibited field
	 * @throws IllegalArgumentException exception on illegal argument
     */
    @Test
    public void testGetSpeed() throws NoSuchFieldException, IllegalAccessException{
        final Planet testPlanet = new Planet("", 100, 100d);
        final Field field = testPlanet.getClass().getDeclaredField("speed");
        field.setAccessible(true);
        
        field.set(testPlanet, 200);
        
        final Integer result = testPlanet.getSpeed();
        
        assertEquals("Wrong speed value", (Integer) 200, result);
    }

    /**
     * Test method for {@link starTrek.galaxy.Planet#getDistance()}.
	 * @throws SecurityException security exception on field creation
	 * @throws NoSuchFieldException exception on wrong field name
	 * @throws IllegalAccessException exception on access to prohibited field
	 * @throws IllegalArgumentException exception on illegal argument
     */
    @Test
    public void testGetDistance() throws NoSuchFieldException, IllegalAccessException{
        final Planet testPlanet = new Planet("", 100, 100d);
        final Field field = testPlanet.getClass().getDeclaredField("distance");
        field.setAccessible(true);
        
        field.set(testPlanet, 200d);
        
        final Double result = testPlanet.getDistance();
        
        assertEquals("Wrong distance value", 200d, result, 0.001);
    }

    /**
     * Test method for {@link starTrek.galaxy.Planet#equals(Object)}
     */
    @Test
    public void testEquals() {
    	final Planet planetTest = new Planet("", 10, 20d);
    	
    	assertEquals(planetTest, planetTest);
    	assertEquals(new Planet("",10, 20d), planetTest);
    	assertNotEquals(null, planetTest);
    	assertNotEquals(planetTest, null);
    	assertNotEquals(planetTest, new Object());
    	assertNotEquals(new Planet("", 20, 20d), planetTest);
    	assertNotEquals(new Planet("", 10, 10d), planetTest);
    }

    /**
     * Test method for {@link starTrek.galaxy.Planet#updatePosition(Long)}
	 * @throws SecurityException security exception on field creation
	 * @throws NoSuchFieldException exception on wrong field name
	 * @throws IllegalAccessException exception on access to prohibited field
	 * @throws IllegalArgumentException exception on illegal argument
     */
    @Test
    public void testUpdatePosition() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    	final Planet testPlanet = new Planet("", 1, 500000d);
    	final Field xPos = testPlanet.getClass().getDeclaredField("xPos");
    	final Field yPos = testPlanet.getClass().getDeclaredField("yPos");
    	
    	xPos.setAccessible(true);
    	yPos.setAccessible(true);
    	
    	testPlanet.updatePosition(10l);
    	
    	final Double xResult = 500000d * Math.cos(Math.toRadians(10));
    	final Double yResult = 500000d * Math.sin(Math.toRadians(10));
    	
    	assertEquals(xResult, xPos.get(testPlanet));
    	assertEquals(yResult, yPos.get(testPlanet));
    }
}
