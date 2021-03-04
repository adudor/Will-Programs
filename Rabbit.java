import java.io.File;

public class Rabbit extends Animal {
  private static final String RABBIT = "images" + File.separator + "rabbit.png";
  private static final String TYPE = "R"; // A String that represents the rabbit type
  private static int hopStep = 70; // one hop step
  private static int scanRange = 175; // scan range to watch out for threats
  private static int nextID = 1; // class variable that represents the identifier
  // of the next rabbit to be created
  private final int ID; // positive number that represents the order of this rabbit

  /**
   * Creates a new rabbit object located at a random position of the display window
   */
  public Rabbit() {
    // Set rabbit drawing parameters
    super(RABBIT);
    // Set rabbit identification fields
    ID = nextID;
    this.label = TYPE + ID; // String that identifies the current rabbit
    nextID++;
  }

  // getter of Rabbit.scanRange static field
  public static int getScanRange() {
    return scanRange;

  }

  // getter of Rabbit.hopStep static field
  public static int getHopStep() {
    return hopStep;
  }

  /**
   * Gets the first carrot in the patch. If the carrot is in the Rabbit hopStep range, the rabbit
   * eats it. It sets its position to the (x,y) position of the carrot and the carrot will be
   * removed from the Carrot Patch. Otherwise, the rabbit moves one hopStep towards that carrot. If
   * no carrot found (meaning Carrots.getFirstCarrot() returns false), the rabbit does nothing.
   */
  public void hopTowardsCarrot() {
    // get the first carrot
    int[] carrot = Carrots.getFirstCarrot();
    int newX = 0;
    int newY = 0;
    if (carrot != null) {
      if (super.isClose(carrot[1], carrot[2], hopStep)) {
        this.setX(carrot[1]);
        this.setY(carrot[2]);
        Carrots.remove(carrot[0]);
      } else {
        newX = (super.getX() + (hopStep * (carrot[1] - super.getX())))
            / (int) Math.sqrt(((carrot[1] - super.getX()) * (carrot[1] - super.getX()))
                + ((carrot[2] - super.getY()) * (carrot[2] - super.getY())));
        newY = (super.getY() + (hopStep * (carrot[2] - super.getY())))
            / (int) Math.sqrt(((carrot[1] - super.getX()) * (carrot[1] - super.getX()))
                + ((carrot[2] - super.getY()) * (carrot[2] - super.getY())));
      }
    }
  }

  @Override
  public void mousePressed() {
    // TODO
    // call the mousePressed defined in the Animal super class
    super.mousePressed();
    // call hopTowardsCarrot() method
    hopTowardsCarrot();
  }

}
