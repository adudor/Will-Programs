// Add Complete File Header Here

// Add javadoc style class header here
// File Header comes here
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * MovieTree.
 *
 */

public class MovieTreeTester {

  /**
   * Checks the correctness of the implementation of both addMovie() and toString() methods
   * implemented in the MovieTree class. This unit test considers at least the following scenarios.
   * (1) Create a new empty MovieTree, and check that its size is 0, it is empty, and that its
   * string representation is an empty string "". (2) try adding one movie and then check that the
   * addMovie() method call returns true, the tree is not empty, its size is 1, and the .toString()
   * called on the tree returns the expected output. (3) Try adding another movie which is smaller
   * that the movie at the root, (4) Try adding a third movie which is greater than the one at the
   * root, (5) Try adding at least two further movies such that one must be added at the left
   * subtree, and the other at the right subtree. For all the above scenarios, and more, double
   * check each time that size() method returns the expected value, the add method call returns
   * true, and that the .toString() method returns the expected string representation of the
   * contents of the binary search tree in an increasing order from the smallest to the greatest
   * movie with respect to year, rating, and then name. (6) Try adding a movie already stored in the
   * tree. Make sure that the addMovie() method call returned false, and that the size of the tree
   * did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddMovieToStringSize() {
    { // scenario 1
      MovieTree tree = new MovieTree();
      if (tree.size() != 0 || !tree.isEmpty() || !tree.toString().equals("")) {
        return false;
      }
    }
    { // scenario 2
      MovieTree tree = new MovieTree();
      if (!tree.addMovie(new Movie(1990, 5.5, "Shrek"))) {
        return false;
      }
      if (tree.size() != 1 || tree.isEmpty()
          || !tree.toString().equals("[(Year: 1990) (Rate: 5.5) (Name: Shrek)]\n")) {
        return false;
      }
    }
    { // scenario 3
      MovieTree tree = new MovieTree();
      if (!tree.addMovie(new Movie(1990, 5.5, "Shrek"))) {
        return false;
      }
      if (!tree.addMovie(new Movie(1989, 7.0, "Cinderella"))) {
        return false;
      }
      if (tree.size() != 2 || tree.isEmpty() || !tree.toString().equals(
          "[(Year: 1989) (Rate: 7.0) (Name: Cinderella)]\n[(Year: 1990) (Rate: 5.5) (Name: Shrek)]\n")) {
        return false;
      }
    }
    { // scenario 4
      MovieTree tree = new MovieTree();
      if (!tree.addMovie(new Movie(1990, 5.5, "Shrek"))) {
        return false;
      }
      if (!tree.addMovie(new Movie(1989, 7.0, "Cinderella"))) {
        return false;
      }
      if (!tree.addMovie(new Movie(2000, 7.0, "Nemo"))) {
        return false;
      }
      if (tree.size() != 3 || tree.isEmpty() || !tree.toString().equals(
          "[(Year: 1989) (Rate: 7.0) (Name: Cinderella)]\n[(Year: 1990) (Rate: 5.5) (Name: Shrek)]"
              + "\n[(Year: 2000) (Rate: 7.0) (Name: Nemo)]\n")) {
        return false;
      }
    }
    { // scenario 5
      MovieTree tree = new MovieTree();
      if (!tree.addMovie(new Movie(1990, 5.5, "Shrek"))) {
        return false;
      }
      if (!tree.addMovie(new Movie(1989, 7.0, "Cinderella"))) {
        return false;
      }
      if (!tree.addMovie(new Movie(2000, 7.0, "Nemo"))) {
        return false;
      }
      if (!tree.addMovie(new Movie(1970, 2.0, "Cowboy"))) {
        return false;
      }
      if (!tree.addMovie(new Movie(2020, 10.0, "Avengers"))) {
        return false;
      }
      if (tree.size() != 5 || tree.isEmpty() || !tree.toString().equals(
          "[(Year: 1970) (Rate: 2.0) (Name: Cowboy)]\n[(Year: 1989) (Rate: 7.0) (Name: Cinderella)]"
              + "\n[(Year: 1990) (Rate: 5.5) (Name: Shrek)]\n[(Year: 2000) (Rate: 7.0) (Name: Nemo)]"
              + "\n[(Year: 2020) (Rate: 10.0) (Name: Avengers)]\n")) {
        return false;
      }
    }
    { // scenario 6
      MovieTree tree = new MovieTree();
      if (!tree.addMovie(new Movie(1990, 5.5, "Shrek"))) {
        return false;
      }
      if (tree.addMovie(new Movie(1990, 5.5, "Shrek"))) {
        return false;
      }
      if (tree.size() != 1 || tree.isEmpty()
          || !tree.toString().equals("[(Year: 1990) (Rate: 5.5) (Name: Shrek)]\n")) {
        return false;
      }
    }
    return true;
  }

  /**
   * This method checks mainly for the correctness of the MovieTree.contains() method. It must
   * consider at least the following test scenarios. (1) Create a new MovieTree. Then, check that
   * calling the contains() method on an empty MovieTree returns false. (2) Consider a MovieTree of
   * height 3 which contains at least 5 movies. Then, try to call contains() method to search for
   * the movie having a match at the root of the tree. (3) Then, search for a movie at the right and
   * left subtrees at different levels considering successful and unsuccessful search operations.
   * Make sure that the contains() method returns the expected output for every method call.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testContains() {
    { // scenario 1
      MovieTree tree = new MovieTree();
      if (tree.contains(1900, 2.0, "Bad Movie")) {
        System.out.println("1");
        return false;
      }
    }
    { // scenario 2
      MovieTree tree = new MovieTree();
      tree.addMovie(new Movie(1990, 5.5, "Shrek"));
      tree.addMovie(new Movie(1989, 7.0, "Cinderella"));
      tree.addMovie(new Movie(2000, 7.0, "Nemo"));
      tree.addMovie(new Movie(1970, 2.0, "Cowboy"));
      tree.addMovie(new Movie(2020, 10.0, "Avengers"));
      if (!tree.contains(1990, 5.5, "Shrek")) {
        System.out.println("2");
        return false;
      }
    }
    { // scenario 3
      MovieTree tree = new MovieTree();
      tree.addMovie(new Movie(1990, 5.5, "Shrek"));
      tree.addMovie(new Movie(1989, 7.0, "Cinderella"));
      tree.addMovie(new Movie(2000, 7.0, "Nemo"));
      tree.addMovie(new Movie(1970, 2.0, "Cowboy"));
      tree.addMovie(new Movie(2020, 10.0, "Avengers"));
      if (!tree.contains(2000, 7.0, "Nemo")) {
        return false;
      }
      if (!tree.contains(1970, 2.0, "Cowboy")) {
        return false;
      }
      if (tree.contains(1992, 1.0, "Cowboy")) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty movie tree is zero. (2) ensures that
   * the height of a tree which consists of only one node is 1. (3) ensures that the height of a
   * MovieTree with the following structure for instance, is 4. (*) / \ (*) (*) \ / \ (*) (*) (*) /
   * (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    { // scenario 1
      MovieTree tree = new MovieTree();
      if (tree.height() != 0) {
        return false;
      }
    }
    { // scenario 2
      MovieTree tree = new MovieTree();
      tree.addMovie(new Movie(1990, 5.5, "Shrek"));
      if (tree.height() != 1) {
        return false;
      }
    }
    { // scenario 3
      MovieTree tree = new MovieTree();
      tree.addMovie(new Movie(1990, 5.5, "Shrek"));
      tree.addMovie(new Movie(1980, 4.6, "Nemo"));
      tree.addMovie(new Movie(1985, 3.2, "Cinderella"));
      tree.addMovie(new Movie(2000, 8.0, "Avengers"));
      tree.addMovie(new Movie(1995, 6.9, "Hulk"));
      tree.addMovie(new Movie(2010, 5.7, "Superbad"));
      tree.addMovie(new Movie(2008, 9.5, "Incredibles"));
      if (tree.height() != 4) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.getBestMovie() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetBestMovie() {
    {
      MovieTree tree = new MovieTree();
      Movie best = new Movie(2012, 9.5, "Incredibles");
      tree.addMovie(new Movie(1990, 5.5, "Shrek"));
      tree.addMovie(new Movie(1980, 4.6, "Nemo"));
      tree.addMovie(new Movie(1985, 3.2, "Cinderella"));
      tree.addMovie(new Movie(2000, 8.0, "Avengers"));
      tree.addMovie(new Movie(1995, 6.9, "Hulk"));
      tree.addMovie(new Movie(2010, 5.7, "Superbad"));
      tree.addMovie(new Movie(2012, 9.0, "Batman"));
      tree.addMovie(best);
      if (!tree.getBestMovie().equals(best)) {
        return false;
      }
    }
    {
      MovieTree tree = new MovieTree();
      Movie best = null;
      if(tree.getBestMovie() != best) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.lookup() method. This test must consider at least 3
   * test scenarios. (1) Ensures that the MovieTree.lookup() method throws a NoSuchElementException
   * when called on an empty tree. (2) Ensures that the MovieTree.lookup() method returns an array
   * list which contains all the movies satisfying the search criteria of year and rating, when
   * called on a non empty movie tree with one match, and two matches and more. Vary your search
   * criteria such that the lookup() method must check in left and right subtrees. (3) Ensures that
   * the MovieTree.lookup() method throws a NoSuchElementException when called on a non-empty movie
   * tree with no search results found.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
    { // scenario 1
      MovieTree tree = new MovieTree();
      try {
        tree.lookup(1900, 2.4);
        return false;
      } catch (NoSuchElementException e) {
        if (!e.getMessage().contains("No movie")) {
          System.out.println("1");
          return false;
        }
      }
    }
    { // scenario 2
      MovieTree tree = new MovieTree();
      Movie shrek = new Movie(1990, 5.5, "Shrek");
      Movie nemo = new Movie(1980, 4.6, "Nemo");
      Movie cinderella = new Movie(2000, 3.2, "Cinderella");
      Movie avengers = new Movie(2000, 8.0, "Avengers");
      Movie hulk = new Movie(1970, 1.0, "Hulk");
      Movie superbad = new Movie(1970, 6.9, "Superbad");
      Movie incredibles = new Movie(1970, 10.0, "Incredibles");
      tree.addMovie(shrek);
      tree.addMovie(nemo);
      tree.addMovie(cinderella);
      tree.addMovie(avengers);
      tree.addMovie(hulk);
      tree.addMovie(superbad);
      tree.addMovie(incredibles);
      ArrayList<Movie> list1 = new ArrayList<Movie>();
      list1.add(shrek);
      ArrayList<Movie> list2 = new ArrayList<Movie>();
      list2.add(cinderella);
      list2.add(avengers);
      ArrayList<Movie> list3 = new ArrayList<Movie>();
      list3.add(hulk);
      list3.add(superbad);
      list3.add(incredibles);
      try {
        if (!tree.lookup(1900, 5.5).equals(list1)) {
          System.out.println("2a");
          return false;
        }
        if (!tree.lookup(2000, 3.2).equals(list2)) {
          System.out.println("2b");
          return false;
        }
        if (!tree.lookup(1970, 1.0).equals(list3)) {
          System.out.println("2c");
          return false;
        }

      } catch (NoSuchElementException e) {
        if (!e.getMessage().contains("No movie")) {
          System.out.println("2d");
          return false;
        }
      }
    }
    { // scenario 3
      MovieTree tree = new MovieTree();
      tree.addMovie(new Movie(2000, 3.2, "Nemo"));
      try {
        tree.lookup(1900, 2.4);
        System.out.println("3a");
        return false;
      } catch (NoSuchElementException e) {
        if (!e.getMessage().contains("No movie")) {
          System.out.println("3b");
          return false;
        }
      }
    }
    System.out.println("all");
    return true;
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testAddMovieToStringSize(): " + testAddMovieToStringSize());
    System.out.println("testContains(): " + testContains());
    System.out.println("testHeight(): " + testHeight());
    System.out.println("testGetBestMovie(): " + testGetBestMovie());
    System.out.println("testLookup(): " + testLookup());
  }

}
