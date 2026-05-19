package Tree;

public class LowestCommonAncestor {
    public Node root;

    public void LCA(int n1,int n2){

        LCA(root,n1,n2);
    }

    public Node LCA(Node root, int n1, int n2){
        if(root==null) return null;

        if(n1 > root.data && n2 > root.data ){
            return LCA(root.right,n1,n2);
        }
        if(n1 < root.data && n2 < root.data ){
            return LCA(root.left,n1,n2);
        }

        return root;
    }

}
