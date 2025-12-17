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

    public  static  ListNode reverseBetween(ListNode head){
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
     head=reverseList(head);
     printlinkedList(head);
    }
}