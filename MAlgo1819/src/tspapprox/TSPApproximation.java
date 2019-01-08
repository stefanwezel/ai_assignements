package tspapprox;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TSPApproximation {

	/**
	 * Calculates and returns a tour thorough all cities.
	 * @param distances the distances between the cities
	 * @return the tour
	 */
	public static List<Vertex> getTour(double[][] distances) {
		double[][] mst = MST_Prim(distances);
		List<Vertex> result = pre_order_walk(mst);
		result.add(new Vertex(0));
		return result;
	}

	public static double[][] MST_Prim(double[][] distances){
		double[][] result = new double[distances.length][distances.length];

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				result[i][j] = -1;

			}
		}

		int[] finished_nodes = new int[distances.length];
		for (int i = 0; i < finished_nodes.length; i++) {
			finished_nodes[i] = -1;
		}
		finished_nodes[0] = 0;
		int finished_nodes_index = 1;
		while(finished_nodes[finished_nodes.length-1] == -1) {
			double min = Double.MAX_VALUE;
			int index_from = -1;
			int index_to = -1;
			for (int i = 0; i < finished_nodes.length; i++) {
				if(finished_nodes[i] != -1) {

					for (int j = 0; j < distances[finished_nodes[i]].length; j++) {
						double potencial_min = distances[finished_nodes[i]][j];
						if(potencial_min < min && i != j && !x_in_array(j, finished_nodes)) {
							min = potencial_min;
							index_from = finished_nodes[i];
							index_to = j;
						}
					}
				}
			}
			result[index_from][index_to] = min;
			//result[index_to][index_from] = min;
			finished_nodes[finished_nodes_index] = index_to;
			
			finished_nodes_index++;
		}

		return result;
	}

	public static boolean x_in_array(int x, int[] array) {

		for (int i = 0; i < array.length; i++) {
			if(x == array[i])
				return true;
		}
		return false;
	}
	
	public static List<Vertex> pre_order_walk(double[][] mst){
		Stack<Integer> stack = new Stack<Integer>();
		List<Vertex> result = new ArrayList<Vertex>();
		stack.push(0);
		result.add(new Vertex(0));
		while(result.size() < mst.length) {
			int first_element = stack.lastElement();
			//System.out.println(first_element);
			int current_element = -1;
			int next_element = -1;
			for(int i = 0; i < mst[first_element].length; i++) {
				if(mst[first_element][i] != -1) {
					stack.push(i);
					//System.out.println(i);
					if(!result.contains(new Vertex(i)))
						result.add(new Vertex(i));
					current_element = next_element;
					next_element = i;
					mst[first_element][i] = -1;
					break;
				}
			}
			//System.out.println(current_element + " " + next_element);
			if(current_element == next_element) {
				stack.pop();
			}
		}
		
		return result;
	}

	// TODO: Space for extra methods, if needed







	public static void main(String[] args) {
		double[][] pos1 = {
				{0,0},
				{3,0},
				{0,4}
		};
		double[][]   dist1 = DistanceCalculator.getDistanceMatrix(pos1);
		DistanceCalculator.printMatrix(dist1);
		List<Vertex> tour1 = getTour(dist1);
		printTour(dist1, tour1);
		double[][] mst1 = MST_Prim(dist1);
		DistanceCalculator.printMatrix(mst1);
		// This test should print the following tour:
		//   0 3 4 0
		// with length 12

		// positions from exercise
		double[][] pos2 = {
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
		double[][]   dist2 = DistanceCalculator.getDistanceMatrix(pos2);
		double[][] mst2 = MST_Prim(dist2);
		DistanceCalculator.printMatrix(dist2);
		DistanceCalculator.printMatrix(mst2);
		List<Vertex> tour2 = getTour(dist2);
		printTour(dist2, tour2);
	}



	private static void printTour(double[][] distanceMatrix, List<Vertex> tour) {
		DecimalFormat df = new DecimalFormat("#.#");

		double tourLength = 0.0;
		String str = "";
		for (int i=0; i<tour.size(); i++) {
			Vertex v = tour.get(i);
			if (i < tour.size()-1) {

				// TODO: Space for extra methods, if needed

				str += (v.getId() + 1) + "~";
				Vertex next = tour.get(i+1);
				tourLength += distanceMatrix[v.getId()][next.getId()];
			}
			else {
				str += (v.getId() + 1);
				Vertex next = tour.get(0);
				tourLength += distanceMatrix[v.getId()][next.getId()];
			}
		}

		str += "\nTOUR LENGTH: " + df.format(tourLength) + "\n";
		System.out.println(str);
	}

}
