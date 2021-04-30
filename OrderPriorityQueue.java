// Remember to add your file header here

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * A max-heap implementation of a priority queue for Orders, where the Order with the LONGEST prep
 * time is returned first instead of the strict first-in-first-out queue as in P08.
 * 
 * TODO: Make sure Order implements Comparable<Order> so that this class can implement the
 * PriorityQueueADT without error!
 */
public class OrderPriorityQueue implements PriorityQueueADT<Order> {

  // Data fields; do not modify
  private Order[] queueHeap;
  private int size;

  /**
   * Constructs a PriorityQueue for Orders with the given capacity
   * 
   * @param capacity the initial capacity for the queue
   * @throws IllegalArgumentException if the given capacity is 0 or negative
   */
  public OrderPriorityQueue(int capacity) {
    // TODO throw IllegalArgumentException if capacity is invalid
    if (capacity <= 0) {
      throw new IllegalArgumentException("Invalid capacity.");
    }
    // TODO initialize data fields appropriately
    queueHeap = new Order[capacity];
    size = 0;
  }

  /**
   * Inserts a new Order into the queue in the appropriate position using a heap's add logic.
   * 
   * @param newOrder the Order to be added to the queue
   */
  @Override
  public void insert(Order newOrder) {
    // TODO If the queue is empty, insert the new order at the root of the heap
    if (isEmpty()) {
      queueHeap[0] = newOrder;
      size++;
    }
    // TODO If the queue is FULL, create a new Order array of double the current heap's size,
    // copy all elements of the current heap over and update the queueHeap reference
    // -> HINT: use Arrays.copyOf(), copying arrays is not the point of this assignment
    else if (size == queueHeap.length) {
      Order[] newQueue = Arrays.copyOf(queueHeap, queueHeap.length * 2);
      queueHeap = new Order[newQueue.length];
      queueHeap = newQueue;
      queueHeap[size] = newOrder;
      percolateUp(queueHeap, size);
      size++;
    }
    // TODO add the newOrder to the end of the heap and percolate up to ensure a valid heap, where
    // the Order with the LONGEST prep time is at the root of the heap
    else {
      queueHeap[size] = newOrder;
      percolateUp(queueHeap, size);
      size++;
    }
  }

  /**
   * A utility method to percolate Order values UP through the heap; see figure 13.3.1 in zyBooks
   * for a pseudocode algorithm.
   * 
   * @param heap       an array containing the Order values to be percolated into a valid heap
   * @param orderIndex the index of the Order to be percolated up
   */
  protected static void percolateUp(Order[] heap, int orderIndex) {
    // TODO implement the max heap percolate up algorithm to modify the heap in-place
    if (orderIndex <= 0) {
      return;
    }
    if (heap[orderIndex].compareTo(heap[getParentIndex(orderIndex)]) == -1) {
      swap(heap, orderIndex, getParentIndex(orderIndex));
      percolateUp(heap, getParentIndex(orderIndex));
    }
  }

