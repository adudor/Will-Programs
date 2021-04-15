import java.util.Iterator;

public class OrderQueue implements QueueADT<Order> , java.lang.Iterable<Order> {
private LinkedOrder front;
private LinkedOrder back;
private LinkedOrder size;
	@Override
	public Iterator<Order> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enqueue(Order newElement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order dequeue() {
		// TODO Auto-generated method stub
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
		return false;
	}

}
