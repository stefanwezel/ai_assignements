package alg.countingSort;

public class CountingSort implements SortableSortingAlgorithm {

	@Override
	public String getName() {
		return "CountingSort";
	}
	
	
	/**
	 * Sorts an array.
	 * @param array
	 * @param min minimal element in this array
	 * @param max maximal element in this array
	 * @return a sorted array
	 */
	public Sortable[] sort(final Sortable[] array, int min, int max) throws OutOfMemoryError {
		if(array == null) {
			return null;
		}
		int		range	= max - min + 1;
		if(range <= 0) {
			throw new IllegalArgumentException();
		}
		
		Sortable[]	result	= new Sortable[array.length];
		int[]		counter	= new int[range];
		
		try {
			// count elements
			for(int i=0; i<array.length; i++) {
				counter[array[i].getKey()-min]++;
			}

			// calculate number of elements less than or equal to min + i
			for(int i=1; i<range; i++) {
				counter[i] = counter[i] + counter[i-1];
			}

			// order elements
			for(int i=array.length-1; i>=0; i--) {
				if(counter[array[i].getKey()-min]-1 < 0) {
					System.out.println("problem");
				}
				result[counter[array[i].getKey()-min]-1] = array[i];
				counter[array[i].getKey()-min]--;
			}
		} catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
			throw new IllegalArgumentException();
		}
		
		return result;
	}
	
	@Override
	public Sortable[] sort(Sortable[] array) throws OutOfMemoryError {
		if(array == null) {
			return null;
		}
		if(array.length <= 0) {
			return new Sortable[]{};
		}

		Sortable 	min 	= array[0];
		Sortable 	max 	= array[0];
		int 		start	= 1;
		if(array.length % 2 == 0) {
			// even length
			if(array[1].compare(array[0]) >= 0) {
				max = array[1];
			}
			else {
				min = array[0];
			}
			start	= 2;
		}
		
		for(int i=start; i<array.length; i=i+2) {
			// compare two successive array elements
			if(array[i].compare(array[i+1]) < 0) {
				min = array[i].compare(min) < 0 ? array[i] : min;
				max = array[i+1].compare(max) > 0 ? array[i+1] : max;
			}
			else {
				min = array[i+1].compare(min) < 0 ? array[i+1] : min;
				max = array[i].compare(max) > 0 ? array[i] : max;
			}
		}
		
		return sort(array, min.getKey(), max.getKey());
	}
	
}
