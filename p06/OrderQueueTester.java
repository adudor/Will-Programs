public class OrderQueueTester {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    runAllTests();

  }

  public static boolean runAllTests() {
    if(!OrderIteratorTester()) {
      return false;
    } 
    if(!testEnqueue()) {
      return false;
    }
    if(!testDequeue()) {
      return false;
    }
    if(!testPeekAndIsEmpty()) {
      return false;
    }
    System.out.println("passed");
    return true;

  }
  
  public static boolean testPeekAndIsEmpty() {
    OrderQueue queue = new OrderQueue();
    Order order1 = new Order("Tacos", 10);
    Order order2 = new Order("Pizza", 30);
    if(!queue.isEmpty()) {
      return false;
    }
    try {
      queue.peek();
      return false;
    } catch (Exception e) {
      if(!e.getMessage().contains("empty")) {
        return false;
      }
    }
    queue.enqueue(order1);
    queue.enqueue(order2);
    if(!queue.peek().equals(order1)) {
      return false;
    }
    return true;
  }
  
  public static boolean testDequeue() {
    OrderQueue queue = new OrderQueue();
    Order order1 = new Order("Tacos", 10);
    Order order2 = new Order("Pizza", 30);
    queue.enqueue(order1);
    queue.enqueue(order2);
    queue.dequeue();
    if(queue.isEmpty()) {
      return false;
    }
    queue.dequeue();
    if(!queue.isEmpty()) {
      return false;
    }
    try {
      queue.dequeue();
    } catch (Exception e) {
      if(!e.getMessage().contains("empty")) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean testEnqueue() {
    OrderQueue queue = new OrderQueue();
    Order order1 = new Order("Tacos", 10);
    queue.enqueue(order1);
    if(queue.isEmpty()) {
      return false;
    }
    return true;
  }

  public static boolean OrderIteratorTester() {
    LinkedOrder order1 = new LinkedOrder(new Order("Tacos", 10));
    LinkedOrder order2 = new LinkedOrder(new Order("Pizza", 30));
    LinkedOrder order3 = new LinkedOrder(new Order("Burger", 12));
    order1.setNext(order2);
    order2.setNext(order3);
    OrderIterator iterator = new OrderIterator(order1);
    if (!iterator.hasNext()) {
      return false;
    }
    if (!iterator.next().equals(order1.getOrder())) {
      return false;
    }
    return true;

  }


}
