package aa.tulybaev;

public class NTreeSerialization {
    private String result = "";

    public String toSerialization(NTreeNode node) {
        if (node == null) return "NULL";

        result = "(" + node.value;

        if (!node.children.isEmpty()) {
            result += ",";

            for (int i = 0; i < node.children.size(); i++) {
                result += toSerialization((NTreeNode) node.children.get(i));
            }
        }

        result +=  ")";


        return result;
    }
}
