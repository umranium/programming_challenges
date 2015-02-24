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
public class SansaAndXOR {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int t = 0; t < T; ++t) {
      int N = in.nextInt();      
      long ans = 0;
      for (int n = 0; n < N; ++n) {
        int v = in.nextInt();
        long times = (long)(n+1)*(long)(N-n);
        if (times%2==1)
          ans ^= v;
      }
      System.out.println(ans);
    }
  }
  
}
