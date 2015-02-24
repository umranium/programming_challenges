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
public class GemStones {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    in.nextLine();
    
    int[] counts = new int['z' - 'a' + 1];
    boolean[] counted = new boolean['z' - 'a' + 1];
    
    for (int i = 0; i < N; i++) {
      char[] a = in.nextLine().trim().toCharArray();
      
      Arrays.fill(counted, false);
      
      for (int j = 0; j < a.length; ++j) {
        char b = a[j];
        if (!counted[b - 'a']) {
          ++counts[b - 'a'];
          counted[b - 'a'] = true;
        }
      }
    }
    
    int countGemElement = 0;
    for (int i = 0; i < counts.length; ++i) {
      if (counts[i]==N) {
        ++countGemElement;
      }
    }
    
    System.out.println(countGemElement);
  }
  
}
