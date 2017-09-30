function commonInSortedArray(xs1, xs2) {
    let acc = [];
    const length1 = xs1.length;
    const length2 = xs2.length;
    let i = 0, j = 0;
    while (i < length1 && j < length2) {
        if (xs1[i] > xs2[j]) {
            j ++;
        } else if (xs1[i] < xs2[j]) {
            i ++;
        } else {
            acc.push(xs1[i]);
            i ++;
            j ++;
        }
    }
    return acc;
}
