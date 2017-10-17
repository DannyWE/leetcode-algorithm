take = (points) => {
    const len = points.length;
    let result = [];
    findMaximumLines(points, 0, len, [], result);

    return maxBy(result);
};

findMaximumLines = (points, k, len, acc, result) => {

    //TODO need workout
    // for (let i = k; i < len; i++) {
    //     if (acc.length <= 2) {
    //         findMaximumLines(points, i, len, acc.concat(points(i)), result);
    //     } else if (points.find(ele => sameLine(acc, points[i]))) {
    //         acc.push(points[i]);
    //     } else {
    //         result.push(acc);
    //         return;
    //     }
    //
    // }
};

maxBy = (acc, func) => (acc.reduce((a, b) => {
    if (func(a) >= func(b)) {
        return a;
    }
    return b;
}));

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