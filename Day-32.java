/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
import java.util.*;

class Solution {

    public static ArrayList<Node> findPreSuc(Node root, int key) {

        Node pre = null, suc = null;
        Node curr = root;

        while (curr != null) {

            if (curr.data < key) {
                pre = curr;
                curr = curr.right;
            } 
            else if (curr.data > key) {
                suc = curr;
                curr = curr.left;
            } 
            else {
                // find predecessor
                if (curr.left != null) {
                    Node temp = curr.left;
                    while (temp.right != null)
                        temp = temp.right;
                    pre = temp;
                }

                // find successor
                if (curr.right != null) {
                    Node temp = curr.right;
                    while (temp.left != null)
                        temp = temp.left;
                    suc = temp;
                }
                break;
            }
        }

        ArrayList<Node> res = new ArrayList<>();
        res.add(pre);
        res.add(suc);

        return res;
    }
}