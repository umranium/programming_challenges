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
public class ValidBST {
  
  private static class CheckTree {
    int N;
    int[] A;
    int[][] rangeMax;
    int[][] rangeMin;

    public CheckTree(int N, int[] A) {
      this.N = N;
      this.A = A;
      
      this.rangeMax = new int[N][N];
      this.rangeMin = new int[N][N];
      
      for (int start = 0; start < N; ++start) {
        int maxSoFar = -1;
        int minSoFar = -1;
        
        for (int end = start; end < N; ++end) {
          if (end==start || A[end]>maxSoFar) {
            maxSoFar = A[end];
          }
          if (end==start || A[end]<minSoFar) {
            minSoFar = A[end];
          }
          
          rangeMax[start][end] = maxSoFar;
          rangeMax[end][start] = maxSoFar;
          rangeMin[start][end] = minSoFar;
          rangeMin[end][start] = minSoFar;
        }
      }
    }
    
    private String toStr(int start, int end) {
      return Arrays.toString(Arrays.copyOfRange(A, start, end+1));
    }
    
    public boolean isValid(int start, int end) {
      if (end-start+1<=2) // if there are fewer than 2 elements in the array, they can be searchable binary trees
        return true;
      
      // iterate through all split points, making sure there's at least one
      //  point where all the elements of the left segment are smaller
      //  than the root, and all the elements of the right segment are
      //  larger than the root.
      int root = A[start];
      for (int splitPoint = start; splitPoint <= end; ++splitPoint) {
        int sLeft = start+1;
        int eLeft = splitPoint;
        int sRight = splitPoint+1;
        int eRight = end;
        
//        System.out.println("  root="+root+", left="+toStr(sLeft, eLeft)+", right="+toStr(sRight, eRight));
        
        boolean isOk = true;
        if (sLeft<=eLeft && rangeMax[sLeft][eLeft]>root) {
//          System.out.println(" >> root="+root+",  left "+toStr(sLeft, eLeft)+" max too large");
          isOk = false;
        }
        if (isOk && sRight<=eRight && rangeMin[sRight][eRight]<root) {
//          System.out.println(" >> root="+root+",  right "+toStr(sRight, eRight)+" min too small");
          isOk = false;
        }
        
        // if this split point looks ok overall, check subtrees
        if (isOk && sLeft<eLeft && !isValid(sLeft, eLeft)) {
          isOk = false;
        }
        if (isOk && sRight<eRight && !isValid(sRight, eRight)) {
          isOk = false;
        }
        
        //  split is ok
        if (isOk) {
//          System.out.println(" >> root="+root+", left="+toStr(sLeft, eLeft)+", right="+toStr(sRight, eRight)+" is ok");
          return true;
        }
      }
      
      return false;
    }
    
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    
    for (int t = 0; t < T; t++) {
      int N = in.nextInt();
      int[] A = new int[N];
      for (int n = 0; n < N; n++) {
        A[n] = in.nextInt();
      }
      
      CheckTree tree = new CheckTree(N, A);
      if (tree.isValid(0, N-1)) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
    
  }
  
}
