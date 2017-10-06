/*
https://leetcode.com/problems/count-primes/description/

 */

countPrimes = n => {
    let count = 0;
    let i = 0;
    while (i <= n) {
        if (isPrime(i)) count++;
        i ++ ;
    }
    return count;
};

isPrime = number => {
    if (number <= 2 && number > 0) {
        return true;
    }
    const half = Math.floor(number / 2);
    for (let i = 2; i <= half; i ++ ) {
        if (number % i === 0 ) {
            return false;
        }
    }

    return true;
};