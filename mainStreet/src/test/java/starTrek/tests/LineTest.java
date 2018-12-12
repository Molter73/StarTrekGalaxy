/**
 * 
 */
package starTrek.tests;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

import starTrek.geometry.Line;

/**
 * Tests for the Line class
 * 
 * @author Mauro Moltrasio
 *
 */
public class LineTest {

	/**
	 * Test method for {@link starTrek.geometry.Line#Line()}.
	 * @throws SecurityException security exception on field creation
	 * @throws NoSuchFieldException exception on wrong field name
	 * @throws IllegalAccessException exception on access to prohibited field
	 * @throws IllegalArgumentException exception on illegal argument
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
	 * @throws SecurityException security exception on field creation
	 * @throws NoSuchFieldException exception on wrong field name
	 * @throws IllegalAccessException exception on access to prohibited field
	 * @throws IllegalArgumentException exception on illegal argument
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
	 * @throws SecurityException security exception on field creation
	 * @throws NoSuchFieldException exception on wrong field name
	 * @throws IllegalAccessException exception on access to prohibited field
	 * @throws IllegalArgumentException exception on illegal argument
	 */
	@Test
	public void testLineDoubleDoubleDoubleDouble() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		final Line line = new Line(1d, 2d, 0d, 0d);
		final Line verticalLine = new Line(1d, 3d, 1d, 5d);
		final Field slope = line.getClass().getDeclaredField("slope");
		final Field intercept = line.getClass().getDeclaredField("intercept");
		
		slope.setAccessible(true);
		intercept.setAccessible(true);
		
		assertNotNull(line);
		assertEquals(2d, slope.get(line));
		assertEquals(0d, intercept.get(line));
		assertTrue(Double.isInfinite((Double) slope.get(verticalLine)));
		assertEquals(1d, intercept.get(verticalLine));
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
	 * @throws SecurityException security exception on field creation
	 * @throws NoSuchFieldException exception on wrong field name
	 * @throws IllegalAccessException exception on access to prohibited field
	 * @throws IllegalArgumentException exception on illegal argument
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
	 * @throws SecurityException security exception on field creation
	 * @throws NoSuchFieldException exception on wrong field name
	 * @throws IllegalAccessException exception on access to prohibited field
	 * @throws IllegalArgumentException exception on illegal argument
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

	/**
	 * Test method for {@link starTrek.geometry.Line#containsPoint(java.lang.Double, java.lang.Double)}
	 */
	@Test
	public void testContainsPoint() {
		final Line line = new Line(2d, 0d);
		final Line verticalLine = new Line(5d, 4d, 5d, 5d);
		
		final Boolean containedResult = line.containsPoint(0d, 0d);
		final Boolean notContainedResult = line.containsPoint(1d, 1d);
		final Boolean verticalContainedResult = verticalLine.containsPoint(5d, 6d);
		final Boolean verticalNotContainedResult = verticalLine.containsPoint(3d, 6d);
		
		assertTrue(containedResult);
		assertFalse(notContainedResult);
		assertTrue(verticalContainedResult);
		assertFalse(verticalNotContainedResult);
	}
}
