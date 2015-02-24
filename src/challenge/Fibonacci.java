/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.util.Arrays;

/**
 *
 * @author umran
 */
public class Fibonacci {

  static int[] fibonacci(int n) {
    int[] fib = new int[n];
    
    if (n>=2) {
      fib[1] = 1;
    }
    
    for (int i = 2; i < n; ++i) {
      fib[i] = fib[i-1] + fib[i-2];
    }
    
    return fib;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(fibonacci(4)));
  }

}
