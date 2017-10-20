/*
Convert Sorted Array to Binary Search Tree

https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

take([1,2,3,4,5,6,7])
 */

take = arr => {
    const len = arr.length;

    if (len === 0) {
        return null;
    }
    return loop(arr, 0, len - 1);
};
loop = (arr, start, end) => {
    if (start > end) {
        return null;
    }
    let mid = Math.floor((start + end) / 2);
    let node = TreeNode(arr[mid]);
    node.left = loop(arr, start, mid - 1);
    node.right = loop(arr, mid + 1, end);

    return node;
};


TreeNode = (val, left = null, right = null) => ({val, left, right});