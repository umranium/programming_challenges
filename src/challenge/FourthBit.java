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
public class FourthBit {

  static int fourthBit(int num) {
    return (num & 0b1000) >> 3;
  }

  public static void main(String[] args) {
    System.out.println(fourthBit(77));
  }
}
