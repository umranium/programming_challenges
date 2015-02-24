/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author umran
 */
public class Pairs {
  
  public static void main(String[] args) throws FileNotFoundException {
//    Scanner in = new Scanner(new FileInputStream(new File("/Users/umran/Downloads/input014.txt")));
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int K = in.nextInt();
    
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = in.nextInt();
    }
    
    Arrays.sort(A);

    int count = 0;
    
    for (int start = 0; start < N; ++start) {
      for (int end = start+1; end < N; ++end) {
        if (A[end]-A[start]>=K) {
          if (A[end]-A[start]==K) {
            ++count;
          }
          break;
        }
      }
    }
    
    System.out.println(count);
  }
  
}
