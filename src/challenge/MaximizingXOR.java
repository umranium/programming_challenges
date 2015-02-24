/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

/**
 *
 * @author umran
 */
public class MaximizingXOR {

  static int maxXor(int l, int r) {

    int c, maxC = 0;
    for (int a = l; a <= r; ++a) {
      for (int b = a; b <= r; ++b) {
        c = a ^ b;
        if (c>maxC) {
          maxC = c;
        }
      }
    }

    return maxC;
  }

  public static void main(String[] args) {

  }
}
