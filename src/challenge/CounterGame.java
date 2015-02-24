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
public class CounterGame {
  
  public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int i = 0; i < T; i++) {
      BigInteger N = in.nextBigInteger();
      
      int count = 0;
      while (!N.equals(BigInteger.ONE)) {
        // check whether N is a power of 2
        if (N.bitCount()==1) {
          N = N.shiftRight(1);
        } else {
          N = N.flipBit(N.bitLength()-1);
        }
        ++count;
      }
      
      if (count%2==0) {
        System.out.println("Richard");
      } else {
        System.out.println("Louise");
      }
    }
    
  }
  
}
