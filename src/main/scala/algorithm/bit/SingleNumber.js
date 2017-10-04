/*
https://leetcode.com/problems/single-number/description/
Single Number

i.e [1,2,1,3,3,4,2,3,6,6,3] => 4

 */

singleNumber = (arr) => {
    let result = 0;

    for (let ele of arr) {
        result = result ^ ele;
    }

    return result;
};