//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P10 Food Delivery
// Files: Delivery.java
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
 * This class represents the single delivery order
 * 
 * @author Hunter Zhang
 *
 */
public class Delivery implements Comparable<Delivery> {
  private int studentId; // the student IDs of the Delivery.
  private String robotName;// the name of the robot of the delivery.
  private int distance;// the distance between the student and the robot

  /**
   * The constructor of this class.
   * @param student: the student who order the order.
   * @param robot: the robot who carry the food.
   */
  public Delivery(Student student, FoodRobot robot) {
    studentId = student.getId();
    robotName = robot.getName();
    distance = Math.abs(student.getX() - robot.getX()) + Math.abs(student.getY() - robot.getY());
  }
  /**
   * Get the distance between the student and the robot.
   * @return the distance between the student and the robot.
   */
  public int getDistance() {
    return this.distance;

  }
  /**
   * Get the id of the student who ordered the delivery.
   * @return the id of the student.
   */
  public int getStudentId() {
    return this.studentId;
  }
  /**
   * Get the name of the robot who ordered the delivery.
   * @return the name of the robot.
   */
  public String GetRobotName() {
    return this.robotName;
  }
  /**
   * The method that determines if the information between two objects are equal.
   * @param object : the object as input.
   * @return true if the objects are equal or else false.
   */
  @Override
  public boolean equals(Object object) {
    if (object instanceof Delivery) {// determine if the object is a Delivery object.
      if ((((Delivery) object).getStudentId() == studentId)// check if the ID or the names are equal
          || ((Delivery) object).GetRobotName().equals(robotName)) {
        return true;
      }

    } else if (object instanceof Student) {//determine if the object is a student object.
      if (((Student) object).getId() == studentId) {// check if the ID are equal
        return true;
      }
    } else {
      if (((FoodRobot) object).getName().equals(robotName)) {//check if the robot names are equal.
        return true;
      }
    }

    return false;

  }

  @Override
  /**
   * The String representation of the object.
   * @return the String representation.
   */
  public String toString() {
    return "The distance between " + studentId + " and " + robotName + " is " + distance;
  }

  @Override
  /**
   * The method that compares two delivery to determine the priority. 
   * @param object : the object that represent another delivery.
   * @return The int value that indicates the priority. 
   */
  public int compareTo(Delivery object) {
   // check which has the shortest distance
    if (this.distance > object.getDistance()) {
      return 1;
    } else if (this.distance < object.getDistance()) {
      return -1;
    } else {
      // check which has the smallest student ID.
      if (studentId < object.getStudentId()) {
        return -1;
      } else if (studentId > object.getStudentId()) {
        return 1;
      } else {
        // check which has the lexigraphically eailer robot name.
        if (robotName.compareTo(object.GetRobotName()) < 0) {
          return -1;
        } else {
          return 1;
        }


      }



    }



  }
}


