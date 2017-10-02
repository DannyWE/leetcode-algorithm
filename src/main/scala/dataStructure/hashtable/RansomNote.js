execute = (magazineArr, ransomArr) => {
    let magazineObj = {};
    for (let ele of magazineArr) {
        magazineObj[ele] = magazineObj[ele] ? magazineObj[ele] + 1 : 1;
    }
    for (let ele of ransomArr) {
        if (magazineObj[ele] && magazineObj[ele] > 0) {
            magazineObj[ele] = magazineObj[ele] - 1;
        } else if (!magazineObj[ele]) {
            return 'No';
        }
    }
    return 'Yes';
};