/**
 * 
 */
package starTrek.WeatherDB;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class acts as a JPA entity for accessing the weather database.
 * 
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
	 * Create a new definition of the weather conditions
	 * for a given day, based on an existing weather desciption.
	 * 
	 * @param weather a Weather description object
	 */
	public Weather(Weather weather) {
		this.day = weather.day;
		this.weatherCondition = weather.weatherCondition;
	}

	/**
	 * Create a new definition of the weather conditions
	 * for a given day.
	 * 
	 * @param day the day number for which this description is
	 * @param weatherCondition a String describing the weather condition
	 */
	public Weather(Long day, String weatherCondition) {
		this.day = day;
		this.weatherCondition = weatherCondition;
	}

	/**
	 * Get the day stored in this weather object
	 * @return the day
	 */
	public Long getDay() {
		return day;
	}

	/**
	 * The conditions associated with the day in this weather object
	 * @return the weatherCondition
	 */
	public String getWeatherCondition() {
		return weatherCondition;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Weather [day=" + day + ", weatherCondition=" + weatherCondition + "]";
	}
}
