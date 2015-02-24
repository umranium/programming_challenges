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
public class UtopianTree {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t;
    int sum;
    long a;
    t = in.nextInt();
    for (int i = 0; i < t; i++) {
      a = in.nextInt();
      
      long h = 1;
      for (int j = 0; j < a; ++j) {
        if (j%2==0)
          h *= 2;
        else
          h += 1;
      }
      
      System.out.println(h);
    }
  }
}
