// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {

    static class Info {
        int min, max, size;
        boolean isBST;

        Info(int min, int max, int size, boolean isBST) {
            this.min = min;
            this.max = max;
            this.size = size;
            this.isBST = isBST;
        }
    }

    static int maxSize = 0;

    static int largestBst(Node root) {
        maxSize = 0;
        solve(root);
        return maxSize;
    }

    static Info solve(Node node) {
        if (node == null)
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);

        Info left = solve(node.left);
        Info right = solve(node.right);

        // Check BST condition
        if (left.isBST && right.isBST && node.data > left.max && node.data < right.min) {

            int size = left.size + right.size + 1;

            maxSize = Math.max(maxSize, size);

            int min = Math.min(node.data, left.min);
            int max = Math.max(node.data, right.max);

            return new Info(min, max, size, true);
        }

        // Not a BST
        return new Info(0, 0, 0, false);
    }
}