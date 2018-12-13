
package starTrek.galaxy;

import java.awt.Polygon;
import java.util.ArrayList;

import starTrek.geometry.Line;

/**
 * This class handles all interactions between
 * planets inside of a galaxy.
 * <p>
 * It has methods for updating position of planets
 * based on its speed and getting the weather on
 * them according to their relative positions.
 * </p>
 *
 * @author Mauro Moltrasio
 *
 */
public class Galaxy {
	private ArrayList<Planet> planets;

	/**
	 * Create a new, empty galaxy.
	 */
	public Galaxy() {
		super();
		this.planets = new ArrayList<Planet>();
	}
	
	/**
	 * Create a new galaxy with the planets specified.
	 * @param planets the planets to be added to the new
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
	 * Add an existing planet to the galaxy.
	 * @param planet the planet to add
	 */
	public void add(Planet planet) {
		this.planets.add(planet);
	}
	
	/**
	 * Add a new planet to the galaxy.
	 * @param speed 	the speed at which the planet rotates
	 * @param distance 	the distance from the sun to this planet
	 */
	public void add(Integer speed, Double distance) {
		this.planets.add(new Planet("", speed, distance));
	}
	
	/**
	 * Update the position of planets for a given day.
	 * @param elapsedDays the amounts of days elapsed
	 */
	public void updatePositions(Long elapsedDays) {
		for(Planet planet : this.planets) {
			planet.updatePosition(elapsedDays);
		}
	}

	/**
	 * Determine whether the existing planets in this 
	 * galaxy are aligned among themselves.
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
		
		/*
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
	 * aligned among themselves and with the sun.
	 * @return true if all planets and the sun are aligned
	 */
	public Boolean planetsAlignedWithSun() {
		if(this.planetsAligned()) {
			/*
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

	/**
	 * Determine the weather of planets based on their
	 * current position.
	 * @return a String description of the weather
	 * @throws NotEnoughPlanetsException exception thrown when there are not enough planets in the galaxy
	 */
	public String getWeather() throws NotEnoughPlanetsException {
		if (this.planets.size() < 2)
			throw new NotEnoughPlanetsException();
		if (this.planetsAligned()) {
			if (this.planetsAlignedWithSun()) {
				return new String("drought");
			} else {
				return new String ("optimum");
			}
		} else { 
			/*
			 * The planets are not aligned, we create a polygon
			 * with them and check to see if the sun (0,0) is 
			 * inside of it
			 */
			Polygon polygon = new Polygon();
			for(Planet planet : this.planets)
				polygon.addPoint(planet.getxPos().intValue(), planet.getyPos().intValue());
			
			if(polygon.contains(0, 0))
				return new String("sunny");
		}
		return new String("rainy");
	}

	/**
	 * Determine the perimeter of the polygon created
	 * by the planets in this galaxy.
	 * If the galaxy has 2 or less planets, the perimeter
	 * defaults to 0.
	 * @return a Double with the total perimeter
	 */
	public Double getPerimeter() {
		Double result = 0d;
		
		if(this.planets.size() <= 2)
			return 0d;

		Planet prevPlanet = this.planets.get(this.planets.size() - 1);
		for (Planet planet : planets) {
			result += Math.hypot(Math.abs(planet.getxPos() - prevPlanet.getxPos()), 
					Math.abs(planet.getyPos() - prevPlanet.getyPos()));
			prevPlanet = planet;
		}
		
		return result;
	}
}
