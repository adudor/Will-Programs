import processing.core.PApplet;

public class CarrotPatchTester extends CarrotPatch {

  private static CarrotPatch processing; // PApplet object that represents the display window of
                                         // this program

  /**
   * This method checks whether isClose(Animal, int) called by a Rabbit returns true if a Wolf is
   * within the rabbit's scanRange area and false if called with another Wolf as input parameter
   * located outside its scanRange area
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean test1isCloseMethod() {
    Carrots.settings(processing);
    Animal.setProcessing(processing);
    Button.setProcessing(processing);

    // This is a suggested example. You can define your own test scenario for this method
    // Create a Rabbit and two Wolves
    try {
      Rabbit r = new Rabbit();
      Wolf w1 = new Wolf();
      Wolf w2 = new Wolf();
      // Set Rabbit at position(200,200)
      r.setX(200);
      r.setY(200);
      // Set first Wolf at position(400,200)
      w1.setX(400); // Wolf is 200px away from Rabbit
      w1.setY(200);
      // Set second Wolf at position(300,200)
      w2.setX(300); // Wolf is 100px away from Rabbit
      w2.setY(200);
      if (r.isClose(w1, Rabbit.getScanRange())) { // bug! isClose() should return false here
        System.out.println(
            "Problem detected: Rabbit.isClose() returned true when it should return false.");
        return false;
      }
      if (!r.isClose(w2, Rabbit.getScanRange())) { // bug! isClose() should return true here
        System.out.println(
            "Problem detected: Rabbit.isClose() returned false when it should return true.");
        return false;
      }

      /////////////////////////////////////
      processing.objects.clear(); // clear all the content of objects list to get ready to the next
                                  // test scenario
    } catch (Exception e) {
      System.out.println("Problem detected: A non-expected exception has been thrown.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * This method checks whether isClose(Animal, int) called by a Wolf returns false when called to
   * check whether it is close to another wolf located outside the Wolf's scanRange area
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean test2isCloseMethod() {
    Carrots.settings(processing);
    Animal.setProcessing(processing);
    Button.setProcessing(processing);
    // TODO Define your test scenario here


    ////////////////////////////////////////
    processing.objects.clear(); // clear all the content of objects list to get ready to the next
                                // test scenario
    return true;
  }


  /**
   * This method checks whether isClose(int, int) called by a Rabbit returns false when called to
   * check whether this rabbit is close to a given (x,y) position located outside of its
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean test3isCloseMethod() {
    Carrots.settings(processing);
    Animal.setProcessing(processing);
    Button.setProcessing(processing);
    // TODO Define your test scenario here


    ////////////////////////////////////////
    processing.objects.clear(); // clear all the content of objects list to get ready to the next
                                // test scenario
    return true;
  }



  /**
   * This is a callback method automatically called only one time when the PApplet application
   * starts as a result of calling PApplet.main("PAppletClassName"); Defines the initial environment
   * properties of this class/program As setup() is run only one time when this program starts, all
   * your test methods should be called in this method
   */
  @Override
  public void setup() {
    super.setup(); // calls the setup() method defined
    processing = this; // set the patch to the current instance of Jungle
    // TODO Call your test methods here
    System.out.println("test1isCloseMethod(): " + test1isCloseMethod());
    System.out.println("test2isCloseMethod(): " + test2isCloseMethod());



    // close PApplet display window (No need for the graphic mode for these tests)
    processing.exit();

  }

  /**
   * runs CarrotPatchTester program as a PApplet client
   * 
   * @param args
   */
  public static void main(String[] args) {
    // Call PApplet.main(String className) to start this program as a PApplet client application
    PApplet.main("CarrotPatchTester");
  }

}