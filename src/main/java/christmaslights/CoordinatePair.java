package christmaslights;

public class CoordinatePair {
	
	int leftTopX;
	int leftTopY;
	int rightBottomX;
	int rightBottomY;
	
	public static CoordinatePair of(int leftTopX, int leftTopY, int rightBottomX, int rightBottomY) {
		return new CoordinatePair(leftTopX, leftTopY, rightBottomX, rightBottomY);
	}
	
	public CoordinatePair(int leftTopX, int leftTopY, int rightBottomX, int rightBottomY) {
		this.leftTopX = leftTopX;
		this.leftTopY = leftTopY;
		this.rightBottomX = rightBottomX;
		this.rightBottomY = rightBottomY;
	}

	/**
	 * @return the leftTopX
	 */
	public int getLeftTopX() {
		return leftTopX;
	}

	/**
	 * @param leftTopX the leftTopX to set
	 */
	public void setLeftTopX(int leftTopX) {
		this.leftTopX = leftTopX;
	}

	/**
	 * @return the leftTopY
	 */
	public int getLeftTopY() {
		return leftTopY;
	}

	/**
	 * @param leftTopY the leftTopY to set
	 */
	public void setLeftTopY(int leftTopY) {
		this.leftTopY = leftTopY;
	}

	/**
	 * @return the rightBottomX
	 */
	public int getRightBottomX() {
		return rightBottomX;
	}

	/**
	 * @param rightBottomX the rightBottomX to set
	 */
	public void setRightBottomX(int rightBottomX) {
		this.rightBottomX = rightBottomX;
	}

	/**
	 * @return the rightBottomY
	 */
	public int getRightBottomY() {
		return rightBottomY;
	}

	/**
	 * @param rightBottomY the rightBottomY to set
	 */
	public void setRightBottomY(int rightBottomY) {
		this.rightBottomY = rightBottomY;
	}
	
	
	
}
