import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class binaryTree{
    //Basic setup
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    private static int idx = -1;
    
    private static Node buildTreeP(int nodes[]){
        idx++;
        if(nodes[idx] == -1){
            return null;
        }

        Node newNode = new Node(nodes[idx]);

        newNode.left = buildTreeP(nodes);
        newNode.right = buildTreeP(nodes);

        return newNode;
        
    }

    public static Node buildTree(int nodes[]){
        idx = -1;
        return buildTreeP(nodes);
    }

    //DFS:
    private static void preorderP(Node root,ArrayList<Integer> nodes){
        if(root == null){
            // nodes.add(-1);
            return;
        }
        
        nodes.add(root.data);

        preorderP(root.left,nodes);
        preorderP(root.right,nodes);
    }

    public static ArrayList<Integer> preorder(Node root){
        ArrayList<Integer> nodes = new ArrayList<>();
        preorderP(root,nodes);
        return nodes;
    }

    private static void inorderP(Node root,ArrayList<Integer> nodes){
        if(root == null)return;

        inorderP(root.left, nodes);
        nodes.add(root.data);
        inorderP(root.right, nodes);
    }

    public static ArrayList<Integer> inorder(Node root){
        ArrayList<Integer> nodes = new ArrayList<>();
        inorderP(root,nodes);
        return nodes;
    }

    private static void postorderP(Node root,ArrayList<Integer> nodes){
        if(root == null)return;

        postorderP(root.left, nodes);
        postorderP(root.right, nodes);
        nodes.add(root.data);
    }

    public static ArrayList<Integer> postorder(Node root){
        ArrayList<Integer> nodes = new ArrayList<>();
        postorderP(root, nodes);
        return nodes;
    }

    //BFS:Using null

    public static void BFS(Node root){
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            Node currNode = queue.remove();

            if(currNode == null){
                System.out.println();
                if(queue.isEmpty()){
                    break;
                }else{
                    queue.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");

                if(currNode.left != null)queue.add(currNode.left);
                if(currNode.right != null)queue.add(currNode.right);
            }
        }
    }

    public static void BFS(Node root,ArrayList<Integer> nodes){
        if(root == null)return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node currNode = queue.remove();

            nodes.add(currNode.data);

            if(currNode.left != null)queue.add(currNode.left);
            if(currNode.right != null)queue.add(currNode.right);
        }
    }

    //Without using null in queue
    public static void BFS2(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0;i < size;i++){
                Node currNode = queue.remove();

                System.out.print(currNode.data+" ");

                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
            
            System.out.println();
        }
    }

    
}

public class _2_TreeTraversal {
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        
        binaryTree.Node root = binaryTree.buildTree(nodes);
        // System.out.println(root.left.right.data);
        System.out.println("Preorder : "+binaryTree.preorder(root));
        System.out.println("Inorder  : "+binaryTree.inorder(root));
        System.out.println("Postorder:"+binaryTree.postorder(root));

        System.out.println("BFS:");
        binaryTree.BFS(root);

        ArrayList<Integer> BFS = new ArrayList<>();
        binaryTree.BFS(root,BFS);
        System.out.println(BFS);
    }
}
