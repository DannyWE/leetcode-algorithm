let i = 0;
process = (currentSum, target, j, n, result) => {
    console.log(++i);
    if (currentSum === target) {
        result.count ++;
        return;
    }

    for (let i = j; currentSum + parseInt(Math.pow(i, n)) <= target; i ++) {
        process(currentSum + parseInt(Math.pow(i, n)), target, i + 1, n, result);
    }
};

function take(sum, n) {
    let result = {
        count: 0
    };
    process(0, sum, 1, n, result);
    console.log(result.count);
}

process = (currentSum, target, j, n, count) => {
    if (currentSum === target) {
        count.push(1);
        return;
    }

    for (let i = j; currentSum + parseInt(Math.pow(i, n)) <= target; i ++) {
        process(currentSum + parseInt(Math.pow(i, n)), target, i + 1, n, count);
    }
};

function take(sum, n) {
    let count = [];
    process(0, sum, 1, n, count);
    console.log(count.length);
}