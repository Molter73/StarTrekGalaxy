/**
 * This class is responsible for running the simulation on 
 * the galaxy, to determine the weather conditions in different
 * days along the first 10 (Earth) years from the creation of the
 * galaxy (or the next 10 years after the next alignment of the three
 * major planets with the sun really, its just a matter of reference)
 */
package starTrek.simulation;

import starTrek.galaxy.Galaxy;
import starTrek.galaxy.Planet;
import starTrek.geometry.Line;

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
		Planet ferengi = new Planet(-1, 500d);
		Planet betasoide = new Planet(-3, 2000d);
		Planet vulcano = new Planet(5, 1000d);
		
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
		
		/**
		 * The system is set, we now sweep day by day
		 * through the next 10 years, check conditions
		 * to determine what the weather will be and record
		 * useful information
		 */
		for(int day = 0; day < 3650; day++) {
			galaxy.updatePositions(day);
			
			/**
			 * Create a line from ferengi and betasoide planets
			 * then find out if vulcano is in said line
			 */
			Line line = new Line(ferengi.getxPos(), ferengi.getyPos(),
					betasoide.getxPos(), betasoide.getyPos());
			
			if(line.containsPoint(vulcano.getxPos(), vulcano.getyPos())) {
				/**
				 * The planets are aligned!! Now we must check if they
				 * are aligned with the sun which is our center (0,0)
				 */
				if(line.containsPoint(0d, 0d)) {
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
	}

}
