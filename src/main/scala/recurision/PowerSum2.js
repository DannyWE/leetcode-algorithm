process = (current, target, j, n, result) => {
    if (current === target) {
        result.count += 1;
        return;
    }

    for (let i = j; current + Math.pow(i, n) <= target; i ++) {
        process(current + Math.pow(i, n), target, i + 1, n, result);
    }
}

function take(sum, n) {
    let result = {count: 0};
    process(0, sum, 1, n, result);
    console.log(result.count);
}