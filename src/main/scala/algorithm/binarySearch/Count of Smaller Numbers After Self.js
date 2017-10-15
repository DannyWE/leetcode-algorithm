/*
https://github.com/paopao2/leetcode-js/blob/master/Count%20of%20Smaller%20Numbers%20After%20Self.js

Example:
Given nums = [5, 2, 6, 1]
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].

 */


/*
Without using result variable, it looks like the insertion sort and then we just need record the index.
 */

take = (arr) => {
  let tmp = [], left, right, mid;
  let len = arr.length;

  let result = [];

  for (let i = len - 1; i >= 0; i --) {
      left = 0;
      right = tmp.length;

      while (left < right) {
          mid = Math.floor((left + right) / 2);
          if (tmp[mid] > arr[i]) {
              right = mid;
          } else {
              left = mid + 1;
          }
      }

      result[i] = right;
      tmp.splice(right, 0, arr[i]);
  }

  return result;
};