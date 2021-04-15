import java.util.Iterator;
import java.util.NoSuchElementException;

public class OrderQueue implements QueueADT<Order>, java.lang.Iterable<Order> {
  private LinkedOrder front;
  private LinkedOrder back;
  private int size;

  @Override
  public Iterator<Order> iterator() {
    return new OrderIterator(front);
  }

  @Override
  public void enqueue(Order newElement) {
    LinkedOrder element = new LinkedOrder(newElement);
    if (front == null) {
      front = element;
    } else if (back == null) {
      front.setNext(element);
      back = element;
    } else {
      back.setNext(element);
      back = element;
    }
    size++;

  }

  @Override
  public Order dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }
    Order returnOrder = front.getOrder();
    if (back != null) {
      front = front.getNext();
    } else {
      front = null;
    }
    size--;
    return returnOrder;
  }

  @Override
  public Order peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }
    return front.getOrder();
  }

  @Override
  public boolean isEmpty() {
    if (front == null) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Creates and returns a String representation of this OrderQueue using an enhanced-for loop. For
   * example, a queue with three Orders might look like this: 1001: fries (2) -> 1002: shake (1) ->
   * 1003: burger (3) -> END
   *
   * @return A String representation of the queue
   */
  @Override
  public String toString() {
    if (this.size == 0)
      return "";
    String qString = "";
    for (Order o : this) {
      qString += o.toString();
      qString += " -> ";
    }
    qString += "END";
    return qString;
  }


}
