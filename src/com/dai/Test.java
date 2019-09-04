package com.dai;

import com.dai.dynamic.LongestCommonSubsequence;
import com.dai.linkedlist.Node;
import com.dai.linkedlist.SingleLinkedList;
import com.dai.otheralgo.BiSearch;

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
//        linkedList.removeHead();
//        linkedList.printLinkedList();
//        linkedList.removeIndex(5);
//        linkedList.printLinkedList();
//        linkedList.removeIndex(0);
//        linkedList.printLinkedList();

//        Node node = linkedList.reverse1(linkedList.head);
//        linkedList.getSize(node);
        linkedList.reverse3();

//        linkedList.printLinkedList();
//        System.out.println("\nsize = " + linkedList.getSize1());
    }


    /**
     * 测试最大字段和问题
     */
    public void testMaxSum() {
        int[] ints = {2, -4, 11, -3, 5, 16, -4, 1, 7};
        LongestCommonSubsequence subsequence = new LongestCommonSubsequence();
        subsequence.sumMaxValue(ints);

        int sum = subsequence.maxSubSum(ints, 0, ints.length - 1);
        System.out.println("\nTest.testMaxSum sum = " + sum);

        subsequence.commonSequence();

    }

    /**
     * 测试折半查找，二分法查找
     */
    public void testBiSearch() {
        BiSearch biSearch = new BiSearch();
        biSearch.biSearch();
    }
}
