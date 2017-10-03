/*
https://leetcode.com/problems/maximum-subarray/description/
Maximum Subarray

Given [-2,1,-3,4,-1,2,1,-5,4] Expected [4,-1,2,1] and sum 6

 */

take = (arr) => {
    const len = arr.length;
    const start = 0;
    const end = len - 1;

    return max(start, end, arr);
};

max = (start, end, arr) => {
    if (start > end) {
        return Number.NEGATIVE_INFINITY;
    }
    if (start === end) {
        return arr[start];
    }
    const mid = Math.floor((start + end) / 2);

    let leftMax = Number.NEGATIVE_INFINITY;
    for (let i = mid - 1, curSum = 0; i >= 0; i--) {
        curSum += arr[i];
        leftMax = Math.max(curSum, leftMax);
    }

    let rightMax = Number.NEGATIVE_INFINITY;
    for (let i = mid + 1, curSum = 0; i < end; i ++ ) {
        curSum += arr[i];
        rightMax = Math.max(curSum, rightMax);
    }

    let midMax = arr[mid] + Math.max(leftMax, 0) + Math.max(rightMax, 0);

    return Math.max(midMax, max(start, mid - 1, arr), max(mid + 1, end, arr));
};