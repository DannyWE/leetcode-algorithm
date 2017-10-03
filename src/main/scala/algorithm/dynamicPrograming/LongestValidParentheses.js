/*
https://leetcode.com/problems/longest-valid-parentheses/description/
Longest Valid Parentheses

i.e. (() = 2  , )()()) = 4
 */

count = (str) => {
    let result = {
        count: 0,
        isClosed: true
    };

    for (let obj of str) {
        if (obj === '(') {
            result.isClosed = false;
        } else if (obj === ')' && !result.isClosed) {
            result.isClosed = true;
            result.count ++;
        }
    }

    return result.count * 2;
};