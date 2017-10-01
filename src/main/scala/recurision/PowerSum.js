logN = (val, n) => Math.pow(val, 1/n);

    //Math.log(val) / Math.log(n);

range = (n) => [...Array(n).keys()].map(e => e + 1);

powerSum = (sum, n) => {
    const max = logN(sum, n);
    const arr = range(parseInt(max));

    const result = [];

    findMatched(arr, sum, 0, n, [], result);

    // console.log(result);

    return result.filter(t => !isDuplicate(t)).length;
};

isDuplicate = (sortedArr) => {
    let result = false;
    for (let i = 0; i < sortedArr.length; i ++) {
        if (i !== sortedArr.length - 1 && sortedArr[i] === sortedArr[i + 1]) {
            result = true;
            break;
        }
    }
    return result;
}

findMatched = (sortedArr, target, j, n, acc, result) => {
  if (acc.length > 2 && isDuplicate(acc)) {
      return;
  }
  if (target === 0 ) {
      result.push(acc);
      return;
  }

  for (let i = j; i < sortedArr.length; i ++) {
      const number = Math.pow(sortedArr[i], n);
      if (target < number) {
          return;
      }
      findMatched(sortedArr, target - number, i, n, acc.concat(number), result);
  }
};