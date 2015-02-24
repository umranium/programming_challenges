/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

/**
 *
 * @author umran
 */
public class JumpingJack {
  
  static final int[] sums = computeSums(2000);

  static int[] computeSums(int N) {
    int[] s = new int[N+1];
    for (int i = 1; i <= N; ++i) {
      s[i] = s[i-1] + i;
    }
    return s;
  }
  
  static int maxStep(int N, int K) {
    //  find the furthest step before we reach missing step at distance K
    int largestActionsBelowK = N;
    while (largestActionsBelowK >= 1) {
      if (sums[largestActionsBelowK]<K) break;
      --largestActionsBelowK;
    }
    
    int dist = sums[N];
    
    //  if we're going to hit the missing step at distance K,
    if (sums[largestActionsBelowK+1]==K) {
      // then skip the first step
      --dist;
    }
    
//    System.out.println("dist = " + dist);
    
    return dist;
  }

  public static void main(String[] args) {
    maxStep(2, 1);
  }
}
