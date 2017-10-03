/*
https://leetcode.com/problems/majority-element/description/
Majority Element

[1,3,4,5,5,5,5,6,9] -> 5
 */

find = (arr) => {
    if (arr.length === 1) {
        return arr[0];
    }

    let count = 1;
    let candidate = arr[0];

    for (let ele of arr) {
        if (count === 0 || ele === candidate) {
            count ++;
            candidate = ele;
        } else {
            count --;
        }
    }
    return candidate;
};
