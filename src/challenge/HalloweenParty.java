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
public class HalloweenParty {
 
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    
    for (int i = 0; i < T ;++i) {
      int K = in.nextInt();
      
      long a = K/2;
      long b = K - a;
      
      System.out.println(a*b);
    }
    
  }
  
}
