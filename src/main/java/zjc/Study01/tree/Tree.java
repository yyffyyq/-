package zjc.Study01.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树实现
 */
public class Tree {
    //自己定义一个二叉树的节点结构（静态内部类）
    public static class TreeNode {
        public int value;        // 节点里存的数字
        public TreeNode left;    // 指向左子节点
        public TreeNode right;   // 指向右子节点

        // 节点的构造函数
        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    // 创建二叉树节点
    private TreeNode root;

    // 创建根节点为空的二叉树
    public Tree(){
        root = null;
    }
    // 创建有根节点的二叉树
    public Tree(TreeNode root){
        this.root = root;
    }
    // 节点插入
    public void insert(int value){
        /// 创建插入节点
        TreeNode treeNode = new TreeNode(value);
        /// 判断是否为空树
        if(root==null){
            root = treeNode;
            return;
        }
        /// 创建队列用于查询插入
        Queue<TreeNode> queue = new LinkedList<>();
        /// 加入根节点用于查询
        queue.add(root);
        /// 查询
        while(!queue.isEmpty()){
            /// 出队列并取值
            TreeNode currentNode = queue.poll();
            /// 左孩子为空就放进去
            if(currentNode.left==null){
                currentNode.left = treeNode;
                return;
            }
            /// 右孩子为空就放进去
            if(currentNode.right==null){
                currentNode.right = treeNode;
                return;
            }
            /// 都不为空，就将左孩子右孩子放进队列
            /// 再先查询左孩子的左右孩子，再查询右孩子的左右孩子
            queue.add(currentNode.left);
            queue.add(currentNode.right);
        }
    }
    // 先序查询
    public void preorderTraversal(TreeNode node){
        if(node==null){
            return;
        }
        /// 显示节点数据
        System.out.print(node.value+" ");
        /// 遍历左树
        preorderTraversal(node.left);
        /// 遍历右树
        preorderTraversal(node.right);
    }
    // 中序查询
    public void inorderTraversal(TreeNode node){
        if(node==null){
            return;
        }
        /// 遍历左树
        inorderTraversal(node.left);
        /// 显示节点数据
        System.out.print(node.value+" ");
        /// 遍历右树
        inorderTraversal(node.right);
    }
    // 后序查询
    public void postorderTraversal(TreeNode node){
        if(node==null){
            return;
        }
        /// 遍历左树
        inorderTraversal(node.left);
        /// 遍历右树
        inorderTraversal(node.right);
        /// 显示节点数据
        System.out.print(node.value+" ");
    }

    // 层序遍历查询
    public void levelorderTraversal(TreeNode node){
        /// 和插入树方法类似，先查询这个节点是否有子类，如果有就先放到队列里，然后再按队列输出
        if(node==null){
            return;
        }
        /// 创建一个树的队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        /// 进行出队操作
        while(!queue.isEmpty()){
            TreeNode currentNode =  queue.poll();
            if(currentNode.left!=null){
                queue.add(currentNode.left);
            }
            if(currentNode.right!=null){
                queue.add(currentNode.right);
            }
            System.out.print(currentNode.value+" ");
        }
    }

    // 树深度计算
    public int treedeeepCalculate(TreeNode node){
        if(node==null){
            return 0;
        }
        /// 拿到左右树高度
        int lefthight = treedeeepCalculate(node.left);
        int righthight = treedeeepCalculate(node.right);

        return Math.max(lefthight,righthight)+1;
    }

    // 获取节点数量
    public int treenodeCalculate(TreeNode node){
        if(node==null){
            return 0;
        }
        return 1+treedeeepCalculate(node.left)+treedeeepCalculate(node.right);
    }

    // 查找值为k的节点
    public boolean treenodeSelect(TreeNode node,int k){
        if(node==null){
            return false;
        }
        if(node.value==k){
            return true;
        }
        return treenodeSelect(node.left,k) || treenodeSelect(node.right,k);

    }

    // 力扣测试
    List<Integer> nodeList=new ArrayList<>();
    public List<Integer> inorderLicoTest(TreeNode root) {
        if(root == null){
            return null;
        }
        inorder(root);
        return nodeList;
    }
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        nodeList.add(root.value);
        inorder(root.right);
    }



    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(0);
        tree.insert(5);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        System.out.println("先序查询");
        tree.preorderTraversal(tree.root);
        System.out.println();
        System.out.println("中序查询");
        tree.inorderTraversal(tree.root);
        System.out.println();
        System.out.println("后序查询");
        tree.postorderTraversal(tree.root);
        System.out.println();
        System.out.println("层序查询");
        tree.levelorderTraversal(tree.root);
        System.out.println();
        System.out.println("树高度计算");
        int value = tree.treedeeepCalculate(tree.root);
        System.out.println(value);
        System.out.println();
        System.out.println("树查值5");
        System.out.println(tree.treenodeSelect(tree.root,5));

        /// 力扣测试
        System.out.println("力扣测试");
        System.out.println(tree.inorderLicoTest(tree.root));
    }
}
