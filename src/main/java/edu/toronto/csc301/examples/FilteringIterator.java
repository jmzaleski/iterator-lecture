package edu.toronto.csc301.examples;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class FilteringIterator<T> implements Iterator<T> {

	private final Iterator<T> selectedIterator;
	
	
	/**
	 * Create a new iterator that will have (at most) <code>limit</code>
	 * random items from <code>underlyingIterator</code>.
	 * 
	 * If the underlyingIterator has (at least) <code>limit</code>, then
	 * this iterator will have exactly <code>limit</code> items.
	 * 
	 * NOTE: The underlyingIterator will be consumed entirely when creating this instance.
	 *  
	 * @param underlyingIterator
	 * @param limit
	 */
	public FilteringIterator(Iterator<T> underlyingIterator, int limit) {

		// Go through the items of the underlyingIterator and select a "random" set of items.
		// - The algorithm uses O(limit) space
		// - The idea is:
		//     * Start by selecting the first limit items from the underlying iterator.
		//     * Continue by repeatedly getting the next item from the underlying iterator.
		//       * Whenever we get a next item, decide (probabilistically) whether or 
		//         not it will be selected.
		//       * If we decide to select it, remove one of the currently selected items 
		//         (chosen randomly).
		
		
		Random rand = new Random();
		
		// Initialize the list of selected items
		List<T> selected = getFirstItems(underlyingIterator, limit);
		// Estimate of the total number of items in underlyingIterator
		int n = selected.size();     
		
		while(underlyingIterator.hasNext()){
			T candidate = underlyingIterator.next();
			n++; // Update our estimate
			
			if (rand.nextDouble() < ((limit + 0.0)/n) ){
				selected.remove(rand.nextInt(selected.size()));
				selected.add(candidate);
			}
		}
		
		Collections.shuffle(selected);
		this.selectedIterator = selected.iterator();
	}
	
	
	

	@Override
	public boolean hasNext() {
		return selectedIterator.hasNext();
	}

	@Override
	public T next() {
		return selectedIterator.next();
	}

	
	
	/**
	 * Helper method.
	 * @return The first <code>limit</code> items of <code>iterator</code> as a list.
	 */
	private List<T> getFirstItems(Iterator<T> iterator, int limit){
		List<T> result = new LinkedList<T>();
		while(result.size() < limit && iterator.hasNext()){
			result.add(iterator.next());
		}
		return result;
	}
}
