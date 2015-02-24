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
public class TheLoveLetterMystery {
  
  public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    in.nextLine();
    
    for (int i = 0; i < T; i++) {
      String s = in.nextLine();
      char[] a = s.toCharArray();
      
      int count = 0;
      
      for (int j=0; j<a.length/2; ++j) {
        int k = a.length - j - 1;
        
        count += Math.abs(a[j] - a[k]);
      }
      
      System.out.println(count);
      
    }
    
  }
  
}
