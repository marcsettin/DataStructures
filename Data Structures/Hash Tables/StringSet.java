
public class StringSet {

  StringNode [] table;
  int numelements;
  int size;

  public StringSet() {
    numelements = 0;
    size = 100;
    table = new StringNode[size];
  }

  public void insert(String key) {

    if (numelements == size) {
      // need to expand the table and rehash the contents
      
      StringNode [] oldTable = table;
      int oldSize = size;
      
      numelements = 0;
      size = 2 * size;
      table = new StringNode[size];
      
      for (int i = 0; i < oldSize; i++) {
				for (StringNode curr = oldTable[i]; curr != null; curr = curr.getNext())
					insert(curr.getKey());
			}
    }
    int i = hash(key);
    table[i] = new StringNode(key, table[i]);
    numelements++;
  }

  public boolean find(String key) {
    int i = hash(key);
    for (StringNode curr = table[i]; curr != null; curr = curr.getNext())
      if (key.equals(curr.getKey())) return true;
    return false;
  }

  public void print() {
    for (int i = 0; i < size; i++)
      for (StringNode curr = table[i]; curr != null; curr = curr.getNext())
        System.out.println(curr.getKey());
  }

  private int hash(String k) {
    int h = 0;
    for (int i = 0; i < k.length(); i++)
      h = (h * 2917 + (int) k.charAt(i)) % size;
    return h;
  }
}
