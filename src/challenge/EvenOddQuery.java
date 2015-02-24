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
public class EvenOddQuery {
  
  public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = in.nextInt();
    }
    
    int Q = in.nextInt();
    for (int i = 0; i < Q; ++i) {
      int x = in.nextInt() - 1;
      int y = in.nextInt() - 1;
  
//      System.out.println((v%2)+","+(A[x]%2));
      
      if (x+1<N && x<y && A[x+1]==0) {
        //  Any number to power 0 is 1
        System.out.println("Odd");
      } else {
        if (A[x]%2==0)
          System.out.println("Even");
        else
          System.out.println("Odd");
      }
    }

  }
  
}
