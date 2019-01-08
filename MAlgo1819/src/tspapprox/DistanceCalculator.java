package tspapprox;

import java.text.DecimalFormat;

public class DistanceCalculator {

	public static final int X_INDEX = 0; // positions[X_INDEX] is the x-position of a city
	public static final int Y_INDEX = 1; // positions[Y_INDEX] is the y-position of a city


	/**
	 * Returns the euclidean distances between the given positions.
	 * @param positions A matrix of the size n x 2 
	 * @return symmetric distance matrix
	 */
	public static double[][] getDistanceMatrix(double[][] positions) {
		int pos_size = positions.length;
		double[][] result = new double[pos_size][pos_size];

		for (int i = 0; i < positions.length; i++) {
			
			for (int j = 0; j < positions.length; j++) {
				double euclidean_distance = 0;

				for (int k = 0; k < positions[i].length; k++) {
					euclidean_distance += Math.pow(positions[i][k]-positions[j][k],2);
					
				}
				euclidean_distance = Math.sqrt(euclidean_distance);
				result[i][j] = euclidean_distance;
			}
		}



		return result;
	}



	// TODO: Space for extra methods, if needed





	public static void main(String[] args) {
		double[][] posTest = {
				{0,0},
				{3,0},
				{0,4}
		};
		double[][] distancesTest = getDistanceMatrix(posTest);
		printMatrix(distancesTest);

		// This test should print the following matrix:
		//   0  3  4
		//   3  0  5
		//   4  5  0


		double[][] posExercise = {
				{3,18},	
				{8,18},	
				{15,17},	
				{6,14},	
				{11,14},	
				{18,13},	
				{2,11},	
				{14,10},	
				{4,5},	
				{17,3},	
				{8,2},	
				{1,1},	
		};
		double[][] distancesExercise = getDistanceMatrix(posExercise);
		printMatrix(distancesExercise);
	}



	public static void printMatrix(double[][] matrix) {
		DecimalFormat df = new DecimalFormat("#.#");
		String str = "";
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix.length; j++) {
				str += df.format(matrix[i][j]) + "\t";
			}
			str += "\n";
		}
		System.out.println(str);
	}

}
