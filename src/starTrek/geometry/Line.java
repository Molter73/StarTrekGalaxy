/**
 * A simple class, meant to hold the necessary values 
 * to define a straight line in a 2 dimensional space
 */
package starTrek.geometry;

/**
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
	 * @param gradient
	 * @param intercept
	 */
	public Line(Double gradient, Double intercept) {
		super();
		this.slope = gradient;
		this.intercept = intercept;
	}
	/**
	 * Calculates and sets the gradient and intercept of this line
	 * based on two dots in the plain
	 * @param x1 the first dot's x position
	 * @param y1 the first dot's y position
	 * @param x2 the second dot's x position
	 * @param y2 the second dot's y position
	 */
	public Line(Double x1, Double y1, Double x2, Double y2) {
		super();
		try {
			this.slope = (y1-y2) / (x1-x2);
		} catch (ArithmeticException e) {
			throw e;
		}
		this.intercept = y1 - (x1 * this.slope);
	}
	/**
	 * @return the gradient
	 */
	public Double getSlope() {
		return slope;
	}
	/**
	 * @param gradient the gradient to set
	 */
	public void setSlope(Double gradient) {
		this.slope = gradient;
	}
	/**
	 * @return the intercept
	 */
	public Double getIntercept() {
		return intercept;
	}
	/**
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
	 * @param xPos the position of the point along the x axis
	 * @param yPos the position of the point along the y axis
	 */
	public boolean containsPoint(Double xPos, Double yPos) {
		return false;
	}
}
