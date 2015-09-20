
public class CellValue {

	private int value = 0;
	private Direction direction = Direction.NONE;
	private String s1Char;
	private String s2Char;
	
	public CellValue()
	{
		value = 0;
		direction = Direction.NONE;
	}

	public int getValue() {
		return value;
	}
	

	public void setValue(int value) {
		this.value = value;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public String getS1Char() {
		return s1Char;
	}

	public void setS1Char(String s1Char) {
		this.s1Char = s1Char;
	}

	public String getS2Char() {
		return s2Char;
	}

	public void setS2Char(String s2Char) {
		this.s2Char = s2Char;
	}
	
	

}



