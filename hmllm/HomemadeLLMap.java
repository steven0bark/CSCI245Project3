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
	 * The head of the map
	 */
    private Node head, tail;
	
	/**
     * Test whether an association exists for this key.
     * @param key The key to remove
     * @return true if there is an association for this key, false otherwise
     */
    public boolean containsKey(String key) {
    	return head.findNode(key) != null;
    }
   

    /**
     * Add an association to the map.
     * @param key The key to this association
     * @param val The value to which this key is associated
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
     * Get the value for a key.
     * @param key The key whose value we're retrieving.
     * @return The value associated with this key, null if none exists
     */
    public String get(String key) {
    	if(head != null) {
    		Node n = head.findNode(key);
    		if(n != null)
    			return n.value();
    	}
    	return "";
    }

    /**
     * Creates an Iterator object to iterate through the list.
     * Creates an anonymous class inside of the method call that defines all necessary
     * methods for an iterator, and the returns an instance of that iterator
     * 
     * @return An iterator over the set of keys.
     */
    public Iterator<String> keyIterator() {
    	return new Iterator<String>() {
    		/**
    		 * Holds where we are in the list
    		 */
    		private Node place = head;
    		
    		/**
    		 * Returns true if there is a next node, false if not
    		 */
			public boolean hasNext() { return place.next() != null; }

			/**
			 *  Determines if there is a next in the list. 
			 *  If there is then it returns the key and sets the place to next for next call.
			 *  Otherwise it returns an empty string.
			 */
			@Override
			public String next() {
				String toreturn = "";
				if(hasNext()) {
					toreturn = place.key();
					place = place.next();
					return toreturn;
				}
					return toreturn;
				
			}
    		
    	};
    }

    
    /**
     * Remove the association for this key.
     * @param key The key to remove
     */   
    public void remove(String key) {
    	
    }

    /**
     *Returns the Node that contains a key, or returns null when that key does not exists 
     */
    public Node findNode(String k) {
    	if(head != null) 
    		return head.findNode(k);
    	return null;
    }
    		

	
}
