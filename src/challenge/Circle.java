/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author umran
 */
public class Circle {
  
  private static class Parser {
     final private int BUFFER_SIZE = 1 << 16;

     private DataInputStream din;
     private byte[] buffer;
     private int bufferPointer, bytesRead;

     public Parser(InputStream in)
     {
        din = new DataInputStream(in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
     }

     public int nextInt() throws Exception
     {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = c == '-';
        if (neg) c = read();
        do
        {
           ret = ret * 10 + c - '0';
           c = read();
        } while (c > ' ');
        if (neg) return -ret;
        return ret;
     }

     private void fillBuffer() throws Exception
     {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1) buffer[0] = -1;
     }

     private byte read() throws Exception
     {
        if (bufferPointer == bytesRead) fillBuffer();
        return buffer[bufferPointer++];
     }
  }  
  
  private static class DirectComp implements Comparator<int[]> {
    
    int d;

    public DirectComp(int d) {
      this.d = d;
    }
    
    @Override
    public int compare(int[] o1, int[] o2) {
      return Integer.compare(o1[d], o2[d]);
    }
  }
  
  private static final int RAD = 0;
  private static final int COST = 1;
  private static final int ID = 2;
  private static final int MIN_COST_ID = 3;
  
  private static class CircleData {
    int N, D;
    int[] R;
    int[] C;
    int[][] rSorted;
    DirectComp compRad = new DirectComp(RAD);

    public CircleData(int N, int D) {
      this.N = N;
      this.D = D;
    }

    public void read(Parser in) throws Exception {
      R = new int[N];
      C = new int[N];
      rSorted = new int[N][4];

      for (int j = 0; j < N; ++j) {
        R[j] = in.nextInt();

        rSorted[j][RAD] = R[j];
        rSorted[j][ID] = j;
      }

      for (int j = 0; j < N; ++j) {
        C[j] = in.nextInt();
        rSorted[j][COST] = C[j];
      }

      Arrays.sort(rSorted, compRad);

      int bestSoFar = -1;
      for (int j = N-1; j >= 0; --j) {
        if (bestSoFar<0 || rSorted[j][COST]<rSorted[bestSoFar][COST]) {
          bestSoFar = j;
        } else {
          if (rSorted[j][COST]==rSorted[bestSoFar][COST]) {
            if (rSorted[j][RAD]>rSorted[bestSoFar][RAD]) {
              bestSoFar = j;
            } else {
              if (rSorted[j][RAD]==rSorted[bestSoFar][RAD]) {
                if (rSorted[j][ID]<rSorted[bestSoFar][ID]) {
                  bestSoFar = j;
                }
              }
            }
          }
        }
        rSorted[j][MIN_COST_ID] = bestSoFar;
      }
    }

    public int findRad(int r) {    
      int search = Arrays.binarySearch(rSorted, new int[]{D-r}, compRad);

      if (search<0) {
        // not found: search = -(insertion point) - 1
        search = -(search + 1);

        search = Math.max(Math.min(search, N-1), 0);
      }

      if (r+rSorted[search][RAD]<D && r+rSorted[N-1][RAD]<D) {
  //      System.out.println(">> not found");
        return 0;
      }

      int minCostSorted = rSorted[search][MIN_COST_ID];

      return rSorted[minCostSorted][ID]+1;
    }
    
  }
  
  
  
  
  
  public static void main(String[] args) throws Exception {
    
//    Parser in = new Parser(new FileInputStream(new File("/Users/umran/Downloads/input001.txt")));
//    Parser in = new Parser(new FileInputStream(new File("/Users/umran/Downloads/input013.txt")));
    Parser in = new Parser(System.in);
    
    int N = in.nextInt();
    int D = in.nextInt();
    
    CircleData circle = new CircleData(N, D);
    circle.read(in);
    
//    System.out.println("N="+N+", D="+D);
    
    for (int i = 0; i < N; ++i) {
//      System.out.println(">> "+circle.R[i]+","+circle.C[i]);
      if (i>0) System.out.print(" ");
      System.out.print(circle.findRad(circle.R[i]));
    }
    
    System.out.println();
    
    
  }
  
}
