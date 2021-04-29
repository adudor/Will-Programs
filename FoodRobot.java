//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P10 Food Delivery
// Files: FoodRobot.java
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
// Online Sources: NONE
/**
 * This class represent a robot
 * @author Hunter Zhang
 *
 */
public class FoodRobot {
  private int x; // the x-coordinate
  private int y; // the y-coordinate
  private String name; // the unique string of robot.
  /**
   * The constructor of the class.
   * @param x : the x- coordinate
   * @param y : the y- coordinate
   * @param name: the name of the robot.
   */
  public FoodRobot(int x, int y, String name) {
    this.x = x;
    this.y = y;
    this.name = name;
  }
  /**
   * Get the x-coordinate of the robot.
   * @return x-coordinate 
   */
  public int getX() {
    return this.x;
  }
  /**
   * Get the y-coordinate of the robot.
   * @return y-coordinate
   */
  public int getY() {
    return this.y;
  }
  /**
   * Get the name of the robot.
   * 
   * @return the name of the robot.
   */
  public String getName() {
    return this.name;
  }
  

  /**
   * Put the robot's class using string representation.
   * @return the String representation of the robot.
   */
  @Override
  public String toString() {
    return this.name+"("+this.x+","+this.y+")";
    
  }
}
