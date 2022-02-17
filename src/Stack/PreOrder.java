package Stack;

public class PreOrder {
    //store only right children to the stack
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return list;

        while(root != null){
            //visit the root
            list.add(root.val);
            //store only the right children to the stack
            if(root.right != null){
                stack.push(root.right);
            }
            //add left children
            root = root.left;
            //when no left children, we add right children from stack into the list
            if(root == null && !stack.isEmpty()){
                root = stack.pop();
            }
        }
        return list;
    }

    //store all children to the stack
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                //add root and left node to the list, and store to the stack
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            //when no left children exist, return the right children of the root
            cur = stack.pop();
            cur = cur.right;
        }
        return list;
    }
}





/*
        Algorithm Preorder(tree)
               1. Visit the root.
               2. Traverse the left subtree, i.e., call Preorder(left-subtree)
               3. Traverse the right subtree, i.e., call Preorder(right-subtree)
 */