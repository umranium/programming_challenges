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
public class PermDivBy8 {
  
  
  private static boolean check1(long[] N) {
    return N[0]%8==0;
  }
  
  private static boolean check2(long[][] setsOf2, long[] N) {
    for (int n=0; n<setsOf2.length; ++n) {
      long p = N[0]*setsOf2[n][0] +
              N[1]*setsOf2[n][1];
//      System.out.println(">>"+p);
      if (p%8==0) {
        return true;
      }
    }

    return false;
  }
  
  private static boolean check3(long[][] setsOf3, long[] N) {
    for (int j = 0; j < N.length; ++j) {
      for (int k = j+1; k < N.length; ++k) {
        for (int l = k+1; l < N.length; ++l) {
          for (int n=0; n<setsOf3.length; ++n) {
            long p = N[j]*setsOf3[n][0] +
                    N[k]*setsOf3[n][1] +
                    N[l]*setsOf3[n][2];
//            System.out.println(">>"+p);
            if (p%8==0) {
              return true;
            }
          }
        }
      }
    }

    return false;
  }
  
  public static void main(String[] args) {
    
    long[][] setsOf2 = new long[][] {
      {1,10},
      {10,1},
    };
    
    long[][] setsOf3 = new long[][] {
      {1,10,100},
      {1,100,10},
      {10,100,1},
      {10,1,100},
      {100,1,10},
      {100,10,1},
    };
    
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    in.nextLine();
    
    for (int i = 0; i < T ;++i) {
      String s = in.nextLine().trim();
      while (s.length()>1 && s.charAt(0)=='0') {
        s = s.substring(1);
      }
      
      char[] N_str = s.toCharArray();
      long[] N = new long[N_str.length];
      
      for (int j = 0; j < N.length; ++j) {
        N[j] = N_str[j] - '0';
      }
      
      boolean is = false;
      if (N.length==1) {
        is = check1(N);
      }
      if (N.length==2) {
        is = check2(setsOf2,N);
      }
      if (N.length>=3) {
        is = check3(setsOf3,N);
      }
      
      if (is) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
      
    }
    
  }
  
}
