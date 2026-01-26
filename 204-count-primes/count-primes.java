class Solution {
    //Solving on 26 Jan 2026

    //intuition 2 (optimizing and cleaning intuition 1) (beats 89.35%): (Sieve of Eratosthenes)
        //In this we iteratively mark the multiples of primes as composite.
        //Then starting from 2 each unmarked number is identified as prime.
        //This process continues till sqrt(n), leaving only prime numbers    


        //"Intuition (Sieve of Eratosthenes):
        // Maintain an array isComposite[0..n-1]. Initially all false.
        // For each i from 2 to sqrt(n), if i is not composite, mark all multiples of i starting from i*i as composite.
        // Finally, count numbers from 2..n-1 that are not composite."
        
        //TC: O(nlog logn): We visit all the numbers exactly once
        //SC: O(n): isComposite boolean array
    public int countPrimes(int n) {
        if(n == 0 || n == 1) return 0;

        boolean[] isComposite = new boolean[n]; //mark composites as true and leave primes as false
            //boolean arrays are more space efficient than int[]
        // isComposite[0] = true;
        // isComposite[1] = true;

        for(int i = 2; i*i < n; i ++){
            if(isComposite[i]) continue;
            for(int j = i * i; j < n; j += i){
                isComposite[j] = true; //marking multiples of i as composite
            } 
        }

        int primeCount = 0;
        for(int i = 2; i < n; i ++){
            if(!isComposite[i]) primeCount += 1; 
        }
        return primeCount;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 26 Jan 2026

    // //intuition 1 (beats 49.79%): (Sieve of Eratosthenes)
    //     //In this we iteratively mark the multiples of primes as composite.
    //     //Then starting from 2 each unmarked number is identified as prime.
    //     //This process continues till sqrt(n), leaving only prime numbers    

    //     //TC: O(nlog logn): Sieve of Eratosthenes
    //     //SC: O(n): primes
    // public int countPrimes(int n) {
    //     if(n == 0 || n == 1) return 0;

    //     int[] primes = new int[n]; //mark composites as -1 and leave primes as 0
    //     primes[0] = -1;
    //     primes[1] = -1;

    //     for(int i = 2; i*i < n; i ++){
    //         if(primes[i] == -1) continue;
    //         for(int j = i; i*j < n; j ++){
    //             primes[i*j] = -1; //marking multiples of primes as -1
    //         }    
    //     }

    //     int primeCount = 0;
    //     for(int primeOrNot : primes){
    //         if(primeOrNot == 0) primeCount += 1; 
    //     }
    //     return primeCount;
    // }
}