/**
 * 
 */
package starTrek.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * This class handles the creation of a servlet application for the
 * REST api.
 * @author Mauro Moltrasio
 *
 */
@EntityScan(basePackages = {"starTrek.WeatherDB"})
@EnableJpaRepositories(basePackages={"starTrek.WeatherDB"}) 
@SpringBootApplication
public class MainRest extends SpringBootServletInitializer{

	/**
	 * @param args the parameters for this execution
	 */
	public static void main(String[] args) {
		SpringApplication.run(MainRest.class, args);
	}
}
