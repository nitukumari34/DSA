import java.util.ArrayList;

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}
public class Main {
    public  static  ListNode reverseList(ListNode head){
      ListNode temp=head;
      ListNode prev=null;

      while(temp!=null){
          ListNode curr=temp.next;
          temp.next=prev;
          prev=temp;
          temp=curr;

      }
      return  prev;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode=new ListNode(0);
        dummyNode.next=head;
        ListNode prev=dummyNode;
        if(head==null || left==right) return  head;

        for(int i=1;i<left;i++){
            prev=prev.next;
        }

        ListNode curr=prev.next;
        ListNode forw=curr.next;

        for(int i=0;i<right-left;i++){
            curr.next=forw.next;
            forw.next=prev.next;
            prev.next=forw;
            forw=curr.next;

        }

        return  dummyNode;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode  KSizeChecker=head;
        for(int i=0;i<k;i++)
        {
            if(KSizeChecker==null)
                return head;
            KSizeChecker = KSizeChecker.next;
        }

        ListNode curr=head;
        ListNode temp=head;
        ListNode prev=null;
        int count=1;
        while(count<=k ){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            count++;
        }
        if(temp!=null)
            head.next=reverseKGroup(temp,k);

        return prev;
    }
    public  static  ListNode rotateRight(ListNode head, int k) {

//        logic and idea

//        Traverse linked list → copy values into ArrayList
//
//        Rotate array to the right by k
//
//        First take last k elements
//
//        Then take first n - k elements
//
//        Rebuild linked list
        if (head == null) return null;

        ArrayList<Integer> arr = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            arr.add(curr.value);
            curr = curr.next;
        }

        int n = arr.size();
        k = k % n;

        ArrayList<Integer> res = new ArrayList<>();

        // last k elements
        for (int i = n - k; i < n; i++) {
            res.add(arr.get(i));
        }

        // first n-k elements
        for (int i = 0; i < n - k; i++) {
            res.add(arr.get(i));
        }

        // rebuild list
        curr = head;
        int i = 0;
        while (curr != null) {
            curr.value = res.get(i++);
            curr = curr.next;
        }

        return head;
    }

    public  static  void printlinkedList(ListNode head){
        while(head!=null){
            System.out.print(head.value +"->");
            head=head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

     ListNode head=new ListNode(8);
     ListNode first=new ListNode(7);
     ListNode second=new ListNode(4);
     ListNode fourth=new ListNode(6);
     head.next=first;
     first.next=second;
     second.next=fourth;
        printlinkedList(head);
//     head=reverseList(head);
//     printlinkedList(head);

//     head=reverseBetween(head,2,3);
//     printlinkedList(head);
//     head=reverseKGroup(head,2);
//     printlinkedList(head);
     head=rotateRight(head,2);
     printlinkedList(head);
    }
}