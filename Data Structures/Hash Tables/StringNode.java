public class StringNode {

  private String key;
  private StringNode next;

  public StringNode(String _key, StringNode _next) {
    key = _key;
    next = _next;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String _key) {
    key = _key;
  }

  public StringNode getNext() {
    return next;
  }

  public void setNext(StringNode _next) {
    next = _next;
  }

}
