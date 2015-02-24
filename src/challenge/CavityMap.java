/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.util.Arrays;

/**
 *
 * @author umran
 */
public class CavityMap {

  static String[] cavityMap(int[] arr) {
    int N = arr.length;
    
    int[][] mp = new int[N][N];
    
    for (int r = 0; r < N; ++r) {
      int x = arr[r];
      
      for (int c = 0; c < N; ++c) {
        mp[r][N-c-1] = x % 10;
        x /= 10;
      }
    }
    
    char[][] res = new char[N][N];
    
    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < N; ++c) {
        res[r][c] = (char)('0' + mp[r][c]);
      }
    }
    
    for (int r = 1; r < N-1; ++r) {
      for (int c = 1; c < N-1; ++c) {
        if (mp[r][c]>mp[r-1][c] && mp[r][c]>mp[r+1][c]
          && mp[r][c]>mp[r][c+1] && mp[r][c]>mp[r][c+1]) {
          res[r][c] = 'X';
        } else {
          res[r][c] = (char)('0' + mp[r][c]);
        }
      }
    }
    
    String[] str = new String[N];
    for (int r = 0; r < N; ++r) {
      str[r] = new String(res[r]);
    }
    
    return str;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(cavityMap(
      new int[] {
      }
    )));
  }
}
