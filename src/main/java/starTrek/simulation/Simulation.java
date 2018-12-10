/**
 * This class is responsible for running the simulation on 
 * the galaxy, to determine the weather conditions in different
 * days along the first 10 (Earth) years from the creation of the
 * galaxy (or the next 10 years after the next alignment of the three
 * major planets with the sun really, its just a matter of reference)
 */
package starTrek.simulation;

import java.awt.Polygon;

import starTrek.galaxy.Galaxy;
import starTrek.galaxy.Planet;

/**
 * @author Mauro Moltrasio
 *
 */
public class Simulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * We first create the three planets that will exist
		 * in the galaxy
		 */
		Planet ferengi = new Planet("ferengi", -1, 500d);
		Planet betasoide = new Planet("betasoide", -3, 2000d);
		Planet vulcano = new Planet("vulcano", 5, 1000d);
		
		/**
		 * Add the planets to a Galaxy
		 */
		Galaxy galaxy = new Galaxy();
		
		galaxy.add(ferengi);
		galaxy.add(betasoide);
		galaxy.add(vulcano);
		
		/**
		 * We create some auxiliary variables to save 
		 * some system information.
		 * TODO: Move this auxiliary variables to a database.
		 */
		Integer optimumConditionsOccured = 0;
		Integer droughtConditionsOccured = 0;
		Integer rainSeasons = 0;
		Integer biggestRainDay = 0;
		Double  maxTrianglePerimeter = 0d;
		
		/**
		 * The system is set, we now sweep day by day
		 * through the next 10 years, check conditions
		 * to determine what the weather will be and record
		 * useful information
		 */
		for(int day = 0; day < 3650; day++) {
			galaxy.updatePositions(day);
			
			if (galaxy.planetsAligned()) {
				/**
				 * The planets are aligned!! Now we must check if they
				 * are aligned with the sun 
				 */
				if(galaxy.planetsAlignedWithSun()) {
					/**
					 * The sun is in line with the planets,
					 * this is a drought season
					 */
					droughtConditionsOccured++;
				} else {
					/**
					 * The sun is not in line with the planets,
					 * This is an optimum condition
					 */
					optimumConditionsOccured++;
				}
			} else {
				/**
				 * The planets are not aligned, we must check if
				 * the sun is inside the triangle created by the planets
				 */
				Polygon triangle = new Polygon();
				
				/**
				 * We will create a triangle from the three planets
				 * using awts polygon and use it to check if the
				 * sun is inside of it.
				 * We will round the positions to integers as we did in
				 * {@link startTrek.geometry.Line#containsPoint(java.lang.Double, java.lang.Double)}
				 * for the same reasons explained in that methods description
				 */
				triangle.addPoint(ferengi.getxPos().intValue(), ferengi.getyPos().intValue());
				triangle.addPoint(betasoide.getxPos().intValue(), betasoide.getyPos().intValue());
				triangle.addPoint(vulcano.getxPos().intValue(), vulcano.getyPos().intValue());
				
				/**
				 * Now check if the sun (0,0) is contained inside the triangle
				 */
				if(triangle.contains(0, 0)) {
					rainSeasons++;
					/**
					 * Calculate the perimeter of the triangle and check
					 * if its bigger than the last one
					 */
					Double perimeter = 
							Math.hypot(Math.abs(ferengi.getxPos() - betasoide.getxPos()),
									Math.abs(ferengi.getyPos() - betasoide.getyPos())) + 
							Math.hypot(Math.abs(ferengi.getxPos() - vulcano.getxPos()),
									Math.abs(ferengi.getyPos() - vulcano.getyPos())) + 
							Math.hypot(Math.abs(vulcano.getxPos() - betasoide.getxPos()),
									Math.abs(vulcano.getyPos() - betasoide.getyPos()));
					if (perimeter > maxTrianglePerimeter) {
						maxTrianglePerimeter = perimeter;
						biggestRainDay = day;
					}
				}
			}
		}
		/**
		 * We have predicted the weather for the next ten years,
		 * print results to console.
		 * TODO: Create a REST interface and associated database
		 */
		System.out.println("Weather results for the next ten years!!");
		System.out.println("Optimum conditions: " + optimumConditionsOccured);
		System.out.println("Drought conditions: " + droughtConditionsOccured);
		System.out.println("Rain Seasons: " + rainSeasons);
		System.out.println("Biggest rain day: " + biggestRainDay);
	}

}
