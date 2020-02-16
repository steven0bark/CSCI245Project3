package hmllm;

/**
 * Node
 * 
 * This is the class for making items in the map, containing both
 * the key and the value.
 * 
 * @author stevenbarker
 */
public class Node {

	/**
	 * The key in the map
	 */
	private String key;
	
	/**
	 * the value in the map
	 */
	private String value;
	
	/**
	 * The reference to the next node in the list
	 */
	private Node next;
	
	/**
	 * Constructor
	 * 
	 * Initializes all necessary instance variables to create a node in the list
	 * @param k The key in the map.
	 * @param v The value in the map.
	 * @param n The reference to the next node in the list.
	 */
	public Node(String k, String v, Node n) {
		key = k;
		value = v;
		next = n;
	}

	/**
	 * getNext gives the next node in the list.
	 * @return the next Node in the list.
	 */
	public Node next() {
		return next;
	}
	/**
	 * setNext sets a node object to be the next node after the calling object
	 * @param n The new node to be set to the next node after the calling object.
	 */
	public void setNext(Node n) {
		next = n;
	}

	/**
	 * getKey gets the key
	 * @return the key
	 */
	public String key() {
		return key;
	}

	/**
	 * getValue gets the value
	 * @return the value associated with the key
	 */
	public String value() {
		return value;
	}

	/**
	 * setValue sets a value to be associated with a key
	 * @param v The value to be associated to the string
	 */
	public void setvalue(String v) {
		value = v;
	}
    
    /**
     * 
     */
    public Node findNode(String k) {
    	if(key.equals(k)) 
    		return this;
    	if(next == null)
    		return null;
    	return next.findNode(k);
    	
    }
  
}

