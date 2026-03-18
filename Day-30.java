/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {

    int moves = 0;

    public int distCandy(Node root) {
        dfs(root);
        return moves;
    }

    int dfs(Node node) {
        if (node == null)
            return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        moves += Math.abs(left) + Math.abs(right);

        return node.data + left + right - 1;
    }
}