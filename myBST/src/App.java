public class App {
    static IntTreeNode root;
    static class IntTreeNode {
        public int data;
        IntTreeNode left;
        IntTreeNode right;

        IntTreeNode(int data) {
            this.data = data;
            right = null;
            left = null;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        root = new IntTreeNode(2);
        root.left = new IntTreeNode(8);
        root.left.left = new IntTreeNode(7);
        root.left.left.left = new IntTreeNode(4);
        root.left.left.right = new IntTreeNode(1);
        root.left.left.right.right = new IntTreeNode(3);
        root.right = new IntTreeNode(9);
        root.right.left = new IntTreeNode(6);
        root.right.left.right = new IntTreeNode(0);
        root.right.left.right.left = new IntTreeNode(4);
        root.right.left.right.right = new IntTreeNode(5);
        tighten(root);
    }



    public static  void tighten() {
        if (root == null) return;
        while (root.left == null ^ root.right == null)
            root = (root.left == null) ? root.right : root.left;

        tighten(root);
    }
    private static void tighten(IntTreeNode node) {
        if (node != null) {
            int bf = -2;
            if (node.left != null)
                while (bf != 0) {
                    bf = 0;
                    if (node.left.right != null) bf++;
                    if (node.left.left != null) bf--;
                    if (bf == 1) // left-right subtree
                        node.left = node.left.right;
                    else if (bf == -1) // left-left subtree
                        node.left = node.left.left;
                }

            if (node.right != null){
                bf = -2;
                while (bf != 0) {
                    bf = 0;
                    if (node.right.right != null) bf++;
                    if (node.right.left != null) bf--;
                    if (bf == 1) // right-right subtree
                        node.right = node.right.right;
                    else if (bf == -1) // right-left subtree
                        node.right = node.right.left;
                }
            }
            tighten(node.left);
            tighten(node.right);
        }
    }
}
