/*
https://leetcode.com/problems/search-insert-position/description/

[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 */

take = (arr, target) => {
  const len = arr.length;

  if (len === 1) {
      if (target >= arr[0]) {
          return 1;
      }
      return 0;
  }

  let start = 0;
  let end = len - 1;

  while (start < end) {
      let mid = Math.floor((start + end) / 2);

      if (arr[mid] === target) {
          return mid;
      } else if (arr[mid] < target) {
          start = mid + 1;
      } else {
          end = mid - 1;
      }
  }

  const position = start >= end ? start : end;
  if (arr[position] > target) {
      return start;
  }

  return start + 1;
};