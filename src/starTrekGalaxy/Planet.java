/**
 * 
 */
package starTrekGalaxy;

/**
 * @author moltrasm
 *
 */
public class Planet {
	private Integer speed;     //  degrees / day
	private Integer distance;  //  kms from the sun
	
	private Integer xPos;
    private Integer yPos;
    
    
    
	public Planet(Integer speed, Integer distance) throws NullPointerException{
        super();
        //  speed and distance can only be set at Planet creation time and are required.
        if(speed == null || distance == null)
            throw new NullPointerException();
        
        this.speed = speed;
        this.distance = distance;
    }
    /**
     * @return the xPos
     */
    public Integer getxPos() {
        return xPos;
    }
    /**
     * @param xPos the xPos to set
     */
    public void setxPos(Integer xPos) {
        this.xPos = xPos;
    }
    /**
     * @return the yPos
     */
    public Integer getyPos() {
        return yPos;
    }
    /**
     * @param yPos the yPos to set
     */
    public void setyPos(Integer yPos) {
        this.yPos = yPos;
    }
    /**
     * @return the speed
     */
    public Integer getSpeed() {
        return speed;
    }
    /**
     * @return the distance
     */
    public Integer getDistance() {
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

}
