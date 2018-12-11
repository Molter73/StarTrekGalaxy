/**
 * 
 */
package starTrek.WeatherDB;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Mauro Moltrasio
 *
 */
@Entity
@Table(name="Weather", schema="StarTrekWeather")
public class Weather {
	@Id int day;
	String weatherCondition;
	
	protected Weather() {}

	/**
	 * @param day
	 * @param weatherCondition
	 */
	public Weather(int day, String weatherCondition) {
		this.day = day;
		this.weatherCondition = weatherCondition;
	}
}
