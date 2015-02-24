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
public class Puzzle {

  private static int[] holes = new int[] {
    1, //0
    0, //1
    0, //2
    0, //3
    1, //4
    0, //5
    1, //6
    0, //7
    2, //8
    1, //9
  };
  
  static int sovlePuzzle(int num) {
    int res = 0;
    while (num>0) {
      int d = num % 10;
      res += holes[d];
      num /= 10;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(sovlePuzzle(1288));
  }
}
