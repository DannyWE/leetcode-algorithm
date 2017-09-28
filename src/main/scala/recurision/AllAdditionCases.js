findMatched = (sortedArr, target, j, acc, result) => {
    if (target === 0) {
        result.push(acc);
        return;
    }
    const length = sortedArr.length;
    for (let i = j; i < length; i ++) {
        if (sortedArr[i] > target) {
            return;
        }

        findMatched(sortedArr, target - sortedArr[i], i, acc.concat(sortedArr[i]), result);
    }
};

allCase = (target) => {
    let sortedArray = [];
    for (let i = 1; i <= target; i ++) {
        sortedArray = sortedArray.concat(i);
    }

    // sortedArray.sort((a, b) => b - a);
    let result = [];

    findMatched(sortedArray, target, 0, [], result);

    return result;
};