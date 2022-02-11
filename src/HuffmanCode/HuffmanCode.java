package HuffmanCode;


import java.util.*;

public class HuffmanCode {

    static Map<Byte,String> huffmanCodes=new HashMap<Byte,String>();
    static StringBuilder stringBuilder=new StringBuilder();

    public static void main(String[] args) {
        String str="a b c d e d f ccg";

        byte[] contentBytes=str.getBytes();
        byte[] huffmanCodesBytes=huffmanZip(contentBytes);
        System.out.println(new String(decode(huffmanCodes,huffmanCodesBytes)));
     }
    private static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes){
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<huffmanBytes.length;i++){
            byte b=huffmanBytes[i];
            boolean flag=(i== huffmanBytes.length-1);
            stringBuilder.append(byteToBitString(!flag,b));
        }
        Map<String,Byte> map=new HashMap<String,Byte>();
        for (Map.Entry<Byte,String> entry:huffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }
        List<Byte> list=new ArrayList<>();
        for (int i=0;i<stringBuilder.length();){
            int count=1;
            boolean flag=true;
            Byte b=null;
            while (flag){
                String key=stringBuilder.substring(i,i+count);
                b=map.get(key);
                if (b==null){
                    count++;
                }else {
                    flag=false;
                }
            }
            list.add(b);
            i+=count;
        }
        byte[] b=new byte[list.size()];
        for (int i=0;i<b.length;i++){
            b[i]=list.get(i);
        }
        return b;
    }
    private static String byteToBitString(boolean flag,byte b){
        int temp =b;
        if (flag){
            temp|=256;
        }
        String str=Integer.toBinaryString(temp);
        if(flag) {
            return str.substring(str.length() - 8);
        }else {
            return str;
        }
    }
    private static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes=getNodes(bytes);
        Node root=createHuffmanTree(nodes);
        huffmanCodes=getCode(root);
        byte[] huffmanCodeBytes=zip(bytes,huffmanCodes);
        return  huffmanCodeBytes;
    }
    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        StringBuilder stringBuilder=new StringBuilder();
        for (byte b:bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }
        int length=(stringBuilder.length()+7)/8;
        byte[] by=new byte[length];
        System.out.println(length);
        int index=0;
        for (int i=0;i<stringBuilder.length();i+=8){
            String strByte;
            if (i+8>stringBuilder.length()){
                strByte=stringBuilder.substring(i);
            }else{
                strByte=stringBuilder.substring(i,i+8);
            }
            by[index]=(byte) Integer.parseInt(strByte,2);
            index++;
        }
       return by;
    }

    private static Map<Byte,String> getCode(Node root){
        if (root==null){
            return null;
        }
        getCode(root.left,"0",stringBuilder);
        getCode(root.right,"1",stringBuilder);
        return huffmanCodes;
    }
    private static void getCode(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder1=new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if(node!=null){
            if(node.data==null){
                getCode(node.left,"0",stringBuilder1);
                getCode(node.right,"1",stringBuilder1);
            }else {
                huffmanCodes.put(node.data, stringBuilder1.toString());
            }
        }
    }
    private static List<Node> getNodes(byte[] bytes){
        ArrayList<Node> nodes=new ArrayList<Node>();
        Map<Byte,Integer> counts=new HashMap<>();
        for (byte b:bytes){
            Integer count=counts.get(b);
            if (count==null){
                counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }
        }
        for (Map.Entry<Byte,Integer> entry:counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }
    private static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size()>1){
            Collections.sort(nodes);
            Node left=nodes.get(0);
            Node right=nodes.get(1);
            Node parent=new Node(null,left.weight+right.weight);
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
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "Node [ data = "+data+" weight = "+weight+" ]";
    }
    public void  preOrder(){
        System.out.println(this);
        if (this.left!=null)
            this.left.preOrder();
        if (this.right!=null)
            this.right.preOrder();
    }
}