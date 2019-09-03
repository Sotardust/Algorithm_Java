package com.dai.linkedlist;


/**
 * 单链表结构
 * 链表是一种最常见的数据结构，其内部数据呈线性排列，属于线性表结构，
 * 什么是线性表:
 * 表中的数据按顺序依次排列，就像用一条线把数据串联起来一样。
 * 链表就是这种排布方式，特点是添加数据和删除数据速度快，
 * 但是查询数据会比较耗时，这是因为链表在内存中的存储结构造成的。
 */
public class SingleLinkedList {

    public int size;
    public Node head;

    /**
     * 添加结点
     *
     * @param obj
     */
    public void addNode(Object obj) {
        Node newNode = new Node(obj);
        if (size == 0) {
            this.head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     * 指定位置插入结点
     *
     * @param index
     * @param obj
     */
    public void insertNode(int index, Object obj) {

        if (index > size) {
            System.out.println("插入位置大于链表长度！！");
            return;
        }
        Node newNode = new Node(obj);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node target = head, previous = null;
            int position = 0;
            while (position != index) {
                previous = target;
                target = target.next;
                position++;
            }
            previous.next = newNode;
            newNode.next = target;
        }
        size++;
    }


    /**
     * 移除head结点
     */
    public Node removeHead() {
        if (size > 0) {
            Node node = head;
            head = head.next;
            size--;
            System.out.println("删除头结点 data =" + node.data);
            return node;
        }
        return null;
    }

    /**
     * 删除指定索引结点
     *
     * @param index
     */
    public void removeIndex(int index) {

        if (index > size) {
            System.out.println("删除索引大于结点长度");
        }

        if (index == 0) {
            System.out.println("删除第" + index + "个结点 data =" + head.data);
            head = head.next;
        } else {
            int position = 0;
            Node target = head;
            Node previous = head;
            while (position != index) {
                previous = target;
                target = target.next;
                position++;
            }
            System.out.println("删除第" + index + "个结点 data =" + target.data);
            previous.next = target.next;
        }
        size--;

    }

    /**
     * 获取链表长度
     *
     * @return size
     */
    public int getSize() {
        int size = 0;
        while (head.next != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    /**
     * 输出链表元素
     */
    public void printLinkedList() {
        if (size > 0) {
            Node node = head;
            int length = size;
            while (length > 0) {
                if (length == 1) {
                    System.out.print(node.data + "\n");
                } else {
                    System.out.print(node.data + " --> ");
                }
                node = node.next;
                length--;
            }
            System.out.println("");
        } else {
            System.out.println("[]");
        }
    }
}
