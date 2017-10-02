sum3Closest = (arr, target) => {
  let result = [];
  process(arr, 0, target, 0, [], result);
  const sortedArr = result.sort((a, b) => sumAndCompare(a, target) > sumAndCompare(b, target));

  return sortedArr.filter(e => sumAndCompare(e, target) === sumAndCompare(sortedArr[0], target));
};

sumAndCompare = (arr, target) => {
    const sum = arr.reduce((a, b) => a + b);
    return Math.abs(sum - target);
};

process = (arr, current, target, j, acc, result) => {
  if (acc.length > 3) {
      return;
  }
  if (acc.length === 3) {
      result.push(acc);
      return;
  }

  for (let i = j; i < arr.length; i ++) {
      process(arr, current + arr[i], target, i + 1, acc.concat(arr[i]), result);
  }
};