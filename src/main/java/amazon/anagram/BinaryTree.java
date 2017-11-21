package amazon.anagram;

// O(n)
// FOr balanced tree its O(logn)
public class BinaryTree {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

       Node root = bt.new Node(0);
        bt.insert(root, 1);
        bt.insert(root, 2);
        bt.insert(root, 3);

        bt.search(root,6);
        bt.insert(root, 6);
        bt.search(root,6);
        bt.insert(root, 7);
        bt.search(root,7);
        bt.insert(root, -1);
        bt.search(root,-1);
        bt.insert(root, 0);
        bt.search(root,0);
        bt.search(root,1);
        bt.search(root,2);
        bt.search(root,3);

        //bt.insert(root, 7);
        //bt.search(root,4);

        System.out.println("Is Binary Search Tree : "+bt.isBST(root, Integer.MAX_VALUE, Integer.MAX_VALUE));
        System.out.println(" Node nearest to key 8 is : "+ bt.closestValue(root,8));
    }


    class Node {
        int data;
        Node left;
        Node right;

        public Node(int value) {
            super();
            this.data = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
        public String toString2() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    /**
     *
     * Keep searching BST style left/right till you find the node or null (UNAVAILABLE).
     *
     * @param root
     * @param key
     * @return
     */
    public Node search(Node root, int key){
        if(root != null) {
            if (root.data == key) {
                System.out.println("Found key = " + key + " in the Binary Tree! ");
            }else if (root.data > key) {
                search(root.left, key);
            } else if (root.data <= key) {
                search(root.right, key);
            }
        } else{
            System.out.println("Could NOT Find key = " + key + " in the Binary Tree! ");
        }
        return root;
    }
    /**
     * VVIMP : FINDING PARENT IS CRITICAL FOR INSERT. Keep parsing tree till CURRENT is NULL(UNAVAILABLE), and you will find PARENT.
     * VVIMP : USE THE PARENT TO DECIDE where to keep the new node.
     *
     *
     * To insert we need to track two nodes PARENT and CURRENT
     * PARENT keeps track of the element closer to the node to be inserted
     *
     *
     * @param root
     * @param key
     * @return
     */
    public Node insert(Node root, int key){
        System.out.println("Inserting new Node with Value : "+key);

        if(root == null) return null;

        //When we start from ROOT, PARENT is null, keep searching till we hit null(UNAVILABLE) node and insert
        Node current = root, parent = null;
        while(current != null){
            if(current.data <= key){
                parent = current;
                current = current.right;

            } else if(current.data > key){
                parent = current;
                current = current.left;
            }
        }

        //USE PARENT information from above to insert
        if(parent.data <= key){
            parent.right = new Node(key);

        } else if(parent.data > key){
            parent.left = new Node(key);
        }


        return current;
    }
    /**
     * binary search trees (BST), sometimes called ordered or sorted binary trees,
     * On average, this means that each comparison allows the operations to skip about half of the tree,
     * so that each lookup, insertion or deletion takes
     *
     *
     * @param root
     * @param min
     * @param max
     * @return
     */
    private boolean isBST(Node root, int min, int max){
        if(root == null) return true;

        if(root.data > max || root.data < min){
            return false;
        }

        return isBST(root.left,min, root.data)
                && isBST(root.right,root.data, max);
    }

    private boolean isValidBST(Node node, int MIN, int MAX) {
        if(node == null)
            return true;
        if(node.data > MIN
                && node.data < MAX
                && isValidBST(node.left, MIN, node.data)
                && isValidBST(node.right, node.data, MAX))
            return true;
        else
            return false;
    }



    public int closestValue(Node root, double target) {
        double min=Double.MAX_VALUE;
        int result = root.data;

        while(root!=null){
            if(target>root.data){

                double diff = Math.abs(root.data-target);
                if(diff<min){
                    min = Math.min(min, diff);
                    result = root.data;
                }
                root = root.right;
            }else if(target<root.data){

                double diff = Math.abs(root.data-target);
                if(diff<min){
                    min = Math.min(min, diff);
                    result = root.data;
                }
                root = root.left;
            }else{
                return root.data;
            }
        }

        return result;
    }


}