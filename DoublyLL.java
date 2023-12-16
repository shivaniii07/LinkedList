public class DoublyLL {

    public static Node head;
    public static Node tail;
    public static int size;

      public class Node{
           int data;
           Node next;
           Node prev;

           public Node(int data)
           {
                this.data=data;
                this.next=null;
                this.prev=null;
           }
      }

      public void addFirst(int data)
      {
          Node newNode =new Node(data);
          size++;
          if(head == null)
          {
            head=tail=newNode;
            return;
          }
          newNode.next=head;
          head.prev=newNode;
          head=newNode;
      }
      public void addLast(int data)
      {
        Node newNode =new Node(data);
        size++;
        if(head == null)
        {
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
      }
      public int removeFirst()
      {
         if(size == 0)
         {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
         }
         if(size == 1)
         {
            int val=head.data;
            head=tail=null;
            size--;
            return val;
         }
            int val=head.data;
            head=head.next;
            head.prev=null;
            size--;
            return val;
      }
      public int removeLast()
      {
        if(size == 0)
        {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1)
        {
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
           int val=tail.data;
           tail=tail.prev;
           tail.next=null;
           size--;
           return val;

      }
       public void reverse()
       {
         Node curr=head;
          Node prev=null;
         Node next;

         while(curr != null)
         {
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
         }
         head=prev;

       }
      public void printList()
      {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
      }
    public static void main(String[] args) {
        DoublyLL dll=new DoublyLL();
        dll.addFirst(4);
        dll.addFirst(6);
        dll.addFirst(7);
        dll.addLast(9);
        dll.addFirst(8);
        // dll.removeFirst();
        // dll.removeLast();
          dll.reverse();
          dll.printList();
        System.out.println(size);
       
       
    }
    
}

