package Tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        HeroNode root= new HeroNode(1, "Todd");
        HeroNode node1= new HeroNode(2, "To");
        HeroNode node2= new HeroNode(3, "dd");
        HeroNode node3= new HeroNode(4, "Td");
        HeroNode node4= new HeroNode(5, "Tdd");
        binaryTree.setRoot(root);
        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node3);
        node2.setRight(node4);
        binaryTree.infixOrder();
        System.out.println();
        HeroNode resNode=binaryTree.postOrderSearch(3);
        if(resNode!=null)
            System.out.println(resNode.toString());
        else
            System.out.println("Not found");
        binaryTree.delNode(3);
        binaryTree.preOrder();
        System.out.println();
    }

}
class BinaryTree{
    private HeroNode root;
    public void setRoot(HeroNode root){
        this.root=root;
    }
    public void preOrder(){
        if (this.root!=null)
            this.root.preOrder();
        else
            System.out.println("Empty tree");
    }
    public void infixOrder(){
        if (this.root!=null)
            this.root.infixOrder();
        else
            System.out.println("Empty tree");
    }
    public void postOder(){
        if (this.root!=null)
            this.root.postOrder();
        else
            System.out.println("Empty tree");
    }
    public HeroNode preOrderSearch(int no){
        if(root!=null){
            return this.root.preOrderSearch(no);
        }else
            return null;
    }
    public HeroNode infixOrderSearch(int no){
        if(root!=null){
            return this.root.infixOrderSearch(no);
        }else
            return null;
    }
    public HeroNode postOrderSearch(int no){
        if(root!=null){
            return this.root.postOrderSearch(no);
        }else
            return null;
    }

    public void delNode(int no){
        if(root!=null){
            if(root.getNo()==no) {
                root = null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("Empty tree");
        }
    }
}
class HeroNode{
    private  int no;
    private String name;
    private HeroNode left;
    public HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString(){
        return "HeroNode [no="+no+", name="+name+"]";
    }
    public void delNode(int no){
        if (this.left!=null&&this.left.no==no){
            this.left=null;
            return;
        }
        if(this.right!=null&&this.right.no==no){
            this.right=null;
            return;
        }
        if (this.left!=null){
            this.left.delNode(no);
        }
        if(this.right!=null){
            this.right.delNode(no);
        }
    }


    public void preOrder(){
        System.out.println(this.toString());
        if(this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this.toString());
        if(this.right!=null){
            this.right.infixOrder();
        }
    }
    public void postOrder(){
        if (this.left!=null){
            this.left.postOrder();
        }
        if (this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this.toString());
    }
    public HeroNode preOrderSearch(int no){
        if (this.no==no){
            return this;
        }
        HeroNode resNode=null;
        if(this.left!=null){
            resNode=this.left.preOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.right!=null){
            resNode=this.right.preOrderSearch(no);
        }
        return resNode;
    }
    public HeroNode infixOrderSearch(int no){

        HeroNode resNode=null;
        if(this.left!=null){
            resNode=this.left.infixOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if (this.no==no){
            return this;
        }
        if(this.right!=null){
            resNode=this.right.infixOrderSearch(no);
        }
        return resNode;
    }
    public HeroNode postOrderSearch(int no){

        HeroNode resNode=null;
        if(this.left!=null){
            resNode=this.left.preOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.right!=null){
            resNode=this.right.preOrderSearch(no);
        }
        if (this.no==no){
            return this;
        }
        return resNode;
    }
}