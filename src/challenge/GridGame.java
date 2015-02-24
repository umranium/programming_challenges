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
public class GridGame {
  
  private static class Range {
    int start, end;

    public Range(int start, int end) {
      this.start = start;
      this.end = end;
    }
    
    public Range intersect(Range other) {
      return new Range(
        Math.max(start,other.start),
        Math.min(end,other.end)
      );
    }
    
    public long getIncLen() {
      return end-start+1;
    }

    @Override
    public String toString() {
      return "Range{" + "start=" + start + ", end=" + end + '}';
    }
    
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    
    Range currentBestX = null;
    Range currentBestY = null;
    
    for (int i = 0; i < n; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      
      Range rangeX = new Range(1, a);
      Range rangeY = new Range(1, b);
      
      if (currentBestX==null) {
        currentBestX = rangeX;
        currentBestY = rangeY;
      } else {
        currentBestX = currentBestX.intersect(rangeX);
        currentBestY = currentBestY.intersect(rangeY);
      }
    }
    
    System.out.println(currentBestX.getIncLen()*currentBestY.getIncLen());
  }
  
}
