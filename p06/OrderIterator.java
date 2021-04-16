import java.util.Iterator;
import java.util.NoSuchElementException;

public class OrderIterator implements Iterator<Order> {

  private LinkedOrder current;

  public OrderIterator(LinkedOrder start) {
    current = start;

  }

  public boolean hasNext() {
    if (current == null) {
      return false;
    } else {
      return true;
    }
  }

  public Order next() throws NoSuchElementException {
    if (!hasNext()) {
      throw new NoSuchElementException("There are no more orders to return!");
    } else {
      Order returnOrder = current.getOrder();
      current = current.getNext();
      return returnOrder;
    }
  }
}
