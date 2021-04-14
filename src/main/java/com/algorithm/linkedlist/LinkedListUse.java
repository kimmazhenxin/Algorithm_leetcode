package com.algorithm.linkedlist;


/**
 * @Author: kim
 * @Description: 单向链表的使用,增删改查
 * @Date: 10:06 2021/4/9
 * @Version: 1.0
 */
public class LinkedListUse {
    // 记录链表头结点位置(链表一定要定义头节点)
    private Node head = null;

    // 记录链表尾节点的位置(特例,视情况而定义)
    private Node tail = null;

    /**
     * 获取链表的第k个节点(k从0开始)
     * @param k
     * @return
     */
    public Node get(int k) {
        // p用来遍历链表节点,初始化为head
        Node p = head;
        // 记录现在遍历到了第几个节点
        int i = 0;
        // 循环条件
        while (null != p) {
            if (i == k) {return p;}
            p = p.next;
            i++;
        }
        return null;
    }

    /**
     * 查找链表中的第一个值
     * @param value
     * @return
     */
    public Node find(int value) {
        // p用来遍历链表节点,初始化为head
        Node p = head;
        // 循环条件
        while (null != p) {
            if (p.data == value) {return p;}
            p = p.next;
        }
        return null;
    }

    /**
     * 往链表头部插入,这种操作将于输入的顺序相反,逆序
     * @param value
     */
    public void insertHead(int value) {
        Node newNode = new Node(value,null);
        // 指向刚开始的头节点
        newNode.next = head;
        // 新的头结点指向刚插入的新节点
        head = newNode;
    }

    /**
     * 往链表尾部插入数据,顺序插入
     * @param value
     */
    public void insertAtTail(int value) {
        Node newNode = new Node(value, null);
        Node p = head;
        // 空链表(考虑特例情况)
        if (head == null) {
            head = newNode;
        } else {
            // 下面这段循环逻辑是为了找到链表的尾结点
            while (null != p.next) {
                p = p.next;
            }
            // 将插入的节点赋值给尾结点
            p.next = newNode;
        }
    }


    /**
     * 链表尾部插入优化一:在定义链表的时候,定义一个尾结点 tail
     * @param value
     */
    public void insertAtTail2(int value) {
        // 假设链表定义了tail节点
        Node newNode = new Node(value, null);
        // 空链表(考虑特例情况)
        if (null == head) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
     * 链表尾部插入优化二:引入虚拟节点,结合之前的tail指针,简化编程,统一逻辑
     * 引入虚拟节点之后,在空链表中插入数据和非空链表中插入数据的逻辑一样,不需要要特殊处理在非空链表中插入数据的这一特殊情况了
     * @param value
     */
    public void insertAtTail3(int value) {
        // 引入虚拟节点,实际就是将head指向一个虚拟节点,它不存储任何数据
        Node head = new Node();
        // tail和head都指向这个虚拟节点
        tail = head;
        Node newNode = new Node(value, null);
        tail.next = newNode;
        tail = newNode;
    }


    /**
     * 在给定节点之后插入一个新节点
     * @param value
     */
    public void insertAfter(Node p, int value) {
        if (null == p) {
            return;
        }
        Node newNode = new Node(value, null);
        newNode.next = p.next;
        p.next = newNode;
    }

    /**
     * 删除给定节点之后的节点
     * @param p
     */
    public void deleteNextNode(Node p) {
        if (null == p || null == p.next) {
            return;
        }
        p.next = p.next.next;
    }

    /**
     * 删除给定的节点
     * @param p
     */
    public void deleteThisNode(Node p) {
        // 空链表或者p为空节点
        if (null == p || head == null) {
            return;
        }

        // p为头节点的特殊情况,此时就意味着要删除head头节点
        if (p == head) {
            head = head.next;
        }

        // 用prev来遍历链表,遍历找到p节点的前一个节点
        Node prev = head;
        // 当prev指向尾节点时或者找到了p节点,那么循环就结束了
        while (prev.next != null && prev.next != p) {
            prev = prev.next;
        }
        // 判断上述循环结束的具体条件,此时说明遍历到尾节点仍然没有发现P节点
        if (prev.next == null) {
            return;
        }
        // 找到了p节点,删除p节点
        prev.next = prev.next.next;
    }
}


/**
 * 链表的节点
 */
class Node {
    //存储的数据
    public int data;
    //存储下一个节点的引用(地址)
    public Node next;

    public Node() {
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {return false;}
        if (this == obj) {return true;}
        if (obj instanceof Node) {
            Node node = (Node)obj;
            if (node.data == this.data) {
                return node.next == this.next;
            } else {
                return false;
            }
        }
        return false;
    }
}
