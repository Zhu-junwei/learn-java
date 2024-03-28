package com.zjw.tree.rbt;

import org.junit.jupiter.api.Test;

/**
 * @author 朱俊伟
 * @since 2023/12/31 21:09
 */
public class RBTreeTest {

    /**
     * 测试 场景4.1 父亲和叔叔为红色节点
     */
    @Test
    public void demo1Test(){
        RBTree<String> bst = new RBTree<>();
        bst.addNode("a");
        bst.addNode("b");
        bst.addNode("c");
        bst.addNode("d");

        bst.printTree(bst.getRoot());
    }

    /**
     * 测试 场景4.2 叔叔为黑色，父亲为红色，LL型失衡
     */
    @Test
    public void demo2Test(){
        RBTree<String> bst = new RBTree<>();
        bst.addNode("d");
        bst.addNode("b");
        bst.addNode("a");

        bst.printTree(bst.getRoot());
    }

    /**
     * 测试 场景4.2 叔叔为黑色，父亲为红色，LR型失衡
     */
    @Test
    public void demo3Test(){
        RBTree<String> bst = new RBTree<>();
        bst.addNode("d");
        bst.addNode("b");
        bst.addNode("c");

        bst.printTree(bst.getRoot());
    }

    /**
     * 测试方法还有问题，需要修改
     */
    @Test
    public void demo4Test(){
        RBTree<String> bst = new RBTree<String>();
        bst.addNode("d");
        bst.addNode("d");
        bst.addNode("c");
        bst.addNode("c");
        bst.addNode("b");
        bst.addNode("f");

        bst.addNode("a");
        bst.addNode("e");

        bst.addNode("g");
        bst.addNode("h");



//        bst.remove("c");

        bst.printTree(bst.getRoot());
    }

}
