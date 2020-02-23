package amazin;


//https://www.techseries.dev/products/coderpro/categories/1831147/posts/6228798
public class DepthOfTree {

    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);
        root.right.right.right = new Node(50);
        System.out.println(new DepthOfTree().maxDepth(root));
    }


    public int maxDepth(Node root) {
        if(root==null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int bigger = Math.max(leftDepth, rightDepth);

        return bigger+1;
    }



}


class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
