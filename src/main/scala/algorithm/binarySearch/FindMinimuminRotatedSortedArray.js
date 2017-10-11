/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

findMinimum([4,5,6,7,0, 1,2])
0
findMinimum([4,5,6,7,0, 1,2, 3])
0
findMinimum([4,5,6,7,8,9,0, 1,2, 3])
0
 */

findMinimum = (arr) => {
    const len = arr.length;
    let start = 0;
    let end = len - 1;

    let fistTime = true;
    while (start <= end) {
        if (end - start === 1) {
            return arr[start] < arr[end] ? arr[start] : arr[end];
        }
        if (start === end ) {
            return arr[start];
        }

        let mid = Math.floor((start + end) / 2);

        if (arr[mid - 1] > arr[mid] && arr[mid + 1] > arr[mid] ) {
            return arr[mid];
        }
        if (fistTime) {
            let i = mid;
            let j = mid;
            while (i > 0 || j < end) {
                if (arr[i] > arr[i - 1]) {
                    i --;
                } else {
                    end = mid - 1;
                    fistTime = false;
                    break;
                }
                if (arr[j] < arr[j + 1]) {
                    j ++;
                } else {
                    start = mid + 1;
                    fistTime = false;
                    break;
                }
            }
            continue;
        }

        arr[mid - 1] < arr[mid + 1] ? end = mid - 1 : start = mid + 1;
    }

};
