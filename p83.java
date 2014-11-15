import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class p83 {

	private static final int infin = Integer.MAX_VALUE / 2; 
	private static int[][] minPath;

	public static void main(String[] args) throws FileNotFoundException {

		//This is for problem 83 
		File file = new File("matrix.txt");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(file);

		int row = 80; 
		int col = 80;
		int size = row*col; 
		int i = 0;

		//Final Matrix
		int[][] Matrix = new int[row][col]; 
		//temp arry for getting the numbers in text file
		Integer[] temp = new Integer[size];

		minPath = new int[row][col];

		//putting the numbers from text file into array
		while(input.hasNext())
		{	

			temp[i] = input.nextInt();
			i++;

		}


		int a = 0;

		//putting the numbers from array into Matrix
		for(int b = 0; b < row; b++)
		{
			for(int c = 0; c < col; c++)
			{
				Matrix[b][c] = temp[a];
				a++;
			}
		}

		//printing to see if itw works. 
		for(int b = 0; b < row; b++)
		{
			for(int c = 0; c < col; c++)
			{
				System.out.print(Matrix[b][c] + " ");

			}
			System.out.println("");
		}

		//computing the minPath
		for(int f = 0; f < row; f++)
		{
			Arrays.fill(minPath[f], infin);
		}

		//used Bellman-Ford Algorithm, I got a reference from wiki and applied it to what I was using
		minPath[0][0] = Matrix[0][0]; 

		for(int w = 0; w < size; w++)
		{
			for(int y = 0; y < row; y++)
			{
				for(int x = 0; x < col; x++)
				{
					int holder = infin; 
					holder = Math.min(getMinDist(x - 1, y), holder);
					holder = Math.min(getMinDist(x + 1, y), holder);
					holder = Math.min(getMinDist(x, y - 1), holder);
					holder = Math.min(getMinDist(x, y + 1), holder);
					minPath[y][x] = Math.min(Matrix[y][x] + holder, minPath[y][x]);
				}
			}
		}

		System.out.println("I should be minPath: " + Integer.toString(minPath[row -1][col -1]));
	}

	private static int getMinDist(int i, int y) {
		// TODO Auto-generated method stub
		if(y < 0 || y >= minPath.length || i < 0 || i >= minPath[y].length)
		{
			return infin;
		}
		else 
			return minPath[y][i];
	}

}
