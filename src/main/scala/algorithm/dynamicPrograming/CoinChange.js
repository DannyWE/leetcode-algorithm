/*
https://leetcode.com/problems/coin-change/description/

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

 */

take = (arr, target) => {
  let result = [];
  process(arr.sort(), 0, target, 0, [], result);
  return result;
};

process = (arr, current, target, j, acc, result) => {
  if (current === target) {
      result.push(acc);
      return;
  }

  for (let i = j; i < arr.length; i ++) {
      if (current + arr[i] > target) {
          return;
      }
      process(arr, current + arr[i], target, i, acc.concat(arr[i]), result);
  }
};