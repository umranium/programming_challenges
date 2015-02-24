/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author umran
 */
public class PascalsTriangle {
  
  public static void main(String[] args) {
    
    int MX = 1000;
    long[][] values = new long[2][MX];
    int current=0, prev=1, tmp;
    
    Scanner in = new Scanner(System.in);
    int K = in.nextInt();
    
    for (int r = 1; r <= K; ++r) {
      for (int c = 1; c <= r; ++c) {
        if (r==1)
          values[current][c] = 1;
        else {
          values[current][c] = values[prev][c];
          if (c>1) {
            values[current][c] += values[prev][c-1];
          }
        }
      }
      
      for (int c = 1; c <= r; ++c) {
        if (c>1)
          System.out.print(" ");
        System.out.print(values[current][c]);
      }
      System.out.println();
      
      tmp = current;
      current = prev;
      prev = tmp;
    }
    
  }
  
}
