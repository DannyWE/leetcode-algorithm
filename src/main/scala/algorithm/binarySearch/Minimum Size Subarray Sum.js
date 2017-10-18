/*
https://leetcode.com/problems/minimum-size-subarray-sum/description/

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
take([2,3,1,2,4,3], 7)

 */

take = (arr, target) => {

    const sortedArr = arr.sort((a, b) => a - b);
    const len = sortedArr.length;
    let start = 0, end = len - 1;
    let result = [];

    while (start < end) {
        let mid = Math.floor((start + end) / 2);
        if (arr[mid] === target) {
            return [arr[mid]];
        } else if (arr[mid] < target) {
            start = mid + 1;
        } else {
            end = mid;
        }
    }
    i = start;
    while (sum(result) < target && i >= 0) {
        result.push(arr[i--]);
    }
    if (i === -1) {
        return 0;
    }
    return result;

};

sum = arr => {
    if (arr.length === 0) {
        return 0;
    }
    return arr.reduce((a, b) => a + b);
};

