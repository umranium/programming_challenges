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
public class AddFractions {

  private static int gcd(int a, int b) {
    while (b > 0) {
      int temp = b;
      b = a % b; // % is remainder
      a = temp;
    }
    return a;
  }

  static String[] fractionSum(String[] str) {

    for (int i = 0; i < str.length; ++i) {
      Scanner in = new Scanner(str[i]);
      in.useDelimiter("[\\s+/+]");

      // x/y + u/v
      int x = in.nextInt();
      int y = in.nextInt();
      int u = in.nextInt();
      int v = in.nextInt();

      int _x = x;
      int _y = y;
      int _u = u;
      int _v = v;

      _x *= v;
      _y *= v;
      _u *= y;
      _v *= y;

      _x += _u;

      int gcd = gcd(_x, _y);

      _x /= gcd;
      _y /= gcd;

      str[i] = _x + "/" + _y;
    }

    return str;
  }

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
    fractionSum(new String[]{
      "722/148+360/176",
      "978/1212+183/183",
      "358/472+301/417",
      "780/309+684/988",
      "258/840+854/686",
    })
    ));
  }

}
