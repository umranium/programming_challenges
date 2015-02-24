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
public class GameOfThrones {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    char[] a = in.nextLine().toCharArray();
    
    int[] counts = new int['z'-'a'+1];
    for (int i = 0; i < a.length; ++i) {
      ++counts[a[i]-'a'];
    }
    
    int countOdd = 0;
    for (int i = 0; i < counts.length; ++i) {
      if (counts[i]%2==0)
        continue;
      ++countOdd;
      if (countOdd>1) {
        System.out.println("NO");
        return;
      }
    }
    
    System.out.println("YES");
  }
  
}
