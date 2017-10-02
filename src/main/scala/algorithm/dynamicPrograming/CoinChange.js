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