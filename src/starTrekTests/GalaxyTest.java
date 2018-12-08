/**
 * 
 */
package starTrekTests;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.Test;

import starTrekGalaxy.Galaxy;
import starTrekGalaxy.Planet;

/**
 * @author Mauro Moltrasio
 *
 */
public class GalaxyTest {

	/**
	 * Test method for {@link starTrekGalaxy.Galaxy#Galaxy()}.
	 */
	@Test
	public void testGalaxy() {
		assertNotNull(new Galaxy());
	}

	
	/**
	 * Test method for {@link starTrekGalaxy.Galaxy#Galaxy(java.util.ArrayList)}.
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void testGalaxyArray() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final ArrayList<Planet> planets = new ArrayList<Planet>();
		final Planet planet = new Planet(10, 10);
		
		planets.add(planet);
		final Galaxy galaxyTest = new Galaxy(planets);
		
		final Field field = galaxyTest.getClass().getDeclaredField("planets");
		field.setAccessible(true);
		
		assertNotNull(galaxyTest);
		assertEquals(planets, field.get(galaxyTest));
	}

	/**
	 * Test method for {@link starTrekGalaxy.Galaxy#getPlanets()}.
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void testGetPlanets() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Planet planet = new Planet(10, 20);
		final ArrayList<Planet> planets = new ArrayList<Planet>();
		final Galaxy galaxyTest = new Galaxy(); 
		final Field field = galaxyTest.getClass().getDeclaredField("planets");
		field.setAccessible(true);
		
		planets.add(planet);
		field.set(galaxyTest, planets);
		
		final ArrayList<Planet> result = galaxyTest.getPlanets();
		
		assertEquals(planets, result);
	}

	/**
	 * Test method for {@link starTrekGalaxy.Galaxy#add(starTrekGalaxy.Planet)}.
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void testAddPlanet() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Galaxy galaxyTest = new Galaxy();
		final Planet planet = new Planet(10, 20);
		final ArrayList<Planet> expectedPlanets = new ArrayList<Planet>();
		final Field field = galaxyTest.getClass().getDeclaredField("planets");
		field.setAccessible(true);
		
		galaxyTest.add(planet);
		expectedPlanets.add(planet);
		
		assertEquals(expectedPlanets, field.get(galaxyTest));
	}

	/**
	 * Test method for {@link starTrekGalaxy.Galaxy#add(java.lang.Integer, java.lang.Integer)}.
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void testAddIntegerInteger() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Galaxy galaxyTest = new Galaxy();
		final Planet planet = new Planet(10, 20);
		final ArrayList<Planet> expectedPlanets = new ArrayList<Planet>();
		final Field field = galaxyTest.getClass().getDeclaredField("planets");
		field.setAccessible(true);
		
		galaxyTest.add(10, 20);
		expectedPlanets.add(planet);
		
		assertEquals(expectedPlanets, field.get(galaxyTest));
	}

}