/**
 * 
 */
package starTrek.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import starTrek.WeatherDB.Weather;
import starTrek.WeatherDB.WeatherRepository;

/**
 * @author Mauro Moltrasio
 *
 */
@RestController
public class WeatherController {
	private static final Logger log = LoggerFactory.getLogger(WeatherController.class);

	@Autowired
	private WeatherRepository repository;
	
	@RequestMapping("/weather")
	public Weather weather(@RequestParam(name="day", required=true) Long day) {
		Weather weather = repository.findById(day).get();
		log.info(weather.toString());
		return repository.findById(day).get();
	}

}
