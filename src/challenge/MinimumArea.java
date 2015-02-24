/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author umran
 */
public class MinimumArea {

  
  private static class CompNei implements Comparator<int[]> {
    
    double[][] distMat;
    int src;

    public CompNei(double[][] distMat) {
      this.distMat = distMat;
    }
    
    @Override
    public int compare(int[] o1, int[] o2) {
      return Double.compare(distMat[src][o1[0]], distMat[src][o2[0]]);
    }
    
  }

  static int minarea(int[] x, int[] y, int K) {
    int N = x.length;
    double[][] distMat = new double[N][N];
    
    for (int i = 0; i < N; ++i) {
      for (int j = i+1; j < N; ++j) {
        int dx = Math.abs(x[i]-x[j])+1;
        int dy = Math.abs(y[i]-y[j])+1;
        distMat[i][j] = distMat[j][i] = Math.sqrt(dx*dx + dy*dy);
      }
    }
    
    CompNei compNei = new CompNei(distMat);
    int minArea = Integer.MAX_VALUE;
    
    for (int i = 0; i < N; ++i) {
      int[][] closestNeighbours = new int[N][1];
    
      for (int j = 0; j < N; ++j) {
        closestNeighbours[j] = new int[] {j};
      }
      
      compNei.src = i;
      Arrays.sort(closestNeighbours, compNei);
      
      int minX=Integer.MAX_VALUE, maxX=Integer.MIN_VALUE;
      int minY=Integer.MAX_VALUE, maxY=Integer.MIN_VALUE;
      int areaSoFar = 0;
      
//      System.out.println(" from "+x[i]+","+y[i]);
      
      for (int j = 0; j < K; ++j) {
        int n = closestNeighbours[j][0];
        
        if (x[n]<minX) minX = x[n];
        if (x[n]>maxX) maxX = x[n];
        if (y[n]<minY) minY = y[n];
        if (y[n]>maxY) maxY = y[n];
        
        int w = (maxX-minX+2);
        int h = (maxY-minY+2);
        
        if (w<h) w=h;
        if (h<w) h=w;
        
        areaSoFar = w*h;
        
//        System.out.println("   "+x[n]+","+y[n]+" "+areaSoFar);
        
        if (areaSoFar>minArea) {
          break;
        }
      }
      
      if (areaSoFar<minArea) {
        minArea = areaSoFar;
      }
    }
    
//    System.out.println(minArea);
    
    return minArea;
  }

  public static void main(String[] args) {
    minarea(new int[]{0,2}, new int[]{0,4}, 2);
  }
}
