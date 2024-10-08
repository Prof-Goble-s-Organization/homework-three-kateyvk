
public class cs232ArrayStack<E> implements CS232Stack<E> {
	
	private CS232ArrayList<E> backingS;
	
	//constructer a new empty stack
	public cs232ArrayStack() {
		backingS = new CS232ArrayList<>();
	}
	
	  /**
     * Add the provided element to the top of the stack.
     * 
     * @param obj the element to push onto the stack.
     */
    public void push(E obj) {
    	backingS.add(obj);
    	
    	
    }
    

    /**
     * Remove the element from of the top of the stack and return it.
     * 
     * @return the element from the top of the stack or null if the stack is
     *         empty.
     */
    public E pop() {
    	if (isEmpty() == true) {
    		return null;
    	}
    	return backingS.remove(backingS.size()-1);
    	
    	
    }

    /**
     * Return a reference to the element on the top of the stack without
     * removing it.
     * 
     * @return a reference to the element on the top of the stack or null if the
     *         stack is empty.
     */
    public E peek() {
    	if (isEmpty() == true) {
    		return null;
    	}
    	return backingS.get(backingS.size()-1);
    	
    	
    }
    
    /**
     * Return the number of elements contained in the stack.
     * 
     * @return the size of the stack.
     */
    public int size() {
    	return backingS.size();
    }
    //check to make sure stack isn't empty
	public boolean isEmpty() {
		if (size()==0){
			return true;
		}
		return false;
		
	}
}
