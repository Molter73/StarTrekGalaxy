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
}
