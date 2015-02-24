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
public class PrimeOrNot {
  
  static int isPrime(long n) {
    if (n<2) {
      throw new RuntimeException();
    }
    
    if (n==2 || n==3) return 1;
    
    if (n%2==0)
      return 2;
    if (n%3==0)
      return 3;
    
    int sqrt = (int)Math.floor(Math.sqrt(n));
    
    for (int i=5; i<=sqrt; i+=6) {
      if (n%i==0) {
        return i;
      }
      if (n%(i+2)==0) {
        return i+2;
      }
    }
    
    return 1;
  }
    
  public static void main(String[] args) {
    System.out.println(isPrime(2147483647));
  }
  
}
