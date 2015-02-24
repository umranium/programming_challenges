/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author umran
 */
public class Challenge {
  
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
  
  public static void xmain(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    in.nextLine();
    for (int i = 0; i < t; i++) {
      String s = in.nextLine();
      char[] a = s.toCharArray();
      
      int count = 0;
      
      for (int j=0; j<a.length/2; ++j) {
        int k = a.length - j - 1;
        
        count += Math.abs(a[j] - a[k]);
      }
      
      System.out.println(count);
    }
  }

  public static void ymain(String[] args) {
    Scanner in = new Scanner(System.in);
    int t, k;
    t = in.nextInt();
    k = in.nextInt();
    int[] a = new int[t];
    for (int i = 0; i < t; i++) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a);
    
    int minDiff = Integer.MAX_VALUE;
    for (int end=k; end<=t; ++end) {
      int start = end-k;
      
      int diff = a[end-1] - a[start];
      if (diff<minDiff) {
        minDiff = diff;
      }
    }
    
    System.out.println(minDiff);
  }
}
