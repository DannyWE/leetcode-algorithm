/*
Binary Tree Right Side View

https://leetcode.com/problems/binary-tree-right-side-view/description/

take(TreeNode(1,
        TreeNode(2, null, TreeNode(5, null, null)),
        TreeNode(3, null, TreeNode(4, null, null))));
 */

take = (nodes) => {
    let result = [nodes.value];
    let current = [nodes.left, nodes.right];
    let len = current.length;

    while (len > 0) {
        result.push(current[len - 1].value);
        current = allNodesInOneLevelInOrder(current);
        len = current.length;
    }

    return result;
};

allNodesInOneLevelInOrder = (nodes) => {
    let result = [];
    const len = nodes.length;
    for (let i = 0; i < len; i ++ ) {
        if (nodes[i].left) {
            result.push(nodes[i].left);
        }
        if (nodes[i].right) {
            result.push(nodes[i].right);
        }
    }

    return result;
};

TreeNode = (value, left = null, right = null) => ({value, left, right});
