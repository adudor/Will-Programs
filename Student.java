//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P10 Food Delivery
// Files: Student.java
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
 * This class represent a single student in the Delivery.
 * 
 * @author Hunter Zhang
 *
 */
public class Student {

  private int x; // x-coordinate
  private int y; // y-coordinate
  private int id; // unique student ID.

  /**
   * The constructor of the class.
   * 
   * @param x   : the x-coordinate of the student.
   * @param y   : the y-coordinate of the student.
   * @param id: the unique student ID.
   */
  public Student(int x, int y, int id) {
    this.x = x;
    this.y = y;
    this.id = id;
  }

  /**
   * Get the x-coordinate of the student.
   * 
   * @return the x-coordinate of the student
   */
  public int getX() {
    return this.x;
  }

  /**
   * Get the y-coordinate of the student.
   * 
   * @return the y-coordinate of the student
   */
  public int getY() {
    return this.y;
  }

  /**
   * Get the ID of the student.
   * 
   * @return the ID of the student.
   */
  public int getId() {
    return this.id;
  }

  /**
   * Put the student's class using string representation.
   * @return the String representation of the student.
   */
  @Override
  public String toString() {
    return this.id + "(" + this.x + "," + this.y + ")";

  }
}
