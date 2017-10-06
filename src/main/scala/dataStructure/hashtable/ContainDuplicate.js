/*
https://leetcode.com/problems/contains-duplicate/description/

 */


take = (arr) => containDuplicate(arr, 2);

containDuplicate = (arr, occurrence) => {
    let result = {};
    for (let ele of arr) {
        if(!result[ele]) {
            result[ele] = 0;
        }
        if (++result[ele] === occurrence) {
            return true;
        }
    }

    return false;
};