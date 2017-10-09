/*
https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

 */

function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

minDepth = function(root) {
    let count = 1;
    let node = root;
    while(node.left) {
        count ++;
        node = node.left;
    }

    return count;
};