/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 *
 * @author umran
 */
public class PowersOf2 {

  static int[] countTwos(int[] arr) {
    for (int i = 0; i < arr.length; ++i) {
      if (arr[i]==0 || Integer.bitCount(arr[i]) > 1) {
        arr[i] = 0;
      } else {
        arr[i] = 1;
      }
    }
    return arr;
  }

  public static void main(String[] args) {
//    System.out.println(Arrays.toString(countTwos(new int[]{2,3,4})));
//    System.out.println(Arrays.toString(countTwos(new int[]{1024,2048,1048576})));
    System.out.println(Arrays.toString(countTwos(new int[]{8,16,24,56,48,0,1,100,99})));
  }

  public static void xmain(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    final String fileName = System.getenv("OUTPUT_PATH");
    BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
    int[] res;

    int _arr_size = Integer.parseInt(in.nextLine());
    int[] _arr = new int[_arr_size];
    int _arr_item;
    for (int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
      _arr_item = Integer.parseInt(in.nextLine());
      _arr[_arr_i] = _arr_item;
    }

    res = countTwos(_arr);
    for (int res_i = 0; res_i < res.length; res_i++) {
      bw.write(String.valueOf(res[res_i]));
      bw.newLine();
    }

    bw.close();
  }
}
