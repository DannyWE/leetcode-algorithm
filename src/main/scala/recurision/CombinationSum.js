const apply = (xs, target) => {
  const sortedList = xs.sort((a, b) => a - b);
  let result = [];
  findMatched(sortedList, target, 0, [], result);
  return result;
};

const findMatched = (sortedList, target, j, acc, result) => {
    if (target === 0) {
        result.push(acc);
        return;
    }
    const length = sortedList.length;
    for (let i = j; i < length; i ++) {
        if (sortedList[i] > target) {
            return;
        }
        findMatched(sortedList, target - sortedList[i], i, acc.concat(sortedList[i]), result)
    }
};