
public interface CS232Queue<T> {

	/**
	 * Interface specifying a Queue ADT
	 * 
	 * @author William Goble
	 * @author Dickinson College
	 * @version Feb 8, 2024
	 */

	/**
	 * Add the provided Object to the end of the Queue.
	 * 
	 * @param obj 
	 *              the Object to add
	 */
	public void add(T obj);

	/**
	 * Remove and return the Object at the head of the Queue.
	 * 
	 * @return 
	 *          the Object at the head of the Queue or null
	 *          if the Queue is empty.
	 */
	public T remove();

	/**
	 * Return a reference to the Object at the head of the Queue without 
	 * removing it from the Queue.
	 * 
	 * @return 
	 *          a reference to the Object at the head of the Queue or
	 *          null if the Queue is empty.
	 */
	public T peek();

	/**
	 * Return the number of elements in the Queue.
	 * 
	 * @return 
	 *          the size of the Queue.
	 */
	public int size();
}
}
