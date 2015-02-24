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
public class EmmaAndSquares {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    
    for (int i = 0; i < T ;++i) {
      int A = in.nextInt();
      int B = in.nextInt();
      
      int a = (int)Math.ceil(Math.sqrt(A));
      int b = (int)Math.floor(Math.sqrt(B));
      
      System.out.println((b-a+1));
    }
    
  }
  
}
