package com.zjw.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * 测试单向链表
 * @author 朱俊伟
 * @date 2020/12/01
 */
public class SingleLinkedListTest {

    /**
     * 测试添加结点
     */
    @Test
    public void addNode(){
        SingleLinkedList linkedList = new SingleLinkedList();
        Node node1 = new Node(1,"111");
        Node node2 = new Node(2,"2222");
        Node node4 = new Node(4,"444");
        Node node8 = new Node(8,"8888");
        linkedList.addNode(node1);
        linkedList.addNode(node2);
        linkedList.addNode(node4);
        linkedList.addNode(node8);
        System.out.println(linkedList.linkedListInfo());
        System.out.println("链表长度:" + linkedList.getLength());
    }

    /**
     * 按照节点nodeNo顺序插入
     */
    @Test
    public void addNodeByOrder(){
        Node node1 = new Node(1,"111");
        Node node2 = new Node(2,"2222");
        Node node4 = new Node(4,"444");
        Node node8 = new Node(8,"8888");
        SingleLinkedList linkedListOrder = new SingleLinkedList();
        linkedListOrder.addNodeByOrder(node2);
        linkedListOrder.addNodeByOrder(node4);
        linkedListOrder.addNodeByOrder(node8);
        linkedListOrder.addNodeByOrder(node1);
        System.out.println(linkedListOrder.linkedListInfo());
    }

    /**
     * 获取结点
     */
    @Test
    public void getNode(){
        SingleLinkedList linkedList = new SingleLinkedList();
        Node node1 = new Node(1,"111");
        Node node2 = new Node(2,"2222");
        Node node4 = new Node(4,"444");
        Node node8 = new Node(8,"8888");
        linkedList.addNode(node1);
        linkedList.addNode(node2);
        linkedList.addNode(node4);
        linkedList.addNode(node8);
        System.out.println(linkedList.linkedListInfo());
        System.out.println("头结点:" + linkedList.getHeadNode());
        System.out.println("位置1的结点:" + linkedList.findIndexNode(1));
        System.out.println("倒数第2个结点:" + linkedList.findLastIndexNode(2));
    }

    /**
     * 测试更新删除结点
     */
    @Test
    public void updateDeleteNode(){
        SingleLinkedList linkedList = new SingleLinkedList();
        Node node1 = new Node(1,"111");
        Node node2 = new Node(2,"2222");
        Node node4 = new Node(4,"444");
        linkedList.addNode(node1);
        linkedList.addNode(node2);
        linkedList.addNode(node4);
        System.out.println("原链表:" + linkedList.linkedListInfo());
        //更新nodeNo为1的结点
        Node newNode = new Node(1, "1.1.1.1");
        linkedList.updateNode(newNode);
        System.out.println("更新位置1结点后:\n" + linkedList.findIndexNode(1));
        //删除node节点id为1的节点
        linkedList.deleteNode(1);
        System.out.println("删除结点1后:\n" + linkedList.linkedListInfo());

    }

    /**
     * 测试链表反转
     */
    @Test
    public void reverse(){
        SingleLinkedList linkedListOrder = new SingleLinkedList();
        Node node1 = new Node(1,"111");
        Node node2 = new Node(2,"2222");
        Node node4 = new Node(4,"444");
        Node node8 = new Node(8,"8888");
        linkedListOrder.addNodeByOrder(node2);
        linkedListOrder.addNodeByOrder(node4);
        linkedListOrder.addNodeByOrder(node8);
        linkedListOrder.addNodeByOrder(node1);
        System.out.println("原链表:\n" + linkedListOrder.linkedListInfo());
        linkedListOrder.reverse();
        System.out.println("反转后:\n" + linkedListOrder.linkedListInfo());
    }

    /**
     * 测试反向遍历链表
     */
    @Test
    public void reverseInfo(){
        SingleLinkedList linkedList = new SingleLinkedList();
        Node node1 = new Node(1,"111");
        Node node2 = new Node(2,"2222");
        Node node4 = new Node(4,"444");
        Node node8 = new Node(8,"8888");
        linkedList.addNode(node1);
        linkedList.addNode(node2);
        linkedList.addNode(node4);
        linkedList.addNode(node8);
        System.out.println(linkedList.linkedListReverseInfo());
    }

    /**
     * 测试两个有序链表合并
     */
    @Test
    public void addListByOrder(){
        //链表1
        SingleLinkedList linkedListOrder = new SingleLinkedList();
        Node node1 = new Node(1,"111");
        Node node2 = new Node(2,"2222");
        Node node4 = new Node(4,"444");
        Node node8 = new Node(8,"8888");
        linkedListOrder.addNodeByOrder(node2);
        linkedListOrder.addNodeByOrder(node4);
        linkedListOrder.addNodeByOrder(node8);
        linkedListOrder.addNodeByOrder(node1);
        System.out.println(linkedListOrder.linkedListInfo());
        //链表2
        SingleLinkedList linkedListOrder2 = new SingleLinkedList();
        Node node3 = new Node(3,"2_333");
        Node node4_2 = new Node(4,"2_444");
        Node node5 = new Node(5,"2_555");
        linkedListOrder2.addNodeByOrder(node3);
        linkedListOrder2.addNodeByOrder(node4_2);
        linkedListOrder2.addNodeByOrder(node5);
        //合并链表
        linkedListOrder.addListByOrder(linkedListOrder2);
        System.out.println(linkedListOrder.linkedListInfo());
    }
}