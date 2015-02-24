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
public class AlternatingCharacters {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t;
    t = in.nextInt();
    in.nextLine();
    for (int i = 0; i < t; i++) {
      String s = in.nextLine();
      char[] a = s.toCharArray();
      int del = 0;
      for (int j = 1; j < a.length; ++j) {
        if (a[j-1]==a[j]) {
          ++del;
        }
      }
      System.out.println(del);
    }
  }
}
