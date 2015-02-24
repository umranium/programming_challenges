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
public class ReduceTheFraction {
  
  private static int gcd(int a, int b) {
    while (b > 0) {
      int temp = b;
      b = a % b; // % is remainder
      a = temp;
    }
    return a;
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    in.useDelimiter("[\\s+/]");
    int n = in.nextInt();
    
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      
      int gcd = gcd(x,y);
      
      x /= gcd;
      y /= gcd;
      
      System.out.println(x+"/"+y);
    }
    
  }
  
}
