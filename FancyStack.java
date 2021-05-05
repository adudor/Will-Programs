///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name:
// Campus ID:
// WiscEmail:
////////////////////////////////////////////////////////////////////////////////

import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * A FancyStack is a linked list based stack of strings. It includes a dummy node at the top of the
 * stack. This stack may contain duplicate strings, except for the string at the top of the stack
 * (at the dummy node) which must be a unique.
 * 
 * Note that the dummy node is used to reduce the need for special-case code in this linked stack.
 * This stack is empty if it contains the dummy node only. The dummy node whose data is "TOP" will
 * be always at the top of the stack, meaning at index 0.
 * 
 * Complete the missing implementation marked by the //TODO tags.
 *
 */
public class FancyStack {
  private LinkedNode<String> top; // top of this stack


  /**
   * Initializes the newly created stack to contain the single String: "TOP".
   */
  public FancyStack() {
    // TODO complete the implementation of this constructor
    LinkedList<LinkedNode<String>> stack = new LinkedList<LinkedNode<String>>();
    top = new LinkedNode<String>("TOP", null);
    stack.add(top);
  }

  /**
   * Checks whether this fancy stack is empty.
   * 
   * @return true when this stack is empty, and false otherwise.
   */
  public boolean isEmpty() {
    // This stack is empty if it contains one node (the dummy node ONLY)
    // TODO complete the implementation of this method
    if(top.getNext() != null) {
      return false;
    }
    return true; // default return statement added to let this code to compile
  }

  /**
   * Adds a new value (to the top-side of this linked stack), meaning at index 1 of the stack.
   * Recall that the dummy node "TOP" must be already at index 0.
   * 
   * @param value that is being added to the stack.
   * @throws IllegalArgumentException if the value to be added is null or equals "TOP"
   */
  public void push(String value) {
    // TODO complete the implementation of this method
    LinkedNode<String> node = new LinkedNode<String>(value);
    if(top.getNext() == null) {
      top.setNext(node);
    } else {
      LinkedNode<String> next = top.getNext();
      top.setNext(node);
      node.setNext(next);
    }
  }

  /**
   * Returns the first element at the top of this stack (skipping the dummy node)
   * 
   * @return the element at the top of this stack
   * @throws EmptyStackException without error message if this method is called on an empty fancy
   *                             stack
   */
  public String peek() {
    // TODO complete the implementation of this method
    if(isEmpty()) {
      throw new EmptyStackException();
    }
    return top.getNext().getData();
  }

  /**
   * Removes and returns the next value from the top-side of this linked stack
   * 
   * @return the next value on this stack
   * @throws EmptyStackException without error message if this fancy stack is empty
   */
  public String pop() {
    // Note that the dummy node at index 0 should never be popped. This method removes and returns
    // the element at index 1 of the linked list.
    // TODO complete the implementation of this method
    if(isEmpty()) {
      throw new EmptyStackException();
    }
    String returnString = top.getNext().getData();
    if(top.getNext().getNext() != null) {
      top.setNext(top.getNext().getNext());
    } else {
      top.setNext(null);
    }
    return returnString; // default statement added to let this code to compile
  }

  /**
   * Returns a string representation of the contents of this fancy stack
   * 
   * @return string representation of this fancy stack
   */
  @Override
  public String toString() {
    String s = "";
    LinkedNode<String> current = top;
    while (current != null) {
      s = s + current.toString();
      current = current.getNext();
    }
    return s;
  }

  /**
   * This test method checks the correctness of the constructor, isEmpty(), push(), and peek()
   * methods
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean test() {

    // TODO create an empty FancyStack and check that it creates a fancy stack which is empty and
    // whose string representation equals "TOP -> END"
    FancyStack stack = new FancyStack();
    if(!stack.isEmpty()) {
      return false;
    }
    if(!stack.toString().equals("TOP -> END")) {
      return false;
    }
    
    // TODO try to call peek() on the empty stack and check whether an EmptyStackException is
    // thrown as expected
    try {
      stack.peek();
      return false;
    } catch(EmptyStackException e) {
      
    }

    // TODO try to push at least three VALID different strings, and check the correctness of
    // push(), peek(), and isEmpty(). You can use the toString() method to check the contents of
    // the stack
    stack.push("A");
    stack.push("B");
    stack.push("C");
    if(stack.isEmpty()) {
      return false;
    }
    if(!stack.peek().equals("C")) {
      return false;
    }

    return true; // CHANGE this (added to avoid compile errors)
  }


  /**
   * A simple demo() of this program
   */
  public static void demo() {
    System.out.println("DEMO: ");
    FancyStack stack = new FancyStack();
    System.out.println("Fancy Stack: " + stack.toString()); // Fancy Stack: TOP -> END
    System.out.println("isEmpty(): " + stack.isEmpty()); // isEmpty(): true
    stack.push("A"); // A pushed
    stack.push("B"); // B pushed
    System.out.println("Fancy Stack: " + stack.toString());
    // Fancy Stack: TOP -> B -> A -> END
    System.out.println("isEmpty(): " + stack.isEmpty()); // isEmpty(): false
    System.out.println("peek(): " + stack.peek()); // peek(): B
    System.out.println("pop(): " + stack.pop()); // pop(): B
    System.out.println("Fancy Stack: " + stack.toString());
    // Fancy Stack: TOP -> A -> END
    System.out.println("peek(): " + stack.peek()); // peek(): A
    System.out.println("pop(): " + stack.pop()); // pop(): A
    System.out.println("Fancy Stack: " + stack.toString()); // Fancy Stack: TOP -> END
    System.out.println("isEmpty(): " + stack.isEmpty()); // isEmpty(): true
  }

  /**
   * Driver for the test method above.
   * 
   * @param args is unused
   */
  public static void main(String[] args) {
    System.out.println("test(): " + test());
    System.out.println(); // new line
    demo();
  }

}
