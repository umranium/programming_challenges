/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author umran
 */
public class AngryChildren {

  static int minUnfairness(int K, int[] A) {
    Arrays.sort(A);

    int minDiff = Integer.MAX_VALUE;
    for (int end = K; end <= A.length; ++end) {
      int start = end - K;

      int diff = A[end - 1] - A[start];
      if (diff < minDiff) {
        minDiff = diff;
      }
    }

    return minDiff;
  }

  public static void main(String[] args) {
    
    System.out.println(minUnfairness(3, new int[]{
10,
100,
300,
200,
1000,
20,
30,      
    }));

  }

}
