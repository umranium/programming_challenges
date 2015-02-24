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
public class BitCounting {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long n = in.nextLong();
    
    char[] str = Long.toBinaryString(n).toCharArray();
    
//    System.out.println(Arrays.toString(str));
    
    System.out.println(Long.bitCount(n));
    
    
    int msb = -1;
    for (int i = 0; i < str.length; ++i) {
      char t = str[i];
      if (t=='1') {
        if (msb<0) {
          msb = i;
        }
        System.out.println((i-msb)+1);
      }
    }
  }
}
