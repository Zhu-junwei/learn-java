package com.zjw.linkedlist;

import java.util.Stack;

/**
 * 模拟单向链表
 * @author 朱俊伟
 */
public class SingleLinkedList {

    /**
     * 头结点，不存放数据，主要是为了指向下一个结点
     */
    private final Node headNode = new Node(-1, null);

    /**
     * 获取头结点
     *
     * @return
     */
    public Node getHeadNode() {
        return this.headNode;
    }

    /**
     * 添加结点，添加到链表结尾
     *
     * @param node 需要添加的结点
     */
    public void addNode(Node node) {
        //用来寻找结点要存放的位置
        Node tempNode = headNode;
        while (true) {
            if (tempNode.nextNode == null) {
                tempNode.nextNode = node;
                break;
            } else {
                tempNode = tempNode.nextNode;
            }

        }
    }

    /**
     * 添加结点，添加到链表开头
     *
     * @param node 需要添加的结点
     */
    public void addHeadNode(Node node) {
        if (this.headNode.nextNode != null) {
            node.nextNode = this.headNode.nextNode;
        } else {
            node.nextNode = null;
        }
        this.headNode.nextNode = node;

    }

    /**
     * 添加结点，根据结点的编号从小到大插入
     *
     * @param node 需要添加的结点
     */
    public void addNodeByOrder(Node node) {
        //用来寻找结点要存放的位置
        Node tempNode = headNode;
        while (true) {
            if (tempNode.nextNode == null) {
                tempNode.nextNode = node;
                break;
            } else if (tempNode.nextNode.nodeNo >= node.nodeNo) {
                node.nextNode = tempNode.nextNode;
                tempNode.nextNode = node;
                break;
            } else {
                tempNode = tempNode.nextNode;
            }

        }
    }

    /**
     * 合并两个有序的单链表，合并之后的链表依然有序
     *
     * @param linkedList 需要合并的链表
     */
    public void addListByOrder(SingleLinkedList linkedList) {
        Node tempNode = linkedList.headNode.nextNode;
        while (tempNode != null) {
            Node nextNode = tempNode.nextNode;
            addNodeByOrder(tempNode);
            tempNode = nextNode;
        }
    }

    /**
     * 修改node结点的信息
     *
     * @param node 需要修改的结点
     */
    public void updateNode(Node node) {
        //遍历到需要修改的结点
        Node tempNode = headNode;

        while (tempNode.nextNode != null) {
            if (tempNode.nextNode.nodeNo == node.nodeNo) {
                node.nextNode = tempNode.nextNode.nextNode;
                tempNode.nextNode = node;
                break;
            }
            tempNode = tempNode.nextNode;
        }
    }

    /**
     * 根据node节点id删除节点
     *
     * @param nodeNo 节点id
     */
    public void deleteNode(int nodeNo) {
        //遍历到需要删除的结点
        Node tempNode = headNode;
        while (tempNode.nextNode != null) {
            if (tempNode.nextNode.nodeNo == nodeNo) {
                if (tempNode.nextNode.nextNode != null) {
                    tempNode.nextNode = tempNode.nextNode.nextNode;
                } else {
                    tempNode.nextNode = null;
                }
                break;
            }
            tempNode = tempNode.nextNode;
        }
    }

    /**
     * 统计节点的个数
     *
     * @return 节点个数
     */
    public int getLength() {
        int length = 0;
        Node tempNode = headNode;
        while (tempNode.nextNode != null) {
            length++;
            tempNode = tempNode.nextNode;
        }
        return length;

    }

    /**
     * 查找单链表中的指定位置的节点
     *
     * @param index 节点位置
     * @return 节点位置上的节点
     */
    public Node findIndexNode(int index) {
        int tempIndex = 0;
        Node tempNode = headNode;
        Node resultNode = null;
        while (tempNode.nextNode != null) {
            tempIndex++;
            tempNode = tempNode.nextNode;
            if (tempIndex == index) {
                resultNode = tempNode;
                break;
            }
        }
        return resultNode;
    }

    /**
     * 查找单链表中的倒数第n个元素
     *
     * @param lastIndex 倒数位数
     * @return 倒数位置上的节点
     */
    public Node findLastIndexNode(int lastIndex) {
        Node tempNode = headNode;
        int length = getLength();
        if (length == 0 || lastIndex > length) {
            return null;
        }
        for (int index = 0; index <= length; index++) {
            tempNode = tempNode.nextNode;
            if (index == (length - lastIndex)) {
                break;
            }
        }
        return tempNode;
    }

    /**
     * 单链表反转
     * 遍历链表，将遍历到的结点添加到反转链表的头部，再将原链表指向反转后的链表
     */
    public void reverse() {
        SingleLinkedList reversedLinkedList = new SingleLinkedList();
        Node tempNode = this.headNode.nextNode;
        while (tempNode != null) {
            Node reverseNode = tempNode;
            tempNode = tempNode.nextNode;
            //将遍历到的结点添加到反转链表的头部
            reversedLinkedList.addHeadNode(reverseNode);
        }
        //使原链表指向反转后的链表
        this.headNode.nextNode = reversedLinkedList.headNode.nextNode;
    }

    /**
     * 遍历结点
     *
     * @return 所有结点的信息
     */
    public String linkedListInfo() {
        //需要遍历的每一个结点
        Node tempNode = headNode;

        StringBuilder sb = new StringBuilder();
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
            sb.append(tempNode).append("\n");
        }
        return sb.toString();

    }

    /**
     * 反向遍历结点，不改变链表结构
     * @return 遍历后的链表信息
     */
    public String linkedListReverseInfo(){
        Stack<Node> nodeStack = new Stack<>();
        //需要遍历的每一个结点
        Node tempNode = headNode;
        //将遍历后的节点存放栈中
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
            nodeStack.push(tempNode);
        }
        //从栈中取出节点
        StringBuilder sb = new StringBuilder();
        while (!nodeStack.empty()){
            sb.append(nodeStack.pop()).append("\n");
        }
        return sb.toString();
    }
}
/**
 * 记录单向链表的结点信息
 */
class Node{

    /**
     * 结点编号
     */
    public int nodeNo;

    /**
     * 结点名字
     */
    private final String nodeName;

    /**
     * 下一个结点
     */
    public Node nextNode;

    public Node(int nodeNo, String nodeName) {
        this.nodeNo = nodeNo;
        this.nodeName = nodeName;
    }


    @Override
    public String toString() {
        return "Node{" +
                "nodeNo=" + nodeNo +
                ", nodeName='" + nodeName + '\'' +
                '}';
    }
}