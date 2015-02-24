/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author umran
 */
public class ListMax {
  //NOTE: timed-out
  
  private static class Range {
    int start, end;
    long value;

    public Range(int start, int end, long value) {
      this.start = start;
      this.end = end;
      this.value = value;
    }
    
    public boolean intersects(Range other) {
      return this.start<=other.end && this.end>=other.start;
    }
    
    public boolean isInside(Range other) {
      return this.start>=other.start && this.end<=other.end;
    }
    
    public Range intersection(Range other, long value) {
      return new Range(Math.max(this.start,other.start), Math.min(this.end,other.end), value);
    }
    
    public boolean has(int a) {
      return a>=start && a<=end;
    }
    
    public static Range merge(Range a, Range b, long value) {
      return new Range(Math.min(a.start,b.start), Math.max(a.end,b.end), value);
    }

    @Override
    public String toString() {
      return "["+start+","+end+"="+value+"]";
    }
    
  }
  
  private static class RangeTreeNode {
    RangeTreeNode parent;
    Range combinedRange;
    RangeTreeNode leftRange;
    RangeTreeNode rightRange;
    
    public RangeTreeNode(RangeTreeNode parent, Range combinedRange) {
      this.parent = parent;
      this.combinedRange = combinedRange;
      this.leftRange = null;
      this.rightRange = null;
    }
    
    public Range getCombinedRange() {
      return combinedRange;
    }
    
    public void setLeftRightRange(RangeTreeNode leftRange, RangeTreeNode rightRange) {
      if (leftRange==null || rightRange==null) {
        throw new RuntimeException(" left="+leftRange+", right="+rightRange);
      }
      this.leftRange = leftRange;
      this.rightRange = rightRange;
      this.combine();
    }

    private void combine() {
//      System.out.println("  updating combined range of "+this);
      Range a = leftRange.getCombinedRange();
      Range b = rightRange.getCombinedRange();
      this.combinedRange = Range.merge(a, b, Math.max(a.value,b.value));
    }
    
    public void updateCombinedRangeDown() {
      if (this.leftRange==null || this.leftRange==null) {
        return;
      }
      
      if (this.leftRange!=null)
        this.leftRange.updateCombinedRangeDown();
      if (this.rightRange!=null)
        this.rightRange.updateCombinedRangeDown();
      this.combine();
    }
    
    private void addValues(Range newRange) {
      if (!this.combinedRange.intersects(newRange)) {
        return;
      }
      if (this.leftRange==null && this.rightRange==null) {
        this.combinedRange.value += newRange.value;
      } else {
        if (this.leftRange!=null)
          this.leftRange.addValues(newRange);
        if (this.rightRange!=null)
          this.rightRange.addValues(newRange);
      }
    }
    
    public void updateStructure(Range newRange) {
      if (!this.combinedRange.intersects(newRange)) {
        return;
      }
      
      if (this.leftRange!=null || this.rightRange!=null) {
        if (this.leftRange!=null && this.leftRange.combinedRange.intersects(newRange)) {
          this.leftRange.updateStructure(newRange);
        }
        if (this.rightRange!=null && this.rightRange.combinedRange.intersects(newRange)) {
          this.rightRange.updateStructure(newRange);
        }
        return;
      }
      
      if (this.combinedRange.isInside(newRange)) {
        this.combinedRange.value += newRange.value;
        return;
      }
      
      //splitting
      Range intersection = combinedRange.intersection(newRange, newRange.value+combinedRange.value);
      Range left = null;
      Range right = null;
      
      if (combinedRange.start<intersection.start) {
        left = new Range(combinedRange.start, intersection.start-1, combinedRange.value);
      }
      if (combinedRange.end>intersection.end) {
        right = new Range(intersection.end+1, combinedRange.end, combinedRange.value);
      }
      
      if (left==null && right==null) {
        throw new RuntimeException("Both left and right are null.");
      }
      
      RangeTreeNode leftNode = null;
      RangeTreeNode rightNode = null;
        
      //  split into three
      if (left!=null && right!=null) {
        
        double mid = (combinedRange.start+combinedRange.end) / 2.0;
        if (mid-intersection.start>mid-intersection.end) {
          //  left piece is larger
          leftNode = new RangeTreeNode(null, null);
          leftNode.setLeftRightRange(
            new RangeTreeNode(leftNode, left),
            new RangeTreeNode(leftNode, intersection));
          
          rightNode = new RangeTreeNode(null, right);
        } else {
          //  right piece is larger
          leftNode = new RangeTreeNode(null, left);
          
          rightNode = new RangeTreeNode(null, null);
          rightNode.setLeftRightRange(
            new RangeTreeNode(rightNode, intersection),
            new RangeTreeNode(rightNode, right));
        }
      } else {
        // split into two
        if (left!=null) {
          leftNode = new RangeTreeNode(null, left);
          rightNode = new RangeTreeNode(null, intersection);
        }
        if (right!=null) {
          leftNode = new RangeTreeNode(null, intersection);
          rightNode = new RangeTreeNode(null, right);
        }
      }
      
      leftNode.parent = this;
      rightNode.parent = this;
      this.setLeftRightRange(leftNode, rightNode);
    }
    
    @Override
    public String toString() {
      if (leftRange==null && rightRange==null) {
        return this.combinedRange.toString();
      } else {
        return "{"+leftRange.toString()+","+rightRange.toString()+"}";
      }
    }
    
  }
  
  private static class RangeTreeNodeDepth {
    RangeTreeNode node;
    int depth;

    public RangeTreeNodeDepth(RangeTreeNode node, int depth) {
      this.node = node;
      this.depth = depth;
    }
    
  }
  
  public static void main(String[] args) throws FileNotFoundException {
//    Scanner in = new Scanner(new FileInputStream(new File("/Users/umran/Downloads/input013.txt")));
    Scanner in = new Scanner(System.in);
    
    int N = in.nextInt();
    int M = in.nextInt();
    RangeTreeNode root = new RangeTreeNode(null, new Range(0, N, 0));
    
//    System.out.println(" read:");
    int[][] updates = new int[M][3];
    for (int i = 0; i < M; i++) {
      int A = in.nextInt();
      int B = in.nextInt();
      int K = in.nextInt();
      
      updates[i][0] = A;
      updates[i][1] = B;
      updates[i][2] = K;
    }
    
//    System.out.println(" sort:");
    Arrays.sort(updates, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        int v = Integer.compare(o1[0], o2[0]);
        if (v==0) {
          v = Integer.compare(o1[1], o2[1]);
        }
        return v;
      }
    });
    
//    System.out.println(" build:");
    RangeTreeNode currentRoot = root;
    for (int i = 0; i < M; i++) {
      int A = updates[i][0];
      int B = updates[i][1];
      int K = updates[i][2];
      
      if (currentRoot.leftRange!=null &&
        currentRoot.rightRange!=null &&
        !currentRoot.leftRange.combinedRange.has(A)) {
        currentRoot = currentRoot.rightRange;
      }
      
//      if (i%1000==0)
//        System.out.println(" "+i+"/"+M);
      
      currentRoot.updateStructure(new Range(A, B, K));
    }
    
//    System.out.println("build complete");
    root.updateCombinedRangeDown();
//    System.out.println("combine complete");
    
//    System.out.println(root.toString());
    System.out.println(root.getCombinedRange().value);
    
  }
  
}
