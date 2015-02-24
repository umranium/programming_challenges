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
public class Music {
  
  //site's test cases had a problem. contacted support.
  
  static int numOfPlaylist(int N, int K, int L) {
    int totalOpts = 1;
    int opts = N;
    
    for (int i = 0; i < L; ++i) {
      System.out.println("  "+opts);
      
      totalOpts *= opts;
      totalOpts %= 1000000007;
      
      if (i<K) {
        --opts;
      }
    }
    
    return totalOpts;
  }

  public static void main(String[] args) {
    System.out.println(numOfPlaylist(4, 0, 4));
  }
}
