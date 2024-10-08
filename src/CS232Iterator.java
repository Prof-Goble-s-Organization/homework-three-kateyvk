package hw03;

/**
 * Interface implemented by objects returned by ADTs that implement
 * CS232Iterable.
 * 
 * @author Grant Braught
 * @author Dickinson College
 * @version Feb 18, 2016
 */
public interface CS232Iterator<E> {

	/**
	 * Check if there is at least one more element that can be retrieved by a
	 * call to next.
	 * 
	 * @return true if next will return an element, false if not (i.e. will
	 *         throw an exception).
	 */
	public boolean hasNext();

	/**
	 * Get the next element in the structure and advance the iterator.
	 * Successive calls to next will traverse all elements of the structure.
	 * Note that alternating calls to next and previous will return the same
	 * element.
	 * 
	 * @return the next element in the structure.
	 * @throws NoSuchElementException
	 *             if there is no next element to be returned (i.e. hasNext
	 *             returns false).
	 */
	public E next();

	/**
	 * Check if there is at least one more element that can be retrieved by a
	 * call to previous.
	 * 
	 * @return true if previous will return an element, false if not (i.e. will
	 *         throw an exception).
	 */
	c

	/**
	 * Get the previous element in the structure and move the iterator backward
	 * in the structure. Successive calls to previous will traverse all elements
	 * of the structure in the opposite order to next. Note that alternating
	 * calls to next and previous will return the same element.
	 * 
	 * @return the previous element in the structure.
	 * @throws NoSuchElementException
	 *             if there is no previous element to be returned (i.e.
	 *             hasPrevious returns false).
	 */
	public E previous();

	/**
	 * Insert an element into the structure. The new element is inserted
	 * immediately before the element that would be returned by next(), if any,
	 * and/or after the element that would be returned by previous(), if any. If
	 * the structure contains no elements, the new element becomes the sole
	 * element in the structure. If the iterator has reached the end of the
	 * structure (i.e. hasNext returns false) then the new element becomes the
	 * last element in the structure (and hasNext still returns false). Note:
	 * The element that would be returned by next is unaffected by an insert and
	 * a call to previous following an insert will return the inserted element.
	 * 
	 * @param element
	 *            the element to be inserted into the structure.
	 */
	public void insert(E element);

	/**
	 * Removes from the list the last element that was returned by next() or
	 * previous(). This call can only be made once per call to next or previous.
	 * 
	 * @return the element that was removed from the structure.
	 * @throws IllegalStateException
	 *             if next or previous have not been called since the last call
	 *             to remove.
	 */
	public E remove();
}
