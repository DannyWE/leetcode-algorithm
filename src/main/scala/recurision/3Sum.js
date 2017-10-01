sum3 = (arr) => {
    let result = [];
    process(arr, 0, 0, 0, [], result);
    console.log(result);
};

isNotSame = (arr, ele) => {
    return arr.map(e => e.sort()).findIndex(t => {
        const sortedAcc = ele.sort();
        return t[0] === sortedAcc[0] && t[1] === sortedAcc[1] && t[2] === sortedAcc[2];
    }) === -1
};

process = (arr, current, target, j, acc, result) => {
    if (acc.length > 3) {
        return;
    }

    if (current === target && acc.length === 3 && isNotSame(result, acc)) {
        result.push(acc);
        return;
    }

    for (let i = j; i < arr.length; i++) {
        process(arr, current + arr[i], target, i + 1, acc.concat(arr[i]), result);
    }
};