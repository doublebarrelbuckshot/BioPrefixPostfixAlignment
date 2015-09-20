
public class Analyzer {

	public static Grid runAnalysis(Grid grid) 
	{

		int columns = grid.getColumnLength();
		int rows = grid.getRowLength();
		System.out.println("Columns " + columns + ".... Rows " + rows);
		
		for(int i = 1; i<rows; i++)
		{
			for(int j = 1; j<columns; j++)
			{
				int left = grid.getCellValue(i, j - 1);
				int top = grid.getCellValue(i-1, j);
				int diagonal = grid.getCellValue(i - 1, j - 1);
				
				int fromLeft = left + ParameterConfigs.indel;
				int fromTop = top + ParameterConfigs.indel;
				
				int fromDiagonal = diagonal;
				boolean matchFound = grid.doStringCharsMatch(i - 1, j - 1);
				if(matchFound)
				{
					fromDiagonal += ParameterConfigs.match;
				}
				else
					fromDiagonal += ParameterConfigs.mismatch;
				
				int bestCase = Analyzer.max(fromLeft, fromTop, fromDiagonal);
				
				if(bestCase == fromLeft)
				{
					grid.setCellDirection(i, j, Direction.LEFT);
					grid.setCellValue(i, j, fromLeft);
					(grid.getCell(i, j)).setS1Char(String.valueOf(grid.s1.charAt(j-1)));
					(grid.getCell(i, j)).setS2Char("_");

				}
				if(bestCase == fromTop)
				{
					grid.setCellDirection(i, j, Direction.TOP);
					grid.setCellValue(i, j, fromTop);
					(grid.getCell(i, j)).setS1Char("_");
					(grid.getCell(i, j)).setS2Char(String.valueOf(grid.s2.charAt(i-1)));

				}
				if(bestCase == fromDiagonal)
				{
					grid.setCellDirection(i, j, Direction.DIAGONAL);
					grid.setCellValue(i, j, fromDiagonal);
					(grid.getCell(i, j)).setS1Char(String.valueOf(grid.s1.charAt(j-1)));
					(grid.getCell(i, j)).setS2Char(String.valueOf(grid.s2.charAt(i-1)));

				}							
			}
		}
		return grid;
	}

	public static void retraceGrid(Grid grid, int i, int j, String seq1, String seq2)
	{
		CellValue start = grid.getCell(i, j);
		Direction dir = start.getDirection();

		if(dir!= Direction.NONE){
			seq1 = /*seq1 +*/ start.getS1Char() + seq1;
			seq2 = /*seq2 +*/ start.getS2Char() + seq2;
		}
		

		switch(dir)
		{
			case TOP:
				retraceGrid(grid, i-1, j, seq1, seq2);
				break;
			case LEFT:
				retraceGrid(grid, i, j-1, seq1, seq2);
				break;
			case DIAGONAL:
				retraceGrid(grid, i-1, j-1, seq1, seq2);
				break;
			default:
				System.out.println(seq1 + "\n" + seq2);
				break;
		}
		
	}
	
	public static int max(int i1, int i2, int i3)
	{
		return Math.max(i1, Math.max(i2, i3));
	}

	public static int findMaxInJ(Grid grid, int j) {
		int maxVal = 0;
		int maxI = grid.getCellValue(0, j);
		
		for(int i = 1; i< grid.getRowLength(); i++)
		{
			if(grid.getCellValue(i, j) > maxVal)
			{
				maxVal = grid.getCellValue(i, j);
				maxI = i;

			}
		}
		return maxI;

		
	}
}
