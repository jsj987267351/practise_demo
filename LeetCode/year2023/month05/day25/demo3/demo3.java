package month05.day25.demo3;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/5/25 14:01
 */
public class demo3 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return head;
        }
//      哨兵节点
        ListNode sen = new ListNode(0,head);
//        用来连接的尾节点
        ListNode last = sen;
        while (head!=null && head.next!=null){
            if (head.val == head.next.val){
                int val = head.val;
                while (head!=null && head.val ==val){
                    head = head.next;
                }
//                因为当前的head有可能还是需要删除的，所以last不动
                last.next = head;
            }else {
//                这时确定了head时不需要删除的，所以全部后移
                last = last.next;
                head = head.next;
            }
        }
        return sen.next;
    }
}

