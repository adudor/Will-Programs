import java.io.File;

public class Wolf extends Animal {
  private static final String WOLF = "images" + File.separator + "wolf.png";
  private static int scanRange = 120; // scanning range to look for a rabbit
  // in the neighborhood
  private static int nextID = 1; // identifier of the next Wolf to be created
  private static final String TYPE = "W"; // A String that represents the Wolf type
  private final int ID; // positive number that represents the order of this Wolf
  private int rabbitEatenCount; // Number of rabbits that the current Wolf has eaten so far

  /**
   * Creates a new Wolf object at a random position of the display window
   *
   * @param processing CarrotPatch object which represents the display window
   */
  public Wolf() {
    super(WOLF);
    ID = nextID;
    this.label = TYPE + ID;
    nextID++;
  }

  public int getRabbitEatenCount() {
    return rabbitEatenCount;
  } // gets rabbitEatenCount instance field

  public static int getScanRange() {
    return scanRange;
  } // gets the scanRange of a Wolf

}
