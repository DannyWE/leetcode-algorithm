/*
https://leetcode.com/problems/powx-n/description/

 */

myPow = (x, n) => {
    if (n < 0) {
        return 1 / power(x, n)
    }
    return power(x, n);
};

power = (x, n) => {
  if (n === 0) {
      return 1;
  }

  let divide = power(x, parseInt(n / 2));

  if (n % 2 === 0 ) {
      return divide * divide;
  }

  return divide * divide * x
};