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

	public Weather(Weather weather) {
		this.day = weather.day;
		this.weatherCondition = weather.weatherCondition;
	}

	/**
	 * @param day
	 * @param weatherCondition
	 */
	public Weather(Long day, String weatherCondition) {
		this.day = day;
		this.weatherCondition = weatherCondition;
	}

	/**
	 * @return the day
	 */
	public Long getDay() {
		return day;
	}

	/**
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
