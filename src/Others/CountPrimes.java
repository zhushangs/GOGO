package Others;

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        //set the boolean array value to true and prime number begin with 2
        for(int i = 2; i < n; i++){
            isPrime[i] = true;
        }

        //one of prime number's factor must less than sqrt(n) b/c n = a*b, if a and b both greater than sqrt(n),
        //then a * b > sqrt(n) * sqrt(n) = n
        //if we cannot find any factor less than sqrt(n), it is prime
        for(int i = 2; i * i < n; i++){
            //if not prime, skip, move to next
            if(!isPrime[i]){
                continue;
            }
            for(int j = i * i; j < n; j+=i){
                //it starts from 2, the first prime
                //then mark the multiple of 2 as false in isPrime, so the loop of i will skip them.
                //the next prime is 3, do the same thing. Then it is 4, which 2*2, so the not prime is true, and will skip to next.
                isPrime[j] = false;
            }
        }

        int count = 0;
        for(int i = 2; i < n; i++){
            if(isPrime[i]){
                count++;
            }
        }
        return count;
    }

    //OR

    public int countPrimes2(int n) {
        boolean[] notPrime = new boolean[n];

        int count = 0;
        // Prime numbers start from 2
        for (int i = 2; i < n; i++) {
            // if the number is not-notPrime(mean it is Prime)
            if (notPrime[i] == false) {
                count++;
                // mark all multiples of i as non-prime
                for (int j=i; j<n; j=j+i)
                    notPrime[j] = true;
            }
        }
        return count;
    }
}
