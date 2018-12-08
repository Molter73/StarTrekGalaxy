/**
 * 
 */
package starTrekGalaxy;

import java.util.ArrayList;

/**
 * @author Molter
 *
 */
public class Galaxy {
	private ArrayList<Planet> planets;

	/**
	 * 
	 */
	public Galaxy() {
		super();
		this.planets = new ArrayList<Planet>();
	}
	
	/**
	 * @param planets
	 */
	public Galaxy(ArrayList<Planet> planets) {
		super();
		this.planets = planets;
	}

	/**
	 * @return the planets
	 */
	public ArrayList<Planet> getPlanets() {
		return planets;
	}

	/**
	 * Add a new planet to the galaxy
	 * @param planet the planet to add
	 */
	public void add(Planet planet) {
		this.planets.add(planet);
	}
	
	/**
	 * Add a new planet to the galaxy
	 * @param speed 	the speed at which the planet rotates
	 * @param distance 	the distance from the sun to this planet
	 */
	public void add(Integer speed, Integer distance) {
		this.planets.add(new Planet(speed, distance));
	}
}
