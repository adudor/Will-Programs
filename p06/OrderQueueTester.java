public class OrderQueueTester {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    runAllTests();

  }

  public static boolean runAllTests() {
    if(!OrderIteratorTester()) {
      return false;
    } 
    if(!OrderQueueTest()) {
      return false;
    }
    return true;

  }
  
  public static boolean OrderQueueTest() {
    OrderQueue queue = new OrderQueue();
    Order order1 = new Order("Tacos", 10);
    Order order2 = new Order("Pizza", 30);
    Order order3 = new Order("Burger", 12);
    queue.enqueue(order1);
    if(queue.isEmpty() || !queue.peek().equals(order1)) {
      return false;
    }
    queue.dequeue();
    if(!queue.isEmpty()) {
      return false;
    }
    queue.enqueue(order2);
    queue.enqueue(order3);
    System.out.println(queue.toString());
    
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
    if (!iterator.next().equals(order2.getOrder())) {
      return false;
    }
    return true;

  }


}
