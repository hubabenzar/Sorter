import java.util.*;
import java.io.*;

class A2Graph {

	private static final int MaxVertex = 100;
	private static final int MinVertex = 1;
	private static Scanner keyboardInput = new Scanner (System.in);
	// adjacency matrix, adjMatrix[i][j] = 1 means i and j are adjacent, 0 otherwise
	public static int[][] adjMatrix = new int[MaxVertex][MaxVertex];
	public static int numVertex; // total number of vertices

	// DO NOT change the main method
	public static void main(String[] args) throws Exception {
		boolean userContinue=true;
		int distance=1;
		int[][] neighbourMatrix = new int[MaxVertex][MaxVertex];
		
		input();

		try {
//			System.out.print("Enter a distance (" + MinVertex + "--" + numVertex + ", -1 to exit): ");
			distance = keyboardInput.nextInt();
		}
		catch (Exception e) {
			keyboardInput.next();
		}
		if (distance < MinVertex || distance > numVertex)
			System.out.println("incorrect range");
		else { 
			neighbourhood(distance, neighbourMatrix, numVertex);
			printSquareArray(neighbourMatrix, numVertex);
		}
		
		degreeSeparation();
	}

	// find the degree of separation of the graph using the method neightbourhood()
	static void degreeSeparation() {

	}

	// input parameter: an integer distance
	// output: compute neighbourhood matrix for distance 
	static void neighbourhood(int distance, int result[][], int size) {

	}

	// DO NOT change this method
	static void printSquareArray(int array[][], int size) {
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	
	// DO NOT change this method
	static void input() {
		int i, j;
		boolean success = false;

		try {
			success = true;
//			System.out.print("How many vertices (" + MinVertex + "--" + MaxVertex + ")? ");
			numVertex = keyboardInput.nextInt();
			if (numVertex > MaxVertex || numVertex < MinVertex) {
				success = false;
			}
			if (success) {
//				System.out.println("Enter adjacency matrix: ");
				for (i=0; i<numVertex; i++)
					for (j=0; j<numVertex; j++)
						adjMatrix[i][j] = keyboardInput.nextInt();
				for (i=0; i<numVertex && success; i++) {
					if (adjMatrix[i][i] != 0)
						success = false;
					for (j=0; j<numVertex; j++) {
						if (adjMatrix[i][j] != adjMatrix[j][i])
							success = false;
					}
				}
			}
			if (!success) {
				System.out.print("Incorrect range ");
				System.out.print("or adjacency matrix not symmetric ");
				System.out.println("or vertex connected to itself");
				System.exit(0);
			}
		}
		catch (Exception e) {
			keyboardInput.next();
		}
	}

}
