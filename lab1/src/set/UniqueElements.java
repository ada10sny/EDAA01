package set;

public class UniqueElements {
	
	/**
	 * Finds duplicates in an array and removes them. Returns the result.
	 * @param 	ints the array you want to search in.
	 * @return	the array without duplicates
	 */
	public static int[] uniqueElements(int[] ints){
		MaxSet<Integer> intSet = new MaxSet<Integer>();
		int[] res;
		for (int i : ints){
			intSet.add(new Integer(i));
		}
		res = new int[intSet.size()];
		for (int i = intSet.size(); i > 0; i--){
			res[i-1] = intSet.getMax().intValue();
			intSet.remove(intSet.getMax());
		}
		return res;
	}
}
