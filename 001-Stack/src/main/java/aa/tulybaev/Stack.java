package aa.tulybaev;

public class Stack {
    private int size;
    private char[] arr;

    public Stack() {
        this.size = 0;
        this.arr = new char[0];
    }

    public Stack(char[] arr) {
        this.size = arr.length;
        this.arr = arr;
    }

    public int getSize() {
        return size;
    }

    public void grow() {
        char[] arr1 = new char[size*(2)];
        for (int i = 0; i < size; i++) {
            arr1[i] = arr[i];
        }
        this.arr = arr1;
    }

    public char get() {
        if (size == 0) return ' ';
        return arr[size];
    }

    public void put(char a) {
        if (size == 0) {
            size = 1;
        }
        if (size == 1) {
            size = 2;
        }
        if (size == arr.length) {
            grow();
        }
        arr[size] = a;
        size++;
    }
}
