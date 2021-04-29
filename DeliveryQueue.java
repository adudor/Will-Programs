//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P10 Food Delivery
// Files: DeliveryQueue.java
// Course: 300,Spring term ,2021
//
// Author: Hunter Zhang
// Email: zzhang978@wisc.edu
// Lecturer's Name: Hobbs
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: NONE
// Online Sources: NoobCoder youtube:https://www.youtube.com/watch?v=6ZwYazKjSs8&t=172s,
// https://www.youtube.com/watch?v=oiJUuJHyads


import java.util.NoSuchElementException;

/**
 * This class represents the priority queue of different deliveries.
 * 
 * @author Hunter Zhang
 *
 */

public class DeliveryQueue {
  private static final int INITIAL_CAPACITY = 20; // the capacity of the heap array.
  private Delivery[] heap;// the array contains the delivery objects.
  private int size;// the size of the heap array.

  /**
   * This is the constructor of the class.
   */
  public DeliveryQueue() {
    this.size = 0;
    heap = new Delivery[INITIAL_CAPACITY];
  }

  /**
   * Get the number of delivery object in the array.
   * 
   * @return the number of delivery object in the array.
   */
  public int getSize() {
    return this.size;
  }

  /**
   * Check if the heap array is empty.
   * 
   * @return true if the heap array is empty,else return false;
   */
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  @Override
  /**
   * Represent the different deliveries in the format of String.
   * 
   * @return the String representation.
   */
  public String toString() {
    String string = "This DeliveryQueue contains " + size + " elements";
    if (isEmpty()) {
      return string;
    }
    string += ": [ ";
    for (int i = 0; i < size; i++)
      string += "\n" + heap[i].toString();
    string += " ]\n";
    return string;
  }

  /**
   * This method compare the child to the parent according to the priority and shift.
   * 
   * @param index: the index passed in as the input.
   */
  private void percolateUp(int index) {
    int parentIndex;
    if (!(index == 0)) {// check whether the index has reached the end.
      parentIndex = getParentIndex(index);
      if (heap[parentIndex].compareTo(heap[index]) > 0) {// compare the current node to the parent
                                                         // node
        swap(parentIndex, index);
        percolateUp(parentIndex);// recursive method to repeat.
      }
    }

  }

  /**
   * The method that compare the parent to the child and shift the node down.
   * 
   * @param index: the index passes as an input.
   */
  private void percolateDown(int index) {
    int leftChildIndex = getLeftChildIndex(index);
    int rightChildIndex = getRightChildIndex(index);
    int minIndex = index;
    // compare the left child with the current heap.
    if ((leftChildIndex < size) && (heap[leftChildIndex].compareTo(heap[minIndex]) < 0)) {
      minIndex = leftChildIndex;
    }
    // compare the right child with the current heap.
    if ((rightChildIndex < size) && (heap[rightChildIndex].compareTo(heap[minIndex]) < 0)) {
      minIndex = rightChildIndex;
    }
    if (minIndex != index) {
      swap(index, minIndex);
      percolateDown(minIndex);// recursive method
    }

  }


  /**
   * The method that heapify the array.
   */
  private void heapify() {
    int index = size / 2;


    for (index = size / 2; index >= 1; index--) {
      percolateUp(index);// calling the method of percolate up.
    }



  }

  /**
   * Determine the parent index of the node.
   * 
   * @param index : the index passed in as input.
   * @return the index of the parent node.
   */
  private int getParentIndex(int index) {
    return (int) Math.floor((index - 1) / 2);

  }

  /**
   * Determine the left Child index of the node.
   * 
   * @param index : the index passed in as input.
   * @return the index of the parent node.
   */
  private int getLeftChildIndex(int index) {
    return 2 * index + 1;
  }

  /**
   * Determine the right child index of the node.
   * 
   * @param index : the index passed in as input.
   * @return the index of the parent node.
   */
  private int getRightChildIndex(int index) {
    return 2 * index + 2;
  }

  /**
   * Swap the different nodes with each other in the array.
   * 
   * @param firstIndex  : the index passed in as the input.
   * @param secondIndex : the index passed in as the input.
   */
  private void swap(int firstIndex, int secondIndex) {
    Delivery temp = heap[firstIndex];
    heap[firstIndex] = heap[secondIndex];
    heap[secondIndex] = temp;
  }

  /**
   * – this method adds a new delivery to this priority queue. If the heap is already at capacity
   * when this method is called, it should first create a new larger capacity array (twice the
   * previous heap capacity), copy the old arrays contents into this larger array, and then use this
   * array as the heap going forward (until it is filled and replaced with an even larger one).
   * 
   * @param delivery : the new delivery to be inserted.
   */
  public void offerDelivery(Delivery delivery) {
    Delivery[] tempArr;
    if (size == heap.length) {// check the array has reached its limit
      tempArr = new Delivery[2 * heap.length];// increase the capacity.
      for (int i = 0; i < size; ++i) {// compy the array into temp array.s
        tempArr[i] = heap[i];
      }

      tempArr[size] = delivery; // add the new delivery.
      size += 1;
      heap = tempArr;

    } else {
      size += 1;

      heap[size - 1] = delivery;

      percolateUp(size - 1);// calling the percolate up method.


    }
    // heapify();
  }


  /**
   * The method that returns the delivery with highest priority.
   * 
   * @return the delivery object with the highest priority.
   * @throws NoSuchElementException : exception that the heap array is empty.
   */
  public Delivery pollBestDelivery() {
    Delivery min;
    int index = 0;

    if (isEmpty()) {
      throw new NoSuchElementException("Warning:Empty Heap!");
    }
    min = heap[0];
    size -= 1;
    heap[0] = heap[size];// assign the root with next node.
    percolateDown(0);// percolate down the node.
    // remove the object that 'equals' to the current object.
    while (index < size) {
      if (heap[index].equals(min)) {
        for (int i = index; i < size - 1; i++) {
          heap[i] = heap[i + 1];
        }
        heap[size - 1] = null;
        size -= 1;



      } else {
        index += 1;

      }

    }
    heapify();// restore the order of the array.
    return min;


  }

  /**
   * returns (without removing) the highest priority delivery. If the heap is empty, then this
   * method should throw a NoSuchElementException with the message “Warning: Empty Heap!”
   * 
   * @return the highest priority delivery object.
   * @throws NoSuchElementException : "warning : empty heap"
   */
  public Delivery peek() {
    if (isEmpty()) {// check if the array is empty
      throw new NoSuchElementException("Warning: Empty Heap!");
    } else {
      return heap[0];
    }

  }

}
