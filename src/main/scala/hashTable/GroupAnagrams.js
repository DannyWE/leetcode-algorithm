/*
https://leetcode.com/problems/group-anagrams/description/

i.e. given ["eat", "tea", "tan", "ate", "nat", "bat"] -> [ ["ate", "eat","tea"], ["nat","tan"], ["bat"]]
 */

groupBy = (xs, mapKeyFunc) => {
    let result = {};
    [result, ...xs].reduce((acc, ele) => {
        const key = mapKeyFunc(ele);
        if (!acc[key]) {
            acc[key] = [];
        }
        acc[key].push(ele);
        return acc;
    });
    return result;
};

mapKeyFunc = (s) => {
    return s.split('').filter((item, i, ar) => {
        return ar.indexOf(item) === i;
    }).sort().join('');
};

take = (xs) => {
    //One way
    const obj = groupBy(xs, mapKeyFunc);
    return Object.keys(obj).map(e => obj[e]);

    //another way
    // let result = [];
    // const obj = groupBy(xs, mapKeyFunc);
    // for (let property in obj) {
    //     result.push(obj[property]);
    // }
    // return result;
};