public  class LinkedList{
public static class Node{
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
    public static Node head;
    public static Node tail;
    public static int size;


    public static void addFirst(int data) {
        Node newNode = new Node(data); // step 1
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        
        newNode.next = head; //link
        head = newNode; // step 3
    }
    public static void addLast(int data) {
        Node newNode = new Node(data); // step 1
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode; //link
        tail = newNode; // step 3

    }
    public void add(int ind, int data) {
        if(ind == 0) {
            addFirst(data);
            return;
        }
Node newNode = new Node(data);
size++;
Node temp = head;
int i =0;

while(i< ind-1) {
  
    temp = temp.next;  
    i++;
}
newNode.next = temp.next;
temp.next= newNode;
    }



    public int removeFirst() {
if(size ==0) {
    System.out.println("Empty");
    return Integer.MIN_VALUE;
}
else if (size ==1) {
    int val = head.data;
    head = tail = null;
    size =0;
return val;
}
int val = head.data;
head = head.next;
size--;
return val;
    }
    public int removeLast() {
        if(size ==0) {
            System.out.println("Empty");
            return Integer.MIN_VALUE;
        }
        else if (size ==1) {
            int val = head.data;
            head = tail = null;
            size =0;
        return val;
        }
        Node pre = head;
        int i=0;
        while(i< size-2) {
            pre = pre.next;
            i++;
        }
        int val = pre.next.data; // tail data
        pre.next= null;
            tail = pre;
            size--;
            return val;

    }
    public static void printlist() {
        
        if(head == null) {
            System.out.print("Empty");
            return;
        }
        
        Node temp = head;
        while(temp != null) {
        System.out.print(temp.data + " ");
        temp = temp.next;
    }
    System.out.println();
    }

//Searching
    public  int search(int value, int i) {
      /*  int i=0;
        Node temp = head;
        while(temp != null) {
            
            
            if(temp.data == value) {
                
                return i;
            }
            temp = temp.next;
           i++; 
        }
        return -1;
    }*/ 
    if(head.data == value) {
        return i;
    }
    else if(head== null) {
        return -1;
    }
    head = head.next;
    return search(value, i+1);
    
}
public void removeNode(int n) {
    Node temp = head;
    Node pre = null;
    int i=0;
    while(i != size-n) {
        temp = temp.next;
        pre = pre.next;
        i++;

    }
    pre.next = temp.next;
    int val = pre.data;
    size--;

}



public void reverse() {
Node curr = tail = head;
Node pre = null;
Node next;
while(curr!= null) {
next = curr.next;
curr.next = pre;
pre = curr;
curr = next;
head = pre;

}
}



public Node findMid( Node head) {
    Node slow = head;
    Node fast = head;
    while(fast == null && fast.next ==null) {
        fast = fast.next.next;
        slow = slow.next;
    }
  return slow;
}
    
     public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.add(1, 9);
        ll.addLast(4);
      // ll.removeFirst();
      // ll.removeLast();

        ll.printlist();
      //System.out.println("size" + ll.size);
       // System.out.print( "ans" +ll.search(9));
        //System.out.print("ans" + ll.search(10, 0));
        ll.reverse();
     //  ll.removeNode(2);
        ll.printlist();
        
     }
     }




