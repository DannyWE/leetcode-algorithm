/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

findMinimum([4,5,6,7,0,1,2])
0
findMinimum([4,5,6,7,0,1,2,3])
0
findMinimum([4,5,6,7,8,9,0,1,2,3])
0
 */

findMinimum = (arr) => {
    const len = arr.length;
    let start = 0;
    let end = len - 1;

    while (start < end) {
        let mid = Math.floor((start + end) / 2);

        if (arr[mid] < arr[start]) {
            end = mid;
        } else if (arr[mid] > arr[end]) {
            start = mid + 1;
        } else {
            return arr[start]
        }
    }
    return arr[start];
};
