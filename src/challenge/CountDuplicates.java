/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author umran
 */
public class CountDuplicates {

  static int countDuplicates(int[] numbers) {

    Map<Integer,Integer> b = new HashMap<Integer,Integer>(numbers.length);
    
    for (int i = 0; i < numbers.length; ++i) {
      int number = numbers[i];
      
      int count = 0;
      if (b.containsKey(number)) {
        count = b.get(number);
      }
      
      ++count;
      
      b.put(number, count);
    }
    
    int count = 0;
    for (Map.Entry<Integer,Integer> e:b.entrySet()) {
      if (e.getValue()>1) {
        ++count;
      }
    }
    
    return count;
  }

  public static void main(String[] args) {
    System.out.println(countDuplicates(
      new int[] {
1,
3,
1,
4,
5,
6,
3,
2,
      }
    ));
  }

}
