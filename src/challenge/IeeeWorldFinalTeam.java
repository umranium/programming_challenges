/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author umran
 */
public class IeeeWorldFinalTeam {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int M = in.nextInt();
    in.nextLine();
    
    BigInteger[] A = new BigInteger[N];
    for (int i = 0; i < N; i++) {
      A[i] = in.nextBigInteger(2);
    }
    
    int[] countTopicHist = new int[M+1];
    int countTopicHistMax = 0;
    
    for (int i = 0; i < A.length; ++i) {
      BigInteger A1 = A[i];
      for (int j = i+1; j < A.length; ++j) {
        BigInteger A2 = A[j];
        
        BigInteger A1A2 = A1.or(A2);
        
//        System.out.println(">> "+A1.toString(2));
//        System.out.println("or "+A2.toString(2));
//        System.out.println("=  "+A1A2.toString(2));
        
        int countTopics = A1A2.bitCount();
//        System.out.println("   "+countTopics);
        ++countTopicHist[countTopics];
        
        if (countTopics>countTopicHistMax) {
          countTopicHistMax = countTopics;
        }
      }
    }
    
    System.out.println(countTopicHistMax);
    System.out.println(countTopicHist[countTopicHistMax]);
   
  }
  
}
