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
public class ServiceLane {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int T = in.nextInt();
    
    int[] width = new int[N];
    for (int i = 0; i < N; i++) {
      width[i] = in.nextInt();
    }
    
    for (int i = 0; i < T; i++) {
      int start = in.nextInt();
      int end = in.nextInt();
      
      int min = 3;
      for (int j = start; j <= end; ++j) {
        if (width[j]<min) {
          min = width[j];
        }
      }
      
      System.out.println(min);
    }    
  }
  
}
