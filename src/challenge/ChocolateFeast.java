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
public class ChocolateFeast {
  
  
  private static int count(int n, int c, int m) {
    int t = 0;
    
    t = n / c;
    int w = t;
    
    while (w>=m) {
      int v = w / m;
      t += v;
      w %= m;
      w += v;
    }
    
    return t;
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t;
    t = in.nextInt();
    for (int i = 0; i < t; i++) {
      int n = in.nextInt();
      int c = in.nextInt();
      int m = in.nextInt();
      
      System.out.println(count(n,c,m));
    }
  }
  
}
