/**
 * 
 */
package starTrekTests;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

import starTrekGalaxy.Planet;

/**
 * @author moltrasm
 *
 */
public class PlanetTest {

    /**
     * Test method for {@link starTrekGalaxy.Planet#Planet(java.lang.Integer, java.lang.Integer)}.
     */
    @Test
    public void testPlanet() {
        Boolean speedException = false;
        Boolean distanceException = false;
        
        try {
            new Planet(null, 1);
        } catch (NullPointerException ex) {
            speedException = true;
        }
        
        try {
            new Planet(1, null);
        } catch (NullPointerException ex) {
            distanceException = true;
        }
        
        assertTrue(speedException);
        assertTrue(distanceException);
    }

    /**
     * Test method for {@link starTrekGalaxy.Planet#getxPos()}.
     */
    @Test
    public void testGetxPos() throws NoSuchFieldException, IllegalAccessException {
        final Planet testPlanet = new Planet(100, 100);
        final Field field = testPlanet.getClass().getDeclaredField("xPos");
        field.setAccessible(true);
        field.set(testPlanet, 50);
        
        final Integer result = testPlanet.getxPos();

        assertEquals("Wrong xPos value", (Integer) 50, result);
    }

    /**
     * Test method for {@link starTrekGalaxy.Planet#setxPos(java.lang.Integer)}.
     */
    @Test
    public void testSetxPos() throws NoSuchFieldException, IllegalAccessException{
        final Planet testPlanet = new Planet(100, 100);
        
        testPlanet.setxPos(50);
        
        final Field field = testPlanet.getClass().getDeclaredField("xPos");
        field.setAccessible(true);
        
        assertEquals("Wrong xPos value", 50, field.get(testPlanet));
    }

    /**
     * Test method for {@link starTrekGalaxy.Planet#getyPos()}.
     */
    @Test
    public void testGetyPos() throws NoSuchFieldException, IllegalAccessException{
        final Planet testPlanet = new Planet(100, 100);
        final Field field = testPlanet.getClass().getDeclaredField("yPos");
        field.setAccessible(true);
        field.set(testPlanet, 50);
        
        final Integer result = testPlanet.getyPos();

        assertEquals("Wrong yPos value", (Integer) 50, result);
    }

    /**
     * Test method for {@link starTrekGalaxy.Planet#setyPos(java.lang.Integer)}.
     */
    @Test
    public void testSetyPos() throws NoSuchFieldException, IllegalAccessException{
        final Planet testPlanet = new Planet(100, 100);
        
        testPlanet.setyPos(50);
        
        final Field field = testPlanet.getClass().getDeclaredField("yPos");
        field.setAccessible(true);
        
        assertEquals("Wrong xPos value", 50, field.get(testPlanet));
    }

    /**
     * Test method for {@link starTrekGalaxy.Planet#getSpeed()}.
     */
    @Test
    public void testGetSpeed() throws NoSuchFieldException, IllegalAccessException{
        final Planet testPlanet = new Planet(100, 100);
        final Field field = testPlanet.getClass().getDeclaredField("speed");
        field.setAccessible(true);
        
        field.set(testPlanet, 200);
        
        final Integer result = testPlanet.getSpeed();
        
        assertEquals("Wrong speed value", (Integer) 200, result);
    }

    /**
     * Test method for {@link starTrekGalaxy.Planet#getDistance()}.
     */
    @Test
    public void testGetDistance() throws NoSuchFieldException, IllegalAccessException{
        final Planet testPlanet = new Planet(100, 100);
        final Field field = testPlanet.getClass().getDeclaredField("distance");
        field.setAccessible(true);
        
        field.set(testPlanet, 200);
        
        final Integer result = testPlanet.getDistance();
        
        assertEquals("Wrong distance value", (Integer) 200, result);
    }

}
