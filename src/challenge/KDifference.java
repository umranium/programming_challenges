/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author umran
 */
public class KDifference {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n, k;
    n = in.nextInt();
    k = in.nextInt();
    Set<Integer> a = new HashSet<Integer>(n);
    Set<Integer> b = new HashSet<Integer>(n);
    
    for (int i = 0; i < n; ++i) {
      int x = in.nextInt();
      a.add(x);
      b.add(x+k);
    }
    
    a.retainAll(b);
    
    System.out.println(a.size());
    
  }
}
