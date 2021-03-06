/**
 * 
 */
package starTrek.galaxy;

/**
 * A class representing a Planet with its speed and position
 * 
 * Contains methods for creating and manipulating planets.
 * 
 * @author Mauro Moltrasio
 *
 */
public class Planet {
	private String name;
	private Integer speed;     	//  degrees / day
	private Double distance;  	//  meters from the sun
	
	private Double xPos;		
    private Double yPos;
        
	/**
	 * 
	 * @param speed the speed at which the planet rotates around the sun
	 * @param distance the distance of the planet from the sun
	 * @throws NullPointerException throws NullPointerException if any of the parameters is null
	 * @deprecated Use {@link #Planet(String,Integer,Double)} instead
	 */
	public Planet(Integer speed, Double distance) throws NullPointerException{
		this("", speed, distance);
	}
	/**
	 * Creates a new planet with the given parameters
	 * 
	 * @param name a String containing the planets name
	 * @param speed the speed at which the planet rotates around the sun
	 * @param distance the distance of the planet from the sun
	 * @throws NullPointerException throws NullPointerException if any of the parameters is null
	 */
	public Planet(String name, Integer speed, Double distance) throws NullPointerException{
        //  speed and distance can only be set at Planet creation time and are required.
        if(speed == null || distance == null || name == null)
            throw new NullPointerException();
        
        this.name = name;
        this.speed = speed;
        this.distance = distance;
        
        // for a matter of simplicity in calculations, all planets start at
        // (xPos = distance, yPos = 0) making the initial angle 0� for all of them
        this.xPos = distance;
        this.yPos = 0d;
    }
    /**
     * Get the planets x position
     * 
     * @return the xPos
     */
    public Double getxPos() {
        return xPos;
    }
    /**
     * The new planets x position
     * Calculates the new distance from the sun
     * 
     * @param xPos the xPos to set
     */
    public void setxPos(Double xPos) {
        this.xPos = xPos;
        // calculate the new distance
        this.distance = Math.hypot(Math.abs(this.xPos), this.yPos);
    }
    /**
     * Get the planets y position
     * 
     * @return the yPos
     */
    public Double getyPos() {
        return yPos;
    }
    /**
     * The new planets x position
     * Calculates the new distance from the sun
     * 
     * @param yPos the yPos to set
     */
    public void setyPos(Double yPos) {
        this.yPos = yPos;
        // calculate the new distance
        this.distance = Math.hypot(Math.abs(this.xPos), this.yPos);
    }
    /**
     * Get the planets rotation speed.
     * 
     * @return the speed
     */
    public Integer getSpeed() {
        return speed;
    }
    /**
     * Get the planets distance from the sun.
     * @return the distance
     */
    public Double getDistance() {
        return distance;
    }
    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((speed == null) ? 0 : speed.hashCode());
		result = prime * result + ((xPos == null) ? 0 : xPos.hashCode());
		result = prime * result + ((yPos == null) ? 0 : yPos.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planet other = (Planet) obj;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (speed == null) {
			if (other.speed != null)
				return false;
		} else if (!speed.equals(other.speed))
			return false;
		if (xPos == null) {
			if (other.xPos != null)
				return false;
		} else if (!xPos.equals(other.xPos))
			return false;
		if (yPos == null) {
			if (other.yPos != null)
				return false;
		} else if (!yPos.equals(other.yPos))
			return false;
		return true;
	}
	/**
	 * Update the position of the planet for a given amount of days
	 * elapsed from its creation
	 * 
	 * @param elapsedDays the amount of this passed since the creation of the galaxy
	 */
	public void updatePosition(Long elapsedDays) {
		double traveledDegrees = this.getSpeed() * elapsedDays;

		// calculate the position of the planet for the given day
		Double xPos = (this.getDistance() * Math.cos(Math.toRadians(traveledDegrees)));
		Double yPos = (this.getDistance() * Math.sin(Math.toRadians(traveledDegrees)));
		
		this.setxPos(xPos);
		this.setyPos(yPos);
	}
}
