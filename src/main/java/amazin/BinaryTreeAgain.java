package amazin;

// insertion and deletion
// https://www.youtube.com/watch?v=wcIRPqTR3Kc


// traversal : udemy
// https://www.udemy.com/course/learn-data-structure-algorithms-with-java-interview/learn/lecture/12486358#overview

public class BinaryTreeAgain {
    BinaryTreeAgain left, right;
    int value;

 public BinaryTreeAgain(int i){
     value = i;
 }

    public static void main(String[] args) {
// example : http://lcm.csa.iisc.ernet.in/dsa/node91.html
     BinaryTreeAgain root = new BinaryTreeAgain(13);
     root.left = new BinaryTreeAgain(7);
        root.left.left = new BinaryTreeAgain(5);
/*        root.left.left.right = new BinaryTreeAgain(2);
        root.left.right = new BinaryTreeAgain(4);
        root.left.right.right = new BinaryTreeAgain(12);
        root.left.right.right.left = new BinaryTreeAgain(10);*/


        //System.out.println(isValidBST(root, Integer.MIN_VALUE , Integer.MAX_VALUE));
        System.out.println(insert(root, new BinaryTreeAgain(1)));


    }



    private static boolean isValidBST(BinaryTreeAgain node, int minValue, int maxValue) {

        if (node == null)
            return true;

        if (node.value > minValue &&
                node.value < maxValue &&
                isValidBST(node.left, minValue, node.value) &&
                isValidBST(node.right, node.value, maxValue))
            return true;
        else return false;
    }

    private static BinaryTreeAgain insert ( BinaryTreeAgain root, BinaryTreeAgain node){
        BinaryTreeAgain current=root, parent= null;
     while(current != null){
         parent = current;
         if(node.value < current.value)
             current = current.left;
         else
             current = current.right;
     }
        System.out.println("Parent is : " + parent.value);
        if(node.value < parent.value)
     parent.left = node;
        else
            parent.right = node;

     return root;
    }

}
