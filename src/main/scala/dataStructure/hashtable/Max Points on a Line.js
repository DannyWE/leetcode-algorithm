/*
https://leetcode.com/problems/max-points-on-a-line/description/

i.e
take([Point(3,4), Point(0,0), Point(1,1), Point(2,2), Point(3,3)])
take([Point(3,4), Point(0,0), Point(1,1), Point(2,2), Point(3,3), Point(4, 9), Point(5, 14), Point(6, 19), Point(3, 6)])
 */

take = (points) => {
    const len = points.length;
    const mid = Math.floor(len / 2);
    let result = [];

    for (let i = 0; i < mid; i ++ ) {
        for (let j = 0; j < len; j ++ ) {
            findMaximumLines(points, len, [points[i], points[j]], result);
        }
    }

    return maxBy(result, t => t.length);
};

findMaximumLines = (points, len, acc, result) => {
    let foundElement = points.find(ele => !contains(acc, ele) && sameLine(acc, ele));
    if (foundElement) {
        findMaximumLines(points, len, acc.concat(foundElement), result)
    } else {
        result.push(acc);
    }
};

contains = (acc, ele) => {
    let i = acc.length;
    while (i--) {
        if (JSON.stringify(acc[i]) === JSON.stringify(ele)) {
            return true;
        }
    }
    return false;
};

maxBy = (arr, func) => {
    let result = [arr[0]];
    const len = arr.length;
    for (let i = 1 ; i < len ; i ++ ) {
        if (func(result[0]) < func(arr[i])) {
            result = [];
            result.push(arr[i]);
        } else if (func(result[0]) === func(arr[i])) {
            result.push(arr[i])
        }
    }
    return result;
};

sameLine = (points, point) => {
    if (points.length < 2) {
        return true;
    }
    const xDistance = points[0].x - points[1].x;
    const yDistance = points[0].y - points[1].y;
    const last = points.slice(-1)[0];

    const pointXDistance = last.x - point.x;
    const pointYDistance = last.y - point.y;

    return xDistance === pointXDistance && yDistance === pointYDistance;
};

Point = (x, y) => ({x, y});