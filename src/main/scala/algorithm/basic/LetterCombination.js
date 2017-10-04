/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

take = (digits) => {
    const mapping = {
        2: ['a', 'b' ,'c'],
        3: ['d', 'e', 'f'],
        4: ['g', 'h', 'i'],
        5: ['j', 'k', 'l']
    };
    const allCharacters = digits.toString().split('').map(e => mapping[e]);
    let result = [];

    process(allCharacters, 0, digits.toString().length, "", result);

    return result;
};

process = (arr, j, n, acc, result) => {
    if (acc.length === n) {
        result.push(acc);
        return;
    }
    for (let i = j; i < arr.length; i ++ ) {
        for (let k = 0; k < 3 ; k ++ ) {
            process(arr, i + 1, n, acc + arr[i][k], result);
        }
    }
};