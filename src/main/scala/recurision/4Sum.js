take = (arr, target) => {
    let result = [];
    process(arr, 0, target, 0, [], result);

    return result;
};

process = (arr, current, target, j, acc, result) => {
    if (acc.length > 4 ) {
        return;
    }
    if (current === target && acc.length === 4) {
        result.push(acc);
        return;
    }

    for (let i = j; i < arr.length; i ++ ) {
        process(arr, current + arr[i], target, i + 1, acc.concat(arr[i]), result);
    }
};