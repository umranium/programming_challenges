/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author umran
 */
public class FillingJars {
 
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int M = in.nextInt();
    
    long sum = 0;
    
    for (int i = 0; i < M; ++i) {
      long a = in.nextInt();
      long b = in.nextInt();
      long k = in.nextInt();
      
      sum += (Math.abs(a-b)+1)*k;
      
    }
    
    System.out.println((long)(sum/N));
    
  }
  
}
