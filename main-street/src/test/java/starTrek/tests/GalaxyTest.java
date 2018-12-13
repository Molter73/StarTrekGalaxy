/**
 * 
 */
package starTrek.tests;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.Test;

import starTrek.galaxy.Galaxy;
import starTrek.galaxy.NotEnoughPlanetsException;
import starTrek.galaxy.Planet;

/**
 * Tests for the Galaxy class
 * @author Mauro Moltrasio
 *
 */
public class GalaxyTest {

	/**
	 * Test method for {@link starTrek.galaxy.Galaxy#Galaxy()}.
	 */
	@Test
	public void testGalaxy() {
		assertNotNull(new Galaxy());
	}

	
	/**
	 * Test method for {@link starTrek.galaxy.Galaxy#Galaxy(java.util.ArrayList)}.
	 * @throws SecurityException security exception on field creation
	 * @throws NoSuchFieldException exception on wrong field name
	 * @throws IllegalAccessException exception on access to prohibited field
	 * @throws IllegalArgumentException exception on illegal argument
	 */
	@Test
	public void testGalaxyArray() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final ArrayList<Planet> planets = new ArrayList<Planet>();
		final Planet planet = new Planet("", 10, 10d);
		
		planets.add(planet);
		final Galaxy galaxyTest = new Galaxy(planets);
		
		final Field field = galaxyTest.getClass().getDeclaredField("planets");
		field.setAccessible(true);
		
