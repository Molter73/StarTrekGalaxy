
package starTrek.simulation;

import starTrek.galaxy.Galaxy;
import starTrek.galaxy.NotEnoughPlanetsException;
import starTrek.galaxy.Planet;

/**
 * This class is responsible for running the simulation on 
 * the galaxy.
 * 
 * To determine the weather conditions in different
 * days along the first 10 (Earth) years from the creation of the
 * galaxy (or the next 10 years after the next alignment of the three
 * major planets with the sun really, its just a matter of reference)
 *
 * @author Mauro Moltrasio
 *
 */
public class Simulation {

	/**
	 * @param args the execution parameters
	 * @throws NotEnoughPlanetsException throws NotEnoughPlanetsException when there are no enough planets to predict the weather in this galaxy 
	 */
	public static void main(String[] args) throws NotEnoughPlanetsException {
		/**
		 * Add planets to a Galaxy
		 */
		Galaxy galaxy = new Galaxy();
		
		galaxy.add(new Planet("ferengi", -1, 500d));
		galaxy.add(new Planet("betasoide", -3, 2000d));
		galaxy.add(new Planet("vulcano", 5, 1000d));
		
		/**
		 * We create some auxiliary variables to save 
		 * some system information.
		 * TODO: Move this auxiliary variables to a database.
		 */
		Integer optimumConditionsOccured = 0;
		Integer droughtConditionsOccured = 0;
		Integer rainSeasons = 0;
		Long biggestRainDay = 0l;
		Double  maxPerimeter = 0d;
		
		/**
		 * The system is set, we now sweep day by day
		 * through the next 10 years, check conditions
		 * to determine what the weather will be and record
		 * useful information
		 */
		for(Long day = 0l; day < 3650; day++) {
			galaxy.updatePositions(day);
			
			switch (galaxy.getWeather()) {
			case "drought":
				droughtConditionsOccured++;
				break;
			case "optimum":
				optimumConditionsOccured++;
				break;
			case "rainy":
				rainSeasons++;
				Double perimeter = galaxy.getPerimeter();
				if (perimeter > maxPerimeter) {
					maxPerimeter = perimeter;
					biggestRainDay = day;
				}
				break;
			case "sunny":
			default:
				break;
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
