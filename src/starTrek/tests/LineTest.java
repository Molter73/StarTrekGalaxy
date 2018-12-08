/**
 * 
 */
package starTrek.tests;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

import starTrek.galaxy.Planet;
import starTrek.geometry.Line;

/**
 * @author Molter
 *
 */
public class LineTest {

	/**
	 * Test method for {@link starTrek.geometry.Line#Line()}.
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void testLine() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Line line = new Line();
		final Field gradient = line.getClass().getDeclaredField("slope");
		final Field intercept = line.getClass().getDeclaredField("intercept");
		
		gradient.setAccessible(true);
		intercept.setAccessible(true);
		
		assertNotNull(line);
		assertEquals(0d, gradient.get(line));
		assertEquals(0d, intercept.get(line));
	}

	/**
	 * Test method for {@link starTrek.geometry.Line#Line(java.lang.Double, java.lang.Double)}.
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void testLineDoubleDouble() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Line line = new Line(1d, 2d);
		final Field gradient = line.getClass().getDeclaredField("slope");
		final Field intercept = line.getClass().getDeclaredField("intercept");
		
		gradient.setAccessible(true);
		intercept.setAccessible(true);
		
		assertNotNull(line);
		assertEquals(1d, gradient.get(line));
		assertEquals(2d, intercept.get(line));
	}

	/**
	 * Test method for {@link starTrek.geometry.Line#Line(java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double)}.
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void testLineDoubleDoubleDoubleDouble() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Line line = new Line(1d, 2d, 0d, 0d);
		final Field slope = line.getClass().getDeclaredField("slope");
		final Field intercept = line.getClass().getDeclaredField("intercept");
		
		slope.setAccessible(true);
		intercept.setAccessible(true);
		
		assertNotNull(line);
		assertEquals(2d, slope.get(line));
		assertEquals(0d, intercept.get(line));
	}

	/**
	 * Test method for {@link starTrek.geometry.Line#getSlope()}.
	 */
	@Test
	public void testGetSlope() {
        final Line line = new Line();
        
        final double result = line.getSlope();

        assertEquals(0d, result, 0.001);
	}

	/**
	 * Test method for {@link starTrek.geometry.Line#setSlope(java.lang.Double)}.
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void testSetSlope() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Line line = new Line();
		final Field slope = line.getClass().getDeclaredField("slope");
		slope.setAccessible(true);
		
		line.setSlope(2d);
		
		assertEquals(2d, (double)slope.get(line), 0.001);
	}

	/**
	 * Test method for {@link starTrek.geometry.Line#getIntercept()}.
	 */
	@Test
	public void testGetIntercept() {
        final Line line = new Line();
        
        final double result = line.getIntercept();

        assertEquals(0d, result, 0.001);
	}

	/**
	 * Test method for {@link starTrek.geometry.Line#setIntercept(java.lang.Double)}.
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void testSetIntercept() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Line line = new Line();
		final Field intercept = line.getClass().getDeclaredField("intercept");
		intercept.setAccessible(true);
		
		line.setIntercept(2d);
		
		assertEquals(2d, (double)intercept.get(line), 0.001);
	}

	/**
	 * Test method for {@link java.lang.Object#equals(java.lang.Object)}.
	 */
	@Test
	public void testEquals() {
		final Line line = new Line();
		
		assertEquals(new Line(), line);
	}

}
