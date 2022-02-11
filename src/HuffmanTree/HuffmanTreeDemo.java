package HuffmanTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int arr[]={10,11,8,20,3,14,5,17};
        Node root= createHuffmanTree(arr);
        preOrder(root);
    }
    public static Node createHuffmanTree(int[]arr){
        List<Node> nodes=new ArrayList<Node>();
        for (int value:arr){
            nodes.add(new Node(value));
        }
        while (nodes.size()>1){
            Collections.sort(nodes);
            Node left=nodes.get(0);
            Node right=nodes.get(1);
            Node parent=new Node(left.value+right.value);
            parent.left=left;
            parent.right=right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
    public static void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("Empty Tree");
        }
    }
}
class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public void  preOrder(){
        System.out.println(this);
        if (this.left!=null)
            this.left.preOrder();
        if (this.right!=null)
            this.right.preOrder();
    }

    @Override
    public String toString() {
        return "Node [Value="+value+"]";
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }
}