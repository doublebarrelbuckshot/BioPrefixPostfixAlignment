
public class Main {

	public static void main(String[] args)
	{
		//Grid grid = new Grid("GTCAGTTT", "GTATCAT");
		//Grid grid = new Grid("AGTGTGACGTGAATAGTGTACGCAT", "GTATACGCATTGCCTACGG");
//		Grid grid = new Grid("GTATACGCATTGCCTACGG", "AGTGTGACGTGAATAGTGTACGCAT");

		String chain1 = "CTCAAGCGCATCGGGGAC";
		String chain2 = "AAGCGCATCGGGGACGAA";
		
		Grid grid = new Grid(chain1, chain2);

		/*
		 * GAGTGTCTCAAGCGCATA
		 * AAGCGCATCGGGGACGAA
		 * TCCGGGACGAACTGGACA
		 * CTCAAGCGCATCGGGGAC
		 */
		Analyzer.runAnalysis(grid);
		//System.out.println(grid.printGrid());
		int maxI = Analyzer.findMaxInJ(grid, grid.getColumnLength() -1);
		
		Grid gridInverse = new Grid(chain2, chain1);
		Analyzer.runAnalysis(gridInverse);
		int maxIChain2 = Analyzer.findMaxInJ(gridInverse, gridInverse.getColumnLength() -1);

		Grid chosen = null;
		int maxChosen = -1;
		
		if(maxI > maxIChain2)
		{
			System.out.println("A then B");
			chosen = grid;
			maxChosen = maxI;
		}
		else
		{
			System.out.println("B then A");
			chosen = gridInverse;
			maxChosen = maxIChain2;
		}
		
		System.out.println(chosen.printGrid());

		String str1 = "";
		String str2 = "";
		for(int i = 0; i<=chosen.s2.length() - 1 - maxChosen; i++)
		{
			str1 =  (chosen.s1).charAt(i) + str1;
			str2 = str2 + " ";
		}
		
		System.out.println(str1);
		System.out.println(str2);
		Analyzer.retraceGrid(chosen, maxChosen, chosen.getColumnLength() -1, str1, str2);
		System.out.println(maxChosen + ", " + (chosen.getColumnLength() - 1));
		//Analyzer.retraceGrid(grid, 7, 8, "", "");
	}
	
	
}
