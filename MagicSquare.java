import java.util.*;
import java.io.*;

public class MagicSquare {

	//Return true if the square is a multiplicative magic square as defined above, false otherwise
	//Throw an IllegalArgumentException if the square does not have the same number of rows and columns

	public static boolean isMagicSquare(int[][] square) {
		try {
			int collumns = square.length;
			int rows = square[0].length;
			int[] collumnProduct = new int[collumns];
			int[] rowProduct = new int[rows];
			boolean rowEquals = true;
			boolean collumnEquals = true;
			boolean rowLength = true;
			boolean collumnLength = true;

			for (int y = 0; y < collumns; y++) {
				collumnProduct[y] = 1;
			
			}

			for (int z = 0; z < rows; z++) {
				rowProduct[z] = 1;
			
			}	
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < collumns; j++) {
					rowProduct[i] *= square[i][j];
					collumnProduct[j] *= square[i][j];
				}
			}

			for (int b = 0; b < collumns; b++) {
				if (collumnProduct[0] != collumnProduct[b]) {
					collumnEquals = false;
				}
			}

			for (int a = 0; a < rows; a++) {
				if (rowProduct[0] != rowProduct[a]) {
					rowEquals = false;
				}
			}		

			for (int c = 0; c < rows; c++) {
				if (collumns != square[c].length ) {
					collumnLength = false;
				}
			}

			if (rows != square.length) {
				rowLength = false;

			}	

			if (rowLength == false || collumnLength == false) {
				throw new IllegalArgumentException("not a square");
			} else if (collumnEquals == true && rowEquals == true) {
				return true;
			} else {
				return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException("not a square");
		}
	} 

	public static void main(String[] args) {
		try{
			String fileName = args[0];
			File filename = new File(fileName);
			Scanner lineCount = new Scanner(filename);
			String line2 = "";
			int lines = 0;
			do {
				if (lines == 1) {
					lines++;
					line2 = lineCount.nextLine();
				} else {
					lines++;
					lineCount.nextLine();
				}
			} while (lineCount.hasNextLine());

			int collumns = 0;
			Scanner collumnCount = new Scanner(line2);
			do {
				collumns++;
				collumnCount.next();
			} while (collumnCount.hasNext());

			Scanner lineScan = new Scanner(filename);
			String size = lineScan.nextLine();
					
		
			int[][] square = new int[lines - 1] [collumns];
			for (int i = 0; i < lines - 1; i++) {
				String line = lineScan.nextLine();
				Scanner cellScan = new Scanner(line);
				for (int j = 0; j < collumns; j++) {
					int cell = cellScan.nextInt();
					square[i][j] = cell; 
				}
			}

			if (isMagicSquare(square) == true) {
				System.out.println("Magic Square: true");
			} else if (isMagicSquare(square) == false) {
				System.out.println("Magic Square: false");
			} else {
				System.out.println("Bad Code");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist. Check file name and rerun the program");
		}
	}
}			
