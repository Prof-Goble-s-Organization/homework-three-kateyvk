package hw03;

import java.util.NoSuchElementException;

/**
 * An implementation of the CS132List interface backed with an array of Objects.
 * 
 * @author Grant Braught
 * @author Dickinson College
 * @version Feb 18, 2016
 */
public class CS232ArrayList<E> implements CS232List<E>, CS232Iterable<E> {

    private static final int INITIAL_CAPACITY = 10;

    private E[] listElements;
    private int currentSize;

    /**
     * Construct a new ArrayBackedList.
     */
    public CS232ArrayList() {
        listElements = (E[]) new Object[INITIAL_CAPACITY];
        currentSize = 0;
    }
    

    /**
     * {@inheritDoc}
     */
    public int size() {
        return currentSize;
    }

    /**
     * {@inheritDoc}
     */
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("accessed " + index + " but size is " + currentSize);
        }
        else {
            return listElements[index];
        }
    }

    /**
     * {@inheritDoc}
     */
    public void set(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("tried to set " + index + " but size is "
                    + currentSize);
        }
        else {
            listElements[index] = element;
        }
    }

    /**
     * Append the specified Object to the end of the list. The size of the list
     * is increased by 1. If the list is full, a new array with twice the capacity 
     * will be created, all of the elements will be copied into the new array and 
     * then the new element will be added to the end.
     * 
     * @param element the Object to append to the list.
     */
    public void add(E element) {
        // If the array is full double its size.
        if (currentSize == listElements.length) {
            doubleArraySize();
        }
        
        listElements[currentSize] = element;
        currentSize++;
    }

    /**
     * Double the size of the array that is holding the list elements and copy
     * the current list into the new array.
     */
    private void doubleArraySize() {
        E[] tmp = (E[]) new Object[listElements.length * 2];
        System.arraycopy(listElements, 0, tmp, 0, listElements.length);
        listElements = tmp;
    }

    /**
     * Insert the specified element at the specified index. All objects at the
     * specified index and higher will be shifted up one index in the underlying
     * array. If the array is full, a new array with twice the capacity will be 
     * created, all of the elements will be copied into the new array and then
     * the new element will be inserted.
     * 
     * @param index the index at which to insert the new object.
     * @param element the object to be inserted.
     * @throws IndexOutOfBoundsException if index < 0 or index >= size()
     */
    public void insert(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index > currentSize) {
            throw new IndexOutOfBoundsException("accessed " + index + " but size is " + currentSize);
        }
        else {
            // If the array is full double its size.
            if (currentSize == listElements.length) {
                doubleArraySize();
            }
            
            /*
             * Shift each of the elements at index or higher up by one location
             * to make room for the new element to be inserted.
             */
            for (int i = currentSize; i > index; i--) {
                listElements[i] = listElements[i - 1];
            }

            // Insert the new element.
            listElements[index] = element;
            currentSize++;
        }
    }

    /**
     * {@inheritDoc}
     */
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("accessed " + index + " but size is " + currentSize);
        }
        else {
            E elem = listElements[index];

            /*
             * Shift each of the elements at index or higher down by one
             * location to fill in the hole left by the removal of the element
             * at index.
             */
            for (int i = index; i < currentSize - 1; i++) {
                listElements[i] = listElements[i + 1];
            }

            // Make sure we don't have two references to the last element in the list.
            listElements[currentSize - 1] = null;

            currentSize--;

            return elem;
        }
    }
    public CS232Iterator<E> getIterator(){
    	
    }
    private class ArrayIterator implements CS232Iterator<E>{
    	private int cursor;
    	private int lastReturn;
    	
    	public ArrayIterator() {
    		cursor = 2;
    		lastReturn =1;
    	}
    	
    	
    	public boolean hasNext() {
    		if(cursor < currentSize) {
    			return true;
    		}else {
    			return false;
    		}
    		
    	}
    	public boolean hasPrevious() {
    		if (cursor >0) {
    			return true;
    		}else {
    			return false;
    		}
    	}
    	public E previous() {
    		if(hasPrevious()==false) {
    			throw new NoSuchElementException("There is no previous element.");
    		}else {
    			lastReturn = --cursor;//update value so the cursor is actually on previous.
    			return listElements[lastReturn]; //returning previous element based on updated lastReturn
    		}
    		
    	}
    	public void insert(E element) {
    		throw new UnsupportedOperationException("");
    	}
    	public E remove() {
    		throw new UnsupportedOperationException("");
    	}
    }
}
