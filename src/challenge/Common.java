/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author umran
 */
public class Common {

  private static long gcd(long a, long b) {
    while (b > 0) {
      long temp = b;
      b = a % b; // % is remainder
      a = temp;
    }
    return a;
  }

  private static long gcd(long[] input) {
    long result = input[0];
    for (int i = 1; i < input.length; i++) {
      result = gcd(result, input[i]);
    }
    return result;
  }

  private static long lcm(long a, long b) {
    return a * (b / gcd(a, b));
  }

  private static long lcm(long[] input) {
    long result = input[0];
    for (int i = 1; i < input.length; i++) {
      result = lcm(result, input[i]);
    }
    return result;
  }
  
  public interface SetFactory<E> {
      Set<E> createSet();
  }
  
  public static <E> List<Set<E>> computePowerSet(Set<E> set, SetFactory<E> setFactory) {
      List<Set<E>> list = new ArrayList<>();

      if (set.isEmpty()) {
          Set<E> emptySet = setFactory.createSet();
          list.add(emptySet);
          return list;
      }

      E first = set.iterator().next();

      set.remove(first);

      List<Set<E>> subsets = computePowerSet(set, setFactory);

      for (Set<E> subset : subsets) {
          Set<E> copy = setFactory.createSet();
          copy.addAll(subset);
          copy.add(first);

          list.add(subset);
          list.add(copy);
      }

      set.add(first);

      return list;
  }
  
}
