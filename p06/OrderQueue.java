import java.util.Iterator;

public class OrderQueue implements QueueADT<Order>, java.lang.Iterable<Order> {
	private LinkedOrder front;
	private LinkedOrder back;
	private LinkedOrder size;

	@Override
	public Iterator<Order> iterator() {
		// TODO Auto-generated method stub
		return new OrderIterator(front);
		
	}

	@Override
	public void enqueue(Order newElement) {
		// TODO Auto-generated method stub
		back.setNext(newElement);
		size++;
		

	}

	@Override
	public Order dequeue() {
		// TODO Auto-generated method stub
		newElement.remove(front);
		return null;
	}

	@Override
	public Order peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (OrderQueue != null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Creates and returns a String representation of this OrderQueue using an
	 * enhanced-for loop. For example, a queue with three Orders might look like
	 * this: 
	 * 1001: fries (2) -> 1002: shake (1) -> 1003: burger (3) -> END
	 * 
	 * @return A String representation of the queue
	 */
	@Override
	public String toString() {
		if (this.size == 0) return "";
		String qString = "";
		for (Order o : this) {
			qString += o.toString();
			qString += " -> ";
		}
		qString += "END";
		return qString;
	}
}
