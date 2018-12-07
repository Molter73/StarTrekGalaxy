/**
 * 
 */
package starTrekGalaxy;

/**
 * @author moltrasm
 *
 */
public class Planet {
	static private final Integer speed = 1;        //  degrees / day
	static private final Integer distance = 500;   //  kms from the sun
	
	private Integer xPos;
    private Integer yPos;
    
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
    public static Integer getSpeed() {
        return speed;
    }
    /**
     * @return the distance
     */
    public static Integer getDistance() {
        return distance;
    }
}
