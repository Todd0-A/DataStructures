package Tree.ThreadedBinaryTree;



public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root=new HeroNode(1,"1");
        HeroNode node2=new HeroNode(3,"3");
        HeroNode node3=new HeroNode(6,"6");
        HeroNode node4=new HeroNode(8,"8");
        HeroNode node5=new HeroNode(10,"10");
        HeroNode node6=new HeroNode(14,"14");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        ThreadedBinaryTree threadedBinaryTree=new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();
        System.out.println(node5.getLeft().toString()+"  "+node5.getRight().toString());
        threadedBinaryTree.threadedList();
    }

}
class ThreadedBinaryTree{
    private HeroNode root;
    private HeroNode pre=null;
    public void setRoot(HeroNode root){
        this.root=root;
    }
    public void threadedNodes(){
        threadedNodes(root);
    }
    public void threadedNodes(HeroNode node){
        if (node==null){
            return;
        }
        threadedNodes(node.getLeft());
        if(node.getLeft()==null){
            node.setLeftType(1);
            node.setLeft(pre);
        }
        if (pre!=null&&pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre=node;
        threadedNodes(node.getRight());

    }
    public void threadedList(){
        HeroNode node=root;
        while(node !=null){
            while (node.getLeftType()==0){
                node=node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);
            }
            node=node.getRight();
        }


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
    private HeroNode right;

    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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

