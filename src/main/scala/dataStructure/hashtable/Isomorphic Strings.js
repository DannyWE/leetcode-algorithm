/*
https://leetcode.com/problems/isomorphic-strings/description/

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
 */

isIsomorphic = (s, t) => {
    const len1 = s.length;
    const len2 = t.length;
    if (len1 !== len2) {
        return false;
    }

    const first = Object.values(getStats(s, len1));
    const second = Object.values(getStats(t, len1));

    return JSON.stringify(first) === JSON.stringify(second);
};

getStats = (s, len) => {
    let strArr = s.split('');
    let result = {};

    for (let i = 0 ; i < len; i ++) {
        if (!result[strArr[i]]) {
            result[strArr[i]] = [];
        }
        result[strArr[i]].push(i);
    }

    return result;
};