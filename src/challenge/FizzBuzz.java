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
public class FizzBuzz {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for (int i = 1; i <= n; ++i) {
      boolean b3 = i % 3 == 0;
      boolean b5 = i % 5 == 0;
      
      if (b3 && b5) {
        System.out.println("FizzBuzz");
      } else {
        if (b3 || b5) {
          if (b3)
            System.out.println("Fizz");
          else
            System.out.println("Buzz");
        } else {
          System.out.println(i);
        }
      }
    }
    
  }
}
