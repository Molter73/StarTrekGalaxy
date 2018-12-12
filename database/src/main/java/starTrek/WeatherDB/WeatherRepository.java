/**
 * 
 */
package starTrek.WeatherDB;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * A JPA repository used to easily connect to underlying database
 * 
 * @author Mauro Moltrasio
 *
 */
@Repository
public interface WeatherRepository extends CrudRepository<Weather, Long> {
	/**
	 * Searches the database for the given days weather
	 * @param day the day for which the weather is requested
	 * @return a Weather object, representing the weather condition
	 */
	Weather findByDay(Long day);
}
