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

import java.util.*;

class Solution {

    public static int minTime(Node root, int target) {

        // Step 1: Parent mapping
        HashMap<Node, Node> parentMap = new HashMap<>();
        Node targetNode = buildParentMap(root, parentMap, target);

        // Step 2: BFS to burn tree
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();

        q.add(targetNode);
        visited.add(targetNode);

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                // left
                if (curr.left != null && !visited.contains(curr.left)) {
                    q.add(curr.left);
                    visited.add(curr.left);
                    burned = true;
                }

                // right
                if (curr.right != null && !visited.contains(curr.right)) {
                    q.add(curr.right);
                    visited.add(curr.right);
                    burned = true;
                }

                // parent
                if (parentMap.containsKey(curr) && !visited.contains(parentMap.get(curr))) {
                    q.add(parentMap.get(curr));
                    visited.add(parentMap.get(curr));
                    burned = true;
                }
            }

            if (burned) time++;
        }

        return time;
    }

    // Build parent map + find target node
    static Node buildParentMap(Node root, HashMap<Node, Node> parentMap, int target) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node targetNode = null;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.data == target)
                targetNode = curr;

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                q.add(curr.left);
            }

            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                q.add(curr.right);
            }
        }

        return targetNode;
    }
}