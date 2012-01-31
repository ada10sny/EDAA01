package set;

import java.util.NoSuchElementException;
import java.util.Iterator;


public class MaxSet<E extends Comparable<E>> extends ArraySet<E> {
	private E maxElement;
	
	/**
	 * Constructs a new empty set.
	 */
	public MaxSet() {
		super();
	}
	
	/** Returns the currently largest element in this set. 
	pre: the set is not empty 
	post: the set is unchanged 
	@return the currently largest element in this set 
	@throws NoSuchElementException if this set is empty 
	*/ 
	public E getMax() {
		if(!isEmpty()){
			return maxElement;
		}
		else{
			throw new NoSuchElementException();
		}
	}
	
	/** 
	 * Adds the specified element to this set, if it is not already present.
	 * post: x is added to the set if it is not already present
	 * @param  x the element to be added
	 * @return true if the specified element was added
	 */
	public boolean add(E x) {
		if(isEmpty()){
			maxElement = x;
			return super.add(x);
		}
		else if(!super.contains(x)){
			if(maxElement.compareTo(x) < 0){
				maxElement = x;
			}
			return super.add(x);
		}
		return false;
	}
	
	/** 
	 * Removes the specified element from this set if it is present. 
	 * post: 	x is removed if it was present
	 * @param 	x the element to remove - if present
	 * @return true if the set contained the specified element
	 */
	public boolean remove(Object x) {
		if(maxElement.equals(x)){
			super.remove(x);
			updateMaxElement();
			return true;
		}
		return super.remove(x);
	}

	private void updateMaxElement() {
		if(isEmpty()){
			return;
		}
		Iterator<E> itr = iterator();
		maxElement = itr.next();
		while(itr.hasNext()){
			E tmp = itr.next();
			if(tmp.compareTo(maxElement) > 0){
				maxElement = tmp;
			}
		}
	}
	
}