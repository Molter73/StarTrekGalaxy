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
 * @author Mauro Moltrasio
 *
 */
@EntityScan(basePackages = {"starTrek.WeatherDB"})
@EnableJpaRepositories(basePackages={"starTrek.WeatherDB"}) 
@SpringBootApplication
public class MainRest extends SpringBootServletInitializer{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MainRest.class, args);
	}
}
