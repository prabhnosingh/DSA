class Solution {
    //Solving on 26 Jan 2026

    //intuition 1: (Sieve of Eratosthenes)
        //In this we iteratively mark the multiples of primes as composite.
        //Then starting from 2 each unmarked number is identified as prime.
        //This process continues till sqrt(n), leaving only prime numbers    
    public int countPrimes(int n) {
        if(n == 0 || n == 1) return 0;

        int maxPrimeNums = n - 2; //-2 for 0 and 1
        int[] primes = new int[n]; //mark composites as negatives and leave primes as 0
        primes[0] = -1;
        primes[1] = -1;

        for(int i = 2; i*i < n; i ++){
            if(primes[i] == -1) continue;
            for(int j = i; i*j < n; j ++){
                primes[i*j] = -1; //marking multiples of primes as -1
            }    
        }

        int primeCount = 0;
        for(int primeOrNot : primes){
            if(primeOrNot == 0) primeCount += 1; 
        }
        return primeCount;
    }
}