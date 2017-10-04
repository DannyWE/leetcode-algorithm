/*
https://leetcode.com/problems/happy-number/description/

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */

take = (number, happyDigit) => {
    let numberStr = number.toString();
    while (numberStr.length !== 1) {
        let newNumber = numberStr.split('').reduce((a, b) => Math.pow(parseInt(a), 2) + Math.pow(parseInt(b), 2));
        if (newNumber === happyDigit) {
            return true;
        }
        numberStr = newNumber.toString();
    }

    return false;
};