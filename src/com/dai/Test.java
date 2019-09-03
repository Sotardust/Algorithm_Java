package com.dai;

import com.dai.linkedlist.SingleLinkedList;

public class Test {


    /**
     * 测试单链表
     */
    public void testSingleLinkedList() {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addNode(12);
        linkedList.addNode("fdsa");
        linkedList.addNode(45);
        linkedList.printLinkedList();
        linkedList.insertNode(2, 5);
        linkedList.insertNode(0, 545);
        linkedList.insertNode(5, 45);
        linkedList.insertNode(6, "长度");
        linkedList.printLinkedList();
        linkedList.removeHead();
        linkedList.printLinkedList();
        linkedList.removeIndex(5);
        linkedList.printLinkedList();
        linkedList.removeIndex(0);
        linkedList.printLinkedList();
        System.out.println("\nsize = " + linkedList.getSize());
    }
}
