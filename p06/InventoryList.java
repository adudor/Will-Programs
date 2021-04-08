import java.util.NoSuchElementException;

public class InventoryList {
  private LinkedBox head;
  private LinkedBox tail;
  private int size;
  private int yellowCount;
  private int blueCount;
  private int brownCount;

  /**
   * Adds a new blue box at the top of blue boxes if the list contains any blue box.
   * 
   * @param blueBox
   */
  public void addBlue(Box blueBox) {

    size++;
    blueCount++;
  }

  /**
   * Adds a brown box at the end of this inventory list
   * 
   * @param brownBox
   */
  public void addBrown(Box brownBox) {

    size++;
    brownCount++;
  }

  /**
   * Adds a new yellow box at the head of this list
   * 
   * @param yellowBox
   */
  public void addYellow(Box yellowBox) {

    size++;
    yellowCount++;
  }

  /**
   * Removes all of the elements from this list.
   */
  public void clear() {
    head = null;
    tail = null;
    size = 0;
    blueCount = 0;
    brownCount = 0;
    yellowCount = 0;
  }

  /**
   * Returns the element stored at position index of this list without removing it.
   * 
   * @param index
   * @return
   */
  public Box get(int index) {
    if (index >= size || index < 0) {
      throw new NoSuchElementException("index not in list");
    }
    LinkedBox element = head;
    for (int i = 0; i < index; i++) {
      element = element.getNext();
    }
    return element.getBox();

  }

  /**
   * Returns the number of blue boxes stored in this list
   * 
   * @return
   */
  public int getBlueCount() {
    LinkedBox element = head;
    int blueCount = 0;
    for(int i = 0; i < size; i++) {
      if(element.getBox().getColor() == Color.BLUE) {
        blueCount++;
      }
      element = element.getNext();
    }
    return blueCount;

  }

  /**
   * Returns the number of brown boxes stored in this list
   * 
   * @return
   */
  public int getBrownCount() {
    LinkedBox element = head;
    int brownCount = 0;
    for(int i = 0; i < size; i++) {
      if(element.getBox().getColor() == Color.BROWN) {
        brownCount++;
      }
      element = element.getNext();
    }
    return brownCount;

  }

  /**
   * Returns the number of yellow boxes stored in this list
   * 
   * @return
   */
  public int getYellowCount() {
    LinkedBox element = head;
    int yellowCount = 0;
    for(int i = 0; i < size; i++) {
      if(element.getBox().getColor() == Color.YELLOW) {
        yellowCount++;
      }
      element = element.getNext();
    }
    return yellowCount;

  }

  /**
   * Checks whether this LinkedBoxList is empty
   * 
   * @return
   */
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  /**
   * Removes and returns a box given its inventory number from this list
   * 
   * @param inventoryNumber
   * @return
   */
  public Box removeBox(int inventoryNumber) {
    return null;
  }

  /**
   * Removes and returns the element at the tail of this list if it has a brown color
   * 
   * @return
   */
  public Box removeBrown() {
    return null;

  }

  /**
   * Removes and returns the box at the head of this list if its color is yellow
   * 
   * @throws NoSuchElementException
   * @return
   */
  public Box removeYellow() {
    if (head.getBox().getColor() != Color.YELLOW) {
      throw new NoSuchElementException("List does not contain any yellow boxes");
    } else {
      head = head.getNext();
      size--;
      yellowCount--;
    }
    return null;

  }

  /**
   * Returns the size of this list
   * 
   * @return
   */
  public int size() {
    return size;

  }

  /**
   * Returns a String representation of the contents of this list
   * 
   * @return
   */
  public String toString() {
    return head.toString();
  }
}
