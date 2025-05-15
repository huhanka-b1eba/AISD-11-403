package aa.tulybaev;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Создание бинарного дерева
        BinaryNode head = new BinaryNode(1);
        head.left = new BinaryNode<>(2);
        head.right = new BinaryNode<>(3);
        head.left.left = new BinaryNode<>(4);
        head.left.right = new BinaryNode<>(5);
        head.right.right = new BinaryNode<>(6);

        // 1 задание
        TreeHight treeHight = new TreeHight();
        System.out.println(treeHight.getAllNodeHeight(head));

        // 2 задание
        TreeSerialization treeSerialization = new TreeSerialization();
        System.out.println(treeSerialization.toSerialization(head));

        // 3 задание
        NTreeNode<Integer> parent = new NTreeNode(1);
        parent.children.add(new NTreeNode<>(2));
        parent.children.add(new NTreeNode<>(3));
        parent.children.add(new NTreeNode<>(4));
        parent.children.get(0).children.add(new NTreeNode<>(5));
        parent.children.get(0).children.add(new NTreeNode<>(6));
        parent.children.get(0).children.add(new NTreeNode<>(7));
        parent.children.get(1).children.add(new NTreeNode<>(8));
        parent.children.get(1).children.add(new NTreeNode<>(9));

        NTreeSerialization nTreeSerialization = new NTreeSerialization();
        System.out.println(nTreeSerialization.toSerialization(parent));
    }
}