/**
 * 
 */
package starTrek.galaxy;

import java.util.ArrayList;

import starTrek.geometry.Line;

/**
 * @author Mauro Moltrasio
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
	public void add(Integer speed, Double distance) {
		this.planets.add(new Planet("", speed, distance));
	}
	
	/**
	 * Update the position of planets for a given day
	 * @param elapsedDays the amounts of days elapsed
	 */
	public void updatePositions(Integer elapsedDays) {
		for(Planet planet : this.planets) {
			planet.updatePosition(elapsedDays);
		}
	}

	/**
	 * Determine whether the existing planets in this 
	 * galaxy are aligned among themselves
	 * @return true if planets are aligned
	 */
	public Boolean planetsAligned() {
		if (this.planets.size() == 0 || //	No planets in the galaxy
			this.planets.size() == 1) {	// 	A single planet has nothing to align to
			return false;
		}
		if (this.planets.size() == 2) {	//	Two planets are always aligned
			return true;
		}
		
		/**
		 * Create a line from the first two planets in the galaxy
		 * and check if all other planets are in said line
		 */
		final Line line = new Line(this.planets.get(0).getxPos(), 
				this.planets.get(0).getyPos(),
				this.planets.get(1).getxPos(), 
				this.planets.get(1).getyPos());
		
		for (Planet planet : this.planets.subList(2, this.planets.size())) {
			if (!line.containsPoint(planet.getxPos(), planet.getyPos()))
				return false;
		}
		
		// All existing planets are aligned
		return true;
	}

	/**
	 * Determine whether the planets in this galaxy are
	 * aligned among themselves and with the sun
	 * @return true if all planets and the sun are aligned
	 */
	public Boolean planetsAlignedWithSun() {
		if(this.planetsAligned()) {
			/**
			 * Create a line from the first two planets in the galaxy
			 * and check if the sun is in said line
			 */
			final Line line = new Line(this.planets.get(0).getxPos(), 
					this.planets.get(0).getyPos(),
					this.planets.get(1).getxPos(), 
					this.planets.get(1).getyPos());
			if (line.containsPoint(0d, 0d)) {
				return true;
			}
		}
		return false;
	}
}
