package aa.tulybaev;

public class BinaryNode<T>  {
    public T value;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "value=" + value +
                '}';
    }
}
