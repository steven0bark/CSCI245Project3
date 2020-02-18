package hmllm;

import java.util.Iterator;

/**
 * HomemadeLLMap
 * 
 * An implementation of the HomemadeMap class that uses
 * a completely-homemade linked list on the inside.
 * 
 * @author Thomas VanDrunen
 * CSCI 245, Wheaton College
 * June 30, 2014
 */

public class HomemadeLLMap implements HomemadeMap {

	/**
	 * The head and tail of the map
	 */
    private Node head, tail;
	
	/**
	 * Constructor.
	 * 
	 * Initializes the head and tail of the map.
	 * @param head
	 * @param tail
	 */
	public HomemadeLLMap() {
		head = null;
		tail = null;
	}


	/**
     * Test whether an association exists for this key.
     * 
     * @param key The key being looked for.
     * @return True if there is an association for this key, false otherwise.
     */
    public boolean containsKey(String key) {
    	if(head != null)
    		return head.findNode(key) != null;
    	return false;
    }	
   

    /**
     * Add an association to the map.
     * 
     * If the head is null, it adds that node to the head. Otherwise, it will put the new key at the end of the 
     * list. If the key already exists, it will just update the value.
     * 
     * @param key The key to this association.
     * @param val The value to which this key is associated.
     */
    public void put(String key, String val) {
    	if(head != null) {
    		Node n = head.findNode(key);
    		if(n == null) {
    			tail.setNext(new Node(key, val, null));
    			tail = tail.next();
    		}else {
    			n.setvalue(val);
    		}
    	}else {
    		head = new Node(key, val, null);
    		tail = head;
    	}
    	
    }  

    /**
     * Gets the value for a key.
     * 
     * @param key The key whose value we're retrieving.
     * @return The value associated with this key, null if none exists.
     */
    public String get(String key) {
    	if(head != null) {
    		Node n = head.findNode(key);
    		if(n != null)
    			return n.value();
    	}
    	return null;
    }

    /**
     * Creates an Iterator object to iterate through the list.
     * 
     * Creates an anonymous class inside of the method that defines all necessary
     * methods for an iterator, and the returns an instance of that iterator. If the map is empty,
     * it will return an iterator that does nothing.
     * 
     * @return An iterator over the set of keys.
     */
    public Iterator<String> keyIterator() {
    	if(head != null) {
	    	return new Iterator<String>() {
	    		
	    		/**
	    		 * Holds where we are in the list
	    		 */
	    		private Node next = head;
	    		
	    		/**
	    		 * @return Returns true if the node we are on exists, false if not
	    		 * 
	    		 */
				public boolean hasNext() { return next != null; }
	
				/**
				 *  Determines if there is a next in the list. 
				 *  
				 *  If there is then it returns the key and sets the place to next for next call.
				 *  Otherwise it returns an null.
				 *  
				 *  @return returns the key that the iterator is on.
				 */
				@Override
				public String next() {
					String toreturn = "";
					if(hasNext()) {
						toreturn = next.key();
						next = next.next();
						return toreturn;
					}
						return null;
					
				}
	    		
	    	};
    	}
    	return new Iterator<String>() {	
    		/**
    		 * There will never be a next if this case runs
    		 * 
    		 * @return false
    		 */
			public boolean hasNext() { return false; }

			/**
			 *  There will never be a next if this runs
			 *  
			 *  @return null
			 */
			@Override
			public String next() {
				return null;
				
			}
    		
    	};
    }

    
    /**
     * Remove the association for this key. Checks for an empty list, if the list is size 1 
     * (or head is the node to remove), and if tail is the node to remove.
     * 
     * @param key The key to remove
     */   
    public void remove(String key) {
    	if(head != null) {
    		if(head.key().equals(key)) {
    			head = head.next();
    			return;
    		}	
	    	Node place = head;
	    	while(place.next() != null) {
	    		if(place.next().key().equals(key)) {
	    			if(place.next() == tail) {
	    				tail = place;
	    				place.setNext(null);
	    			}else {
	    				place.setNext(place.next().next());
	    			}
	    			return;
	    		}
	    		place = place.next();
	    	}
	    }
    }

    /**
     * Find if a node exists by making a recursive call to the method in Node class.
     *
     * @param k The key being looked for
     * @return the Node that contains the string, or null if the list empty
     */
    public Node findNode(String k) {
    	if(head != null) 
    		return head.findNode(k);
    	return null;
    }
    		

	
}
