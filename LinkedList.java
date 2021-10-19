
/********** count the number of nodes*****************/
import java.util.*;
class Node{
    int data;
    Node next;
    
    Node(int a){
        data = a;
        next = null;
    }
    
}


class Solution
{
    //Function to count nodes of a linked list.
    public static int getCount(Node head)
    {
        int i=0;
        while(head!=null){
            i++;
            head = head.next;
        }
        return i;
    }
}
/*******Function to insert a node at the beginning of the linked list. ***********/
	Node insertAtBeginning(Node head, int x)
    {
        Node node = new Node(x);
        node.next = head;
        head = node;
        return head;
    }
    
    /***********Function to insert a node at the end of the linked list.************/
    Node insertAtEnd(Node head, int x)
    {
        Node curr = head;
        if(head==null) return node;
        while(head.next!=null){
            head = head.next;
           
       }
        head.next = node;
        head = curr;
        return head;
        
    }


 /********Function to insert a new node at given position in doubly linked list**************/
    void addNode(Node head, int pos, int data)
	{

	    Node node = new Node(data);
	    while(pos!=0){
	        head=head.next;
	        pos--;
	    }
	    if(head.next!=null){
	    
	    head.next.prev =node;
	    node.next=head.next;
	   
	    }
	    
	    
	    head.next=node;
	    node.prev = head;
		
	}


/************ Insert in Middle of Linked List *********************/
	public Node insertInMid(Node head, int data){
        
        Node node = new Node(data);
        Node curr = head;
        int i=0;
        while(head!=null){
            i++;
            head = head.next;
        }

        int k;
        k=i/2;
        if(i%2==0) k--;
        head = curr;

        while(k!=0){
            k--;
            head = head.next;
        }
        
        if(head.next!=null){
            node.next = head.next;
            head.next = node;
        }else{
            head.next = node;
        }
        head = curr;
        return head;
        
    }
    

/************ Function to check whether two linked lists are identical or not. ***************/
    public boolean isIdentical (Node head1, Node head2){
        while(head1!=null && head2!=null){
            if(head1.data!=head2.data){
                return false;
            }
            head1=head1.next;
            head2=head2.next;
        }
        if(head1==null && head2==null) return true;
        else return false;
    }


/***************** Function to delete a node without any reference to head pointer.******************/
	void deleteNode(Node del)
    {
         if(del.next==null){
             del=null;
         }else{
             del.data = del.next.data;
             del.next = del.next.next;
         }
    }


 /***************** Function to remove duplicates from sorted linked list.***********/
     public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(head!=null){
            if(head.next!=null && head.val == head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return curr;
        
    }


	/*************** Function to remove duplicates from a unsorted linked list ******************/
    static void removeDuplicate(node head)
    {
        // Hash to store seen values
        HashSet<Integer> hs = new HashSet<>();
     
        /* Pick elements one by one */
        node current = head;
        node prev = null;
        while (current != null)
        {
            int curval = current.val;
             
             // If current value is seen before
            if (hs.contains(curval)) {
                prev.next = current.next;
            } else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
 
    }


 /********** Function to find the data of nth node from the end of a linked list.***********/
    int getNthFromLast(Node head, int n)
    {
        int i=0;
        Node cur = head;
        while(head!=null){
            i++;
            head = head.next;
        }
        if(i<n) return -1;
        else {
            i = i-n;
            while(i>0){
                cur=cur.next;
                i--;
            }
            return cur.data;
        }
    }