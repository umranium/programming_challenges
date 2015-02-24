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
public class DieHard3 {
  
  private static long gcd(long a, long b) {
    while (b > 0) {
      long temp = b;
      b = a % b; // % is remainder
      a = temp;
    }
    return a;
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int i = 0; i < T; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();
      
      long gcd = gcd(a,b);
      if (c % gcd==0 && c<=Math.max(a,b)) {
        System.out.println("YES");
      } else {
        System.out.println("NO");        
      }
    }    
  }
  
}
