/**
	This class holds a single node of an element in a Hash Map.
**/
public class StringNode {

	private String key;				// This is the key field that is used as the key in the hash table.
	private String value;			// This is the associated value of the key field.
	private StringNode next;	// Reference to the next node in the hash map.

	/**
		Constructor: creates an instance of StringNode.
	**/
	public StringNode(String _key, String _value, StringNode _next) {
		key = _key;
		value = _value;
		next = _next;
	}

	// Several get and set methods follow.

	public String getKey() {
		return key;
	}

	public void setToken(String _key) {
		key = _key;
	}

	public StringNode getNext() {
		return next;
	}

	public void setNext(StringNode _next) {
		next = _next;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String _value) {
		value = _value;
	}
}
