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
public class Anagram {
  
  private static int isAnagram(char[] A, int midPoint) {
    int[] hist = new int['z' - 'a' + 1];
    
    for (int i = 0; i < midPoint; ++i) {
      ++hist[A[i]-'a'];
    }
    
    for (int i = midPoint; i < A.length; ++i) {
      --hist[A[i]-'a'];
    }
    
    int sumPos = 0;
    for (int i = 0; i < hist.length; ++i) {
      if (hist[i]>0) {
        sumPos += hist[i];
      }
//      System.out.println((char)('a'+i)+":"+hist[i]);
    }
    
    return sumPos;
  }
  
  public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    in.nextLine();
    for (int i = 0; i < T; i++) {
      String s = in.nextLine();
      char[] A = s.toCharArray();
      
      if (A.length%2!=0) {
        System.out.println("-1");
      } else {
        System.out.println(isAnagram(A, A.length/2));
      }
    }
    
  }
  
}
