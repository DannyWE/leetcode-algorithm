package dataStructure.tree;

import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left;
    Node right;
}


public class PreOrderTree {

    void preOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        preOrderConcat(root, list);
        String result = "";
        for (Integer ele : list) {
            result += ele + " ";
        }
        System.out.println(result.trim());
//        Stream<String> rStream = list.stream().map(Object::toString);
//        System.out.println(String.join(" ",  rStream.collect(Collectors.toList())));
    }

    void preOrderConcat(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.data);
        if (root.left != null && root.right != null) {
            preOrderConcat(root.left, list);
            preOrderConcat(root.right, list);
        } else if (root.left != null) {
            preOrderConcat(root.left, list);
        } else {
            preOrderConcat(root.right, list);
        }
    }

}
