package sword2offer.q35;

/**
 * @Author starry
 */
public class Q35 {
    public RandomListNode Clone(RandomListNode head) {
       if (head == null)return null;
       head = cpyNext(head);

       head = cpyRandom(head);

       RandomListNode cur = head;
       RandomListNode r = head.next;
       RandomListNode res = r;
       while (cur.next.next!=null){
           cur.next = cur.next.next;
           r.next = r.next.next;
           cur = cur.next;
           r = r.next;
       }
       return res;
    }

    public RandomListNode cpyNext(RandomListNode head){
        RandomListNode cur = head;
        while (cur != null){
            RandomListNode t = new RandomListNode(cur.label);
            t.next = cur.next;
            cur.next = t;
            cur = t.next;
        }
        return head;
    }

    public RandomListNode cpyRandom(RandomListNode head){
        RandomListNode cur = head;
        while (cur != null){
            if (cur.random!=null){
                cur.next.random = cur.random.next;
            }

            cur = cur.next.next;
        }
        return head;
    }

    private static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        RandomListNode r4 = new RandomListNode(4);
        RandomListNode r5 = new RandomListNode(5);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;
        r2.random = r5;
        r1.random = r3;
        r4.random = r2;
        RandomListNode res = new Q35().Clone(r1);
        while (res!=null){
            System.out.print(res.label+" ");
            if (res.random!=null)
            System.out.print(res.random.label+" ");
            System.out.println();
            res= res.next;
        }
    }
}
