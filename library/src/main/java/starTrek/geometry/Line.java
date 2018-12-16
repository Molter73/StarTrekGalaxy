
package starTrek.geometry;
/**
 * A simple class, meant to hold the necessary values 
 * to define a straight line in a 2 dimensional space
 *
 * @author Mauro Moltrasio
 *
 */
public class Line {
	private Double slope;
	private Double intercept;
	
	/**
	 * The default constructor generates a straight line along
	 * the X axis
	 */
	public Line() {
		super();
		slope = (double) 0;
		intercept = (double) 0;
	}
	/**
	 * Sets the lines parameters from the given arguments.
	 * 
	 * @param gradient the slope of this line
	 * @param intercept the value of y at which this line crosses the vertical axis
	 */
	public Line(Double gradient, Double intercept) {
		super();
		this.slope = gradient;
		this.intercept = intercept;
	}
	/**
	 * Calculates and sets the gradient and intercept of this line
	 * based on two dots in the plain.
	 * @param x1 the first dot's x position
	 * @param y1 the first dot's y position
	 * @param x2 the second dot's x position
	 * @param y2 the second dot's y position
	 */
	public Line(Double x1, Double y1, Double x2, Double y2) {
		super();
		this.slope = (y1-y2) / (x1-x2);
		
		/**
		 * if the slope is infinite, there wont be an intercept.
		 * Instead, I will save the x value for the vertical line,
		 */
		
		if (Double.isInfinite(this.slope))
			this.intercept = x1;
		else
			this.intercept = y1 - (x1 * this.slope);
	}
	/**
	 * Get this lines slope
	 * @return the slope
	 */
	public Double getSlope() {
		return slope;
	}
	/**
	 * Sets a new slope for this line
	 * @param slope the slope to be set
	 */
	public void setSlope(Double slope) {
		this.slope = slope;
	}
	/**
	 * Get the point at which this line crosses the y axis
	 * @return the intercept
	 */
	public Double getIntercept() {
		return intercept;
	}
	/**
	 * Sets the point at which this line crosses the y axis
	 * @param intercept the intercept to set
	 */
	public void setIntercept(Double intercept) {
		this.intercept = intercept;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((slope == null) ? 0 : slope.hashCode());
		result = prime * result + ((intercept == null) ? 0 : intercept.hashCode());
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
		Line other = (Line) obj;
		if (slope == null) {
			if (other.slope != null)
				return false;
		} else if (!slope.equals(other.slope))
			return false;
		if (intercept == null) {
			if (other.intercept != null)
				return false;
		} else if (!intercept.equals(other.intercept))
			return false;
		return true;
	}
	/**
	 * Checks whether a given point is inside this line
	 * <p>
	 * Before doing the actual check and taking into account the
	 * application for this class is in a planetary scale, where
	 * the integer value is in the order of thousands of kilometers,
	 * we will round position values to integers and drop the decimals. 
	 * Because of this, the alignment of planets wont be perfect, 
	 * but then again, planets are big and our model just assumes they are dots 
	 * so it will balance itself out.
	 * @param xPos the position of the point along the x axis
	 * @param yPos the position of the point along the y axis
	 * @return true if the point is within the line
	 */
	public boolean containsPoint(Double xPos, Double yPos) {
		if (Double.isInfinite(this.slope)) {
			if (this.intercept.intValue() == xPos.intValue()) {
				return true;
			}
			return false;
		} else {	// check to see if point is in this line
			Double calcY = (xPos * this.slope) + this.intercept;
			if(calcY.intValue() == yPos.intValue()) {
				return true;
			} 
			return false;
		}
	}
}
