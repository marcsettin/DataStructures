/**
	This class implements a hash table capable of holding strings.
	Both the keys and their associated values are of type Strings.
	The table expands if the there are too many elements stored in the table.
**/
public class StringMap {

  StringNode [] table;	// The array of tables. Each table cell is a pointer to the head node of a linked list.
  int numelements;			// The number of elements actually stored in the table.
  int size;							// The size of the array (or table).

	/**
		Constructor: Creates an instance of StringMap.
	**/
  public StringMap() {
    numelements = 0;
    size = 100;
    table = new StringNode[size];
  }

	/**
		This function inserts a key and its corresponding value into the map.
		Be careful, that duplicate keys are not ignored.
	**/
  public void insert(String key, String value) {

    if (numelements == size) {
      // need to expand the table and rehash the contents
      
      StringNode [] oldTable = table;
      int oldSize = size;
      
      numelements = 0;
      size = 2 * size;
      table = new StringNode[size];
      
      for (int i = 0; i < oldSize; i++) {
				for (StringNode curr = oldTable[i]; curr != null; curr = curr.getNext())
					insert(curr.getKey(), curr.getValue());
			}
    }
    int i = hash(key);
    table[i] = new StringNode(key, value, table[i]);
    numelements++;
  }

	/**
		This function finds if a key is present or absent in the StringMap.
		Returns the reference to the String Node if it is present, otherwise returns null.
	**/
  public StringNode find(String key) {
    int i = hash(key);
    for (StringNode curr = table[i]; curr != null; curr = curr.getNext())
      if (key.equals(curr.getKey())) return curr;
    return null;
  }

	/**
		A polynomial hash function to hash strings.
	**/
  private int hash(String k) {
    int h = 0;
    for (int i = 0; i < k.length(); i++)
      h = (h * 2917 + (int) k.charAt(i)) % size;
    return h;
  }
}
