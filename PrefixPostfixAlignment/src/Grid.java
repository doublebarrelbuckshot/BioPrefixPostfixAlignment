
public class Grid {
	public static CellValue[][] grid;
	public String s1;
	public String s2;
	public int gridI;
	public int gridJ;
	
	
	public Grid(String s1, String s2)
	{
		//int count = 0;
		this.s1 = s1;
		this.s2 = s2;
		this.gridI = s2.length() + 1;
		this.gridJ = s1.length() + 1;
		/*
		 *     ____________S1___________
		 *    |_________________________
		 * S2 |_________________________
		 *    |_________________________
		 */
		
		grid = new CellValue[gridI][gridJ];
	
		for(int i = 0; i<gridI; i++)
		{
			for(int j=0; j<gridJ; j++)
			{
				grid[i][j] = new CellValue();
				if(j == 0)
				{
					grid[i][j].setValue( i * ParameterConfigs.indel);
				}

				//grid[i][j].setValue(count);
				//count++;
			}			
		}	
	}

	public int getColumnLength()
	{
		if(grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1)
			throw new IllegalArgumentException("Invalid Grid");
		return grid[0].length;
	}
	
	public int getRowLength()
	{
		if(grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1)
			throw new IllegalArgumentException("Invalid Grid");
		return grid.length;
	}

	public String printGrid()
	{
		String result = "";
		for(int i = 0; i<gridI; i++)
		{
			for(int j=0; j<gridJ; j++)
			{
				result += grid[i][j].getValue() + "  ";
			}
			result += "\n";
			
		}	
		return result;
	}

	public int getCellValue(int i, int j) {
		return grid[i][j].getValue();
	}

	public boolean doStringCharsMatch(int i, int j) {
		return s1.charAt(j) == s2.charAt(i);
	}

	public void setCellDirection(int i, int j, Direction direction) {
		grid[i][j].setDirection(direction);
		
	}

	public void setCellValue(int i, int j, int newValue) {
		 grid[i][j].setValue(newValue);
		
	}

	public CellValue getCell(int i, int j) {
		return grid[i][j];
	}
}
