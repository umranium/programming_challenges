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
public class CalculateFactorial {
  
  public static void main(String[] args) {
    int N = 15;
    long[] fact = new long[N+1];
    
    fact[1] = 1;
    for (int i = 2; i <= N; ++i) {
      fact[i] = fact[i-1] * i;
    }
    
    
    Scanner in = new Scanner(System.in);
    int x = in.nextInt();
    while (x>=0) {
      System.out.println(fact[x]);
      x = in.nextInt();
    }
  }
  
}
