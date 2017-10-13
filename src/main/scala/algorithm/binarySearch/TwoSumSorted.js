/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */

take = (arr, target) => {
    let len = arr.length;
    let start = 0;
    let end = len - 1;
    let neededArr = [];

    while (start < end) {
        let mid = Math.floor((start + end) / 2);
        if (arr[mid] >= target) {
            end = mid - 1;
        } else {
            neededArr = arr.slice(0, end);
            break;
        }
    }
    len = neededArr.length;
    for (let i = 0; i < len; i ++) {
        for (let j = 1; j < len; j ++) {
            if ((arr[i] + arr[j]) === target) {
                return [i + 1, j + 1];
            }
        }
    }
};