//https://leetcode.com/problems/symmetric-tree/description/

/**
 *     1
      / \
     2   2
    / \ / \
   3  4 4  3
 *
 *
 */


Node = (value, left = null, right = null) => {
    return {
        value,
        left,
        right,
    }
};

check = (root) => {
    if (root.left === null && root.right === null) {
        return true;
    }
    let result = {isSymmetric: true};
    checkTwoNodes(root.left, root.right, result);

    return result.isSymmetric
};

checkTwoNodes = (left, right, result) => {
    const nullLen = [left, right].filter(e => e === null).length;
    if (nullLen === 2) {
        return;
    }
    if (nullLen === 1) {
        result.isSymmetric = false;
        return;
    }

    if (left.value !== right.value) {
        result.isSymmetric = false;
        return;
    }
    checkTwoNodes(left.right, right.left, result);
    checkTwoNodes(left.left, right.right, result);
};

node1 = Node(1, Node(2, Node(3), Node(4)), Node(2, Node(4), Node(3))); //true
node2 = Node(1, Node(2, Node(3), Node(4)), Node(2, Node(3), Node(4))); //false
node3 = Node(1, Node(2, null, Node(3)), Node(2, null, Node(3))); //false