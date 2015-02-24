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
public class IsItPossible {
  
  static String isitpossible(int a, int b, int c, int d) {
    while (c>=a && d>=b) {
      
      if (c==a && d==b) {
        return "Yes";
      }
      
      if (c<d) {
        d -= c;
      } else {
        c -= d;
      }
    }
    
    return "No";
  }

  public static void main(String[] args) {
    System.out.println(isitpossible(1, 4, 5, 9));
  }

}
