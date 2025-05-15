package aa.tulybaev;

public class TreeSerialization {
    private String result = "";

    public String toSerialization(BinaryNode node) {
        if (node == null) return "NULL";

        result = "(" + node.value + "," + toSerialization(node.left) + "," + toSerialization(node.right) + ")";

        return result;
    }
}
