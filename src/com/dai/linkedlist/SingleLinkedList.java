package com.dai.linkedlist;


import java.util.Stack;

/**
 * 单链表结构
 * 链表是一种最常见的数据结构，其内部数据呈线性排列，属于线性表结构，
 * 什么是线性表:
 * 表中的数据按顺序依次排列，就像用一条线把数据串联起来一样。
 * 链表就是这种排布方式，特点是添加数据和删除数据速度快，
 * 但是查询数据会比较耗时，这是因为链表在内存中的存储结构造成的。
 * <p>
 * 单向链表与双向（循环）链表的区别：
 * <p>
 * 在存储空间方面：
 * 单链表需要的存储空间比双向链表的要少，因为双向链表不仅保存有指向下一个节点的指针，
 * 还保存有指向上一个节点的指针，需要较大的空间来存储双向链表的指针域。
 * <p>
 * 在处理时间方面：
 * 双向链表的插入与删除操作比单链表的时间要快很多。
 * 在最末尾插入的时候，单链表需要找到需要插入位置的前一个节点，需要遍历整个链表，时间复杂度为O（n），
 * 而双向链表只需要head->tail,就可以得到最后一个节点的位置，然后就可以进行插入操作，时间复杂度为O（1）。
 * <p>
 * 在删除操作方面，单链表需要遍历到需要删除的节点的前一个节点，
 * 双向链表需要遍历到需要删除的节点，时间复杂度同为O(n)。
 */
public class SingleLinkedList {

    private int size;

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
            //头插法
//            newNode.next = head;
//            head = newNode;

//            尾插法
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
             node.next = newNode;
        }
            getSize(head);
//        getSize(head);
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
    public void removeHead() {
        if (size > 0) {
            Node node = head;
            head = head.next;
            size--;
            System.out.println("删除头结点 data =" + node.data);
        }
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

    public Node reverseNode;

    /**
     * 递归实现 当栈深度大于12000 则会出现StakOverflowError
     * <p>
     * 链表反转,递归
     *
     * @param node
     */
    public Node reverse1(Node node) {
        if (node.next == null) return node;
        Node newNode = reverse1(node.next);
        Node temp = node.next;
        System.out.print("data: " + newNode.data + " node data :" + node.data + "\n");
        temp.next = node; //data --> 45
        node.next = null; //与上个结点断开
//        getSize(newNode);
        return newNode;
    }

    /**
     * 遍历实现 通用实现方法
     * 考虑到reverse1最多只支持12000，因此将size改为100000时，
     * 再观察reverse2和reverse3之间的执行结果
     * 最好的方法是采用遍历的方式进行反转。
     * <p>
     * 链表反转 遍历结点
     * 1 -> 2 -> 3 -> 4
     */
    public void reverse2(Node head) {

        Node newNode = null;
        Node temp;
        while (head != null) {
            temp = head.next;
            head.next = newNode;
            newNode = head;
            head = temp;
        }
        getSize(newNode);
    }

    public void reverse2() {
        reverse2(head);
    }

    /**
     * 使用栈管理 链表反转
     *
     * @param head
     */
    public void reverse3(Node head) {
        Stack<Node> stack = new Stack<>();
        Node temp;
        while (head != null) {
            temp = head.next;
            head.next = null;
            stack.push(head);
            head = temp;
        }
        Node target = null;
        temp = null;
        while (!stack.empty()) {
            temp = target;
            target = stack.pop();
            target.next = temp;
            getSize(target);
        }
        getSize(target);
    }

    public void reverse3() {
        reverse3(head);
    }

    /**
     * 获取链表长度
     *
     * @return size
     */
    public int getSize(Node node) {
        System.out.println("\n");
        int size = 0;
        while (node != null) {
            System.out.print(node.data + " --> ");
            node = node.next;
            ++size;
        }
        return size;
    }

    /**
     * 获取链表长度
     *
     * @return size
     */
    public int getSize() {
        return getSize(head);
    }

    /**
     * 输出链表元素
     */
    public void printLinkedList() {
        System.out.println("\n");
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
            System.out.println("\n");
        } else {
            System.out.println("[]");
        }
    }
}
