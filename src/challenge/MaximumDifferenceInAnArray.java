/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

/**
 *
 * @author umran
 */
public class MaximumDifferenceInAnArray {

  static int maxDifference(int[] a) {

    int[] maxToEnd = new int[a.length]; // the maximum from an element to the end of a, inclusive.

    int maxSoFar = -1;
    for (int i = a.length - 1; i >= 0; --i) {
      if (maxSoFar < 0 || a[i] > maxSoFar) {
        maxSoFar = a[i];
      }
      maxToEnd[i] = maxSoFar;
    }

    int bsfDiff = -1;
    int minSoFar = Integer.MAX_VALUE;
    for (int i = 0; i < a.length - 1; ++i) {
      if (a[i] < minSoFar) {
        minSoFar = a[i];
      }

      int diff = maxToEnd[i + 1] - minSoFar;

      if (diff > bsfDiff) {
        bsfDiff = diff;
      }
    }

    return bsfDiff;
  }

  public static void main(String[] args) {
    System.out.println(maxDifference(
      new int[] {
        7,9,5,6,3,2
      }
    ));
  }

}
