/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.util.Scanner;

/**
 *
 * @author umran
 */
public class SumThemAll {

  static long sumOfIntegers(int[] arr) {
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }    

    return sum;
  }
  
  
  public static void main(String[] args) {
    System.out.println(sumOfIntegers(new int[]{
1,
2,
3,
4,
5,      
    }));
  }
}
