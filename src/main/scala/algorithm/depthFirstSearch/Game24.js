/*
https://leetcode.com/problems/24-game/description/
 */

take = (arr, target) => {
    let result = {
        found: false
    };
    process(arr, target, result);

    return result.found;
};

process = (arr, target, result) => {
    const accuracy = 0.001;
    if (result.found) return;
    if (arr.length === 1) {
        if (Math.abs(arr[0] - target) <= accuracy) result.found = true;
        return;
    }
    for (let i = 0; i < arr.length; i ++ ) {
        for (let j = 0; j < i; j ++) {
            let p1 = arr[i];
            let p2 = arr[j];
            let next = [p1+p2, p1-p2, p2-p1, p1*p2];
            if (Math.abs(p2) > accuracy) next.push(p1 / p2);
            if (Math.abs(p1) > accuracy) next.push(p2 / p1);

            arr.splice(i, 1);
            arr.splice(j, 1);

            for (let ele of next) {
                // console.log(arr);
                arr.push(ele);
                process(arr, target, result);
                arr.pop();
            }

            arr.splice(j, 0, p2);
            arr.splice(i, 0, p1);
        }
    }
};