		assertNotNull(galaxyTest);
		assertEquals(planets, field.get(galaxyTest));
	}

	/**
	 * Test method for {@link starTrek.galaxy.Galaxy#getPlanets()}.
	 * @throws SecurityException security exception on field creation
	 * @throws NoSuchFieldException exception on wrong field name
	 * @throws IllegalAccessException exception on access to prohibited field
	 * @throws IllegalArgumentException exception on illegal argument
	 */
	@Test
	public void testGetPlanets() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Planet planet = new Planet("", 10, 20d);
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
	 * Test method for {@link starTrek.galaxy.Galaxy#add(starTrek.galaxy.Planet)}.
	 * @throws SecurityException security exception on field creation
	 * @throws NoSuchFieldException exception on wrong field name
	 * @throws IllegalAccessException exception on access to prohibited field
	 * @throws IllegalArgumentException exception on illegal argument
	 */
	@Test
	public void testAddPlanet() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Galaxy galaxyTest = new Galaxy();
		final Planet planet = new Planet("", 10, 20d);
		final ArrayList<Planet> expectedPlanets = new ArrayList<Planet>();
		final Field field = galaxyTest.getClass().getDeclaredField("planets");
		field.setAccessible(true);
		
		galaxyTest.add(planet);
		expectedPlanets.add(planet);
		
		assertEquals(expectedPlanets, field.get(galaxyTest));
	}

	/**
	 * Test method for {@link starTrek.galaxy.Galaxy#add(java.lang.Integer, java.lang.Double)}.
	 * @throws SecurityException security exception on field creation
	 * @throws NoSuchFieldException exception on wrong field name
	 * @throws IllegalAccessException exception on access to prohibited field
	 * @throws IllegalArgumentException exception on illegal argument
	 */
	@Test
	public void testAddIntegerInteger() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Galaxy galaxyTest = new Galaxy();
		final Planet planet = new Planet("", 10, 20d);
		final ArrayList<Planet> expectedPlanets = new ArrayList<Planet>();
		final Field field = galaxyTest.getClass().getDeclaredField("planets");
		field.setAccessible(true);
		
		galaxyTest.add(10, 20d);
		expectedPlanets.add(planet);
		
		assertEquals(expectedPlanets, field.get(galaxyTest));
	}

	/**
	 * Test method for {@link starTrek.galaxy.Galaxy#updatePositions(Long)}
	 * @throws SecurityException security exception on field creation
	 * @throws NoSuchFieldException exception on wrong field name
	 * @throws IllegalAccessException exception on access to prohibited field
	 * @throws IllegalArgumentException exception on illegal argument
	 */
	@Test
	public void testUpdatePositions() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    	final Galaxy testGalaxy = new Galaxy();
    	final Planet testPlanet = new Planet("", 1, 500000d);
		final ArrayList<Planet> expectedPlanets = new ArrayList<Planet>();
		final Field planets = testGalaxy.getClass().getDeclaredField("planets");
		planets.setAccessible(true);
		
		expectedPlanets.add(new Planet("", 1, 500000d));
		expectedPlanets.get(0).updatePosition(10l);
		
    	testGalaxy.add(testPlanet);
    	testGalaxy.updatePositions(10l);
    	
    	assertEquals(expectedPlanets, planets.get(testGalaxy));
	}

	/**
	 * Test method for {@link starTrek.galaxy.Galaxy#planetsAligned}
	 */
	@Test
	public void testPlanetsAligned() {
		final Galaxy emptyGalaxy = new Galaxy();
		final Galaxy singlePlanetGalaxy = new Galaxy();
		final Galaxy doublePlanetGalaxy = new Galaxy();
		final Galaxy triplePlanetGalaxy = new Galaxy();
		final Galaxy tripleUnalignedGalaxy = new Galaxy();
		final Planet unalignedPlanet = new Planet("", 1, 100d);
		
		unalignedPlanet.setyPos(200d);
		
		singlePlanetGalaxy.add(new Planet("", 1, 100d));
		doublePlanetGalaxy.add(new Planet("", 1, 100d));
		doublePlanetGalaxy.add(new Planet("", 1, 200d));
		triplePlanetGalaxy.add(new Planet("", 1, 100d));
		triplePlanetGalaxy.add(new Planet("", 1, 200d));
		triplePlanetGalaxy.add(new Planet("", 1, 300d));
		tripleUnalignedGalaxy.add(new Planet("", 1, 100d));
		tripleUnalignedGalaxy.add(new Planet("", 1, 200d));
		tripleUnalignedGalaxy.add(unalignedPlanet);
		
		assertFalse(emptyGalaxy.planetsAligned());
		assertFalse(singlePlanetGalaxy.planetsAligned());
		assertTrue(doublePlanetGalaxy.planetsAligned());
		assertTrue(triplePlanetGalaxy.planetsAligned());
		assertFalse(tripleUnalignedGalaxy.planetsAligned());
	}
	
	/**
	 * Test method for {@link starTrek.galaxy.Galaxy#planetsAlignedWithSun}
	 */
	@Test
	public void testPlanetsAlignedWithSun() {
		final Galaxy emptyGalaxy = new Galaxy();
		final Galaxy singlePlanetGalaxy = new Galaxy();
		final Galaxy doublePlanetGalaxy = new Galaxy();
		final Galaxy triplePlanetGalaxy = new Galaxy();
		final Galaxy tripleUnalignedGalaxy = new Galaxy();
		final Galaxy notAlignedWithSun = new Galaxy();
		final Planet unalignedPlanet = new Planet("", 1, 100d);
		
		unalignedPlanet.setyPos(200d);
		
		singlePlanetGalaxy.add(new Planet("", 1, 100d));
		doublePlanetGalaxy.add(new Planet("", 1, 100d));
		doublePlanetGalaxy.add(new Planet("", 1, 200d));
		triplePlanetGalaxy.add(new Planet("", 1, 100d));
		triplePlanetGalaxy.add(new Planet("", 1, 200d));
		triplePlanetGalaxy.add(new Planet("", 1, 300d));
		tripleUnalignedGalaxy.add(new Planet("", 1, 100d));
		tripleUnalignedGalaxy.add(new Planet("", 1, 200d));
		tripleUnalignedGalaxy.add(unalignedPlanet);
		notAlignedWithSun.add(new Planet("", 1, 100d));
		notAlignedWithSun.add(unalignedPlanet);
		
		assertFalse(emptyGalaxy.planetsAlignedWithSun());
		assertFalse(singlePlanetGalaxy.planetsAlignedWithSun());
		assertTrue(doublePlanetGalaxy.planetsAlignedWithSun());
		assertTrue(triplePlanetGalaxy.planetsAlignedWithSun());
		assertFalse(tripleUnalignedGalaxy.planetsAlignedWithSun());
		assertFalse(notAlignedWithSun.planetsAlignedWithSun());
	}

	/**
	 * Test method for {@link starTrek.galaxy.Galaxy#getWeather}
	 * @throws NotEnoughPlanetsException exception thrown when trying to do math with not enough planets in the galaxy
	 */
	@Test
	public void testGetWeather() throws NotEnoughPlanetsException {
		final Galaxy emptyGalaxy = new Galaxy();
		final Galaxy droughtGalaxy = new Galaxy();
		final Galaxy optimumGalaxy = new Galaxy();
		final Galaxy rainyGalaxy = new Galaxy();
		final Galaxy sunnyGalaxy = new Galaxy();
		final Planet firstPlanet = new Planet("", 1, 100d);
		final Planet secondPlanet = new Planet("", 1, 100d);
		final Planet thirdPlanet = new Planet("", 1, 100d);
		NotEnoughPlanetsException galaxyEmptyException = null;
		String droughtText;
		String optimumText;
		String rainyText;
		String sunnyText;
		
		firstPlanet.setyPos(100d);		// (100, 100)
		secondPlanet.setyPos(-100d);	// (100, -100)
		thirdPlanet.setxPos(-100d);		// (-100, 0)
		
		droughtGalaxy.add(new Planet("", 1, 100d));
		droughtGalaxy.add(new Planet("", 1, 200d));
		optimumGalaxy.add(new Planet("", 1, 100d));
		optimumGalaxy.add(firstPlanet);
		rainyGalaxy.add(new Planet("", 1, 100d));
		rainyGalaxy.add(new Planet("", 1, 200d));
		rainyGalaxy.add(firstPlanet);
		sunnyGalaxy.add(firstPlanet);
		sunnyGalaxy.add(secondPlanet);
		sunnyGalaxy.add(thirdPlanet);
		
		try {
			emptyGalaxy.getWeather();
		} catch (NotEnoughPlanetsException e) {
			galaxyEmptyException = e;
		}

		droughtText = droughtGalaxy.getWeather();
		optimumText = optimumGalaxy.getWeather();
		rainyText = rainyGalaxy.getWeather();
		sunnyText = sunnyGalaxy.getWeather();
		
		assertNotNull(galaxyEmptyException);
		assertEquals("drought", droughtText);
		assertEquals("optimum", optimumText);
		assertEquals("rainy", rainyText);
		assertEquals("sunny", sunnyText);
	}

	/**
	 * Test method for {@link starTrek.galaxy.Galaxy#getPerimeter}
	 */
	@Test
	public void testGetPerimeter()  {
		final Galaxy emptyGalaxy = new Galaxy();
		final Galaxy testGalaxy = new Galaxy();
		final Planet firstPlanet = new Planet("", 1, 100d);
		final Planet secondPlanet = new Planet("", 1, 100d);
		final Planet thirdPlanet = new Planet("", 1, 100d);
		Double perimeter;
		
		firstPlanet.setyPos(100d);		// (100, 100)
		secondPlanet.setyPos(-100d);	// (100, -100)
		thirdPlanet.setxPos(-100d);		// (-100, 0)
		
		testGalaxy.add(firstPlanet);
		testGalaxy.add(secondPlanet);
		testGalaxy.add(thirdPlanet);

		perimeter = testGalaxy.getPerimeter();
		
		assertEquals(0d, emptyGalaxy.getPerimeter(), 0.001);
		assertEquals(647.213, perimeter, 0.001);
	}

}
