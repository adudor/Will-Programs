///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name:
// Campus ID:
// WiscEmail:
////////////////////////////////////////////////////////////////////////////////

import java.util.Arrays;

/**
 * This CitySorter class contains one public method: sortCityNames(), along with several helper
 * methods and one simple test method. The sortCityNames() method sorts names of cities in
 * lexicographic order with respect to the provided specification.
 * 
 * Complete the missing implementation marked by the //TODO tags.
 *
 */
public class CitySorter {

  /**
   * This method returns the index of the smaller of two strings stored within an array at two given
   * positions with respect to the result of String.compareTo() method.
   * 
   * @param data   an array of strings
   * @param index1 index of a string within the array data
   * @param index2 index of another string within the array data
   * @return the index of smallest of the strings data[index1] and data[index2] with respect to the
   *         lexicographic order
   */
  protected static int min(String[] data, int index1, int index2) {
    // We assume that both indexes index1 and index2 are in bounds of the range of indexes of
    // the array data. You do not need to check for that.

    // TODO implement this method
    int smallestIndex = index1;
    for (int i = index1+1; i < index2; i++) {
      if (data[index1].compareTo(data[i]) == 1) {
        smallestIndex = i;
      }
    }
    return smallestIndex; // CHANGE this (added to avoid compile errors)
  }

  /**
   * Recursive method which returns the index of the smallest element of the partition of an array
   * data starting from a given index until the end of the array (including the last element of the
   * array)
   * 
   * @param data  a non empty perfect size array
   * @param index an index position
   * @return the index of the smallest element of the partition of the array data starting from
   *         index to the end of the array
   */
  protected static int getMinimum(String[] data, int index) {
    // We assume that index is in bound of the range of indexes of the array data.
    // You do not need to check for that.

    // TODO base case (starting index refers to the last position of the array)
    if (index == data.length - 1)
      return index; // CHANGE this (added to avoid compile errors)

    // TODO recursive case
    // Try to decompose problem into smaller problems of the same type as follows.
    // data: [e1, e2, e3, e4, e5, e6]; index: 0
    // This array data can be divided into two partitions:
    // sub_array1: [e1]; and
    // sub_array2: [e2, e3, e4, e5, e6],
    // If we can get the minimum of each partition, we can determine the
    // minumum of the array data. The solution to one sub-problem is trivial.
    // The other sub-problem can be decomposed into smaller sub-problems of the same type
    int returnIndex = index;

    String[] partition = new String[data.length-index];
    for (int i = 0; i < partition.length; i++) {
      partition[i] = data[index+i];
    }
    
    int smallestPartition = min(partition, 0, partition.length);
    
    if(returnIndex > smallestPartition) {
      returnIndex = smallestPartition;
    }
    
    return returnIndex;
  }


  /**
   * Sorts an array of file names in the lexicographic order using the recursive getMinimum()
   * method. This sort operation operates in-place.
   * 
   * @param cities an unsorted array of file names
   */
  public static void sortCityNames(String[] cities) {
    // This is an in-place sorting algorithm.
    // This method MUST use getMinimum() method to operate


    // TODO Traverse the array cities starting from index 0
    // Feel free to use a for or a while loop to traverse the array cities
    // The algorithm maintains two subarrays in the given array cities:
    // 1) The subarray which is already sorted from index 0 to index i.
    // 2) Remaining subarray which is unsorted starting from index i to the end of the array.
    // TODO In every iteration i, get the minimum element from the unsorted subarray
    // and swap it with the element at index i.
    
    String[] sortedCities = new String[cities.length];
    
    for(int i = 0; i < cities.length; i++) {
      swap(sortedCities, i, getMinimum(cities, i));
    }



  }

  /**
   * Swaps elements at indexes i and j of an array
   * 
   * @param data array of strings
   * @param i    an index
   * @param j    another index
   * @throws ArrayIndexOutOfBoundsException if i or j are out of bounds of the range of indexes from
   *                                        0 .. data.length-1
   */
  private static void swap(String[] data, int i, int j) {
    String x = data[i];
    data[i] = data[j];
    data[j] = x;
  }


  /**
   * One short and simple test for the sortFileNames() method.
   * 
   * @return true when this test passes, otherwise false
   */
  public static boolean test() {
    // TODO create an unsorted perfect size array which contains at least 6 different
    // city names (strings)
    String[] cities = new String[]{"New York", "Chicago", "Milwaukee", "Madison", "Miami", "Los Angeles"};

    // TODO create a new array representing the expected output: a sorted version
    // of the above unsorted one
    String[] expected = new String[]{"Chicago", "Los Angeles", "Madison", "Miami", "Milwaukee", "New York"};

    // TODO call sortCityNames method to sort the unsorted array
    sortCityNames(cities);

    // TODO compare the result with the expected sorted array; return true if they are
    // equals and false otherwise.
    // You can use Arrays.deepEquals(String[], String[]) methods to check whether two arrays are
    // equals
    if(Arrays.deepEquals(cities, expected)) {
      return true;
    }

    return false; // CHANGE this (added to avoid compile errors)
  }

  /**
   * Driver for the test method above.
   * 
   * @param args is unused
   */
  public static void main(String[] args) {
    System.out.println("test(): " + test());
  }

}
