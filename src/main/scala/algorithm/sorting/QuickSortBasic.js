const quickSort = (list) => {
    const length = list.length;
    if (length <= 1) return list;

    let left = [];
    let right = [];

    const pivot = list[0];

    for(i = 1 ; i < length; i ++) {
        list[i] < pivot ? left.push(list[i]) : right.push(list[i])
    }

    return quickSort(left).concat(pivot, quickSort(right));
};