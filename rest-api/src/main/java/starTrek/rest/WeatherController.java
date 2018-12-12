/**
 * 
 */
package starTrek.rest;

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
	@Autowired
	private WeatherRepository repository;
	
	@RequestMapping("/weather")
	public Weather weather(@RequestParam(name="day", required=true) Long day) {
		return repository.findById(day).get();
	}
	
	@RequestMapping("/")
	public String welcome() {
		return "<h1>Welcome to the star trek weather service</h1>";
	}

}
