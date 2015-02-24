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
public class NumberComponent {

  static int getIntegerComplement(int n) {
    int mask = 0;
    while (mask<n) {
      mask <<= 1;
      mask |= 1;
    }
    
    
    int res = n ^ mask;
    
//    System.out.println(Integer.toBinaryString(n));
//    System.out.println(Integer.toBinaryString(mask));
//    System.out.println(Integer.toBinaryString(res));
    
    return res;
  }

  public static void main(String[] args) {
    getIntegerComplement(50);
  }

}
