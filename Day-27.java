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

    static class Pair {
        Node node;
        int hd;

        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }

    static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair temp = q.poll();
            Node curr = temp.node;
            int hd = temp.hd;

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(curr.data);

            if (curr.left != null)
                q.add(new Pair(curr.left, hd - 1));

            if (curr.right != null)
                q.add(new Pair(curr.right, hd + 1));
        }

        for (ArrayList<Integer> list : map.values())
            result.add(list);

        return result;
    }
}