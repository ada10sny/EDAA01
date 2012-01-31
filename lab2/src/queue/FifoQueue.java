package queue;

import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		last = null;
	}

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Inserts the specified element into this queue, if possible post: The
	 * specified element is added to the rear of this queue
	 * 
	 * @param x
	 *            the element to insert
	 * @return true if it was possible to add the element to this queue, else
	 *         false
	 */
	public boolean offer(E x) {
		if (size == 0) {
			last = new QueueNode<E>(x);
			last.next = last;
		} else {
			QueueNode<E> firstNode = last.next;
			last.next = new QueueNode<E>(x);
			last.next.next = firstNode;
		}
		size++;
		return true;
	}

	/**
	 * Retrieves and removes the head of this queue, or null if this queue is
	 * empty. post: the head of the queue is removed if it was not empty
	 * 
	 * @return the head of this queue, or null if the queue is empty
	 */
	public E poll() {
		QueueNode<E> curLast = last;
		if (size == 1) {
			last = null;
			size--;
		} else if (size > 1) {
			for (int i = 1; i < size; i++) {
				last = last.next;
			}
			last.next = curLast.next;
			size--;
		}
		return (curLast == null) ? null : curLast.element;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, returning null if
	 * this queue is empty
	 * 
	 * @return the head element of this queue, or null if this queue is empty
	 */
	public E peek() {
		return (size == 0) ? null : last.element;
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

	/**
	 * Returns an iterator over the elements in this queue
	 * 
	 * @return an iterator over the elements in this queue
	 */
	public Iterator<E> iterator() {
		return new QueueIterator();
	}
	
	/* Om pos skall vara början på QueueList */
	private class QueueIterator implements Iterator<E>{
		private QueueNode<E> pos;
		private boolean iterating;
		
		/* Konstruktor */
		private QueueIterator() {
			pos = last.next;
			iterating = false;
		}
		
		/** Returns true if the iteration has more elements. (In other words, 
		 * returns true if next would return an element rather than throwing an exception.)
		 * @return true if the iterator has more elements.
		 */
		public boolean hasNext() {
			return !(pos == last.next && iterating);
		}
		
		/** Returns the next element in the iteration.
		 * @return the next element in the iteration
		 * @throws NoSuchElementException - iteration has no more elements.
		 */
		public E next() {
			if(pos == last.next && iterating){
				throw new NoSuchElementException();
			}
			iterating = true;
			QueueNode<E> res = pos;
			pos = pos.next;
			return res.element;
		}
		
		/** @throws UnsupportedOperationException - this operation is 
		 * not supported by this operator
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	
//	/* Om pos skall vara slutet på QueueList (last): 
//	 * och gå baklänges*/
//	private class QueueIterator implements Iterator<E>{
//		private QueueNode<E> pos;
//		private boolean iterating;
//		
//		/* Konstruktor */
//		private QueueIterator() {
//			pos = last;
//			iterating = false;
//		}
//		
//		/** Returns true if the iteration has more elements. (In other words, 
//		 * returns true if next would return an element rather than throwing an exception.)
//		 * @return true if the iterator has more elements.
//		 */
//		public boolean hasNext() {
//			return !(pos == last && iterating);
//		}
//		
//		/** Returns the next element in the iteration.
//		 * @return the next element in the iteration
//		 * @throws NoSuchElementException - iteration has no more elements.
//		 */
//		public E next() {
//			if(pos == last.next && iterating){
//				throw new NoSuchElementException();
//			}
//			iterating = true;
//			QueueNode<E> res = pos;
//			for(int i = 1; i < size; i++){
//				pos = pos.next;
//			}
//			return res.element;
//		}
//		
//		/** @throws UnsupportedOperationException - this operation is 
//		 * not supported by this operator
//		 */
//		public void remove() {
//			throw new UnsupportedOperationException();
//		}
//	}
}
