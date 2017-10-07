/*
https://leetcode.com/problems/binary-tree-level-order-traversal/description/

Given [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7

[
  [3],
  [9,20],
  [15,7]
]
 */

take = (arr) => {
    const len = arr.length;
    let result = {};
    for (let i = 0; i < len; i ++ ) {
        if (arr[i]) {
            const index = Math.floor(Math.log2(i + 1));
            if (!result[index]) {
                result[index] = [];
            }
            result[index].push(arr[i]);
        }
    }
    return Object.values(result);
};