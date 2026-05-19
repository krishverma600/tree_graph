import Tree.*;

public class Main {
    public static void main(String[] args){

        BinaryTree tree= new BinaryTree();
        tree.insert(8);
        tree.insert(7);
        tree.insert(12);
        tree.insert(15);
        tree.insert(2);
        tree.insert(5);


        tree.inorder();
        System.out.println("Inorder");

        tree.postorder();
        System.out.println("Postorder");

        tree.preorder();
        System.out.println("Preorder");


        tree.delete(8);
        System.out.println("\nAfter deleting 8:");
        tree.preorder();


        int SumOfLeftNodes = tree.sumOfAllLeftNode(tree.root);
        System.out.println("Sum of all left nodes: "+  SumOfLeftNodes);

        int sumOfAllLeafNodes = tree.sumOfAllLeafNodes(tree.root);
        System.out.println("Sum of all leaf nodes: "+ sumOfAllLeafNodes);

        int sumOfAllLeftLeafNodes = tree.sumOfAllLeftLeafNodes(tree.root);
        System.out.println("Sum of all left leaf nodes: "+ sumOfAllLeftLeafNodes);

        int countNodes = tree.countTotalNodes(tree.root);
        System.out.println("Total nodes: "+ countNodes);

        int height = tree.height(tree.root);
        System.out.println("Height of tree: "+ height);


        //Lowest Common Ancestor
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();

        Node lca = lowestCommonAncestor.LCA(tree.root, 2,5);
        System.out.println("Lowest Ancestor: "+lca.data);


        kthSmallest kth = new kthSmallest();
        int kthSmall = kth.kthSmallest(tree.root,1);

        System.out.println("Kth Smallest: "+ kthSmall);

        System.out.println("Level Order: ");
        tree.levelOrder();

    }
}
