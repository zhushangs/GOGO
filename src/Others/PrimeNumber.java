package Others;

import java.util.ArrayList;

public class PrimeNumber {

    public int[] PrimeNumbers(int start, int end){
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if(isPrime(i)){
                primes.add(i);
            }
        }
        int[] ans = new int[primes.size()];
        for(int i = 0; i < primes.size(); i++) {
            ans[i] = primes.get(i);
        }
        return ans;
    }

    public static boolean isPrime(int n) {

        if (n < 2) return false;
/*
        Prime: a number only has two factor, 1 and itself
        the maxInteration can be n/2 or sqrt(n)
        n/2: the largest factor must <= n/2
        sqrt(n): if n is not a prime, then n = a * b
        a and b can't both greater than sqrt(n), otherwise a * b > sqrt(n) * sqrt(n)
        Therefor, at least one factor must < sqrt(n), if we cannot find any factor less than sqrt(n), it is prime
 */
        int maxIteration = (int) Math.ceil(Math.sqrt(n));

        for (int i = 2; i < maxIteration; i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