  /**
   * Return the Order with the longest prep time from the queue and adjust the queue accordingly
   * 
   * @return the Order with the current longest prep time from the queue
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public Order removeBest() {
    // TODO If the queue is empty, throw a NoSuchElementException
    if(isEmpty()) {
      throw new NoSuchElementException("Queue is empty.");
    }
    // TODO Remove the root Order of the heap and re-structure the heap to ensure that its ordering
    // is valid, then return the previous root
    Order returnOrder = queueHeap[0];
    int counter = 0;
    for (int i = 0; i < size; i++) {
      if (queueHeap[i].equals(returnOrder)) {
        queueHeap[i] = null;
        counter++;
      }
    }
    
    // move all null elements to end of array
    Order[] arrayHolder = new Order[queueHeap.length];
    int j = 0;
    for (int i = 0; i < arrayHolder.length; i++) {
      if (queueHeap[i] != null) {
        arrayHolder[j++] = queueHeap[i];
      }
    }
    queueHeap = arrayHolder;

    size -= counter;
    for (int i = size / 2; i >= 0; i--) {
      percolateDown(queueHeap, i, size);
    }
    return returnOrder;

  }

  /**
   * A utility method to percolate Order values DOWN through the heap; see figure 13.3.2 in zyBooks
   * for a pseudocode algorithm.
   * 
   * @param heap       an array containing the Order values to be percolated into a valid heap
   * @param orderIndex the index of the Order to be percolated down
   * @param size       the number of initialized elements in the heap
   */
  protected static void percolateDown(Order[] heap, int orderIndex, int size) {
    // TODO implement the max heap percolate down algorithm to modify the heap in-place
    if (heap[getLeftChildIndex(orderIndex)] == null
        && heap[getRightChildIndex(orderIndex)] == null) {
      return;
    } else if (heap[getRightChildIndex(orderIndex)] == null) { // only need to check left child
      if (heap[orderIndex].compareTo(heap[getLeftChildIndex(orderIndex)]) == 1) {
        swap(heap, orderIndex, getLeftChildIndex(orderIndex));
        percolateDown(heap, getLeftChildIndex(orderIndex), size);
      }
    } else {
      // left child has higher priority
      if (heap[getLeftChildIndex(orderIndex)]
          .compareTo(heap[getRightChildIndex(orderIndex)]) == -1) {
        if (heap[orderIndex].compareTo(heap[getLeftChildIndex(orderIndex)]) == 1) {
          swap(heap, orderIndex, getLeftChildIndex(orderIndex));
          percolateDown(heap, getLeftChildIndex(orderIndex), size);
        }
      } else { // right child has higher priority
        if (heap[orderIndex].compareTo(heap[getRightChildIndex(orderIndex)]) == 1) {
          swap(heap, orderIndex, getRightChildIndex(orderIndex));
          percolateDown(heap, getRightChildIndex(orderIndex), size);
        }
      }
    }

  }

  /**
   * Return the Order with the highest prep time from the queue without altering the queue
   * 
   * @return the Order with the current longest prep time from the queue
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public Order peekBest() {
    if (size == 0) {
      throw new NoSuchElementException("Warning: Empty Heap!");
    }
    return queueHeap[0];
  }

  /**
   * Returns true if the queue contains no Orders, false otherwise
   * 
   * @return true if the queue contains no Orders, false otherwise
   */
  @Override
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  /**
   * Returns the number of elements currently in the queue
   * 
   * @return the number of elements currently in the queue
   */
  public int size() {
    return size;
  }

  /**
   * Creates a String representation of this PriorityQueue. Do not modify this implementation; this
   * is the version that will be used by all provided OrderPriorityQueue implementations that your
   * tester code will be run against.
   * 
   * @return the String representation of this PriorityQueue, primarily for testing purposes
   */
  public String toString() {
    String toReturn = "";
    for (int i = 0; i < this.size; i++) {
      toReturn += queueHeap[i].getID() + "(" + queueHeap[i].getPrepTime() + ")";
      if (i < this.size - 1)
        toReturn += ", ";
    }
    return toReturn;
  }

  /**
   * Gets the parent index of the index in the parameter and returns it.
   * 
   * @param index - index of the node in the queue
   * @return index of parent
   */
  private static int getParentIndex(int index) {
    return (index - 1) / 2;

  } // end getParentIndex

  /**
   * Swaps the elements at two indexes of the heap array.
   * 
   * @param one - first index from array containing element to be swapped
   * @param two - second element from array containing element to be swapped
   */
  private static void swap(Order heap[], int one, int two) {
    Order temp = heap[two];
    heap[two] = heap[one];
    heap[one] = temp;

  } // end swap

  /**
   * Gets the left child index of the index in the parameter and returns it.
   * 
   * @param index - index of the node in the queue
   * @return index of left child
   */
  private static int getLeftChildIndex(int index) {
    return (index * 2) + 1;

  } // end getLeftChildIndex

  /**
   * Gets the right child of the index in the parameter and returns it.
   * 
   * @param index - index of the node in the queue
   * @return index of the right child
   */
  private static int getRightChildIndex(int index) {
    return (index * 2) + 2;

  } // end getRightChildIndex

}
