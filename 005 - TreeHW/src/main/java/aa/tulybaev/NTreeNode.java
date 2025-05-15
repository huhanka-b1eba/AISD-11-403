package aa.tulybaev;

import java.util.ArrayList;
import java.util.List;

public class NTreeNode<T> {
    public T value;
    public ArrayList<NTreeNode<T>> children  = new ArrayList<>();

    public NTreeNode(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "NTreeNode{" +
                "value=" + value + '}';
    }
}
