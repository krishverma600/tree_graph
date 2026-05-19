package Tree;

public class kthSmallest {
    Node root;

    int count = 0;
    int result = -1;

    public int kthSmallest(Node root, int k){


        if(root==null){
            return -1;
        }

        kthSmallest(root.left,k);
        count++;
        if(count == k){
            result = root.data;
            return result;
        }
        kthSmallest(root.right,k);

        return result;
    }
}
