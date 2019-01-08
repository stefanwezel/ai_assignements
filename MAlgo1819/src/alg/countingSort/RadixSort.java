package alg.countingSort;

public class RadixSort implements SortableSortingAlgorithm {

	@Override
	public String getName() {
		return "RadixSort";
	}

	
	@Override
	public Sortable[] sort(Sortable[] array) {
		if(array == null) {
			return null;
		}
		if(array.length <= 0) {
			return new Sortable[]{};
		}
		if(array.length <= 1) {
			return new Sortable[]{array[0]};
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
		
		
//		int range	= max.getKey() - min.getKey() + 1;
//		int rLog	= (int) Math.log10(range);
//		
//		if(array.length > (range + 1 - 10 * (rLog + 1)) / (10 * rLog)) {
//			// counting sort will be better in this case
//			System.out.println("Trying counting sort, which is supposedly better.");
//			try {
//				return new CountingSort().sort(array, min.getKey(), max.getKey());
//			} catch(OutOfMemoryError e) {
//				System.out.println("Range to big for counting sort, go on with radix sort.");
//			}
//		}
		
		return radixSort(array, (int) (Math.log10(max.getKey())) + 1);
	}
	
	
	private Sortable[] radixSort(Sortable[] array, int nrDigits) {
		Digits[] digits = new Digits[array.length];
		for(int i=0; i<array.length; i++) {
			digits[i] = new Digits(array[i], nrDigits);
		}
		for(int i=0; i<nrDigits; i++) {
			digits = countingSort(digits, i);
		}
		Sortable[] result = new Sortable[array.length];
		for(int i=0; i<array.length; i++) {
			result[i] = digits[i].getSortable();
		}
		return result;
	}
	
	
	private Digits[] countingSort(Digits[] array, int pos) {
		Digits[]	result	= new Digits[array.length];
		int[]		counter	= new int[10];
		
		// count elements
		for(int i=0; i<array.length; i++) {
			counter[array[i].getDigit(pos)]++;
		}

		// calculate number of elements less than or equal to i
		for(int i=1; i<10; i++) {
			counter[i] = counter[i] + counter[i-1];
		}

		// order elements
		for(int i=array.length-1; i>=0; i--) {
			int digit = array[i].getDigit(pos);
			result[counter[digit]-1] = array[i];
			counter[digit]--;
		}
		
		return result;
	}
	
	
	private class Digits {
		
		private Sortable 	sortable;
		private int[]		digits;
		
		public Digits(Sortable sortable, int len) {
			this.sortable 	= sortable;
			this.digits		= new int[len];
			int key			= sortable.getKey();
			for(int i=0; i<len; i++) {
				digits[i] 	= key % 10;
				key			= (int) (key / 10);  
			}
		}
		
		public int getDigit(int pos) {
			return digits[pos];
		}
		
		public Sortable getSortable() {
			return sortable;
		}
	}
}
