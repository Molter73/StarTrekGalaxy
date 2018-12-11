/**
 * 
 */
package starTrek.WeatherDB;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Mauro Moltrasio
 *
 */
public interface WeatherRepository extends CrudRepository<Weather, Long> {

}
