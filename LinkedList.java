public class LinkedList {

    public static Node head;
    public static Node tail;
    public static int size;

    public class Node{
        int data;
        Node next;

        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }

    public void addFirst(int data)
    {
        Node newNode = new Node(data);
        size++;
        if(head == null)
        {
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head = newNode;
    }

    public void addLast(int data)
    {
         Node newNode = new Node(data);
         size++;
         if(head == null)
         {
            head=tail=newNode;
            return;
         }
        tail.next=newNode;
        tail=newNode;
    }
    public void addIndex(int idx , int data)
    {   
        if(idx == 0)
        {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while(i < idx-1)
        {
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }

    public int removeFirst()
    {   
        if(size == 0)
        {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1)
        {
            int val = head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    public int removeLast()
    {
        if(size == 0)
        {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1)
        {
            int val = head.data;
            head=tail=null;
            size=0;
            return val;
        }
        Node prev = head;
        for(int i=0;i<size-2;i++)
        {
           prev=prev.next;
        }
        int val=prev.next.data; //tail.val
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }
    public void deleteNFromEnd(int n)
    {
        //  calculating size
        int size=0;
        Node temp=head;
        while(temp!=null)
        {
            temp=temp.next;
            size++;
        }
        if(n == size) // that the deleting index is head
        {
             head=head.next;
             return;
        }
        int i=1;
        int iToFind=size-n;
        Node prev=head;
        while(i<iToFind)
        {
           prev=prev.next;
           i++;
        }
        prev=prev.next.next;
        return;
    }

    public void printList()
    {
       Node temp = head;
       while(temp!=null)
       {
         System.out.print(temp.data+"->");
         temp=temp.next;
       }
       System.out.println("null");
    }

 public static void main(String[] args) {
    LinkedList ll=new LinkedList();
    ll.addFirst(1);
    ll.addFirst(2);
    ll.addLast(5);
    ll.addLast(7);
    ll.addIndex(2, 4);
    ll.removeFirst();
    ll.removeLast();
    ll.printList();
    System.out.println(ll.size);
 }     
    
}
