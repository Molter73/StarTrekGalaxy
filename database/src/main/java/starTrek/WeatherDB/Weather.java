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
@Table(name="Weather", schema="star_trek_weather")
public class Weather {
	@Id Long day;
	String weatherCondition;
	
	protected Weather() {}

	/**
	 * @param day
	 * @param weatherCondition
	 */
	public Weather(Long day, String weatherCondition) {
		this.day = day;
		this.weatherCondition = weatherCondition;
	}
}
