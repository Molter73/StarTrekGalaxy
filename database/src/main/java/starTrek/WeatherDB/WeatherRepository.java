/**
 * 
 */
package starTrek.WeatherDB;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mauro Moltrasio
 *
 */
@Repository
public interface WeatherRepository extends CrudRepository<Weather, Long> {
	Weather findByDay(Long day);
}
