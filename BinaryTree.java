package Tree;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public Node root;

    public void insert(int data) {

        root = insertRec(root,data);

    }
    public Node insertRec(Node root , int data) {
        if(root==null){
            root = new Node(data);
        } else if (data < root.data) {
            root.left = insertRec(root.left,data);
        } else if (data > root.data) {
            root.right = insertRec(root.right,data);
        }

        return root;
    }
    //InOrder Traversal
    public void inorder(){
        inorderRec(root);
    }
    public void inorderRec(Node root){
        if(root !=null){
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
    //Postorder Traversal
    public void postorder() {

        postorderRec(root);
    }
    public void postorderRec(Node root){
        if(root!=null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");

        }

    }
    //Preorder Traversal
    public void preorder(){

        preorderRec(root);
    }
    private void preorderRec(Node root) {
        if(root!=null){
            System.out.print(root.data +" ");
            preorderRec(root.left);
            preorderRec(root.right);


        }
    }
    //Delete the node from tree
    public Node findMin(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public void delete(int key) {
        root = delete(root, key);
    }
    public Node delete(Node root,int key){

        if(root==null){
            return null;
        }

        if(key < root.data){
            root.left = delete(root.left,key);
        }
        else if(key > root.data) {
            root.right = delete(root.right,key);
        }
        else{
            //No Child
            if(root.left == null && root.right==null){
                return null;
            }
            //Only one Child
            if(root.left == null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }

            //Two Child
            Node successor = findMin(root.right);
            root.data = successor.data;
            root.right = delete(root.right, successor.data);

        }
        return root;


    }

//    public void sumOfAllLeftNode(int key) {
//        int sum = sumOfAllLeftNode(root);
//    }

    public int sumOfAllLeftNode(Node root){
        if(root==null){
            return 0;
        }
        int sum =0;

        if(root.left != null){
            sum += root.left.data;
        }

        // Recur for left and right subtree
        sum += sumOfAllLeftNode(root.left);
        sum += sumOfAllLeftNode(root.right);

    return sum;
    }

    //Sum of All Leaf Nodes
    public void sumOfAllLeafNodes(){
        sumOfAllLeafNodes(root);
    }

    public int sumOfAllLeafNodes(Node root){
        if(root==null) return 0;

        if(root.left == null && root.right == null){
            return root.data;
        }

        return sumOfAllLeafNodes(root.left) + sumOfAllLeafNodes(root.right);
    }

    //Sum of all left leaf nodes
    public void sumOfAllLeftLeafNodes(){
        sumOfAllLeftLeafNodes(root);
    }

    public int sumOfAllLeftLeafNodes(Node root){
        if(root==null) return 0;

        int sum = 0;

        if(root.left!=null &&
            root.left.left==null && root.left.right==null){
            sum += root.left.data;
        }
        sum+= sumOfAllLeftLeafNodes(root.left);
        sum+= sumOfAllLeftLeafNodes(root.right);

        return sum;
    }

    public void countTotalNodes(){
        countTotalNodes(root);
    }

    public int countTotalNodes(Node root){
        if(root==null) return 0;

        return 1 + countTotalNodes(root.left) + countTotalNodes(root.right);
    }

    public void height(){
        height(root);
    }
    public int height(Node root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left,right);
    }

    public void levelOrder(){
        levelOrdertraversal(root);
    }

    public void levelOrdertraversal(Node root){

        if(root==null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.data + " ");
            if (current.left != null) {
                queue.add(current.left);
            } else if (current.right != null) {
                queue.add(current.right);
            }

        }

    }


}
