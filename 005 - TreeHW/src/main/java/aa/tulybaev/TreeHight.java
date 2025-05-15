package aa.tulybaev;

import java.util.HashMap;

public class TreeHight {
    private HashMap<BinaryNode, Integer> map = new HashMap<>();

    public HashMap<BinaryNode, Integer> getAllNodeHeight(BinaryNode node) {
        getNodeHeight(node);
        return map;
    }

    public int getNodeHeight(BinaryNode node) {
        if (node == null) return -1;

        if (map.containsKey(node)) {
            return map.get(node);
        }

        int height = 1 + Math.max(getNodeHeight(node.left), getNodeHeight(node.right));

        map.put(node, height);

        return height;
    }


}
