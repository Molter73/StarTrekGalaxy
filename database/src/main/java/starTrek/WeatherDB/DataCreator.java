/**
 * 
 */
package starTrek.WeatherDB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import starTrek.galaxy.Galaxy;
import starTrek.galaxy.Planet;

/**
 * This class handles the REST api which access the weather database
 * 
 * @author Mauro Moltrasio
 *
 */
@SpringBootApplication
public class DataCreator {
	private static final Logger log = LoggerFactory.getLogger(DataCreator.class);
	
	/**
	 * @param args the execution parameters for this instance
	 */
	public static void main(String[] args) {
		SpringApplication.run(DataCreator.class);
	}
	
	@Bean
	public CommandLineRunner runner(WeatherRepository repository) {
		return (args) -> {
			log.info("Adding planets to a new galaxy...");
			/**
			 * Add planets to a Galaxy
			 */
			Galaxy galaxy = new Galaxy();
			
			galaxy.add(new Planet("ferengi", -1, 500d));
			galaxy.add(new Planet("betasoide", -3, 2000d));
			galaxy.add(new Planet("vulcano", 5, 1000d));
			
			/**
			 * Sweep the weather conditions for the next
			 * 10 Earth years and save the results to a
			 * database
			 */
			log.info("Simulating weather and saving to DB...");
			for(Long day = 0l; day < 3650; day++) {
				galaxy.updatePositions(day);
				
				repository.save(new Weather(day, galaxy.getWeather()));
			}
		};
	}
	
}
